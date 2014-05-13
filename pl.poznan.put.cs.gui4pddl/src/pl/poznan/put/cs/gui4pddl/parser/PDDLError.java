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
package pl.poznan.put.cs.gui4pddl.parser;

import org.antlr.runtime.RecognitionException;

public class PDDLError {
	enum Type {
		ERROR, WARNING;
	}

	public int charPositionInLine;
	public int line;
	public String message;
	Type type = Type.ERROR;

	public PDDLError() {
		// TODO Auto-generated constructor stub
	}

	public PDDLError(RecognitionException ex) {
		this.charPositionInLine = ex.charPositionInLine;
		this.line = ex.line;
		this.message = ex.getMessage();
	}
}
