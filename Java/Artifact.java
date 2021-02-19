/**
 * Artifact Java Object
 * All artifacts have a Main stat and 4 Substats
**/

class Artifact {
	public Stat Main_Stat;
	public Stat[] Sub_Stats = new Stat[4];
	
	private int Stat_Index = 0;
	
	private final String[] Possible_Sub_Stats = {
		"HP",
		"HP%",
		"ATK",
		"ATK%",
		"DEF",
		"DEF%",
		"Elemental Mastery",
		"Energy Recharge",
		"CRIT Rate",
		"CRIT DMG"
	};

	protected void consolePrintArtifact() {
		System.out.print ("  ");
		Main_Stat.consolePrintStat();
		
		for (int i = 0; i < Sub_Stats.length; i++) {
			if (Sub_Stats[i] == null) continue;
			System.out.print ("   ");
			Sub_Stats[i].consolePrintStat();
		}
	}
	
	private boolean isSubStat (String Stat_Name) {
		for (int i = 0; i < Possible_Sub_Stats.length; i++)
			if (Stat_Name.equals (Possible_Sub_Stats[i])) return true;
		return false;
	}
	
	public void addSubstat (String Stat_Name, double Stat_Value) {
		if (isSubStat (Stat_Name) && Stat_Index < 4) {
			Sub_Stats[Stat_Index] = new Stat (Stat_Name, Stat_Value);
			Stat_Index++;
		}
	}
	
	public static void main (String[] args) {
	}
}