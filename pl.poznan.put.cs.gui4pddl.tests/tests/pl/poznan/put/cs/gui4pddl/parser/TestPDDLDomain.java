package pl.poznan.put.cs.gui4pddl.parser;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLType;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLTypedList;

public class TestPDDLDomain {

	@Test
	public void testIsSubtype() {
		PDDLDomain domain = new PDDLDomain("domena");
		
		PDDLTypedList list = new PDDLTypedList();
		list.add("ala", PDDLType.defaultType());
		list.add("ma", PDDLType.simpleType("type1"));
		
		domain.addTypes(list);
		
		domain.getTypeNames();
		//To zwróci liste
		//assertEquals czy lista to "ala ma type1 object"
		Set<String> expected = new TreeSet<String>();
		expected.add("ala");
		expected.add("ma");
		expected.add("type1");
		expected.add("object");
		assertEquals(expected,list);
		//assert czy .isSubtype(PDDLType.simpleType("ala"), PDDLType.simpleType("type1"));
		
		//fail("Not yet implemented");
	}

}
