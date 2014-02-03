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
package pl.poznan.put.cs.gui4pddl.codecompletion;

import java.io.InputStream;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.parser.PDDLLexer;

public class PDDLCodeCompletionContext {
	enum DefinitionType {
		PROBLEM,
		DOMAIN,
		INITSIT,
		NONE,
		COMMENT
	}
	
	private DefinitionType type = DefinitionType.NONE;
	private String name = "";
	//privateBoolean is whitespace
	
	//public int currentTokenNumber
	
	//Stack of lists of {tokenType, tokenText}
	
	//equals
	
	private Stack<List<Token>> scopeStack; 
	private List<Token> currentScope;
	private char lastChar;
	private IPDDLCodeModel codeModel;
	private PDDLFile fileIndex;
	
	public PDDLCodeCompletionContext(IPDDLCodeModel model, PDDLFile fileIndex) {
		scopeStack = new Stack<List<Token>>();
		currentScope = new LinkedList<Token>();
		scopeStack.push(currentScope);

		this.codeModel = model;
		this.fileIndex = fileIndex;
	}
	
	public IPDDLCodeModel getCodeModel() {
		return codeModel;
	}
	
	public PDDLFile getFileIndex() {
		return fileIndex;
	}
	
	public boolean isDomain() {
		return type == PDDLCodeCompletionContext.DefinitionType.DOMAIN;
	}
	public boolean isProblem() {
		return type == PDDLCodeCompletionContext.DefinitionType.PROBLEM;
	}
	
	//pobiera token znajdujący się jako piewszy po tym samym nawiasie co kursor
	public Token getOpeningToken() {
		if (currentScope != null && currentScope.size() > 0)
			return currentScope.get(0);
		return null;
	}
	
	public boolean isOpeningToken(int type, boolean recursive) {
		int i = scopeStack.size() - 1;
		do {
			List<Token> scope = scopeStack.get(i);
			if (scope.size() > 0 && scope.get(0).getType() == type)
				return true;
			i--;
		} while (recursive && i > 0);
		
		return false;
	}
	
	public boolean isPrecedingToken(int type, boolean recursive, boolean includeCurrentScope) {
		int i;
		if (includeCurrentScope)
			i = scopeStack.size() - 1;
		else 
			i = scopeStack.size() - 2;
		
		do {
			List<Token> scope = scopeStack.get(i);
			if (scope.size() >= 2 && scope.get(scope.size() - 2).getType() == type)
				return true;
			i--;
		} while (recursive && i > 0);
		
		return false;
	}
	
	public boolean isPreviousToken(int type) {
		List<Token> scope = scopeStack.peek();
		if (scope.size() > 0 && scope.get(scope.size()-1).getType() == type)
			return true;
		else
			return false;
	}
	
	public boolean isFirstInScope() {
		if (currentScope.size() == 0)
			return true;
		if (currentScope.size() == 1 && !Character.isWhitespace(lastChar))
			return true;

		return false;
	}
	
	public int nestingLevel() {
		if (scopeStack.size() == 0)
			return 0;
		else
			return scopeStack.size() - 1;
	}
	
	public DefinitionType getDefinitionType() {
		return type;
	}
	
	public String getDefinitionName() {
		return name;
	}
	
	public List<Token> getElementScope(int elementType) {
		for (int i =  scopeStack.size() - 1; i >= 0; i--)
		{
			List<Token> scope = scopeStack.get(i);
			if (scope.size() > 0 && scope.get(0).getType() == elementType)
				return scope;
		}
		return null;
	}
	
	public void parse(IDocument document, int offset) {
		try {
			if (document.getPartition(offset).getType() == null) {
				type = DefinitionType.COMMENT;
				return;
			}
			
			lastChar = document.getChar(offset-1);

			ANTLRStringStream input = new ANTLRStringStream(document.get(0,
					offset));
			
			PDDLLexer lexer = new PDDLLexer(input);
			TokenParser parser = new TokenParser();

			Token token;
			while ((token = lexer.nextToken()).getType() != Token.EOF) {				
				parser.parseToken(token);
			}
		} catch (BadLocationException e) {
			return;
		}

	}
	
	public String toString() {
		String typename;
		switch(type) {
		case DOMAIN: typename = "DOMAIN"; break;
		case PROBLEM: typename = "PROBLEM"; break;
		case INITSIT: typename = "INITSIT"; break;
		default: typename = "NONE";
		}
		return String.format("(%s %s last: %c stack:(%s))", typename, name, lastChar, scopeStack);
	}
	
	
	private enum HeaderState {
		NONE,
		CATCH_TYPE,
		CATCH_NAME
	}
	
	private class TokenParser {
		private HeaderState headerState = HeaderState.NONE;
		
		private void catchHeader(Token t) {			
			switch (headerState) {
			case NONE:
				if(t.getType() == PDDLLexer.DEFINE) {
					headerState = HeaderState.CATCH_TYPE;
					name = "";
					type = DefinitionType.NONE;
				}
				break;
			case CATCH_TYPE:
				switch (t.getType()) {
				case PDDLLexer.DOMAIN_DEF:
					type = DefinitionType.DOMAIN;
					headerState = HeaderState.CATCH_NAME;
					break;
				case PDDLLexer.PROBLEM_DEF:
					type = DefinitionType.PROBLEM;
					headerState = HeaderState.CATCH_NAME;
					break;
				case PDDLLexer.SITUATION_DEF:
					type = DefinitionType.INITSIT;
					headerState = HeaderState.CATCH_NAME;
					break;
				}
				break;
			case CATCH_NAME:
				if(t.getType() == PDDLLexer.NAME)
					name = t.getText();
				headerState  = HeaderState.NONE;
			}
		}
		
		private void parseToken(Token t) {
			System.out.println(t);
			
			if (t.getType() == PDDLLexer.COMMENT)
				return;
			
			catchHeader(t);
			
			
			currentScope.add(t);
			
			if (t.getType() == PDDLLexer.PLEFT) {
				currentScope = new LinkedList<Token>();
				scopeStack.push(currentScope);
			}
			
			if (t.getType() == PDDLLexer.PRIGHT) {
				if (scopeStack.size() > 1) {
					scopeStack.pop();
					currentScope = scopeStack.peek();
				}
			}
		}
	}
	

	/*
		InputStream stream = null;
		try {
			stream = file.getContents();

			ANTLRInputStream input = new ANTLRInputStream(stream);
			PDDLLexer lexer = new PDDLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
	}
	//name
	//
	 * */
	
	
}
