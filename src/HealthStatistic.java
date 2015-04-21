

import java.io.Serializable;
import java.util.Date;

/**
 * The HealthStatistic class allows the user to track health information
 * such as blood pressure, BMI, etc.
 * 
 */
public class HealthStatistic extends Record implements Serializable {
    private double value;
    
    /**
     * Constructor to create a HealthStatistic with the given name
     * and value
     * @param name
     * @param value 
     * @param date
     */
    public HealthStatistic(String name, double value, Date date) {
        super(name, date);
    }
}
