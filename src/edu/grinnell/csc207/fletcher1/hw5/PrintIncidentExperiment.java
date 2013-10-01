package edu.grinnell.csc207.fletcher1.hw5;

import edu.grinnell.glimmer.ushahidi.*;
import java.io.*;

public class PrintIncidentExperiment {
	 public static void main(String[] args) throws Exception{
		 PrintWriter pen = new PrintWriter(System.out);
	        // A few basic incidents
	        UshahidiExtensions.printIncident(pen, UshahidiUtils.SAMPLE_INCIDENT);
	        UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
	        UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());

	        // A newly created incident
	        UshahidiIncident myIncident = new UshahidiIncident();
	        UshahidiExtensions.printIncident(pen, myIncident);

	        // One from a list
	        UshahidiClient client = UshahidiUtils.SAMPLE_CLIENT;
	        UshahidiExtensions.printIncident(pen, client.nextIncident());

	        // One that requires connecting to the server
	        UshahidiClient webclient = new UshahidiWebClient("https://mightymoriver.crowdmap.com/");
	        UshahidiExtensions.printIncident(pen, webclient.nextIncident());
	    } // main(String[])
}
