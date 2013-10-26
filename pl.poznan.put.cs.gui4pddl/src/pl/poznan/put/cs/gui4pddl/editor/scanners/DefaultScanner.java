package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import pl.poznan.put.cs.gui4pddl.*;
import pl.poznan.put.cs.gui4pddl.editor.TokenManager;

public class DefaultScanner extends RuleBasedScanner {
	
	String[] keywords =
		{
		"define",
		"and",
		"change",
		"define",
		"domain",
		"either",
		"exists",
		"fluent", 
        "forall",
        "imply",
        "not",
        "or",
        "problem",
        "situation",
        "when"
		};
	
	String[] values =
		{
		":functions",
		":action",
		":axiom",
		":constants",
		":context",
		":domain",
		":domain-variables",
		":effect",
		":expansion",
		":extends",
		":goal",
		":implies",
		":init", 
	    ":length",
	    ":maintain",
	    ":method",
	    ":objects",
	    ":only-in-expansions",
	    ":parallel",
	    ":parameters",
	    ":precondition",
	    ":predicates",
	    ":requirements", 
	    ":safety",
	    ":serial",
	    ":situation",
	    ":timeless",
	    ":types",
	    ":vars",
	    ":strips",
	    ":typing",
	    ":disjunctive-preconditions",
	    ":equality",
	    ":existential-preconditions",
	    ":universal-preconditions",
	    ":quantified-preconditions",
	    ":conditional-effects",
	    ":action-expansions",
	    ":foreach-expansions",
	    ":dag-expansions",
	    ":domain-axioms",
	    ":subgoal-through-axioms",
	    ":safety-constraints",
	    ":expression-evaluation",
	    ":fluents",
	    ":open-world",
	    ":true-negation",
	    ":adl",
	    ":ucpop"
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
		//IRule valueRule = new ValueRule(valueToken);
		WordRule valueRule = new WordRule(new IWordDetector() {
            public boolean isWordStart(char c) { 
         	if(c==':')
         		return true;
         	return false;
            }
            public boolean isWordPart(char c) {
            	if(c=='-') return true;
            	return Character.isLetter(c); 
            }
         });
		for (int i = 0; i < values.length; i++)
		{
		valueRule.addWord(values[i], valueToken);
		}
		IRule variableRule = new VariableRule(variableToken);
		WordRule keywordRule = new WordRule(new IWordDetector() {
			public boolean isWordStart(char c) {
				return Character.isLetter(c);
			}

			public boolean isWordPart(char c) {
				return (c == '-') || (Character.isLetterOrDigit(c));
			}
		}, defaultToken);
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