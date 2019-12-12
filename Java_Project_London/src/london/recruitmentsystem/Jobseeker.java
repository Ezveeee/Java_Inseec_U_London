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
        query = "INSERT INTO Jobseeker VALUES ((SELECT id FROM Account WHERE id=" + this.account.getAccountID() +"), (SELECT id FROM CV WHERE id=" + this.curriculumVitae.getCVID() + "));";
        MySQL.executeUpdateAndExceptionHandling(query);
    }
    
    public void applyToJob(Job job){
        query = "INSERT INTO Applied VALUES ((SELECT id FROM Account WHERE id=" + this.account.getAccountID() +"), (SELECT id FROM CV WHERE id=" + this.curriculumVitae.getCVID() + "));";
    }
    
   public static void modifyPersonalInformation(String email, String password, String telephoneNumber,String street, String postCode, String city, String country, String firstName, String lastName){
        String telephoneNumberQuery = "telephoneNumber=NULL";
        try{
            if(!telephoneNumber.isBlank()){
                telephoneNumberQuery = "telephoneNumber='" + telephoneNumber + "'";
            }
        }
        catch(Exception e){
            System.out.println("Jobseeker telephone number : " + e.getMessage());
        }
        
        query = "UPDATE  Address SET street='" + street + "', postCode='" + postCode + "', city='" + city + "', country='" + country 
                        + "' WHERE id=(SELECT address FROM Account WHERE id=" + Account.getLoggedID() + ");";
        MySQL.executeUpdateAndExceptionHandling(query);
        query = "UPDATE Account SET email='" + email + "', password='" + password + "', " + telephoneNumberQuery 
                        + " WHERE id=" + Account.getLoggedID() + ";";
        MySQL.executeUpdateAndExceptionHandling(query);
        query = "UPDATE CV SET firstName='" + firstName + "', lastName='" + lastName 
                        + "' WHERE id=(SELECT cv FROM Jobseeker WHERE id=" + Account.getLoggedID() + ");";
        MySQL.executeUpdateAndExceptionHandling(query);
    }
    
    
    public void applyJob(int jobID){
        query = "INSERT INTO Applied VALUES (" + jobID + ", " + Account.getLoggedID() + ";";
        MySQL.executeUpdateAndExceptionHandling(query);
    }
    
    
    public void cancelJobApplication(){
        
    }
    
    
    public static int[] getAppliedJobsID(){
        int[] appliedJobsID = new int[0];
        return appliedJobsID;
    }
    //______________________________
}