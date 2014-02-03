/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl.parser;

import static org.junit.Assert.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import pl.poznan.put.cs.gui4pddl.codemodel.PDDLType;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLTypedList;

public class TestTypedListParse {

	PDDLTypedList parseList(String text) throws RecognitionException {
		PDDLTypedList list = new PDDLTypedList();
		
		ANTLRStringStream stream = new ANTLRStringStream(text);
		PDDLLexer lexer = new PDDLLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		PDDLParser parser = new PDDLParser(tokens);
		parser.setPrintToStdErr(true);
		PDDLParser.typed_list_of_name_test_return ret = parser.typed_list_of_name_test();
		CommonTree t = (CommonTree)ret.getTree();
		System.out.println(t.toStringTree());		
		
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
	    PDDLModelBuilder walker = new PDDLModelBuilder(nodes);
	    list = walker.typed_list();
	    
	    return list;
	}

	@Test
	public void test() {
		String text = "type1 type2 type3 another-type";
		
		PDDLTypedList expected = new PDDLTypedList();
		expected.add("type1", PDDLType.defaultType());
		expected.add("type2", PDDLType.defaultType());
		expected.add("type3", PDDLType.defaultType());
		expected.add("another-type", PDDLType.defaultType());
		
		try {
			PDDLTypedList actual = parseList(text);
			assertEquals(expected, actual);
		} catch (RecognitionException e){
			fail("RecognitionException: " + e.getMessage());
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testEither() {
		String text = "object1 - (either type1 type2)";
		
		PDDLTypedList expected = new PDDLTypedList();
		List typeList = new LinkedList<PDDLType>();
		typeList.add(PDDLType.simpleType("type1"));
		typeList.add(PDDLType.simpleType("type2"));
		PDDLType type = PDDLType.eitherType(typeList);
		expected.add("object1", type);
		
		try {
			PDDLTypedList actual = parseList(text);
			assertEquals(expected, actual);
		} catch (RecognitionException e){
			fail("RecognitionException: " + e.getMessage());
		}
		
	}
	
	@Test
	public void testTypes() {
		String text = "object1 object2 - type1 object3 - type2";
		
		PDDLTypedList expected = new PDDLTypedList();
		expected.add("object1", PDDLType.simpleType("type1"));
		expected.add("object2", PDDLType.simpleType("type1"));
		expected.add("object3", PDDLType.simpleType("type2"));

		try {
			PDDLTypedList actual = parseList(text);
			assertEquals(expected, actual);
		} catch (RecognitionException e){
			fail("RecognitionException: " + e.getMessage());
		}
	}
	
	@Test
	public void testTypesDefault() {
		String text = "object1 object2 - type1 object3 - type2 object4";
		
		PDDLTypedList expected = new PDDLTypedList();
		expected.add("object1", PDDLType.simpleType("type1"));
		expected.add("object2", PDDLType.simpleType("type1"));
		expected.add("object3", PDDLType.simpleType("type2"));
		expected.add("object4",  PDDLType.defaultType());

		try {
			PDDLTypedList actual = parseList(text);
			assertEquals(expected, actual);
		} catch (RecognitionException e){
			fail("RecognitionException: " + e.getMessage());
		}

	}
		
}
