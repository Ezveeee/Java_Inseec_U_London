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
        this.account = new Account(account, account.getHouseAddress());
        this.name = name;
    }
    
    public Company(Company company){
        this.account = new Account(company.getAccount(), company.getAccount().getHouseAddress());
        this.name = company.getName();
    }
    //______________________________
    
    
    // Methods 
    public void registerCompany(){
        this.account.registerAccount();       
        query = "INSERT INTO Company VALUES ((SELECT id FROM Account WHERE id=" + this.account.getAccountID() +"), '" + this.name + "', NULL);";
        MySQL.insertDataAndExceptionHandling(query);
    }
    
    
    public Account getAccount(){
        return this.account;
    }
    
    
    public String getName(){
        return this.name;
    }
    
    public static void modifyPersonalInformation(String email, String password, String telephoneNumber,String street, String postCode, String city, String country, String nameOfTheCompany){
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
        MySQL.insertDataAndExceptionHandling(query);
        query = "UPDATE Account SET email='" + email + "', password='" + password + "', " + telephoneNumberQuery 
                        + " WHERE id=" + Account.getLoggedID() + ";";
        MySQL.insertDataAndExceptionHandling(query);
        query = "UPDATE Company SET name='" + nameOfTheCompany + "',"
                        + " WHERE id=" + Account.getLoggedID() + ");";
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