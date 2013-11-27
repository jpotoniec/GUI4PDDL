package pl.poznan.put.cs.gui4pddl.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pl.poznan.put.cs.gui4pddl.tests.ui.wizards.PDDLFileWizardTest;
import pl.poznan.put.cs.gui4pddl.tests.ui.wizards.PDDLProjectWizardTest;

@RunWith(Suite.class)
@SuiteClasses({PDDLProjectWizardTest.class, PDDLFileWizardTest.class, PDDLNatureTest.class})
public class AllTests {

}
