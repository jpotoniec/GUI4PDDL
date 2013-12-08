grammar PDDL;

options {
	output = AST;
	ASTLabelType=CommonTree;
}

tokens {
	DEFINE = 'define';
	DOMAIN_DEF = 'domain';
	PROBLEM_DEF = 'problem';
	SITUATION_DEF = 'situation';
	PLEFT = '(';
	PRIGHT = ')';
	REQUIRE_DEF = ':requirements';
}

@header {
	package pl.poznan.put.cs.gui4pddl.parser;
	
	import java.util.LinkedList;
	import java.util.List;
}

@members {
    private List<PDDLError> errors = new LinkedList<PDDLError>();
    private boolean printToStdErr = true;
    
    public void setPrintToStdErr(boolean val) {
    	printToStdErr = val;
    }
    
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        
        PDDLError error = new PDDLError();
        error.message = hdr + " " + msg;
        error.line = e.line;
        error.charPositionInLine = e.charPositionInLine;
        errors.add(error);
        
        if (printToStdErr)
        	System.err.println(hdr + " " + msg);
    }
    public List<PDDLError> getErrors() {
        return errors;
    }
    protected void exitSubtree(IntStream input) {
    	int level = 0;
    	int ttype = input.LA(1);
    	while (ttype != Token.EOF) {
    		if (ttype == 10) { // '('
    		    level++;
    		} else if (ttype == 11) { // ')'
    			level--;
    			if (level == 0) {
    			    input.consume();
    			    break;
    			}
    		}
    		
    		input.consume();
    		ttype = input.LA(1);
    	}
    }
    public void recover(IntStream input,
           RecognitionException re) {
           
           if (re instanceof NoViableAltException ) {
		       exitSubtree(input);
		       
		       //consumeUntil(input, 11)
		       //input.consume();
	       } else {
		       super.recover(input,re);
	       }
    }
}

@lexer::header {
	package pl.poznan.put.cs.gui4pddl.parser;
}

pddl_file
    :    definition*
    ;

definition 
	:	'('! 'define'^ problem_header problem_item* ')'!
	|	'('! 'define'^ domain_header domain_item* ')'!
	|   '('! 'define'^ initsit_header initsit_body ')'!
	;

/*
Domains (4)
*/

domain_header 
	:	'('! 'domain'^ NAME ')'!
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
	:	'('! ':extends'^ NAME+ ')'!
	;
	
types_def 
	:	'('! ':types'^ typed_list_of_name ')'!
	;
	
constants_def
	:	'('! ':constants'^ typed_list_of_name ')'!
	;

domain_vars_def
	:	'('! ':domain-variables'^ typed_list_of_domain_var_declaration ')'!
	;

predicates_def 
	:	'('! ':predicates'^ atomic_formula_skeleton+ ')'!
	;

timeless_def
	:	'('! ':timeless'^ literal_of_name+ ')'!
	;
	
safety_def 
	:	'('! ':safety'^ gd ')'!
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
	:	'(' ':action' NAME
			':parameters' '(' typed_list_of_variable ')'
			action_def_body ')'   -> ^(':action' NAME ^(':parameters' typed_list_of_variable) action_def_body) 
	;

	
action_def_body
    :    action_def_body_item*
    ;
    
action_def_body_item
    :    ':vars'^ '('! typed_list_of_variable ')'! //:existential-preconditions, :conditional-effects
    |    ':precondition'^ gd
    |    ':expansion'^ action_spec       //action expansions
    |    ':maintain'^ gd                  //action expansions
    |    ':effect'^ effect
    |    ':only-in-expansions'^ boolean_type  //action expansions
    ;

/*
Effects (7)
*/
effect
    :    '('! 'and' effect* ')'!
    |    '('! 'not' atomic_formula_of_term ')'!
    |    atomic_formula_of_term
    |    '('! 'forall' '('! typed_list_of_variable ')'! effect ')'! //:conditional−effects
    |    '('! 'when' gd effect ')'! //:conditional−effects
    |    '('! 'change' fluent expression ')'!  //:fluents
    ;

fluent
    :    general_tree_item
    ;
    
expression
    :    general_tree_item
    ;

/*
 Action expansions (8)  -- Not supported
*/

action_spec
    :    general_tree
    ;

action_spec_od_action_term 
	:	general_tree // TODO: maybe general tree?
	;


