import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.Scanner;

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
	private String write;
	
	
	@Before
	public void setUp() {
		project = new Project();
		delimeter = DEFAULT_DELIMETER;
		expectedResult = "";
		write = "";
	}
	
	
	@Test
	public void successfullyGetsFileContentUsingNewLine() throws FileNotFoundException {
		expectedResult = "this" + delimeter + "is" + delimeter + "a" +
					delimeter + "test" + delimeter + "file" + delimeter + "called: readme" +
					delimeter + "for CSC131 class project" + delimeter;
		assertNotNull(project.getFileContent(delimeter));
		assertEquals("returns the contents of the file ", expectedResult, project.getFileContent(delimeter));
	}
	@Test
	public void writeValuesToFile() {
		write = "test: writing to the file";
		assertEquals("successfully wrote to file ",true,project.writeToFile(write));
	}
	
	@Test
	public void printTest() 
	{
		write = "This is the test case for a program that in no way resembles a phone gps tag!";
		project.writeToFile(write);
		
		Scanner input;
		try {
			input = new Scanner(new File("writeToMe"));
			while (input.hasNextLine())
			{
				System.out.println(input.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("successfully wrote to file", true, project.writeToFile(write));
		
		
	}
	
	@test
	public void testfindGPSLocation()
	{
		System.out.println("if a random number outputs following this message, then success!!");
		System.out.println(findGPSLocation());
	}
	
	@test
	public void testsetGPS()
	{
		int gps = 12;
		System.out.println(CellPhoneOwner(setGPS.gps));//should output the GPS that was set in this test case
	}
}
