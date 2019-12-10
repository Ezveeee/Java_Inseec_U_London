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
    private static String query;
    //______________________________
    
    
    // Constructors
    public Jobseeker(Account account, CV curriculumVitae){
        this.account = new Account(account, account.getHouseAddress());
        this.curriculumVitae = new CV(curriculumVitae);
    }
    //______________________________
    
    
    // Methods
    public void registerJobseeker(){
        this.account.registerAccount();
        this.curriculumVitae.registerCV();
        query = "INSERT INTO Company VALUES ((SELECT id FROM Account WHERE id=" + this.account.getAccountID() +"), (SELECT id FROM CV WHERE id=" + this.curriculumVitae.getCVID() + "));";
        MySQL.insertDataAndExceptionHandling(query);
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