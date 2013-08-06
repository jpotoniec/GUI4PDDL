package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.editor.TokenManager;

public class CommentScanner extends RuleBasedScanner {
	public CommentScanner(TokenManager tokenManager) {
		IToken commentToken = tokenManager
				.getToken(Activator.PREF_COMMENT_COLOR);
		setDefaultReturnToken(commentToken);
	}
}