/**
This is a class for PA4 for COSI 12 by Vee Zhu
This is the simulation program.
This program simulates the building.
There are multiple groups of people taking the elevator.
*/


public class Simulation {

    /* Note: use additional methods as you see fit. */

    public static void main(String[] args) {
    	Building build = new Building();
    	
    	//group 1
    	Person per1 = new Person("Vee","Zhu");
		per1.enterBuilding(build, 10);
		Person per2 = new Person("Cindy", "Lovely");
		per2.enterBuilding(build,3);
		Person per3 = new Person("Sarah", "Peterson");
		per3.enterBuilding(build,27);
		Person per4 = new Person("Alex", "Wang");
		per4.enterBuilding(build,49);

		build.startElevator();
		System.out.println("\nPeople on each floor so far:");
		System.out.print(build.toString()+" \n");
		
		//group2
		Person perOne = new Person("Linda","Shapiro");
		perOne.enterBuilding(build, 26);
		Person perTwo = new Person("Mic", "Jacob");
		perTwo.enterBuilding(build,3);
		
		build.startElevator();
		System.out.println("\nPeople on each floor so far:");
		System.out.print(build.toString()+" \n");
    }

}
