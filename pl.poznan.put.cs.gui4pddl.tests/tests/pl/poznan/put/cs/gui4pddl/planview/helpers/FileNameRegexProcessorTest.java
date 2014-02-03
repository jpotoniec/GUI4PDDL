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
package pl.poznan.put.cs.gui4pddl.planview.helpers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileNameRegexProcessorTest {

	@Test
	public void testGetRegexWithReplacementsAtBegin() {
		
		assertEquals(FileNameRegexProcessor.getRegexWithReplacements("-project_name-blablalbalksadfj", "-project_name-", "project-name"), "project-nameblablalbalksadfj");
	}
	
	@Test
	public void testGetRegexWithReplacementsAtEnd() {
		
		assertEquals(FileNameRegexProcessor.getRegexWithReplacements("blablalbalksadfj-project_name-", "-project_name-", "project-name"), "blablalbalksadfjproject-name");
	}
	
	@Test
	public void testGetRegexWithReplacementsInTheMiddle() {
		
		assertEquals(FileNameRegexProcessor.getRegexWithReplacements("blablal-project_name-balksadfj", "-project_name-", "project-name"), "blablalproject-namebalksadfj");
	}
	
	@Test
	public void testGetRegexWithReplacementsWithErrorInTheMiddle() {
		
		assertEquals(FileNameRegexProcessor.getRegexWithReplacements("blablal-project_namebalksadfj", "-project_name-", "project-name"), "blablal-project_namebalksadfj");
	}
	
	@Test
	public void testGetRegexWithReplacementsWithErrorAtBegin() {
		
		assertEquals(FileNameRegexProcessor.getRegexWithReplacements("project_name-blablalbalksadfj", "-project_name-", "project-name"), "project_name-blablalbalksadfj");
	}
	
	@Test
	public void testGetRegexWithReplacementsWithErrorAtEnd() {
		
		assertEquals(FileNameRegexProcessor.getRegexWithReplacements("blablalbalksadfj-project_name", "-project_name-", "project-name"), "blablalbalksadfj-project_name");
	}
	
	

}
