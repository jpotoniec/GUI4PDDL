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
package pl.poznan.put.cs.gui4pddl.codemodel;

public class PDDLAction {
	String functor = "";
	PDDLTypedList parameters = new PDDLTypedList();
	PDDLTypedList variables = new PDDLTypedList();

	public String toString() {
		return String.format("(functor %s parameters %s variables %s)",
				functor, parameters, variables);

	}

	public PDDLAction(String functor) {
		this.functor = functor;
	}
	
	public String getFunctor() {
		return functor;
	}

	public void addParameter(String name, PDDLType type) {
		parameters.add(name, type);
	}

	public void addParameters(PDDLTypedList list) {
		parameters.append(list);
	}

	public void addVariable(String name, PDDLType type) {
		variables.add(name, type);
	}

	public void addVariables(PDDLTypedList list) {
		variables.append(list);
	}
	
	public PDDLTypedList getVariables() {
		return variables;
	}
	
	public PDDLTypedList getParameters() {
		return parameters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functor == null) ? 0 : functor.hashCode());
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result
				+ ((variables == null) ? 0 : variables.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PDDLAction other = (PDDLAction) obj;
		if (functor == null) {
			if (other.functor != null)
				return false;
		} else if (!functor.equals(other.functor))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (variables == null) {
			if (other.variables != null)
				return false;
		} else if (!variables.equals(other.variables))
			return false;
		return true;
	}
}
