package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CV {
    
    // Attributes
    private int CVID; //INT - primary key - not null - AUTO_INCREMENT
    private DMY birthDate; //DATE - not null
    private String firstName; //VARCHAR(30) - not null
    private String lastName; //VARCHAR(30) - not null
    private String overview; //TEXT - can be null
    private String education; //TEXT - can be null
    private String workExperience; //TEXT - can be null
    private String skills; //TEXT - can be null
    private static String query;
    //______________________________
    
    
    // Constructors
    public CV(DMY birthDate, String firstName, String lastName){
        query = "SELECT * FROM cv WHERE id = (SELECT MAX(id) FROM cv);";
        if(MySQL.getIntAndExceptionHandling(query) != -1){
            this.CVID = MySQL.getIntAndExceptionHandling(query) + 1;
            this.birthDate = birthDate;
            this.firstName = firstName;
            this.lastName = lastName;            
        }
    }
    
    public CV(CV curriculumVitae){
        this.CVID = curriculumVitae.getCVID();
        this.birthDate = curriculumVitae.getBirthDate();
        this.firstName = curriculumVitae.getFirstName();
        this.lastName = curriculumVitae.getLastName();
    }
    //______________________________
    
    
    // Methods
    public void registerCV(){
        query = "INSERT INTO CV VALUES (NULL, '" + this.birthDate.getYear() + "-" + this.birthDate.getMonth() + "-" + this.birthDate.getDay() + "', '" + this.firstName + "', '"
                        + this.lastName + "', NULL, NULL, NULL, NULL);";
        MySQL.insertDataAndExceptionHandling(query);
    }
    
    public static void modifyCV(String overview, String education, String workExperience, String skills){
        String overviewQuery = "overview=NULL, ";
        String educationQuery = "education=NULL, ";
        String workExperienceQuery = "workExperience=NULL, ";
        String skillsQuery = "skills=NULL";
        try{
            if(!overview.isBlank()){
                overviewQuery = "overview='" + overview + "', ";
            }
        }
        catch(Exception e){
            System.out.println("CV overview : " + e.getMessage());
        }
        try{
            if(!education.isBlank()){
                educationQuery = "education='" + education + "', ";
            }
        }
        catch(Exception e){
            System.out.println("CV education : " + e.getMessage());
        }
        try{
            if(!workExperience.isBlank()){
                workExperienceQuery = "workExperience='" + workExperience + "', ";
            }
        }
        catch(Exception e){
            System.out.println("CV work experience : " + e.getMessage());
        }
        try{
            if(!skills.isBlank()){
                skillsQuery = "skills='" + skills + "'";
            }
        }
        catch(Exception e){
            System.out.println("CV skills : " + e.getMessage());
        }
        query = "UPDATE  CV SET " + overviewQuery + educationQuery + workExperienceQuery + skillsQuery + " WHERE id=(SELECT cv FROM Jobseeker WHERE id=" + Account.getLoggedID() + ");";
        MySQL.insertDataAndExceptionHandling(query);
    }
      
    public int getCVID(){
        return this.CVID;
    }
    
    
    public DMY getBirthDate(){
        return this.birthDate;
    }
    
    
    public String getFirstName(){
        return this.firstName;
    }
    
    
    public String getLastName(){
        return this.lastName;
    }
    //______________________________

}