package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Address{
    
    // Attributes
    private int addressID; //INT -  unsigned - not null - auto increment - primary key
    private String street; //VARCHAR(100) - not null
    private String postCode; //VARCHAR(10) - not null
    private String city; // VARCHAR(60) - not null
    private String country; //VARCHAR(30) - not null
    private static String query;
    //______________________________
    
    
    // Constructors  
    public Address(String street, String postCode, String city, String country){
        
        query = "SELECT * FROM Address WHERE ID = (SELECT IDENT_CURRENT('Address')) + 1";
        if(MySQL.getIntAndExceptionHandling(query) != -1){
            this.addressID = MySQL.getIntAndExceptionHandling(query);
            this.street = street;
            this.postCode = postCode;
            this.city = city;
            this.country = country;
        }
    }
    //______________________________
    
    
    // Methods    
    public void registerAddress(){
        
        query = "INSERT INTO Address VALUES ("+ this.addressID + ", " + this.street + ", " + this.postCode + ", " + this.city + ", " + this.country + ");"; 
        MySQL.insertDataAndExceptionHandling(query);
    }
    
    
    public int getAddressID(){
        
        return this.addressID;
    }
    
    
    public String getStreet(){
        
        return this.street;
    }
    
    
    public String getPostCode(){
        
        return this.postCode;
    }
    
    
    public String getCity(){
        
        return this.city;
    }
    
    
    public String getCountry(){
        
        return this.country;
    }
    
    
    public void showAddress(){
        
        
    }
    //______________________________
    

}