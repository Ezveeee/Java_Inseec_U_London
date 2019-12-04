package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.Date;

public class CV {
    
    // Attributes
    private int CVID; //INT - primary key - not null - AUTO_INCREMENT
    private Date birthDate; //DATE - not null
    private String firstName; //VARCHAR(30) - not null
    private String lastName; //VARCHAR(30) - not null
    private String overview; //TEXT - can be null
    private String education; //TEXT - can be null
    private String workExperience; //TEXT - can be null
    private String skills; //TEXT - can be null
    private static String query;
    //______________________________
    
    
    // Constructors
    public CV(){
        
    }
    //______________________________
    
    
    // Methods
    public void registerCV(){
    
    }
    
    
    public int getCVID(){
        
        return this.CVID;
    }
    
    
    public Date getBirthDate(){
        
        return this.birthDate;
    }
    
    
    public String getFirstName(){
        
        return this.firstName;
    }
    
    
    public String getLastName(){
        
        return this.lastName;
    }
    //______________________________

}