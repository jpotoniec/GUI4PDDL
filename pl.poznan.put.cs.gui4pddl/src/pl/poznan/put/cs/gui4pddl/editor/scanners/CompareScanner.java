package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import pl.poznan.put.cs.gui4pddl.*;
import pl.poznan.put.cs.gui4pddl.editor.TokenManager;

public class CompareScanner extends RuleBasedScanner {
	String[] keywords = { "ALL", "DEBUG", "ERROR", ":requirements"
	// ...
	};

	public  CompareScanner(TokenManager tokenManager) {
		IToken defaultToken = tokenManager
				.getToken(Activator.PREF_DEFAULT_COLOR);
		IToken compareToken = tokenManager
				.getToken(Activator.PREF_COMPARE_COLOR);
		IToken keywordToken = tokenManager
				.getToken(Activator.PREF_KEYWORD_COLOR);
		IToken questionToken = tokenManager
				.getToken(Activator.PREF_QUESTION_COLOR);
		
		IRule braceRule = new SingleLineRule("?", null, questionToken, ' ',
				true);
		WordRule keywordRule = new WordRule(new WordDetector());
		for (int i = 0; i < keywords.length; i++) {
			keywordRule.addWord(keywords[i], keywordToken);
		}
		IRule compareRule = new CompareRule(compareToken);
		IRule whitespaceRule = new WhitespaceRule(new WhitespaceDetector());
		setDefaultReturnToken(defaultToken);
		setRules(new IRule[] { braceRule, compareRule, keywordRule,
				whitespaceRule, });
	}
}