import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;



/**
 * The Hms class is the entry point (main) for the program.
 * It should create a frame and put the main panel in the frame.  It then
 * packs and shows the frame.
 * 
 * It is also responsible for creating the Database and passing references
 * to the database for the panels to use as necessary
 * 
 */
public class Hms {

    /**
     * @param args the command line arguments
     */
	public static JFrame dude;
	public static mainframe one;
	public static logphysical two;
	public static logHealthIndicators three;
	public static Database database;
	
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // TODO code application logic here
    	database=new Database("saved");
    	one=new mainframe();
    	two=new logphysical();
    	three=new logHealthIndicators();
    	dude=new JFrame();
    	dude.setSize(500,250);
    	dude.add(one);
    	dude.setVisible(true);
    }
}
