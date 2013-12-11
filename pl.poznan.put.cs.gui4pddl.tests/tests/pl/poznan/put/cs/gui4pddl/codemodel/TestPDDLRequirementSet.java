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
