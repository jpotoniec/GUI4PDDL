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
package pl.poznan.put.cs.gui4pddl.codemodel;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPDDLAction {

	@Test
	public void testEquals() {
		PDDLAction expected = new PDDLAction("");
		PDDLAction actual = expected;
		assertEquals(expected.equals(actual),true);
		
		actual=null;
		assertEquals(expected.equals(actual),false);
		
		String string = new String("string");
		assertEquals(expected.equals(string),false);
		
		string = null;
		expected = new PDDLAction(string);
		actual = new PDDLAction("actual");
		assertEquals(expected.equals(actual),false);
		
		expected = new PDDLAction("expected");
		actual = new PDDLAction("actual");
		assertEquals(expected.equals(actual),false);
		
		expected = new PDDLAction("actual");
		actual = new PDDLAction("actual");
		assertEquals(expected.equals(actual),true);
		
		expected = new PDDLAction("actual");
		actual = new PDDLAction("actual");
		assertEquals(expected.equals(actual),true);
		System.out.print(actual.toString()); 
		
		
		expected.addParameter("parametr", PDDLType.simpleType("param"));
		assertEquals(expected.equals(actual),false);
		
		actual.addParameter("parametr", PDDLType.simpleType("another param"));
		assertEquals(expected.equals(actual),false);
			
		
	}

}
