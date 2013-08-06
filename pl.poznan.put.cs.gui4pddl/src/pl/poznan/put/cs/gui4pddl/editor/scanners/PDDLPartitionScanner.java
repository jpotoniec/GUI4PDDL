package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class PDDLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String PDDL_COMMENT = "__pddl_comment";
	public final static String PDDL_VALUE = "__pddl_value";
	public final static String PDDL_QUESTION = "__pddl_question";
	public final static String PDDL_COMPARE = "__pddl_compare";

	public PDDLPartitionScanner() {
		super();
		Token commentPartition = new Token(PDDL_COMMENT);
		Token valuePartition = new Token(PDDL_VALUE);
		Token questionPartition = new Token(PDDL_QUESTION);
		

		
		SingleLineRule commentRule = new SingleLineRule(";", null,
				commentPartition, (char) 0, true);
		commentRule.setColumnConstraint(0);
		
		SingleLineRule valueRule = new SingleLineRule(":", null,
				valuePartition, (char) 0, true);
		
		
		SingleLineRule questionRule = new SingleLineRule("?", null,
				questionPartition, (char) 0, true);
		
		setPredicateRules(new IPredicateRule[] { commentRule, valueRule, questionRule });
	}

	public static String[] getLegalContentTypes() {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE,
				PDDLPartitionScanner.PDDL_COMMENT,
				PDDLPartitionScanner.PDDL_VALUE,
				PDDLPartitionScanner.PDDL_QUESTION };
	}
}