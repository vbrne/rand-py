/**
 * Stat object; each Stat has a Name and Value;
 * Only has finite possible substats; main stats are
 *	artifact-type specific.
**/
class Stat {
	private final String Name;
	private final double Value;
	
	void consolePrintStat() {
		System.out.println (Name + " : " + Value);
	}
		
	public Stat (String name, double value) {
		Name = name;
		Value = value;
	}
}