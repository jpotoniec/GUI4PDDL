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

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestPDDLRequirementSet extends PDDLRequirementSet {

	@Test
	public void test() {/*
		Set<String> compare = new TreeSet<String>();
		compare.add(":quantified-preconditions");
		compare.add(":existential-preconditions");
		compare.add(":universal-preconditions");*/
		PDDLRequirementSet reqSet = new PDDLRequirementSet();
		reqSet.add(":quantified-preconditions");
		assert(hasRequirement(":quantified-preconditions"));
		assert(hasRequirement(":existential-preconditions"));
		assert(hasRequirement(":universal-preconditions"));

	}

}
