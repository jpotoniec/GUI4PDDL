package pl.poznan.put.cs.gui4pddl;

import pl.poznan.put.cs.gui4pddl.codecompletion.IPDDLCodeCompletionManager;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;

public interface IPDDLNature {

	IPDDLCodeCompletionManager getCodeCompletionManager();

	IPDDLCodeModel getCodeModel();
}
