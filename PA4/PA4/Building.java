/**
* This is a class for PA4 for COSI 12 by Vee Zhu
* This shows a building. This will hold an array of floors and an instanve of an elevator

*/



public class Building {
	Floor[] floors;
	Elevator elevator;
    // Fields
    // TODO: what object instances should you keep track of?


    // Constructor

    /**
     *  Make sure to instantiate the building's elevator and the array
     *  of floors. You can decide on the specifics of the building.
     */
    public Building() {
        // TODO: implement me!
    	elevator = new Elevator(this);
    	floors = new Floor[100];
    	for(int i=0; i< floors.length; i++) {
			floors[i] = new Floor(i+1);
			//the i+1 is the parameter that represent the number of the floor
    	}
    }

    /**
     *  This method will process the request made by a person to enter the
     *  building. Then, it should pass on the request to an elevator instance.
     *  Make sure that the elevator visits the first floor and then the floor
     *  requested by the person.
     *  @param person the person that has requested access to the building
     *  @param floor the number of the desired floor
     */
    public boolean enterElevator(Person person, int floor) {
        //check if the person has used the elevator before
    	boolean firstTime = true;
		for(int i=0; i<floors.length; i++) { //for every floor
			for(int j=0; j<floors[i].personIndex; j++) { 
				if(floors[i].peopleAtFloor[j].equals(person) == true) {
					firstTime = false;
				}
				
			}
		}
		if(firstTime == true) { //if the person is using the elevator for the first time, create the job
			elevator.createJob(person, floor);
			}
			return firstTime;
    }

    /**
     *  This will call a method in the elevator instance that should process
     *  all current jobs.
     */
    public void startElevator() {
    	this.elevator.processAllJobs();

    }

    /**
     *  This method should simply access the given floor object and
     *  call a method to save a reference to the person in the given
     *  floor.
     *  @param person the person to acceess the floor
     *  @param floor the floor to be entered
     */
    public boolean enterFloor(Person person, int floor) {
    	this.floors[floor-1].enterFloor(person);//[floor-1] because the index is 1 less than the floor number
		return true;
    }

    /**
     *  The string should be informative yet clean and concise
     *  In this method I will print out the number of people on each floor
     */
    public String toString() {
        String eachFloor = "";
        for(int i=0; i<this.floors.length; i++) {
        	String temp = "There are " + (this.floors[i].personIndex) +" people on floor "+ (i+1) + "\n";
        	eachFloor = eachFloor + temp ; //put together a string that print the number of people
        }
        return eachFloor;
    }
}
