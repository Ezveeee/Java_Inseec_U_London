package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.Date;

public class Job {
    
    // Attributes
    private int id; //INT - not null - primary key - AUTO_INCREMENT
    private Company company; //jointure avec Company
    private String name; //VARCHAR(30) - not null
    private String contractType; //VARCHAR(10) - not null
    private Address location; //jointure avec Address
    private String description; //TEXT/LONGTEXT) - can be null
    private float salary; //DECIMAL/NUMERIC/FLOAT/DOUBLE voir cours openclassrooms - can be null
    private Date startingDate; //DATE - can be null
    private Date endingDate; //DATE can be null
    private boolean partOrFullTime; //voir openclassrooms 0 being part time and 1 being full time
    private static String query;
    //______________________________
    
    
    // Constructors
    public Job(){
        
    }
    //______________________________
    
    
    // Methods
    
    //______________________________

}