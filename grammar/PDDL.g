grammar PDDL;

definition 
	:	'(' 'define' problem_header problem_item* ')'
	;
		
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
	:	'(' ':objects' ')'
	;

init 	:	'(' ':init' literal_of_name+ ')'
	;

goal	:	'(' ':goal' gd ')'
	;	//TODO - add alternative action expansion
	
length_spec 
	:	'(' ':length' ('(' ':serial' INTEGER ')')? ('(' ':parallel' INTEGER ')')? ')'
	;


gd 	: 	literal_of_name
	|	'(' 'and' gd* ')'
	;	//TODO: add disjunctive-preconditions


predicate 
	:	NAME
	;

literal_of_name 
	:	atomic_formula_of_name
	|	'(' 'not' atomic_formula_of_name ')'
	;
	
atomic_formula_of_name
	:	'(' predicate NAME* ')'
	;

typed_list_of_name 
	:	NAME*
	|	NAME+ '-' type typed_list_of_name //:typing
	;


type 	:	NAME
	|	'(' 'either' type+ ')'
	|	'(' 'fluent' type ')' //:fluents
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

