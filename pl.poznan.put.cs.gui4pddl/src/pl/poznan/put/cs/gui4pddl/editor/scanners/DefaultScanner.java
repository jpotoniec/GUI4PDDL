package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import pl.poznan.put.cs.gui4pddl.*;
import pl.poznan.put.cs.gui4pddl.editor.TokenManager;

public class DefaultScanner extends RuleBasedScanner {
	
	String[] keywords =
		{
		"define",
		};
	
	public DefaultScanner(TokenManager tokenManager) {
		IToken defaultToken = tokenManager
				.getToken(Activator.PREF_DEFAULT_COLOR);
		IToken valueToken = tokenManager
				.getToken(Activator.PREF_VALUE_COLOR);
		IToken variableToken = tokenManager
				.getToken(Activator.PREF_VARIABLE_COLOR);
		IToken keywordToken = tokenManager
				.getToken(Activator.PREF_KEYWORD_COLOR);
		IToken bracketToken = tokenManager
				.getToken(Activator.PREF_BRACKET_COLOR);
		IRule valueRule = new ValueRule(valueToken);
		IRule variableRule = new VariableRule(variableToken);
		WordRule keywordRule = new WordRule(new WordDetector());
		for (int i = 0; i < keywords.length; i++)
		{
		keywordRule.addWord(keywords[i], keywordToken);
		}
		IRule bracketRule = new BracketRule(bracketToken);
		IRule whitespaceRule = new WhitespaceRule(new WhitespaceDetector());
		setDefaultReturnToken(defaultToken);
		setRules(new IRule[] {keywordRule, valueRule, variableRule, bracketRule, whitespaceRule });
	}
}