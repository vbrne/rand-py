/**
 * Circlet type artifact
**/

public class Circlet extends Artifact {
	public final String[] Possible_Main_Stats = {
		"HP%",
		"ATK%",
		"DEF%",
		"Elemental Mastery",
		"CRIT Rate",
		"CRIT DMG",
		"Healing Bonus"
	};
	
	public Circlet (String Stat_Name, double Stat_Value) {
		if (isMainStat (Stat_Name, Possible_Main_Stats)) Main_Stat = new Stat (Stat_Name, Stat_Value); 
		else Main_Stat = new Stat();
	}
	
	void consolePrintCirclet() {
		System.out.println ("Circlet : ");
		consolePrintArtifact();
	}
	
	public static void main (String[] args) {
		Circlet Cir = new Circlet ("HP%", 12);
		Cir.addSubstat ("CRIT Rate", 7.3);
		Cir.addSubstat ("HP%", 11.1);
		Cir.addSubstat ("HP" , 400);
		Cir.consolePrintCirclet();
	}
}