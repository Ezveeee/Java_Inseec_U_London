package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Job {
    
    // Attributes
    private int jobID; //INT - not null - primary key - AUTO_INCREMENT
    private String companyName; //jointure avec Company
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
    public Job(String companyName, String name, String contractType, Address location, String description, String salary, DMY startingDate, DMY endingDate, String partOrFullTime){
        query = "SELECT * FROM Job WHERE id = (SELECT MAX(id) FROM Job);";
        if(MySQL.getIntAndExceptionHandling(query) != -1){
            this.jobID = MySQL.getIntAndExceptionHandling(query) + 1;
            this.companyName = companyName;
            this.name = name;
            this.contractType = contractType;
            this.location = new Address(location);
            
            if(!description.isBlank()){
                this.description = description;
            }
            
            if(!salary.isBlank()){
                this.salary = Integer.parseInt(salary);
            }
            
            if(!(startingDate.getDay().isBlank() || startingDate.getMonth().isBlank() || startingDate.getYear().isBlank())){
                this.startingDate = new DMY(startingDate);
            }
            
            if(!(endingDate.getDay().isBlank() || endingDate.getMonth().isBlank() || endingDate.getYear().isBlank() || startingDate.getDay().isBlank() || startingDate.getMonth().isBlank() || startingDate.getYear().isBlank())){
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
            if(!this.description.isBlank()){
                descriptionQuery = "'" + this.description + "', ";
            }
            else{
                    System.out.println("No job description");
            }
        }
        catch(Exception e){
            System.out.println("Job description : " + e.getMessage());
        }
        
 
        if(this.salary > 0){
            salaryQuery = this.salary + ", ";
        }
        else{
            System.out.println("No salary");
        }
        
        try{
            startingDateQuery = "'" + this.startingDate.getYear() + "-" + this.startingDate.getMonth() + "-" + this.startingDate.getDay() + "', ";
        }
        catch(Exception e){
            System.out.println("No starting date : " + e);
        }
        
        try{
            endingDateQuery = "'" + this.endingDate.getYear() + "-" + this.endingDate.getMonth() + "-" + this.endingDate.getDay() + "', ";
        }
        catch(Exception e){
            System.out.println("No ending date : " + e);
        }
        
        try{
            if(this.partOrFullTime.equals("Part time") || this.partOrFullTime.equals("Full time") || this.partOrFullTime.equals("Paid hourly")){
                if(this.partOrFullTime.equals("Part time")){
                    partOrFullTimeQuery = 0 + ", ";
                }
                if(this.partOrFullTime.equals("Full time")){
                    partOrFullTimeQuery = 1 + ", ";
                }
                if(this.partOrFullTime.equals("Paid hourly")){
                    partOrFullTimeQuery = 2 + ", ";
                }
            }
            else{
                System.out.println("No part time or full time");
            }
        }
        catch(Exception e){
            System.out.println("Job partOrFullTime : " + e.getMessage());
        }
        
        query = "INSERT INTO Job VALUES (NULL, '" + this.name + "', '" + this.contractType + "', " + descriptionQuery 
                        + salaryQuery + startingDateQuery + endingDateQuery + partOrFullTimeQuery + Account.getLoggedID() + ", " + this.location.getAddressID() + ");";
        MySQL.executeUpdateAndExceptionHandling(query);
    }
    
    public void removeJob(int jobID){
        query = "DELETE FROM Job WHERE id=" + jobID + ";";
        MySQL.executeUpdateAndExceptionHandling(query);
    }
    
    public void jobseekerApply(){
        query = "INSERT INTO Applied VALUES ((SELECT id FROM Job WHERE id=" + this.jobID + "), (SELECT id FROM Jobseeker WHERE id=" + Account.getLoggedID() + "));";
        MySQL.executeUpdateAndExceptionHandling(query);
    }
    
    public int getJobID(){
        return this.jobID;
    }
    
    public String getCompanyName(){
        return this.companyName;
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