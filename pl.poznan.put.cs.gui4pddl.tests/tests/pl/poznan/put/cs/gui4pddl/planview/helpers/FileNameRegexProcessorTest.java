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
