package pl.poznan.put.cs.gui4pddl.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.log.Log;

public class PDDLIndexer {

	public interface IErrorHandler {
		void reportError(PDDLError error);
	}
	
	public static CommonTree scanPDDLFile(InputStream stream, IErrorHandler errorHandler)
			throws RecognitionException, IOException {
		
		CommonTree result = null;

		try {
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
				reportErrors(errors, errorHandler);
			}	
		}
		finally {
			if (stream != null) {
				stream.close();
			}
		}
		
		return result;
	}
	
	public static void updateIndex(CommonTree ast, PDDLFile index)
			throws RecognitionException {
		System.out.println(ast.toStringTree());

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		PDDLModelBuilder builder = new PDDLModelBuilder(nodes);
		builder.pddl_file(index);
	}

	public static void checkSemanticErrors(CommonTree ast,
			IPDDLCodeModel codeModel, PDDLFile fileIndex, IErrorHandler errorHandler)
			throws RecognitionException {

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		PDDLSemanticChecker checker = new PDDLSemanticChecker(nodes);
		try {
			checker.pddl_file(codeModel, fileIndex);
		} finally {
			List<PDDLError> errors = checker.getErrors();
			reportErrors(errors, errorHandler);
		}
	}
	
	public static void indexPDDLFile(InputStream fileStream, IPDDLCodeModel codeModel, PDDLFile fileIndex, IErrorHandler errorHandler) {
		try {
			CommonTree ast = scanPDDLFile(fileStream, errorHandler);
			if (codeModel != null) {
				fileIndex.clear();
				try {
					updateIndex(ast, fileIndex);
				} catch (RecognitionException e) {}
				
				checkSemanticErrors(ast, codeModel, fileIndex, errorHandler);
			}
		} catch (IOException e) {  
			Log.log(e);
		}  catch (RecognitionException e) {
			Log.log(e);
		} catch (RuntimeException e) {
			Log.log(e);
		}
	}
	
	public static void indexPDDLFile(IFile file, IPDDLCodeModel codeModel, IErrorHandler errorHandler) {
		try {
			InputStream fileStream = file.getContents();
			PDDLFile fileIndex = codeModel.getOrCreateFile(file);
			indexPDDLFile(fileStream, codeModel, fileIndex, errorHandler);
		} catch (CoreException e){
			Log.log(e);
		}
	}
	
	public static void indexPDDLFile(IFile file, IPDDLCodeModel codeModel) {
		PDDLIndexer.IErrorHandler dummyErrorHandler = new PDDLIndexer.IErrorHandler() {
			public void reportError(PDDLError error) {
			}
		};
		indexPDDLFile(file, codeModel, dummyErrorHandler);
	}
	


	private static void reportErrors(List<PDDLError> errors, IErrorHandler handler) {
		if (handler == null)
			return;

		for (PDDLError error: errors) {
			handler.reportError(error);
		}
	}
}
