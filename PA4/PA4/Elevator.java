/**

This is a class for PA4 for COSI 12 by Vee Zhu
This class represent the behaviors of the elevator

*/



public class Elevator {

    // Fields
    // TODO: what object instances should you keep track of?
    /* Note:    You need to keep track of the current floor
                at which the elevator is at. Every time the
                elevator moves, a line should be printed to
                indicate the current floor of the elevator,
                which should change a floor at a time. */
	Job[] jobs;
	int jobIndex; //how many jobs in the job array
	int currJobIndex; //current job Index
	int currFloor; //the current location of the floor
	Building building;
    int people;

    // Constructor

    /**
     *  Make sure to instantiate the required objects, such as the array
     *  of jobs that the elevator needs to have.
     */
    public Elevator() {
    	jobs = new Job[100];
		jobIndex = 0;
		currJobIndex = 0;
		currFloor = 1; //lift starts at stop 1
		people=0;

    }

    // Methods

    /**
     *  This method should simply add, in the right place, a new job
     *  to be completed by the elevator.
     *  @param person the person that requested the elevator
     *  @param floor the desired floor number
     */
    public boolean createJob(Person person, int floor) {
        // TODO: implement me!
        /* Note:    In order to add jobs to the array you will
                    need to have a variable that will keep track
                    of the index of the job added last, this way
                    you will be able to add a job at the next
                    position in the array. */
    	//this is the job taking individual to the desired stop
    			jobs[jobIndex] = new Job(person, floor); 
    			if(jobs[jobIndex].num>4)
    			{
    				jobIndex++;
    			}			
    			people++;
    			return true;

    }

    /**
     *  This method will be used after completing (and removing) a job.
     *  The use of this method should guarantee that the jobs array is
     *  in a valid state.
     */
    public void cleanUpJobs(Job job) {
    	System.out.println("The lift is currently on floor "+ (this.currFloor-1));
		//back to floor 1	
		for(this.currFloor = currFloor-2; this.currFloor>=1; this.currFloor--) {
			System.out.println("The lift is on stop "+ this.currFloor);
		}
		people=people-job.num;

    }

    /**
     *  This method should remove jobs one by one (in the right order)
     *  and process them individually.
     */
    public void processAllJobs() {
    	for(currJobIndex=0; currJobIndex<jobIndex; currJobIndex++) {
			if(this.currFloor != 1 ) {
				if(currJobIndex >=1) {
					this.cleanUpJobs(jobs[currJobIndex -1]);
					//removing the previous job 
					jobs[currJobIndex -1] = null;
				//special case when lift is not at stop1 but there is a new group of people 
				}else { 
					this.cleanUpJobs(jobs[currJobIndex]);
				}
			}
			//traversing the job array 
			System.out.println("The lift is now at floor 1 ");
			this.processJob(jobs[currJobIndex]);		
			
		}
		//set the job index back to 0
		this.jobIndex = 0; 
		
    }

    /**
     *  This method should process a job, and move the elevator floor
     *  by floor (while printing updates) in order to reach the desired
     *  floor. Then, the exit method should be called, simulating the exit
     *  of a person (if necessary).
     *  @param job the job to be processed
     */
    public boolean processJob(Job job) {
    	job.person.currLocation = 200; //in the lobby
		System.out.println(job.person.getLocation()); 
		System.out.println("It will now take "+job.person+" to floor "+job.floor);
		job.person.currLocation = 400; //represent the person is on the elevator
		System.out.println(job.person.getLocation());
		
		//start a loop represent the elevator is processing 
		for(this.currFloor=2; this.currFloor<=job.floor; this.currFloor++) { //starting at stop2
			System.out.println("The lift has reached floor "+ this.currFloor);
		}
		this.exit(job.person, job.floor);
		System.out.println(job.person+" has arrived at their floor.");
		//update the person's current location
		job.person.currLocation = job.floor; 
		System.out.println(job.person.getLocation());
		
		return true;

    }

    /**
     *  This method should call a method on the building for a person
     *  to enter a given floor (hold a reference to the person in the given
     *  floor).
     *  @param person the person exiting at a given floor
     *  @param floor the floor at which the person is exiting
     */
    public boolean exit(Person person, int floor) {
    	this.building.enterFloor(person, floor);
		return true;

    }

    /**
     *  This string tells the info for the person at certain floor in the elevator
     *  The string should be informative yet clean and concise
     */
    public String toString() {
    	return "Elevator info: "+this.jobs[currJobIndex].person.toString()+ " is on floor "+this.currFloor;

    }
}
