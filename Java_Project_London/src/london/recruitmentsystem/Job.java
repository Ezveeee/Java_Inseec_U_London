package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Job {
    
    // Attributes
    private int jobID; //INT - not null - primary key - AUTO_INCREMENT
    private Company company; //jointure avec Company
    private String name; //VARCHAR(30) - not null
    private String contractType; //VARCHAR(10) - not null
    private Address location; //jointure avec Address
    private String description; //TEXT/LONGTEXT) - can be null
    private int salary; //DECIMAL/NUMERIC/FLOAT/DOUBLE voir cours openclassrooms - can be null
    private DMY startingDate; //DATE - can be null
    private DMY endingDate; //DATE can be null
    private int partOrFullTime; //voir openclassrooms 0 being part time and 1 being full time
    private static String query;
    //______________________________
    
    
    // Constructors
    public Job(Company company, String name, String contractType, Address location, String description, String salary, DMY startingDate, DMY endingDate, String partOrFullTime){
        query = "SELECT * FROM Job WHERE id = (SELECT MAX(id) FROM Job);";
        if(MySQL.getIntAndExceptionHandling(query) != -1){
            this.jobID = MySQL.getIntAndExceptionHandling(query) + 1;
            this.company = new Company(company);
            this.name = name;
            this.contractType = contractType;
            this.location = new Address(location);
            
            if(!description.isBlank()){
                this.description = description;
            }
            
            if(!salary.isBlank()){
                this.salary = Integer.parseInt(salary);
            }
            
            if(!(startingDate.getDay().isBlank() && startingDate.getMonth().isBlank() && startingDate.getYear().isBlank())){
                this.startingDate = new DMY(startingDate);
            }
            
            if(!(endingDate.getDay().isBlank() && endingDate.getMonth().isBlank() && endingDate.getYear().isBlank() || startingDate.getDay().isBlank() && startingDate.getMonth().isBlank() && startingDate.getYear().isBlank())){
                this.endingDate = new DMY(endingDate);
            }
            
            if(!partOrFullTime.isBlank()){
                if(partOrFullTime.equals("Part time")){
                    this.partOrFullTime = 0;
                }
                 if(partOrFullTime.equals("Full time")){
                    this.partOrFullTime = 1;
                }
                  if(partOrFullTime.equals("Paid hourly")){
                    this.partOrFullTime = 2;
                }
            }
            
        }
    }
    //______________________________
    
    
    // Methods
    public void registerJob(){
        
    }
    //______________________________

}