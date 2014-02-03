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
