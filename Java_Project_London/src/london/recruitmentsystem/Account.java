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
        MySQL.insertDataAndExceptionHandling(query);
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
    //______________________________

}