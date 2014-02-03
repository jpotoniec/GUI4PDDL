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
