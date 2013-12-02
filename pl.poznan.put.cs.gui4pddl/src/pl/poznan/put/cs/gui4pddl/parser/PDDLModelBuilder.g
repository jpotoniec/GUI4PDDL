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
    [PDDLFile filemodel]
    scope {
    	PDDLFile file;
    }
    :    {$pddl_file::file = $filemodel;} definition*
    ;

definition
scope {
	PDDLDomain domain;
}
//	:	^( 'define' problem_header problem_item* )
	:	^( 'define' domain_header domain_item* ) 
//	|   ^( 'define' initsit_header initsit_body )
	;

/*
Domains (4)
*/

domain_header 
	:	^( 'domain' NAME ) {$definition::domain = $pddl_file::file.getOrCreateDomain($NAME.text);}
	;

domain_item
	:	extension_def
	|	require_def
	|	types_def
	|	constants_def
	|	domain_vars_def
	|	predicates_def
	|	timeless_def
	|	safety_def
//	|	structure_def
	;
	
extension_def 
	:	^(':extends' (NAME {$definition::domain.addExtension($NAME.text);} )+ )
	;

require_def
	:	^(':requirements' (REQUIRE_KEY {$definition::domain.addRequirement($REQUIRE_KEY.text);})+)
	;

types_def
@init {
	PDDLTypedList types = new PDDLTypedList();
}
	:	^(':types' typed_list_of_name_item[types]* ) {$definition::domain.addTypes(types);}
	;
	
constants_def
	:	^(':constants' typed_list_of_name[$definition::domain.getConstants()] )
	;

domain_vars_def
	:	^(':domain-variables' typed_list_of_domain_var_declaration)
	;

predicates_def 
	:	^(':predicates' atomic_formula_skeleton+)
	;

timeless_def
	:	^(':timeless' . )
	;
	
safety_def 
	:	^(':safety' . )
	;
	
structure_def 
	:	
	;
    
typed_list_of_name
	[PDDLTypedList list]
	:   typed_list_of_name_item[$list]*
	;

typed_list_of_name_item
    [PDDLTypedList list]
    : NAMEDEF
    | ^(NAMEDEF NAME) {list.add($NAME.text, null);}
    | ^(NAMEDEF NAME type) {list.add($NAME.text, $type.t);}
	;


type returns [PDDLType t]
	@init {
		List<PDDLType> eitherTypes = new LinkedList<PDDLType>();
	}
    :	NAME {$t = PDDLType.simpleType($NAME.text);} 
	|	^('either' (nested=type {eitherTypes.add($nested.t);})+) {$t = PDDLType.eitherType(eitherTypes);}
	|   ^('fluent' nested=type) {$t = PDDLType.fluentType($nested.t);} 
	;

    
typed_list_of_domain_var_declaration
    :  .
    ;
    catch [RuntimeException e] {
    }

atomic_formula_skeleton
    :  .
    ;
    catch [RuntimeException e] {
    }
