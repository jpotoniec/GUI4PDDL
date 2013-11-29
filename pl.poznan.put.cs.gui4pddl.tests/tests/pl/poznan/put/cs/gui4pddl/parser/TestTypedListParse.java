package pl.poznan.put.cs.gui4pddl.parser;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.Test;

import pl.poznan.put.cs.gui4pddl.codemodel.PDDLTypedList;

public class TestTypedListParse {

	PDDLTypedList parseList(String text) throws RecognitionException {
		PDDLTypedList list = new PDDLTypedList();
		
		ANTLRStringStream stream = new ANTLRStringStream(text);
		PDDLLexer lexer = new PDDLLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		System.out.println(tokens);
		for(Token t : tokens.getTokens())
			System.out.println(t);
		
		
		PDDLParser parser = new PDDLParser(tokens);
		PDDLParser.typed_list_of_name_test_return ret = parser.typed_list_of_name_test();
		CommonTree t = (CommonTree)ret.getTree();
		
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
	    PDDLModelBuilder walker = new PDDLModelBuilder(nodes);
	    walker.typed_list_of_name(list);
	    
	    return list;
	}

	@Test
	public void test() {
		String text = "type1 type2 type3 another-type";
		PDDLTypedList list;
		Set<String> expectedTypenames = new TreeSet<String>(Arrays.asList(new String[] {"type1", "type2", "type3", "another-type"}));
		
		try {
			list = parseList(text);
			assertEquals(expectedTypenames, list.getNames());
		} catch (RecognitionException e){
			fail("RecognitionException: " + e.getMessage());
		}
		
	}

}
