package csc131.project;

import java.io.PrintWriter;
import java.util.Random;

public class Finder //class for the cellphone finder.
{
	private int lostTag;// takes in the tag and gps of the lost phone as instance variables.
	private int lostGps;
	
	public Finder()
	{
		lostTag = -1;
		lostGps = -1;
	}
	public int getLostTag()
	{
		return lostTag;
	}
	public int getLostGps()
	{
		return lostGps;
	}
	public void getItemTag(int tag)// gets the lost item tag.
	{
		lostTag = tag;
	}
	public void findGPSLocation()// simulates gps with randomizer.
	{
		// randomized gps.
		Random rand = new Random();
		lostGps = rand.nextInt(10000) + 1;
	}
	public void reportGPS(PrintWriter writer)// reports the lost phones location to the database.
	{
		writer.println(lostTag + " " + lostGps);
		//write to file
	}
}