/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl.editor.scanners;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class PDDLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String PDDL_COMMENT = "__pddl_comment";
	public final static String PDDL_DEFAULT = "__pddl_default";

	public PDDLPartitionScanner() {
		super();
		Token commentPartition = new Token(PDDL_COMMENT);
		Token valuePartition = new Token(PDDL_DEFAULT);
		

		
		SingleLineRule commentRule = new SingleLineRule(";", null,
				commentPartition, (char) 0, true);
		//commentRule.setColumnConstraint(0);

		setPredicateRules(new IPredicateRule[] { commentRule });
	}

	public static String[] getLegalContentTypes() {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE,
				PDDLPartitionScanner.PDDL_COMMENT,
				 };
	}
}
