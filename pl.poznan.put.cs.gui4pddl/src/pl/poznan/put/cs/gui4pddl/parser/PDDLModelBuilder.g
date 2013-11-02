tree grammar PDDLModelBuilder;

options {
    tokenVocab=PDDL;
    ASTLabelType=CommonTree;
}

@header {
	package pl.poznan.put.cs.gui4pddl.parser;
	
	import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
	import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
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
    :  .
    ;
    catch [RuntimeException e] {
    }
