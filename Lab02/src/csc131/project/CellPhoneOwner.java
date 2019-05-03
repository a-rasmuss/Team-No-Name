package csc131.project;

import java.io.PrintWriter;
import java.util.Random;

public class CellPhoneOwner
{
	private int tag;
	private int gps;

	public CellPhoneOwner()
	{
		Random rand = new Random();
	    tag = rand.nextInt(100) + 1;
	    gps = 0;// gps location is 0 when the phone is in owner's possession.
	}
    public int getTag()
	{
		return tag;
	}
	public int getGPS()
	{
		return gps;
	}
	public void setGPS(int gps)
	{
		this.gps = gps;
	}
	public void registerTag(PrintWriter writer)
	{
		writer.println(tag + " " + gps);
	}
	public int notifyOfLoss(PrintWriter writer)
	{
		setGPS(-1);// gps location is -1 if lost.
		writer.println(tag + " " + gps);// update file.
		return tag;// return phone tag.
	}
}