/*
Axioms (9)
*/
axiom_def 
	:	'('! ':axiom' 
	        ':vars' '('! typed_list_of_variable ')'!
	        ':context' gd
	        ':implies' literal_of_term ')'! 
	;


	

/*
Problems (13)
*/


problem_header : '('! 'problem'^ NAME ')'!
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
	:	'('! ':domain'^ NAME ')'!
	;
	
require_def
	:	'('! ':requirements'^ REQUIRE_KEY+ ')'!
	;
	
situation 
	:	'('! ':situation' NAME ')'!
	;
	
object_declaration 
	:	'('! ':objects'^ typed_list_of_name ')'!
	;

init 	:	'('! ':init'^ literal_of_name+ ')'!
	;

goal	:	'('! ':goal'^ gd ')'!
	|	'('! ':expansion'^ action_spec_od_action_term ')'! //:action-expansion
	;
	
length_spec 
	:	'('! ':length' ('('! ':serial' INTEGER ')'!)? ('('! ':parallel' INTEGER ')'!)? ')'!
	;
	 
	
initsit_header
    :   '('! 'situation'^ NAME ')'!
    ;

initsit_body
    :  '(' ':domain' NAME ')'
            initsit_body_item*   -> ^(':domain' NAME) initsit_body_item*
    ;
    
initsit_body_item
    :   object_declaration
    |   init
    ;

/*
Goal description (6)
*/

gd  :   atomic_formula_of_term
    |   complicated_gd
    ;

complicated_gd 	: 	'('! 'and' gd* ')'!
	|	'('! 'or' gd* ')'! //:disjunctive-preconditions
    |	'('! 'not' atomic_formula_of_term ')'! 
    |	'('! 'not' complicated_gd ')'! //:disjunctive-preconditions TODO lookahead
	|	'('! 'imply' gd gd ')'! //:disjunctive-preconditions
	|	'('! 'exists' '('! typed_list_of_variable ')'! gd ')'! //:existential-preconditions
	|	'('! 'forall' '('! typed_list_of_variable ')'! gd ')'! //:universal-predonditions
	;


predicate 
	:	NAME
	;


term 	:	NAME
	|	VARIABLE
	;


literal_of_name 
	:	atomic_formula_of_name
	|	'('! 'not' atomic_formula_of_name ')'!
	;

literal_of_term
	:	atomic_formula_of_term
	|	'('! 'not' atomic_formula_of_term ')'!
	;

atomic_formula_of_term
	:	'('! predicate term* ')'!
	;
	
atomic_formula_of_name
	:	'('! predicate NAME* ')'!
	;

typed_list_of_name
	:   -> ^(NAMEDEF)
	|   NAME+ -> ^(NAMEDEF NAME)+
	|   NAME+ '-' type tail=typed_list_of_name -> ^(NAMEDEF NAME type)+ $tail
	;
	
typed_list_of_name_item
	:   NAME+
	|   NAME+ '-' type   //:typing
	;
	
//This rule is needed to parse input consisting of typed_list_of_name
//If that rule is called directly a mismatch with ) and EOF occurs
typed_list_of_name_test
	: typed_list_of_name
	;

typed_list_of_variable
	:   -> ^(NAMEDEF)
	|   VARIABLE+ -> ^(NAMEDEF VARIABLE)+
	|   VARIABLE+ '-' type tail=typed_list_of_variable -> ^(NAMEDEF VARIABLE type)+ $tail
	;


type 	:	NAME -> NAME
	|	'(' 'either' type+ ')' -> ^('either' type+)
	|	'(' 'fluent' type ')' -> ^('fluent' type)   //:fluents
	;

/*
Addenda (11) -- Not supported
*/
method_def
	:	'('! ':method' general_tree_item* ')'!
	;

	
//
atomic_formula_skeleton 
	:	'('! predicate^ typed_list_of_variable ')'!
	;
	

/*
 Expression evaluation (12)
 */
 
domain_var_declaration 
	:	NAME
	|	'('! NAME NAME ')'!
	;

typed_list_of_domain_var_declaration 
	:	
	|	domain_var_declaration+ ('-' type typed_list_of_domain_var_declaration)?
	;

/*
Temp
*/

general_tree 
	:	'('! general_tree_item* ')'!
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
	
boolean_type
    :    TRUE
    |    FALSE
    ;
    
/*
Tokens
*/


TRUE
    :    'true'
    ;
    
FALSE
    :    'false'
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

NAMEDEF
    :
    ;

