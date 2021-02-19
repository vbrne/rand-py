/**
 * Plume type artifact
 * Plumes only have ATK Main Stat
**/

public class Plume extends Artifact {
	public Plume (double Stat_Value) {
		Main_Stat = new Stat ("ATK", Stat_Value); 
	}
	
	void consolePrintPlume() {
		System.out.println ("Plume : ");
		consolePrintArtifact();
	}
	
	public static void main (String[] args) {
		Plume Plu = new Plume (311);
		Plu.addSubstat ("CRIT Rate", 7.2);
		Plu.addSubstat ("HP%", 12.3);
		Plu.addSubstat ("SSS", 22.2);
		Plu.addSubstat ("ATK", 42);
		Plu.consolePrintPlume();
	}
}