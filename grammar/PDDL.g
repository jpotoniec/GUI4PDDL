grammar PDDL;

definition 
	:	'(' 'define' problem_header problem_item* ')'
	;
		
problem_header : '(' 'problem' NAME ')'
   ; 

/*
Problems (13)
*//
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
	:	'(' ':objects' ')'
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

gd 	: 	atomic_formula_of_term
	|	'(' 'and' gd* ')'
	|	literal_of_term
	|	'(' 'or' gd* ')' //:disjunctive-preconditions
	|	'(' 'not' gd ')' //:disjunctive-preconditions
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
	:	NAME*
	|	NAME+ '-' type typed_list_of_name //:typing
	;

typed_list_of_variable
	:	VARIABLE*
	|	VARIABLE+ '-' type typed_list_of_variable //:typing
	;

type 	:	NAME
	|	'(' 'either' type+ ')'
	|	'(' 'fluent' type ')' //:fluents
	;

/*
 Action expansions (8)
*/
action_spec_od_action_term 
	:	'(' ')' // TODO: maby general tree?
	;

general_tree 
	:	'(' general_tree_item* ')'
	;
	
general_tree_item
	:	GENERAL_ATOM
	|	general_tree
	;

GENERAL_ATOM
	:	('a'..'z'|'A'..'Z'|'_'|'-'|'0'..'9'|'-'|'+'|'?')+
	;

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
