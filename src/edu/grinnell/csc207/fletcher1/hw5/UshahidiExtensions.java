package edu.grinnell.csc207.fletcher1.hw5;

import java.io.PrintWriter;
import edu.grinnell.glimmer.ushahidi.*;

public class UshahidiExtensions {

	public static void printIncident(PrintWriter pen, UshahidiIncident event){
		pen.println("Incident #: "+ event.getTitle()
				+ "\n  " + event.getDescription()
				+ "\n  Location: "+ event.getLocation()
				+ "\n  Status: (" + event.getMode() + event.getActive() 
				+ event.getVerified() + ")");
	} // printIncident(PrintWriter, UshahidiIncident)
	
} // UshahidiExtensions
