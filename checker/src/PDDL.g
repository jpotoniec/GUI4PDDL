grammar PDDL;

@header {
	package checker;
	
	import java.util.LinkedList;
	import java.util.List;
}

@members {
    private List<String> errors = new LinkedList<String>();
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        errors.add(hdr + " " + msg);
    }
    public List<String> getErrors() {
        return errors;
    }
}

@lexer::header {
	package checker;
}

definition 
	:	'(' 'define' problem_header problem_item* ')'
	|	'(' 'define' domain_header domain_item* ')'
	;

/*
Domains (4)
*/

domain_header 
	:	'(' 'domain' NAME ')'
	;

domain_item
	:	extension_def
	|	require_def
	|	types_def  //typing
	|	constants_def
	|	domain_vars_def //expression-evaluation
	|	predicates_def
	|	timeless_def
	|	safety_def //safety-constraints
	|	structure_def
	;
	
extension_def 
	:	'(' ':extends' NAME+ ')'
	;
	
types_def 
	:	'(' ':types' typed_list_of_name ')'
	;
	
constants_def
	:	'(' ':constants' typed_list_of_name ')'
	;

domain_vars_def
	:	'(' ':domain-variables' typed_list_of_domain_var_declaration ')'
	;

predicates_def 
	:	'(' ':predicates' atomic_formula_skeleton+ ')'
	;

timeless_def
	:	'(' ':timeless' literal_of_name+ ')'
	;
	
safety_def 
	:	'(' ':safety' gd ')'
	;
	
structure_def 
	:	action_def
	|	axiom_def //domain-axioms
	|	method_def //action-expansions
	;
	
/*
Actions (5)
*/
action_def 
	:	'(' ':action' general_tree_item* ')'  //TODO
	;

/*
Axioms (9)
*/
axiom_def 
	:	'(' ':axiom' general_tree_item* ')' //TODO
	;

/*
Action expansions (11)
*/
method_def
	:	'(' ':method' general_tree_item* ')'
	;

	
//
atomic_formula_skeleton 
	:	'(' predicate typed_list_of_variable ')'
	;
	
	

/*
Problems (13)
*/


problem_header : '(' 'problem' NAME ')'
   ; 

problem_item
	:	domain_reference
	|	require_def
	|	situation
	|	object_declaration
	|	init
	|	goal
	|	length_spec
	;

domain_reference 
	:	'(' ':domain' NAME ')'
	;
	
require_def
	:	'(' ':requirements' REQUIRE_KEY+ ')'
	;
	
situation 
	:	'(' ':situation' NAME ')'
	;
	
object_declaration 
	:	'(' ':objects' typed_list_of_name ')'
	;

init 	:	'(' ':init' literal_of_name+ ')'
	;

goal	:	'(' ':goal' gd ')'
	|	'(' ':expansion' action_spec_od_action_term ')' //:action-expansion
	;
	
length_spec 
	:	'(' ':length' ('(' ':serial' INTEGER ')')? ('(' ':parallel' INTEGER ')')? ')'
	;

/*
Goal description (6)
*/

gd 	: 	'(' 'and' gd* ')'
    |	literal_of_term
	|	'(' 'or' gd* ')' //:disjunctive-preconditions
	       // |	'(' 'not' gd ')' //:disjunctive-preconditions TODO here
	|	'(' 'imply' gd gd ')' //:disjunctive-preconditions
	|	'(' 'exists' '(' typed_list_of_variable ')' gd ')' //:existential-preconditions
	|	'(' 'forall' '(' typed_list_of_variable ')' gd ')' //:universal-predonditions
	;


predicate 
	:	NAME
	;


term 	:	NAME
	|	VARIABLE
	;


literal_of_name 
	:	atomic_formula_of_name
	|	'(' 'not' atomic_formula_of_name ')'
	;

literal_of_term
	:	atomic_formula_of_term
	|	'(' 'not' atomic_formula_of_term ')'
	;

atomic_formula_of_term
	:	'(' predicate term* ')'
	;
	
atomic_formula_of_name
	:	'(' predicate NAME* ')'
	;

typed_list_of_name 
	:	
	|	NAME+ ('-' type typed_list_of_name)? //:typing
	;

typed_list_of_variable
	:	
	|	VARIABLE+ ('-' type typed_list_of_variable)? //:typing
	;



type 	:	NAME
	|	'(' 'either' type+ ')'
	|	'(' 'fluent' type ')' //:fluents
	;

/*
 Action expansions (8)
*/
action_spec_od_action_term 
	:	general_tree // TODO: maybe general tree?
	;

/*
 Expression evaluation (12)
 */
 
domain_var_declaration 
	:	NAME
	|	'(' NAME NAME ')'
	;

typed_list_of_domain_var_declaration 
	:	
	|	domain_var_declaration+ ('-' type typed_list_of_domain_var_declaration)?
	;

/*
Temp
*/

general_tree 
	:	'(' general_tree_item* ')'
	;
	
general_tree_item
	:	NAME
	|	INTEGER
	|	VARIABLE
	|	REQUIRE_KEY //TODO: list all tokens
	|	'and'
	|	'not'
	|	general_tree
	;
	
/*
Tokens
*/

WS :		(' ' |'\t' |'\n' |'\r' )+ {skip();}
   ;

COMMENT
    :   ';' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

NAME	:	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'-'|'0'..'9')*
    ;

INTEGER :	'0'..'9'+
	;

REQUIRE_KEY
	:	':'('a'..'z'|'A'..'Z'|'_'|'-'|'0'..'9')+
    ;

VARIABLE 
	:	'?'('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'-'|'0'..'9')*
	;
