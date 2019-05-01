package csc131.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Project {

	private static final String FILE_NAME = "readme"; //file name

	private static String lineText; //stores the values of the text file 'readme'
	private static Scanner scanner;
	
	
	public Project() {
		//default constructor
	}
	public String getFileContent(String inDelimeter) throws FileNotFoundException {
		StringBuilder fileContent = new StringBuilder();
		try {
			scanner = new Scanner(new File(FILE_NAME));
			while(scanner.hasNextLine()) {
				lineText = scanner.nextLine();
				fileContent.append(lineText).append(inDelimeter);
			}
			scanner.close();
		} catch (FileNotFoundException error) {
			System.err.println("Error! Unable to open file. Error: "+ error);
		}
		return fileContent.toString();
	}
	
}
