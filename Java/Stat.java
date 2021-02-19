/**
 * Stat object; each Stat has a Name and Value;
 * Only has finite possible substats; main stats are
 *	artifact-type specific.
**/
class Stat {
	protected final String Name;
	protected final double Value;
	
	void consolePrintStat() {
		System.out.println (Name + " : " + Value);
	}
		
	public Stat (String name, double value) {
		Name = name;
		Value = value;
	}
	
	/**
	 * Garbage Stat; used to denote invalid or currupted stat
	**/
	public Stat () {
		Name = "--";
		Value = -999.999;
	}
}