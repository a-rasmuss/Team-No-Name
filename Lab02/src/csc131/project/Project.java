package csc131.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Project {

	private static final String READ_FILE = "readme"; //file to read from
	private static final String WRITE_FILE = "writeToMe"; //file to write to
	
	private PrintWriter writer;
	private static String lineText; //stores the values of the text file 'readme'
	private static Scanner scanner;
	
	
	public Project() {
		//default constructor
	}
	/**
	 * opens and reads from a file, then stores and returns
	 * the file content in a string field, fileContent
	 * @param inDelimeter
	 * @return the content of the file read as a string
	 * @throws FileNotFoundException
	 */
	public String getFileContent(String inDelimeter) throws FileNotFoundException {
		StringBuilder fileContent = new StringBuilder();
		try {
			scanner = new Scanner(new File(READ_FILE));
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
	/**
	 * writes some string values to the file 'writeToMe'
	 * @param input, the string value to write to the file
	 * @return true, if the file was written to successfully
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public Boolean writeToFile(String input) {
		try {
			writer = new PrintWriter(WRITE_FILE, "UTF-8");
			writer.println(input);
		} catch (FileNotFoundException e) {
			System.out.println("Error, file not found: " + e.getMessage());
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.close();
		return writer.checkError() == false ? true : false;
	}
}
