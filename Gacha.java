/**
 * Quick Gacha simulator (to the best of my knowledge)
**/


public class Gacha {
	private int[] pulls;
	private int[] threes;	// To keep track of at each index (pull count) 3*s
	private int[] fours;	// "                                         " 4*s
	private int[] fives;	// "                                         " 5*s
	
	private int fivePity;
	private int fourPity;
	private int fiveCount;
	private int fourCount;
	private int atPity;
	
	private int total;

	public Gacha (int count) {
		this.total = count;
		
		this.pulls = new int[count];	// Initializes all with a size of count
		this.threes = new int[count];
		this.fours = new int[10]; 	// Max pity 10
		this.fives = new int[90];	// Max pity 90
		
		this.fivePity = 0;	// Initialize pity counters to 0
		this.fourPity = 0;
		this.fiveCount = 0;
		this.fourCount = 0;
		this.atPity = 0;
	}
	
	public void printRates() {
		System.out.println ("Out of " + this.total + " Pulls..");
		System.out.println (" " + this.fiveCount + " 5*s with " + this.atPity + " @ Pity");
		System.out.println (" " + this.fourCount + " 4*s");
	}
	
	public void printFives() {
		for (int i = 0; i < fives.length; i++) {
			double percent = 100.0 * (double) fives[i] / (double) fiveCount;
			if (i % 10 == 0) System.out.println();
			System.out.print (String.format(" | %2d: [", i) + String.format("%4d, ", fives[i]) + String.format("%4.2f", percent) + "%]");
		}
	}
	
	public void sim() {
		/**
		 * How 'for loop' works:
		 *
		 * for ({variable counter}; {condition for loop}; {Operation post loop}) {
		 * 	{Code to be looped through};
		 * }
		 *
		 * For the example below:
		 *  Variable counter: int i = 0; our loop will start with i @ 0 (because array indexing starts at 0).
		 *  Condtition: i < pulls.length; our loop will continue as long as i < pulls.length, being 100 in this case.
		 *  Operation post loop: i++; i will increment by 1 after each loop.
		 *
		**/
		for (int i = 0; i < pulls.length; i++) {	// Loop through all the pulls (100 pulls)
			int pull = pull();			// Pulls 
			this.pulls[i] = pull;			// Stores pull at i-th index of pulls
			
			if (pull == 3) { this.threes[i]++; }
			if (pull == 4) { this.fourCount++; }
			if (pull == 5) { this.fiveCount++; }
		}
	}
	
	/**
	 * How functions work:
	 * {"Visibility"} {Return Type} {Function Name}({Function Parameters}) {
	 *	{Code that is ran when function is called upon};
	 * }
	 * 
	 * - "Visibility" refers to what code can "see" this function; 'private' means
	 *	only the class object itself can see it, whereas 'public' means any place 
	 *	in the code can see and use it.
	 * - Return Type refers to what type of object the function must return, "int" or
	 *	Integer being it in this case.
	 * - Function Name is just a name.
	 * - Function Parameters are any variables that the function needs to work and use.
	 *
	**/
	private int pull() {
		this.fivePity++;		// Increments Pity
		this.fourPity++;		// ""
		
		/**
		 * 'If' statements:
		 *  if ({Conditioin}) {
		 *  	{Code that will be ran if condition is true};
		 *  } else {
		 *  	{Code that will be ran if condition is false};
		 *  }
		 *
		**/
		if (this.fivePity == 90) {	// Checks 5* pity first
			this.fives[this.fivePity - 1]++;
			this.atPity++;
			this.fivePity = 0;	// Resets if @ pity
			this.fourPity = 0;
			return 5;		// Returns 5* (and exits)
		}
		/**
		 * The "return" keyword exits the function and returns whatever value
		 *  given to wherever the function is called. Because of this, I chose
		 *  not to include "else" statements since it'll be redundant;
		**/
		
		if (this.fourPity == 10) {	// Checks 4* pity 
			this.fourPity = 0;	// Resets if @ pity
			return 4;		// Returns 4*
		}
	
		int tmp = (int) (Math.random()*1000);	// Get's number between 0-1000 (includes 0, excludes 1000)
		if (tmp < 943) return 3;		// 94.3% chance it's 3*
		if (tmp < 994) { 			// 99.4% - 94.3% = 5.1% it's 4*
			this.fourPity = 0;
			return 4;
		}
		if (tmp < 1000) {			// 100% - 99.4% = 0.6% it's 5*
			this.fives[this.fivePity - 1]++;
			this.fourPity = 0;
			this.fivePity = 0;
			return 5;
		}
		return -1; 				// This should never happen;
	}

	public static void main (String[] args) {
		for (int i = 0; i < 1; i++) {
			Gacha G = new Gacha (100000);
			G.sim();
			G.printRates();
			G.printFives();
			System.out.println();
		}
	}
}




