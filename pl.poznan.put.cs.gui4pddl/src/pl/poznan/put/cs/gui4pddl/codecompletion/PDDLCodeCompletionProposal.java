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
package pl.poznan.put.cs.gui4pddl.codecompletion;

public class PDDLCodeCompletionProposal implements Comparable<PDDLCodeCompletionProposal>{
	
	private String text;
	private String description;
	
	public PDDLCodeCompletionProposal(String text) {
		this.text = text;
	}
	
	public PDDLCodeCompletionProposal(String text, String description) {
		this.text = text;
		this.description = description;
	}
	
	public String getText() {
		return text;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getInvalid() {
		return false;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int compareTo(PDDLCodeCompletionProposal o) {
		return text.compareTo(o.text);
	}
}
