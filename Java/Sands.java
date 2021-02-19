/**
 * Sands type artifact
**/

public class Sands extends Artifact {
	public final String[] Possible_Main_Stats = {
		"HP%",
		"ATK%",
		"DEF%",
		"Elemental Mastery",
		"Energy Recharge"
	};
	
	public Sands (String Stat_Name, double Stat_Value) {
		if (isMainStat (Stat_Name, Possible_Main_Stats)) Main_Stat = new Stat (Stat_Name, Stat_Value); 
		else Main_Stat = new Stat();
	}
	
	void consolePrintSands() {
		System.out.println ("Sands : ");
		consolePrintArtifact();
	}
	
	public static void main (String[] args) {
		Sands San = new Sands ("HP%", 46.6);
		San.addSubstat ("CRIT Rate", 7.2);
		San.addSubstat ("HP%", 12.3);
		San.addSubstat ("SSS", 22.2);
		San.addSubstat ("ATK", 42);
		San.consolePrintSands();
	}
}