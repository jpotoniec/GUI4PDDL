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
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLProblem;
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
	
	public static void updateIndex(CommonTree ast, PDDLFile index)
			throws RecognitionException {
		System.out.println(ast.toStringTree());

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		PDDLModelBuilder builder = new PDDLModelBuilder(nodes);
		builder.pddl_file(index);
	}

	public static void checkSemanticErrors(IFile file, CommonTree ast,
			IPDDLCodeModel codeModel, IErrorHandler errorHandler)
			throws RecognitionException {

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(ast);
		PDDLSemanticChecker checker = new PDDLSemanticChecker(nodes);
		PDDLFile fileIndex = codeModel.getFile(file, false);
		fileIndex = new PDDLFile(file.getFullPath().toPortableString());
		try {
			checker.pddl_file(codeModel, fileIndex);
		} finally {
			List<PDDLError> errors = checker.getErrors();
			reportErrors(file, errors, errorHandler);
		}
	}
	
	public static void indexPDDLFile(IFile file, IPDDLCodeModel codeModel) {
		PDDLIndexer.IErrorHandler dummyErrorHandler = new PDDLIndexer.IErrorHandler() {
			public void reportError(IFile file, PDDLError error) {
			}
		};
		indexPDDLFile(file, codeModel, dummyErrorHandler);
	}
	
	public static void indexPDDLFile(IFile file, IPDDLCodeModel codeModel, IErrorHandler errorHandler) {
		try {
			CommonTree ast = scanPDDLFile(file, errorHandler);
			if (codeModel != null) {
				PDDLFile index = codeModel.getOrCreateFile(file);
				index.clear();
				try {
					updateIndex(ast, index);
				} catch (RecognitionException e) {}
				
				//Debug code for prining
				for(PDDLDomain d: codeModel.getDomains(null)) {
					System.out.println(d.getName());
				}
				
				for(PDDLProblem p: index.getProblems()) {
					PDDLDomain d = codeModel.getDomain(p);
					if (d != null)
						System.out.printf("Domain for %s is %s at %s", p.getName(), d.getName(), d.getFile().getFullPath().toOSString());
					else
						System.out.printf("Domain for %s is NULL", p.getName());
				}
				
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
