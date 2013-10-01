package edu.grinnell.csc207.fletcher1.hw5;

import java.io.PrintWriter;
import java.util.GregorianCalendar;
import edu.grinnell.glimmer.ushahidi.*;

public class UshahidiExtensions {

	/* Preconditions: No additional.
	 * Postconditions: Prints relevant information about the given UshahidiIncident. */
	
	public static void printIncident(PrintWriter pen, UshahidiIncident event){
		pen.println("Incident #: "+ event.getTitle()
				+ "\n  " + event.getDescription()
				+ "\n  Location: "+ event.getLocation()
				+ "\n  Status: (" + event.getMode() + ", " + event.getActive() 
				+ ", " + event.getVerified() + ")"
				+ "\n");
	} // printIncident(PrintWriter, UshahidiIncident)
	
	/* Preconditions:
	 * Postconditions: */
	
	public static UshahidiIncidentList UshahidiIncidentList() {
		// STUB
		return null;
	} // UshahidiIncidentList()
	
	/* Preconditions: Incident IDs must be positive integers.
	 * Postconditions: Prints the UshahidiIncidents with the highest and lowest IDs
	 * from the given UshahidiClient. */
	
	public static void extremeIncidents(UshahidiClient client) throws Exception {
		int currentId, largest, smallest;
		smallest = 0;
		largest = 0;
		UshahidiIncident small = UshahidiIncident();
		UshahidiIncident big = UshahidiIncident();
		UshahidiIncident current;
		PrintWriter pen = new PrintWriter(System.out, true);
		
		for (client.hasMoreIncidents();;) { // while there are incidents in the client
			current = client.nextIncident(); // get the next incident
			currentId = current.getId(); // get the next incident's id
			if (currentId > largest) { // if this incident's id is the largest so far, set it
				largest = currentId;   // to the incident big
				big = current;
			} // if
			if (currentId < smallest) { // if this incident's id is the smallest so far, set it
				smallest = currentId;   // to the incident small
				small = current;
			} // if
			
			if (! client.hasMoreIncidents()) { // break before reaching the end of the client
				break;
			}
			
		} // for
		
		// print the incidents
		pen.println("Lowest ID\n");
		printIncident(pen, small);
		pen.println("Highest ID\n");
		printIncident(pen, big);
		
	} // extremeIncidents(UshahidiClient)

	/* Preconditions: No additional.
	 * Postconditions: Prints the UshahidiIncidents between the given start and end dates from
	 * the given UshahidiClient. */
	
	public void identifyIncidents(UshahidiClient client, GregorianCalendar start, 
			GregorianCalendar end) throws Exception {
		
		boolean afterStart = false;
		boolean afterEnd = false;
		UshahidiIncident current;
		GregorianCalendar currentDate;
		PrintWriter pen = new PrintWriter(System.out, true);
		
		for (client.hasMoreIncidents();;) { // while there are incidents in the client
			current = client.nextIncident(); // get the next incident
			currentDate = (GregorianCalendar) current.getDate(); // get the next incident's date
			
			if (currentDate == start) {
				afterStart = true;
			}
			
			if (currentDate == end) {
				afterEnd = true;
			}
			
			// print the incidents between the start and end dates
			if (afterStart && afterEnd == false) {
				printIncident(pen, current);
			}
			
			// break after we reach the end date
			if (afterEnd) {
				break;
			}
		}
	} // identifyIncidents(UshahidiClient, GregorianCalendar, GregorianCalendar)
	
	/* Preconditions:
	 * Postconditions: Returns a list of the UshahidiIncidents between the given start and end
	 * dates from the given UshahidiClient. */
	
	public static UshahidiIncidentList selectIncidents(UshahidiClient client, 
			GregorianCalendar start, GregorianCalendar end) throws Exception {
		
		boolean afterStart = false;
		boolean afterEnd = false;
		UshahidiIncident current;
		GregorianCalendar currentDate;
		UshahidiIncidentList found = UshahidiIncidentList();
		
		for (client.hasMoreIncidents();;) { // while there are incidents in the client
			current = client.nextIncident(); // get the next incident
			currentDate = (GregorianCalendar) current.getDate(); // get the next incident's date
			
			if (currentDate == start) {
				afterStart = true;
			}
			
			if (currentDate == end) {
				afterEnd = true;
			}
			
			// add the incidents between the dates to the list to be returned
			if (afterStart && afterEnd == false) {
				found.addIncident(current);
			}
			
			// break after we reach the end date
			if (afterEnd) {
				break;
			}
		}
		
		return found;
		
	} // identifyIncidents(GregorianCalendar, GregorianCalender)
	
} // UshahidiExtensions
