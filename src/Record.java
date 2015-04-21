

import java.io.Serializable;
import java.util.Date;

/**
 * This class is abstract because it does not contain enough information
 * by itself to constitute a valid entry.  Child classes must extend this
 * class in order to provide enough detail to enter a Record into the Database
 */
public class Record implements Serializable {
    private String name;
    private Date date;
    
    /**
     * Create a new record with the given name
     * @param name Name of the record
     * @param date The date the Record was created
     */
    public Record(String name, Date date) {
        this.name = name;
        this.date = date;
    }
    public String getName()
    {
    	return name;
    }
    public Date getDate(){
    return date;
    }
}
