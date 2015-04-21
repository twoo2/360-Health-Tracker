

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Database class is responsible for managing the list of workouts
 * and health statistics for the user.  It provides public methods
 * to save the database when the program closes, reload the saved database
 * when the program opens, enter a new record into the database, remove
 * a record from the database, and edit a record in the database.
 * 
 */
public class Database implements Serializable{
    private ArrayList<Record> recordList;
    
    /**
     * Creates/reloads a Database.  Attempts to reload Database from file.
     * If file does not exist, creates an empty Database.
     * @param file Name of file to read from
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public Database(String file) throws IOException, ClassNotFoundException {
    	File inputfile=new File(file);
        // if file exists, use object serialization to attempt
        // to reload recordList
    	if(inputfile.exists())
    	{
    		//Once saving as object is implemented we can start working on reading objects
    		/*FileInputStream fin=new FileInputStream(file);
    		ObjectInputStream ois=new ObjectInputStream(fin);
    		recordList.add=(Record)ois.readObject());
    		ois.close();*/
    		
    		Scanner in= new Scanner(inputfile);
    		//while(in.)
    		//read method not implemented yet so just initalizing new list everytime program is opened
    		recordList=new ArrayList<Record>();
    	}
    	else
    	{
    	 recordList=new ArrayList<Record>();
    	}
    	
        // else just create a new empty recordList
    }
    
    /**
     * Populates the database pointed to by file
     * @param file Name of file to read from
     */
    public void load(String file) {
        
    }
    
    /**
     * Save the database to the given file name
     * @param file Name of file to write to
     * @throws IOException 
     */
    public void save(String file) throws IOException {
    	//Trying to figure out how to save as object keep working on this if you want
    	
    	/*FileOutputStream fout=new FileOutputStream(file);
    	ObjectOutputStream oos=new ObjectOutputStream(fout);
    	int size=recordList.size();
    	for(int i=0;i<size; i++)
    	{
    		oos.writeObject(recordList.get(i));
    	}
    	oos.close();*/
    	
    	//saving as strings for now
        PrintWriter out=new PrintWriter(file);
        int size=recordList.size();
        for(int i=0;i<size;i++)
        {
        	out.print(recordList.get(i).getName()+" " );
        	out.println(recordList.get(i).getDate());
        }
        
        out.close();
    }
    
    /**
     * Add Record r to the database.  Adding a Record cannot fail
     * because duplicate Records are allowed
     * @param r The Record to add
     */
    public void addRecord(Record r) {
        recordList.add(r);
    }
    
    /**
     * Updates Record r
     * @param r The Record to update
     * @return true if the Record existed and was updated, false otherwise
     */
    public boolean updateRecord(Record r) {
        return false;
    }
    
    /**
     * Remove Record r
     * @param r The Record to remove
     * @return true if the Record was removed, false otherwise
     */
    public boolean deleteRecord(Record r) {
        return false;
    }
    
    /**
     * Print a table based String representation of the Records
     * Records should be sorted by date of record.
     * @return String representation of Database.  One row for each Record.
     */
    public String toString() {
        return "";
    }
}
