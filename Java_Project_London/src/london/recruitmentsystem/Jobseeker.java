package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Jobseeker {

    // Attributes
    private Account account; //jointure avec account [account id - primary key? how does this work? see schema de relation SQL]
    private CV curriculumVitae; //jointure avec CV [can be null? how does this work? see schema de relation SQL]
    private Job[] appliedJobs; //jointure avec Job [can be null? how does this work? see schema de relation SQL]
    private static String query;
    //______________________________
    
    
    // Constructors
    public Jobseeker(){
        
    }
    //______________________________
    
    
    // Methods
    public void registerJobseeker(){
        
        this.account.getHouseAddress().registerAddress();
        
        this.account.registerAccount();
        
        query = "INSERT INTO Jobseeker VALUES (" + this.account.getAccountID() +", " + this.curriculumVitae.getCVID() + ", "
                        + this.account.getTelephoneNumber() + ", " + this.account.getHouseAddress().getAddressID() + ");"; 
        MySQL.insertDataAndExceptionHandling(query);
        
        this.curriculumVitae.registerCV();
        
    }
    
    
    public void createCV(){
      
    }
    
    
    public void changeCV(){
        
    }
    
    
    public void applyJob(){
        
    }
    
    
    public void cancelJobApplication(){
        
    }
    
    
    public void getAppliedJobs(){
        
    }
    //______________________________
    
    
    
}