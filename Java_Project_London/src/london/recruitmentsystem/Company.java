package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Company {
    
    // Attributes
    private Account account; //foreign key - account id as primary key
    private String name; //VARCHAR(50) - not null
    private String description; //VARCHAR(255) - can be null
    private static String query;
    //______________________________
    
    
    // Constructors
    public Company(Account account, String name){
        
        this.account = new Account(account);
        this.name = name;
    }
    //______________________________
    
    
    // Methods 
    public void registerCompany(){
        
        this.account.registerAccount();        
        
        query = "INSERT INTO Company VALUES (" + this.account.getAccountID() +", " + this.name + ");";
        MySQL.insertDataAndExceptionHandling(query);
        }
    
    
    
    public void changeDescription(){
        //demander au user la description
        //this.description = 
        //envoyer description à la base de donnée
    }
    
    public void postJob(){
        
    }
    
    public void removeJob(){
        
    }
    
    public void getPostedJobs(){
        
    }
    
    public void recruitCandidate(int candidateID){
        
    }
    
    public void searchCV(){
        
    }
    //______________________________
    

}