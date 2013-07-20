package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.WhitespaceRule;

import pl.poznan.put.cs.gui4pddl.*;
import pl.poznan.put.cs.gui4pddl.editor.TokenManager;

public class DefaultScanner extends RuleBasedScanner {
	public DefaultScanner(TokenManager tokenManager) {
		IToken propertyToken = tokenManager
				.getToken(Activator.PREF_DEFAULT_COLOR);
		setDefaultReturnToken(propertyToken);
		setRules(new IRule[] { new WhitespaceRule(new WhitespaceDetector()) });
	}
}