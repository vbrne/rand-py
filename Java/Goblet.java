/**
 * Goblet type artifact
**/

public class Goblet extends Artifact {
	public final String[] Possible_Main_Stats = {
		"Geo DMG",
		"Pyro DMG",
		"Cryo DMG",
		"Hydro DMG",
		"Anemo DMG",
		"Electro DMG",
		"Physical DMG",
		"HP%",
		"ATK%",
		"DEF%",
		"Elemental Mastery"
	};
	
	public Goblet (String Stat_Name, double Stat_Value) {
		if (isMainStat (Stat_Name)) Main_Stat = new Stat (Stat_Name, Stat_Value); 
		else Main_Stat = new Stat("-", 0);
	}
	
	private boolean isMainStat (String Stat_Name) {
		for (int i = 0; i < Possible_Main_Stats.length; i++) 
			if (Stat_Name.equals (Possible_Main_Stats[i])) return true;
		return false;
	}
	
	void consolePrintGoblet() {
		System.out.println ("Goblet : ");
		consolePrintArtifact();
	}
	
	public static void main (String[] args) {
		Goblet Gob = new Goblet ("Geo DMG", 12);
		Gob.addSubstat ("CRIT Rate", 7.3);
		Gob.addSubstat ("CRIT DMG", 14.3);
		Gob.addSubstat ("HP%", 4.5);
		Gob.consolePrintGoblet();
		
		Gob.addSubstat ("Elemental Mastery", 44);
		Gob.addSubstat ("Energy Recharge", 13.3);
		Gob.consolePrintGoblet();
	}
}