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
    private String partOrFullTime; //voir openclassrooms 0 being part time and 1 being full time
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
                this.partOrFullTime = partOrFullTime;
            }
            
        }
    }
    //______________________________
    
    
    // Methods
    public void registerJob(){
        String descriptionQuery = "NULL, ";
        String salaryQuery = "NULL, ";
        String startingDateQuery = "NULL, ";
        String endingDateQuery = "NULL, ";
        String partOrFullTimeQuery = "NULL, ";
        try{
            descriptionQuery = "'" + this.description + "', ";
        }
        catch(Exception e){
            System.out.println("No job description");
        }
        try{
            salaryQuery = this.salary + ", ";
        }
        catch(Exception e){
            System.out.println("No salary");
        }
        
        //query = "INSERT INTO Job VALUES ((SELECT id FROM Job WHERE id=" + this.getJobID() +"), '" + this.getName() + "', '" + this.contractType + "', " + this.descriptionQuery + "
        //MySQL.insertDataAndExceptionHandling(query);
    }
    
    public int getJobID(){
        return this.jobID;
    }
    
    public Company getCompany(){
        return this.company;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getContractType(){
        return this.contractType;
    }
    
    public Address getLocation(){
        return this.location;
    }
    
    public DMY getStartingDate(){
        return this.startingDate;
    }
    
    public DMY getEndingDate(){
        return this.endingDate;
    }
    //______________________________
}