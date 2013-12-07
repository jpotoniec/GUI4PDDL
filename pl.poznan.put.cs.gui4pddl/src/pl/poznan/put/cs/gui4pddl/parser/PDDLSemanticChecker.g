tree grammar PDDLSemanticChecker;

options {
    tokenVocab=PDDL;
    ASTLabelType=CommonTree;
}

@header {
	package pl.poznan.put.cs.gui4pddl.parser;
	
	import pl.poznan.put.cs.gui4pddl.codemodel.*;
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
		System.out.printf("error " +  message);
	}
	
	public List<PDDLError> getErrors() {
		return errors;
	}
}

pddl_file
    [IPDDLCodeModel model, PDDLFile file]
    :   definition[$model, $file]*
    ;

definition
[IPDDLCodeModel model, PDDLFile file]
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
	
	
	|	^( 'define' problem_header {} problem_item* )
	
	|   ^( 'define' initsit_header {} initsit_body )
	;

/*
Domains (4)
*/

domain_header
	returns [String name, int line]
	:	^( 'domain' NAME ) {$name = $NAME.text; $line = $NAME.line;}
	;

domain_item
	: .
	;
	catch [Throwable t] {}

problem_header
	returns [String name, int line]
	:	^( 'problem' NAME ) {$name = $NAME.text; $line = $NAME.line;}
	;

problem_item
	: .
	;
	catch [Throwable t] {}

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
