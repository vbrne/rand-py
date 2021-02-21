/**
 * "Main" program
 * This is where GUI is going to be running
**/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;	
import java.awt.Insets;						// ?

import java.text.DecimalFormat;			    // ? For formatting displayed data

import javax.swing.AbstractAction;			// ?
import javax.swing.BorderFactory;
import javax.swing.border.Border;			// ?
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;				// ?
import javax.swing.Box;						// ?
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;				// ?
import javax.swing.JMenu;					// ?
import javax.swing.JMenuItem;				// ?
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;				// ?
import javax.swing.JTable;					// ?
import javax.swing.KeyStroke;				// ?
import javax.swing.ScrollPaneConstants;		// ?
import javax.swing.SwingConstants;			// ?
import javax.swing.table.TableColumnModel;	// ?

public class Gui {
	private JFrame frame;
	
	/**
	 * The Artifact Objects:
	 * All attributes are available to this class so we can
	 *	directly modify each (i.e. Main
	**/
	private Circlet circlet	= new Circlet();
	//private Goblet 	goblet	= new Goblet();
	//private Sands 	sands	= new Sands();
	//private Plume 	plume	= new Plume();
	//private Flower 	flower	= new Flower();
	
	public Gui() {
		Frame();
		ArtifactSetPanel();
		Exit();
	}
	
	/**
	 * Frame: esentially the entire window
	**/
	private void Frame() {
		frame = new JFrame ("Rabber dit Schkavern! Gishmirla!");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize (720, 720);
		frame.setLayout (new BorderLayout());
		frame.setVisible (true);
	}
	
	/**
	 * Panel for the Artifacts; Let me try to draw it out:
	 *	
	 *	|- JPanel --------------------------------------------|
	 *	|  "Artifacts:"            							  |
	 *	| 													  |
	 *	| |- Circlet Artifact JPanel -----------------------| |
	 *	| |													| |
	 *	| |  Circlet JLabel:                             	| |
	 *	| |    Main-Stat JCombo Box : Main-Stat JTextField	| |
	 *	| |		... 										| |
	 *	| |    Sub-Stat4 JCombo Box : Sub-Stat4 JTextField	| |
	 *	| |													| |
	 *	| |-------------------------------------------------| |
	 *	| 													  |
	 *	| 	...												  |
	 *	| 													  |
	 *	| |- Flower Artifact JPanel ------------------------| |
	 *	| |													| |
	 *	| |  Flower JLabel:                             	| |
	 *	| |    Main-Stat JCombo Box : Main-Stat JTextField 	| |
	 *	| |		... 										| |
	 *	| |    Sub-Stat4 JCombo Box : Sub-Stat4 JTextField  | |
	 *	| |													| |
	 *	| |-------------------------------------------------| |
	 *	| 													  |
	 *	| 									   Update Button  |
	 *	|-----------------------------------------------------|
	 *
	 * Each JPanel would need the objects stacked vertically,
	 *	so a Verticle BoxLayout(?) would be used in each.
	 * For Artifact Panel, possibly do BorderLayout with Label
	 *	on TOP and another panel (for the boxes) in the CENTER
	 *
	 * Thinking more on this, this is just going to be a cluster
	 *	of JPanels, BorderLayouts, and BoxLayouts...
	 *
	 * Hierarchy:
	 *  JPanel {
	 *		Artifacts label
	 *		SubPanel {
	 *			circletPanel {
	 *				mainStat label
	 *				mainStatPanel {
	 *					StatName; StatValue
	 *				}
	 *				SubStat label
	 *				subStatPanels {
	 *					Stat1Name; Stat1Value
	 *					Stat2Name; Stat2Value
	 *					Stat3Name; Stat3Value
	 *					Stat4name; Stat4Value
	 *				}
	 *			} x4 for Goblet, Sands, Plume, Flower1
	 *			update button (can go here or in main panel)
	 *		}
	 *	}
	 *
	 * Everything is split up so it can look nice
	 *
	**/
	private void ArtifactSetPanel() {
		JPanel panel = new JPanel ();
		panel.setLayout (new BorderLayout());
		panel.setBorder (new EmptyBorder (new Insets (5, 5, 5, 5)));	// Adds nice cushion around panel
		JLabel title = new JLabel ("Artifacts:");						// "Title" label
		panel.add (BorderLayout.NORTH, title);
		
		JPanel subPanel = ArtifactSubPanel();
		panel.add (BorderLayout.CENTER, subPanel);

		frame.getContentPane().add (BorderLayout.CENTER, panel);
	}
	private JPanel ArtifactSubPanel() {
		JPanel subPanel = new JPanel ();								// Sub Panel for Artifact Set
		subPanel.setLayout (new BoxLayout (subPanel, BoxLayout.Y_AXIS));// Layout to align vertically

		subPanel.add (circletPanel());
		
		//JPanel 
		
		return subPanel;
	}
	private JPanel circletPanel() {
		JPanel circletPanel = new JPanel();
		circletPanel.setLayout (new BoxLayout (circletPanel, BoxLayout.Y_AXIS));
		
		circletPanel.add (new JLabel ("Main Stat:"));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout (new BoxLayout (mainPanel, BoxLayout.Y_AXIS));
		JComboBox <String> mainStats = new JComboBox <String> (circlet.Possible_Main_Stats);
		mainPanel.add (mainStats);
		circletPanel.add (mainPanel);
		
		circletPanel.add (new JLabel ("Substats:"));
		
		
		return circletPanel;
	}
	
	/**
	 * Exit button at the bottom of the Frame
	**/
	private void Exit() {
		JButton exit = new JButton ("Exit");
		exit.addActionListener (new ActionListener() { 
			public void actionPerformed (ActionEvent E) { System.exit(0); } 
		});
		frame.getContentPane().add (BorderLayout.SOUTH, exit);
	}
	
	public static void main (String[] args) {
		new Gui();
	}
}

