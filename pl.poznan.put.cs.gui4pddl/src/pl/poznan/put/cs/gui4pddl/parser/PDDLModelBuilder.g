tree grammar PDDLModelBuilder;

options {
    tokenVocab=PDDL;
    ASTLabelType=CommonTree;
}

@header {
	package pl.poznan.put.cs.gui4pddl.parser;
	
	import pl.poznan.put.cs.gui4pddl.codemodel.*;
	import java.util.LinkedList;
}

pddl_file
    [PDDLFile file]
    :   definition[$file]*
    ;

definition
[PDDLFile file]
scope {
	PDDLDomain domain;
	PDDLProblem problem;
	PDDLInitialSituation initsit;
}
	:	^( 'define' problem_header {$definition::problem=$problem_header.val; $file.addProblem($definition::problem);} problem_item* )
	|	^( 'define' domain_header {$definition::domain=$domain_header.val; $file.addDomain($definition::domain);} domain_item* )
	|   ^( 'define' initsit_header {$definition::initsit=$initsit_header.val;} initsit_body ) {$file.addInitialSituation($definition::initsit);}
	;

/*
Domains (4)
*/

domain_header
	returns [PDDLDomain val]
	:	^( 'domain' NAME ) {$val = new PDDLDomain($NAME.text);}
	;

domain_item
	:	extension_def
	|	require_def[$definition::domain.getRequirementSet()]
	|	types_def
	|	constants_def
	|	domain_vars_def
	|	predicates_def
	|	timeless_def
	|	safety_def
	|	structure_def
	;
	
extension_def 
	:	^(':extends' (NAME {$definition::domain.addExtension($NAME.text);} )+ )
	;

require_def [PDDLRequirementSet rs]
	:	^(':requirements' (REQUIRE_KEY {$rs.add($REQUIRE_KEY.text);})+)
	;

types_def
	:	^(':types' list=typed_list) {$definition::domain.addTypes($list.list);}
	;
	
constants_def
	:	^(':constants' list=typed_list ){$definition::domain.addConstants($list.list);}
	;

domain_vars_def
	:	^(':domain-variables' list=typed_list) {$definition::domain.addDomainVariables($list.list);}
	;

predicates_def 
	:	^(':predicates' (pred=atomic_formula_skeleton {$definition::domain.addPredicate($pred.val);})+)
	;

timeless_def
	:	^(':timeless' . )
	;
	
safety_def 
	:	^(':safety' . )
	;
	
structure_def 
	:	action_def
	|   ^(':axiom' .* )
	|   ^(':method' .* )
	;
	catch [RecognitionException e] {}

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

//TODO: support for domain-var nested values

type
	returns [PDDLType t]
	@init {
		List<PDDLType> eitherTypes = new LinkedList<PDDLType>();
	}
    :	NAME {$t = PDDLType.simpleType($NAME.text);} 
	|	^('either' (nested=type {eitherTypes.add($nested.t);})+) {$t = PDDLType.eitherType(eitherTypes);}
	|   ^('fluent' nested=type) {$t = PDDLType.fluentType($nested.t);} 
	;


atomic_formula_skeleton
	returns [PDDLPredicate val]
    :  ^(NAME list=typed_list) {$val = new PDDLPredicate($NAME.text, $list.list);}
    ;
    
action_def
	: ^(':action' NAME ^(':parameters' typed_list) .*) 
	;
    
 /* Problems (13)*/  
problem_header
	returns [PDDLProblem val]
	:	^( 'problem' NAME ) {$val = new PDDLProblem($NAME.text);}
	;

problem_item
	:	domain_reference
	|	require_def[$definition::problem.getRequirementSet()]
	|	situation
	|	object_declaration[$definition::problem.getObjects()]
	|	init
	|	goal
	|	length_spec
	;

domain_reference
	:	^(':domain' NAME) {$definition::problem.addDomain($NAME.text);}
	;
	
//require_def is defined earlier

situation 
	:	^(':situation' NAME) {$definition::problem.addSituation($NAME.text);}
	;

object_declaration
	[PDDLTypedList objects]
	:	^(':objects' list=typed_list) {$objects.append($list.list);}
	;

init
 	:	^(':init' .*)
	;
	catch [RecognitionException e] {}

goal
	:	^(':goal' .*)
	|	^(':expansion' .*) 
	;
	catch [RecognitionException e] {}
	
length_spec 
	:	^(':length' .*)
	;
	catch [RecognitionException e] {}
	
/* Initial situations (13) */
initsit_header
	returns [PDDLInitialSituation val]
    :   ^('situation' NAME) {$val = new PDDLInitialSituation($NAME.text);}
    ;

initsit_body
    :  ':domain' NAME {$definition::initsit.addDomain($NAME.text);}
       initsit_body_item*
    ;
    
initsit_body_item
    :   object_declaration[$definition::initsit.getObjects()]
    |   init
    ;

