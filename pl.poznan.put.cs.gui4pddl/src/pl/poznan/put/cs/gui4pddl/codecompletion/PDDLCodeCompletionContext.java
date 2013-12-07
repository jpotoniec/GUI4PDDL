package pl.poznan.put.cs.gui4pddl.codecompletion;

import java.io.InputStream;
import java.util.EmptyStackException;
import java.util.Stack;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

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
	private Stack<Token> openingTokenStack = new Stack<Token>();
	
	
	public PDDLCodeCompletionContext(IDocument document, int offset) {
		getContextInfo(document, offset);
	}
	
	
	private void getContextInfo(IDocument document, int offset) {
		try {
			if (document.getPartition(offset).getType() == null) {
				type = DefinitionType.COMMENT;
				return;
			}

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
		return String.format("(%s %s stack:(%s))", typename, name, openingTokenStack);
	}
	
	
	private enum HeaderState {
		NONE,
		CATCH_TYPE,
		CATCH_NAME
	}
	
	private class TokenParser {
		private HeaderState headerState = HeaderState.NONE;
		private boolean openingToken = false;
		
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
			
			if (openingToken)
				openingTokenStack.push(t);
			
			if (t.getType() == PDDLLexer.PLEFT)
				openingToken = true;
			else
				openingToken = false;
			
			if (t.getType() == PDDLLexer.PRIGHT) {
				try {
					openingTokenStack.pop();
				} catch (EmptyStackException e) {}
				if (openingTokenStack.empty())
				{
					type = DefinitionType.NONE;
					name = "";
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
