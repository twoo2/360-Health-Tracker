

import java.io.Serializable;
import java.util.Date;

/**
 * The Workout class allows the user to track exercise related information
 * such as lifting weights, going for a walk, etc.
 * 
 */
public class Workout extends Record implements Serializable {
    private int length;
    
    /**
     * Create a workout with the given name of duration length
     * @param name Name to give the workout
     * @param length Workout length in minutes
     * @param date The date the workout occurred on
     */
    public Workout(String name, double length, Date date) {
        super(name,date);
    }
}
