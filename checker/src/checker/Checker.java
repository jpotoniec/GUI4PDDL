package checker;

import java.io.IOException;

import org.antlr.runtime.*;

public class Checker {

	public static void main(String[] args) throws IOException{
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		PDDLLexer lexer = new PDDLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PDDLParser parser = new PDDLParser(tokens);
		
		try {
			parser.definition();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
