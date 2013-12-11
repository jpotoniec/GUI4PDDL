package pl.poznan.put.cs.gui4pddl;

import pl.poznan.put.cs.gui4pddl.codecompletion.IPDDLCodeCompletionManager;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLProjectIndex;

public interface IPDDLNature {

	IPDDLCodeCompletionManager getCodeCompletionManager();

	IPDDLProjectIndex getPDDLProjectIndex();
	
	IPDDLCodeModel getCodeModel();
}
