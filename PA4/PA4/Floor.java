/**

This is a class for PA4 for COSI 12 by Vee Zhu
This class represent a floor

*/



public class Floor {

    // Note: you may assume that the capacity won't be surpassed.
    public static final int floorCapacity = 100;

    // Fields
    Person[] peopleAtFloor;
	int floorNum;
	int personIndex; //keep track of the array
    // TODO: what object instances should you keep track of?


    // Constructor

    /**
     *  Make sure to instantiate the required fields.
     */
    public Floor(int floor) {
    	this.peopleAtFloor = new Person[floorCapacity];
		floorNum = floor;
		personIndex = 0; //beginning is 0

    }

    // Methods

    /**
     *  This method should save a reference to the person.
     *  @param person the person to enter the floor.
     */
    public boolean enterFloor(Person person) {
    	peopleAtFloor[personIndex] = person;
		personIndex++;
		return true;// TODO: implement me!

    }

    /**
     *  The string tells the total number of people on certain floor.
     */
    public String toString() {
    	return this.personIndex+" on floor "+floorNum;

    }
}
