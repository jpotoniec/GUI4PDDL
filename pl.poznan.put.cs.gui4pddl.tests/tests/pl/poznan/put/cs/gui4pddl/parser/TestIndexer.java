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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import pl.poznan.put.cs.gui4pddl.codemodel.PDDLAction;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLPredicate;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLType;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLTypedList;

public class TestIndexer {
	
	public PDDLFile loadFile(String path){
		File f= new File(path);
		InputStream stream;
		try {
			stream = new FileInputStream(f);
			PDDLCodeModel model = new PDDLCodeModel();
			IPath filepath = new Path(path);
			PDDLFile file = model.getOrCreateFile(filepath);
			PDDLAnalyzer.indexPDDLFile(stream, model, file, null);
			return file;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		return null;
	}
	@Test
	public void test() throws FileNotFoundException {

		
		PDDLFile file = loadFile("sample/PIPESWORLD/DOMAIN.PDDL");
				
		PDDLFile expected = new PDDLFile(new Path("sample/PIPESWORLD/DOMAIN.PDDL").toPortableString());
		PDDLDomain domain = new PDDLDomain("pipesworld_strips");
		domain.addRequirement(":strips");
		domain.addRequirement(":typing");
		domain.addConstant("lco", PDDLType.simpleType("product"));
		domain.addConstant("gasoleo", PDDLType.simpleType("product"));
		domain.addConstant("rat-a", PDDLType.simpleType("product"));
		domain.addConstant("oca1", PDDLType.simpleType("product"));
		domain.addConstant("oc1b", PDDLType.simpleType("product"));
		
		PDDLTypedList list = new PDDLTypedList();
		list.add("?pipe", PDDLType.simpleType("pipe"));
		domain.addPredicate(new PDDLPredicate("unitary",list));
		
		list = new PDDLTypedList();
		list.add("?pipe", PDDLType.defaultType());
		domain.addPredicate(new PDDLPredicate("not-unitary",list));
		
		list = new PDDLTypedList();
		list.add("?batch-atom", PDDLType.simpleType("batch-atom"));
		list.add("?product", PDDLType.simpleType("product"));
		domain.addPredicate(new PDDLPredicate("is-product",list));
		

	    	    		
		PDDLAction action = new PDDLAction("PUSH-START");
		list = new PDDLTypedList();
		list.add("?pipe",PDDLType.simpleType("pipe"));
		list.add("?batch-atom-in",PDDLType.simpleType("batch-atom"));
		list.add("?from-area",PDDLType.simpleType("area"));
		list.add("?to-area",PDDLType.simpleType("area"));
		list.add("?first-batch-atom",PDDLType.simpleType("batch-atom"));
		list.add("?product-batch-atom-in",PDDLType.simpleType("product"));
		list.add("?product-first-batch",PDDLType.simpleType("product"));
		action.addParameters(list);
		domain.addAction(action);	


	    	    		
		action = new PDDLAction("POP-END");
		list = new PDDLTypedList();
		action.addParameter("?pipe",PDDLType.simpleType("pipe"));
		action.addParameter("?from-area",PDDLType.simpleType("area"));
		action.addParameter("?to-area",PDDLType.simpleType("area"));
		action.addParameter("?first-batch-atom",PDDLType.simpleType("batch-atom"));
		action.addParameter("?next-first-batch-atom",PDDLType.simpleType("batch-atom"));
		action.addParameters(list);
		domain.addAction(action);
		
		
		
		expected.addDomain(domain);
		System.out.println(file);
		System.out.println(expected);
		
		assertEquals(expected, file);
		
		
	}
	
	@Test
	public void test2() throws FileNotFoundException {

		
		PDDLFile file = loadFile("sample/AIRPORT/DOMAIN.PDDL");
		//PDDLFile expected = new PDDLFile(new Path("sample/AIRPORT/DOMAIN.PDDL").toPortableString());
		//PDDLDomain domain = new PDDLDomain("pipesworld_strips");
		
		
		
	}

}
