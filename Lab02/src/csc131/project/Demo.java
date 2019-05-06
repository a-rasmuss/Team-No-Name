package csc131.project;
import java.io.*;
import java.util.*;
public class Demo
{
	public static void main(String args[])
	{
		start();
	}
	public static void start() //throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Scanner console = new Scanner(System.in);
		Project demo = new Project();
		CellPhoneOwner owner = new CellPhoneOwner();
		Finder finder = new Finder();
		String id = "";
		System.out.println("Welcome.");
		do
		{
			System.out.print("Please enter your login id: ");
			id = console.nextLine();
		} while (!id.equalsIgnoreCase("1234"));
		String choice = "";
		do
		{
			System.out.println("\nHere are your options:");
			System.out.println("Register tag");
			System.out.println("Report lost phone");
			System.out.println("Exit\n");
			choice = console.nextLine();
			if (choice.equalsIgnoreCase("Register tag"))
			{
				System.out.println("Your tag is: " + owner.getTag());
				demo.writeToFile(owner.getTag() + "    " + owner.getGPS());
				System.out.println("Your tag has been registered");
			}
			else if (choice.equalsIgnoreCase("Report lost phone"))
			{
				owner.setGPS(-1);
				demo.writeToFile(owner.getTag() + "    " + owner.getGPS());
				finder.getItemTag(owner.getTag());
				System.out.println("Your lost phone has been reported.");
			}
		} while (!choice.equalsIgnoreCase("Exit"));
		try
		{
			System.out.println("\nCurrent phone info:");
			System.out.println(demo.getFileContent(" "));
		} catch(FileNotFoundException error)
		{
			error.getMessage();
		}
		finder.findGPSLocation();
		demo.writeToFile(finder.getLostTag() + "    " + finder.getLostGps());
		try
		{
			System.out.println("\nPhone info after located: ");
			System.out.println(demo.getFileContent(" "));
		} catch(FileNotFoundException error)
		{
			error.getMessage();
		}
	}
}
