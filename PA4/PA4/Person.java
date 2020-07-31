/**
this class shows a person in the elevator
This is a class for PA4 for COSI 12 by Vee Zhu

*/


public class Person {
	String first;
	String last;
	int currLocation;
	//the first name and last name of the person taking the elevator
    // Fields
    // TODO: what object instances should you keep track of?


    // Constructor

    /**
     * This constructs the person using the parameter first and last names
     *   Make sure to pass as parameter the necessary information to
     *  initialize the object with a name and a last name.
     */
    public Person(String first, String last) {
    	this.first = first; 
		this.last = last; 
		this.currLocation = 0;
    }
    
    /**
     *  This method will simply call the appropriate method from the
     *  building instance to enter the elevator and request a job.
     *  @param building the building to be entered
     *  @param floor the floor requested
     */
    public boolean enterBuilding(Building building, int floor) {
    	boolean valid = true;
    	valid = building.enterElevator(this, floor);
    	if(valid == true) {
    		this.currLocation = 200; //stands for in lobby
    	}else {
    		System.out.println("Not valid for the ride.");
    	}
		return valid;
    }

    /**
     * In this program I set the floor level as 1-100;
     * if currLocation is 200, the person is in the lobby
     * if currLocation is 400, the person is in the elevator
     */
    
    /**
     *  You should hold a variable that will say the location of a person. You can choose how
     *  to implement this, but you should return strings like "In lobby",
     *  "In Elevator", or "In floor 4", etc...
     */
    public String getLocation() {
    	 if(currLocation == 200) {
			 return this.toString()+" is waiting in lobby.";
		 }if(currLocation == 400 ) {
			 return this.toString()+" is in the elevator";
		 }if(currLocation == 0) {
			 return this.toString()+" was not valid to take the elevator";
		 }else {
			 return this.toString()+" is on floor "+currLocation;
		 }

    }

    /**
     *  The string should be informative yet clean and concise
     */
    public String toString() {
    	return first+" "+last;

    }
}
