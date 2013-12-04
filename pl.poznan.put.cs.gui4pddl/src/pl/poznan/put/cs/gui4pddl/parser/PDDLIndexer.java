package pl.poznan.put.cs.gui4pddl.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.log.Log;

public class PDDLIndexer {

	public interface IErrorHandler {
		void reportError(IFile file, PDDLError error);
	}
	
	public static CommonTree scanPDDLFile(IFile file, IErrorHandler errorHandler)
			throws CoreException, IOException, RecognitionException {
		
		if (file == null || !file.exists())
			throw new IOException("file does not exist"); 
		
		CommonTree result = null;
		
		InputStream stream = null;
		try {
			stream = file.getContents();

			ANTLRInputStream input = new ANTLRInputStream(stream);
			PDDLLexer lexer = new PDDLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			PDDLParser parser = new PDDLParser(tokens);
			parser.setPrintToStdErr(false);
			
			try {
				PDDLParser.pddl_file_return ret = parser.pddl_file();
				result = (CommonTree)ret.getTree();
			} finally {
				List<PDDLError> errors = parser.getErrors();
				reportErrors(file, errors, errorHandler);
			}	
		}
		finally {
			if (stream != null) {
				stream.close();
			}
		}
		
		return result;
	}
	
	public static void updateIndex(CommonTree ast, PDDLFile index) {
		//we can update PDDLFile from commonTree
	}
	
	public static void checkSemanticErrors(IFile file, CommonTree ast, IPDDLCodeModel codeModel, IErrorHandler errorHandler) {
		//checks semantic errors based on PDDLCodeModel and commonTree
	}
	
	public static void indexPDDLFile(IFile file, IPDDLCodeModel codeModel, IErrorHandler errorHandler) {
		try {
			CommonTree ast = scanPDDLFile(file, errorHandler);
			if (codeModel != null) {
				PDDLFile index = codeModel.getOrCreateFile(file);
				updateIndex(ast, index);
				checkSemanticErrors(file, ast, codeModel, errorHandler);
			}
		} catch (CoreException e) {
			Log.log(e);
		} catch (IOException e) {
			Log.log(e);
		} catch (RecognitionException e) {
			Log.log(e);
		}
	}

	private static void reportErrors(IFile file, List<PDDLError> errors, IErrorHandler handler) {
		for (PDDLError error: errors) {
			handler.reportError(file, error);
		}
	}
}