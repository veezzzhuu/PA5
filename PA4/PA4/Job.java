/**

This is a class for PA4 for COSI 12 by Vee Zhu
This class represent a job that is an elevator trip
*/

public class Job {

    // Fields
	Person person; 
	int floor;
    int num;

    // Constructor

    /**
     *  this shows the job: the person and what floor is requested for the job
     *  Make sure to pass the necessary parameters in order to
     *  instantiate a Job object that holds a person and a floor.
     */
    public Job(Person per, int floor) {
		person = per;
		this.floor = floor;
        num++;
    }

    // Methods

    /**
     *  this string tells the current job of the elevator
     *  where it is going and who it is carrying
     *  The string should be informative yet clean and concise
     */
    public String toString() {
    	return "The current job: "+person.first+" "+person.last+" going to "+ floor;

    }
}
