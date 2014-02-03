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

import org.eclipse.jface.text.rules.IWordDetector;

public class WordDetector implements IWordDetector {
	public boolean isWordStart(char c) {
		return Character.isLetter(c);
	}

	public boolean isWordPart(char c) {
		return Character.isLetterOrDigit(c);
	}
}
