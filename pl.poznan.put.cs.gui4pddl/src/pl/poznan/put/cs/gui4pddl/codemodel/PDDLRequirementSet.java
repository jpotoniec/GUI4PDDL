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

import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PDDLRequirementSet {

	

	public static String[] knownRequirements = new String[] { ":strips",
			":typing", ":disjunctive-preconditions", ":equality",
			":existential-preconditions", ":universal-preconditions",
			":quantified-preconditions", ":conditional-effects",
			":action-expansions", ":foreach-expansions", ":dag-expansions",
			":domain-axioms", ":subgoal-through-axioms", ":safety-constraints",
			":expression-evaluation", ":fluents", ":open-world",
			":true-negation", ":adl", ":ucpop" };

	private static Map<String, String[]> implications;

	private Set<String> requirements = new TreeSet<String>();

	{
		implications = new TreeMap<String, String[]>();
		implications.put(":quantified-preconditions", new String[] {
				":existential-preconditions", ":universal-preconditions" });
		implications.put(":foreach-expansions",
				new String[] { ":action-expansions" });
		implications.put(":dag-expansions",
				new String[] { ":action-expansions" });
		implications.put(":expression-evaluation",
				new String[] { ":domain-axioms" });
		implications.put(":true-negation", new String[] { ":open-world" });
		implications.put(":fluents", new String[] { ":expression-evaluation",
				":domain-axioms" });
		implications.put(":adl", new String[] { ":strips", ":typing",
				":disjunctive-preconditions", ":equality",
				":quantified-preconditions", ":existential-preconditions",
				":universal-preconditions", ":conditional-effects" });
		implications.put(":icpop", new String[] { ":adl", ":strips", ":typing",
				":disjunctive-preconditions", ":equality:",
				":quantified-preconditions", ":existential-preconditions",
				":universal-preconditions", ":conditional-effects",
				":domain-axioms", ":safety-constraints" });
	}

	public void add(String name) {

		requirements.add(name);

		String[] temp;
		if ((temp = implications.get(name)) != null) {
			for (String implication : temp) {
				requirements.add(implication);
			}
		}
	}

	
	
	/**
	 *Checks if given requirement is contained in the set. It takes into account implications.
	 * 
	 * @param name name of requirement
	 * @return true if requirement is contained, false if not
	 */
	public boolean hasRequirement(String name) {
		return requirements.contains(name);
	}

	public static boolean isValid(String name)
	{
		for (String knownName : knownRequirements) {
			if (knownName.equals(name))
				return true;
		}
		return false;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((requirements == null) ? 0 : requirements.hashCode());
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
		PDDLRequirementSet other = (PDDLRequirementSet) obj;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		return true;
	}
}
