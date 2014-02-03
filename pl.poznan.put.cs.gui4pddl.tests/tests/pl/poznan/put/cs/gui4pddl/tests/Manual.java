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
package pl.poznan.put.cs.gui4pddl.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import pl.poznan.put.cs.gui4pddl.codemodel.PDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.parser.PDDLLexer;
import pl.poznan.put.cs.gui4pddl.parser.PDDLModelBuilder;
import pl.poznan.put.cs.gui4pddl.parser.PDDLParser;



public class Manual {

	void run() {

		PDDLCodeModel model = new PDDLCodeModel();
		
		InputStream stream;
		try {
			stream = this.getClass().getResourceAsStream("test.pddl");
			
			
			//stream = new FileInputStream("test.pddl");
			ANTLRInputStream input = new ANTLRInputStream(stream);
			PDDLLexer lexer = new PDDLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			PDDLParser parser = new PDDLParser(tokens);
			
			try {
				PDDLParser.pddl_file_return ret = parser.pddl_file();
				CommonTree t = (CommonTree)ret.getTree();
				System.out.println(t.toStringTree());
				
				 CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
			     PDDLModelBuilder walker = new PDDLModelBuilder(nodes); // create a tree parser
			     
			     URL filepath = this.getClass().getResource("test.pddl");
			     IPath path = Path.fromOSString(filepath.getPath());
			     
			     PDDLFile file = model.getOrCreateFile(path);
			     walker.pddl_file(file);                 // launch at start rule prog
			
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
		
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Manual runner = new Manual();
		runner.run();
	}

}
