package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.editor.TokenManager;

public class DefineScanner extends RuleBasedScanner {
	public DefineScanner(TokenManager tokenManager) {
		IToken commentToken = tokenManager
				.getToken(Activator.PREF_DEFINE_COLOR);
		setDefaultReturnToken(commentToken);
	}
}