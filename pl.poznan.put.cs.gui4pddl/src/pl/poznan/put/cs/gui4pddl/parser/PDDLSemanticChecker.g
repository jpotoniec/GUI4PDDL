tree grammar PDDLSemanticChecker;

options {
    tokenVocab=PDDL;
    ASTLabelType=CommonTree;
}

@header {
	package pl.poznan.put.cs.gui4pddl.parser;
	
	import pl.poznan.put.cs.gui4pddl.codemodel.*;
	import java.util.Set;
	import java.util.TreeSet;
	import java.util.LinkedList;
}

@members {
	private LinkedList<PDDLError> errors = new LinkedList<PDDLError>();

	void warning(int line, String message) {
		PDDLError e = new PDDLError();
		e.line = line;
		e.message = message;
		e.type = PDDLError.Type.WARNING;
		errors.add(e);
	}
	
	void error(int line, String message) {
		PDDLError e = new PDDLError();
		e.line = line;
		e.message = message;
		e.type = PDDLError.Type.ERROR;
		errors.add(e);
	}
	
	void critical(String message) throws RuntimeException{
		throw new RuntimeException(message);
	}
	
	public List<PDDLError> getErrors() {
		return errors;
	}
}





pddl_file
    [IPDDLCodeModel model, PDDLFile file]
    throws RuntimeException
    :   definition[$model, $file]*
    ;


/**********************
  PDDL Basic structures
***********************/

term [Set<String> objectScope, Set<String> variableScope]
	:	NAME {
			if(!objectScope.contains($NAME.text))
				error($NAME.line, String.format("Use of undefined object: \%s", $NAME.text));
		}
	|	VARIABLE {
			if(!variableScope.contains($VARIABLE.text))
				error($VARIABLE.line, String.format("Use of undefined variable: \%s", $VARIABLE.text));
		}
	;

predicate 
	:	NAME
	;
	
type
	returns [PDDLType t]
	@init {
		List<PDDLType> eitherTypes = new LinkedList<PDDLType>();
	}
    :	NAME {$t = PDDLType.simpleType($NAME.text);} 
	|	^('either' (nested=type {eitherTypes.add($nested.t);})+) {$t = PDDLType.eitherType(eitherTypes);}
	|   ^('fluent' nested=type) {$t = PDDLType.fluentType($nested.t);} 
	;

typed_list
	returns[PDDLTypedList list]
	@init {
		$list = new PDDLTypedList();	
	}
	:   typed_list_item[$list]*
	;

typed_list_item
    [PDDLTypedList list]
    : NAMEDEF
    | ^(NAMEDEF NAME) {list.add($NAME.text, null);}
    | ^(NAMEDEF VARIABLE) {list.add($VARIABLE.text, null);}
    | ^(NAMEDEF NAME type) {list.add($NAME.text, $type.t);}
    | ^(NAMEDEF VARIABLE type) {list.add($VARIABLE.text, $type.t);}
	;

literal_of_name
	:	atomic_formula_of_name
	|	^('not' atomic_formula_of_name)
	;

atomic_formula_of_name 
	:	^(predicate NAME*) 
	;
	
atomic_formula_of_term[Set<String> objectScope, Set<String> variableScope]
	:	^(predicate^ term[objectScope, variableScope]*) {System.out.println("atomic formula of term");}
	;


/*
  PDDL Goal description
*/

gd [Set<String> objectScope, Set<String> variableScope]
	:   atomic_formula_of_term[objectScope, variableScope]
    |   complicated_gd[objectScope, variableScope]
    ;

complicated_gd [Set<String> objectScope, Set<String> variableScope]
	: 	^('and' gd[objectScope, variableScope]*)
	|	^('or' gd[objectScope, variableScope]*) //:disjunctive-preconditions
    |	^('not' atomic_formula_of_term[objectScope, variableScope]) 
    |	^('not' complicated_gd[objectScope, variableScope]) //:disjunctive-preconditions TODO lookahead
	|	^('imply' gd[objectScope, variableScope] gd[objectScope, variableScope]) //:disjunctive-preconditions
	|	^('exists' typed_list gd[objectScope, variableScope])  //:existential-preconditions
	|	^('forall' typed_list gd[objectScope, variableScope])  //:universal-predonditions
	.
	;
	
/*
  PDDL Definitions
*/

definition
[IPDDLCodeModel model, PDDLFile file]
throws RuntimeException
scope {
	PDDLDomain domain;
	PDDLProblem problem;
	PDDLInitialSituation initsit;
}
	:	^( 'define' domain_header
		{
			String name = $domain_header.name;
			if (!(name + ".pddl").equals($file.getName()) && !"domain.pddl".equals($file.getName()))
				warning($domain_header.line, String.format("Filename \%s should match domain name \%s", $file.getName(), name));
			//$definition::domain=$file.getDomain(name);
		}
		domain_item* )
	
	
	|	^( define='define' problem_header
		{
			String name = $problem_header.name;
			
			for(PDDLProblem p: $file.getProblems()) {
				System.out.println(p.getName());
			}
			
			$definition::problem = $file.getProblem(name);
			if ($definition::problem ==  null)
				critical("Problem index not found");
			$definition::domain = model.getDomain($definition::problem);
		}
		problem_item* )
	
	|   ^( 'define' initsit_header {} initsit_body )
	;
	

/*
	Common items for domains and problems
*/

require_def
	: ^(':requirements' (REQUIRE_KEY {
		if (!PDDLRequirementSet.isValid($REQUIRE_KEY.text))
			error($REQUIRE_KEY.line, String.format("\%s is not valid requirement name", $REQUIRE_KEY.text));
	   })+)
	;


/*
Domains (4)
*/

domain_header
	returns [String name, int line]
	:	^( 'domain' NAME ) {$name = $NAME.text; $line = $NAME.line;}
	;

domain_item
	: require_def 
	| .
	;
	catch [Throwable t] {}

/*
Problems
*/

problem_header
	returns [String name, int line]
	:	^( 'problem' NAME ) {$name = $NAME.text; $line = $NAME.line;}
	;

problem_item
	: domain_reference
	| require_def
	| init
	| goal
	| .
	;
	catch [Throwable t] {}

domain_reference 
	:	^(':domain'^ NAME )
		{
			if ($definition::domain == null)
				error($NAME.line, "Domain not found in project");
		}
	;

init
	: ^(':init' literal_of_name+)
	;
	
goal
	@init {
		Set<String> objectScope = PDDLProblem.getObjectScope($definition::problem, $definition::domain);
		Set<String> variableScope = PDDLProblem.getVariableScope($definition::problem, $definition::domain);
	}
	: ^(':goal' gd[objectScope, variableScope])
	;

/*
Initial situations
*/

initsit_header
	returns [String name]
	:	^( 'situation' NAME ) {$name = $NAME.text;}
	;

initsit_body
	: ^(':domain' NAME) initsit_body_item*
	;

initsit_body_item
	:  .
	;
	catch [Throwable t] {}
