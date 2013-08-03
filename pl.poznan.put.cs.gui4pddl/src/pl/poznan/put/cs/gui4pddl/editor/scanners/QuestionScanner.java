package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.PatternRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.editor.TokenManager;

public class QuestionScanner extends RuleBasedScanner {

	public  QuestionScanner(TokenManager tokenManager) {
		IToken defaultToken = tokenManager
				.getToken(Activator.PREF_DEFAULT_COLOR);
		IToken questionToken = tokenManager
				.getToken(Activator.PREF_QUESTION_COLOR);
		IRule questionRule = new QuestionRule(questionToken);
		IRule whitespaceRule = new WhitespaceRule(new WhitespaceDetector());
		setDefaultReturnToken(defaultToken);
		setRules(new IRule[] { questionRule,
				whitespaceRule, });
	}
}