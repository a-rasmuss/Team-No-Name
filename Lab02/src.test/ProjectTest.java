import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import csc131.project.Project;

public class ProjectTest {
	
	private static final String DEFAULT_DELIMETER = "\n";

	private Project project;
	private String delimeter;
	private String expectedResult;
	@Before
	public void setUp() {
		project = new Project();
		delimeter = DEFAULT_DELIMETER;
		expectedResult = "";
	}
	
	
	@Test
	public void successfullyGetsFileContentUsingNewLine() throws FileNotFoundException {
		expectedResult = "this" + delimeter + "is" + delimeter + "a" +
					delimeter + "test" + delimeter + "file" + delimeter + "called: readme" +
					delimeter + "for CSC131 class project" + delimeter;
		assertNotNull(project.getFileContent(delimeter));
		assertEquals("returns the contents of the file", expectedResult, project.getFileContent(delimeter));
	}
}
