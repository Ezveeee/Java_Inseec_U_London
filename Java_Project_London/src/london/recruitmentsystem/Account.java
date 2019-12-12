package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Account {
    
    // Attributes
    private int accountID; //INT -  unsigned - not null - auto increment - primary key
    private String email; //VARCHAR(100) - not null
    private String password; //VARCHAR(30) - not null
    private String telephoneNumber; //VARCHAR(20) - can be null
    private Address houseAddress; //foreign key
    private static String query;
    private static int loggedID;
    //______________________________
    
    // Constructors
    public Account(String email, String password, String telephoneNumber, Address houseAddress){
        query = "SELECT * FROM Account WHERE id = (SELECT MAX(id) FROM Account);";
        if(MySQL.getIntAndExceptionHandling(query) != -1){
            this.accountID = MySQL.getIntAndExceptionHandling(query) + 1;
            this.email = email;
            this.password = password;
            this.telephoneNumber = telephoneNumber;
            this.houseAddress = new Address(houseAddress.getStreet(), houseAddress.getPostCode(), houseAddress.getCity(), houseAddress.getCountry());
        }
    }
    
    public Account(Account account, Address houseAddress){
        this.accountID = account.accountID;
        this.email = account.email;
        this.password = account.password;
        this.telephoneNumber = account.telephoneNumber;
        this.houseAddress = new Address(houseAddress);
    }
    //______________________________
    
    
    // Methods    
    public void registerAccount(){
        this.houseAddress.registerAddress();
        query = "INSERT INTO Account VALUES (NULL, '" + this.email + "', '" + this.password + "', '"
                        + this.telephoneNumber + "', (SELECT id FROM Address WHERE id=" + this.houseAddress.getAddressID() + "));"; 
        MySQL.executeUpdateAndExceptionHandling(query);
    }
    
    public static boolean checkLogin(String email, String password){
        boolean rightPassword = false;
        query = "SELECT password FROM  Account WHERE email='" + email + "';";
        String correspondingPassword = MySQL.getStringAndExceptionHandling(query);
        if(password.equals(correspondingPassword)){
            rightPassword = true;
        }
        return rightPassword;
    }
    
    public static boolean getAccountType(String email){ // à améliorer si le temps erreur illegal operation on empty result set
        query = "SELECT name FROM Company WHERE id = (SELECT id FROM Account WHERE email='"+ email +"');";
        try{
            String accountName = MySQL.getStringAndExceptionHandling(query);
            return false;
        }
        catch(Exception e){
            System.out.println("Not a company --> is a jobseeker : " + e);
            return true;
        }
    }
    
        
    public int getAccountID(){
        return this.accountID;
    }
    
    
    public String getEmail(){
        return this.email;
    }
    
    
    public String getPassword(){
        return this.password;
    }
    
    
    public String getTelephoneNumber(){
        return this.telephoneNumber;
    }
    
    
    public Address getHouseAddress(){
        return this.houseAddress;
    }
    
    
    public static int getLoggedID(){
        return loggedID;
    }
    
    
    public static void setLoggedID(int newLoggedID){
        query = "SELECT * FROM Account WHERE id = (SELECT MAX(id) FROM Account);";
        if(MySQL.getIntAndExceptionHandling(query) != -1){
            int maxID = MySQL.getIntAndExceptionHandling(query);
            if(loggedID >= 0 && loggedID <= maxID){
                loggedID = newLoggedID;
            }
        }
    }
    
    
    public static int getIDFromLogin(String email){
        query = "SELECT id FROM Account WHERE email='" + email + "';";
        if(MySQL.getIntAndExceptionHandling(query) != -1){
            int loginID = MySQL.getIntAndExceptionHandling(query);
            return loginID;
        }
        else{
            return 0;
        }
    }
    //______________________________

}