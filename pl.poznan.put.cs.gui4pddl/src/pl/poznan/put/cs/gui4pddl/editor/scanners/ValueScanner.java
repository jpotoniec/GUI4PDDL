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

public class ValueScanner extends RuleBasedScanner {
	String[] keywords = { "ALL", "DEBUG", "ERROR", ":requirements"
	// ...
	};

	public ValueScanner(TokenManager tokenManager) {
		IToken defaultToken = tokenManager
				.getToken(Activator.PREF_DEFAULT_COLOR);
		IToken formatToken = tokenManager
				.getToken(Activator.PREF_FORMAT_COLOR);
		IToken keywordToken = tokenManager
				.getToken(Activator.PREF_KEYWORD_COLOR);
		IRule braceRule = new SingleLineRule("{", "}", formatToken, (char) 0,
				true);
		WordRule keywordRule = new WordRule(new WordDetector());
		for (int i = 0; i < keywords.length; i++) {
			keywordRule.addWord(keywords[i], keywordToken);
		}
		IRule formatRule = new FormatRule(formatToken);
		IRule whitespaceRule = new WhitespaceRule(new WhitespaceDetector());
		setDefaultReturnToken(defaultToken);
		setRules(new IRule[] { braceRule, formatRule, keywordRule,
				whitespaceRule, });
	}
}