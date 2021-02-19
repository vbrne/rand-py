/**
 * Flower type artifact
 * Flowers only have HP Main Stat
**/

public class Flower extends Artifact {
	public Flower (double Stat_Value) {
		Main_Stat = new Stat ("HP", Stat_Value); 
	}
	
	void consolePrintFlower() {
		System.out.println ("Flower : ");
		consolePrintArtifact();
	}
	
	public static void main (String[] args) {
		Flower Flo = new Flower (4567);
		Flo.addSubstat ("CRIT Rate", 7.2);
		Flo.addSubstat ("HP", 1231);
		Flo.addSubstat ("SSS", 22.2);
		Flo.addSubstat ("ATK", 42);
		Flo.consolePrintFlower();
	}
}