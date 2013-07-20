package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class PDDLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String PDDL_DEFINE = "__pddl_define";
	public final static String PDDL_VALUE = "__pddl_value";
	public final static String PDDL_QUESTION = "__pddl_question";
	public final static String PDDL_COMPARE = "__pddl_compare";

	public PDDLPartitionScanner() {
		super();
		Token valuePartition = new Token(PDDL_VALUE);
		Token definePartition = new Token(PDDL_DEFINE);
		Token questionPartition = new Token(PDDL_QUESTION);
		Token comparePartition = new Token(PDDL_COMPARE);
		

		
		SingleLineRule defineRule = new SingleLineRule("(define", null,
				definePartition, (char) 0, true);
		defineRule.setColumnConstraint(0);
		
		SingleLineRule compareRuleMore = new SingleLineRule("(>", null,
				comparePartition, (char) 0, true, false);
		
		SingleLineRule compareRuleLess = new SingleLineRule("(<", null,
				comparePartition, (char) 0, true, false);
		
		SingleLineRule compareRuleEqual = new SingleLineRule("(=", null,
				comparePartition, (char) 0, true, false);
		
		SingleLineRule valueRule = new SingleLineRule(":", null,
				valuePartition, (char) 0, true);
		
		
		SingleLineRule questionRule = new SingleLineRule("?", null,
				questionPartition, (char) 0, true);
		
		setPredicateRules(new IPredicateRule[] { defineRule, valueRule, questionRule, compareRuleMore, compareRuleLess, compareRuleEqual });
	}

	public static String[] getLegalContentTypes() {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE,
				PDDLPartitionScanner.PDDL_DEFINE,
				PDDLPartitionScanner.PDDL_VALUE,
				PDDLPartitionScanner.PDDL_QUESTION,
				PDDLPartitionScanner.PDDL_COMPARE };
	}
}