package london.recruitmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MySQL {
    
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;
    public static ResultSet rs2;
    public static ResultSetMetaData rsmd;
    public static String query;
    
    public static void obtainConnection(){
        conn = null;
        try{
            String url = "jdbc:mysql://localhost/pole_emploi";
            String username = "lucas";
            String password = "lucas";
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    
    public static void insertDataAndExceptionHandling(String query){
        try{
            MySQL.stmt = MySQL.conn.createStatement();
            MySQL.stmt.executeUpdate(query);
        }
        catch(SQLException e){
            System.out.println("SQLException when calling insertData(String query) --> stmt.executeUpdate(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
    }
    
    public static int getIntAndExceptionHandling(String query){
        int number = -1;
        try{
            stmt = MySQL.conn.createStatement();
            rs = MySQL.stmt.executeQuery(query);
            try{
                rs.next();
                number = rs.getInt(1);
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getInt(String query) --> rs.next() & number = rs.getInt(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        
        catch(SQLException e){
            System.out.println("SQLException when calling getInt(String query) --> stmt.executeQuery(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
        return number;
    }
    
     public static String getStringAndExceptionHandling(String query){
        String str = null;
        try{
            stmt = MySQL.conn.createStatement();
            rs = MySQL.stmt.executeQuery(query);
            try{
                rs.next();
                str = rs.getString(1);
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        
        catch(SQLException e){
            System.out.println("SQLException when calling getInt(String query) --> stmt.executeQuery(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
        return str;
    }
     
     public static String[] getLoggedInCVInfo(){
        String[] infos = new String[4];
        try{
            stmt = MySQL.conn.createStatement();
            query = "SELECT overview, education, workExperience, skills FROM cv WHERE id=(SELECT cv FROM Jobseeker WHERE id=" + Account.getLoggedID() + ");";
            rs = MySQL.stmt.executeQuery(query);
            try{
                if(rs.next()){
                    infos[0] = rs.getString(1);
                    infos[1] = rs.getString(2);
                    infos[2] = rs.getString(3);
                    infos[3] = rs.getString(4);
                }
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        
        catch(SQLException e){
            System.out.println("SQLException when calling getInt(String query) --> stmt.executeQuery(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
        return infos;
    }
     
     public static String[] getLoggedInJobseekerInfo(){
        String[] infos = new String[9];
        try{
            stmt = MySQL.conn.createStatement();
            query = "SELECT street, postCode, city, country FROM Address WHERE id=(SELECT Address FROM Account WHERE id=" + Account.getLoggedID() + ");";
            rs = MySQL.stmt.executeQuery(query);
            try{
                if(rs.next()){
                    infos[0] = rs.getString(1);
                    infos[1] = rs.getString(2);
                    infos[2] = rs.getString(3);
                    infos[3] = rs.getString(4);
                }
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            
            query = "SELECT email, password, telephoneNumber FROM Account WHERE id=" + Account.getLoggedID() + ";";
            rs = MySQL.stmt.executeQuery(query);
            try{
                if(rs.next()){
                    infos[4] = rs.getString(1);
                    infos[5] = rs.getString(2);
                    infos[6] = rs.getString(3);
                }
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            
            query = "SELECT firstName, lastName FROM CV WHERE id=(SELECT cv FROM Jobseeker WHERE id=" + Account.getLoggedID() + ");";
            rs = MySQL.stmt.executeQuery(query);
            try{
                if(rs.next()){
                    infos[7] = rs.getString(1);
                    infos[8] = rs.getString(2);
                }
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        
        catch(SQLException e){
            System.out.println("SQLException when calling getInt(String query) --> stmt.executeQuery(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
        return infos;
    }
     
    public static String[] getLoggedInCompanyInfo(){
        String[] infos = new String[8];
        try{
            stmt = MySQL.conn.createStatement();
            query = "SELECT street, postCode, city, country FROM Address WHERE id=(SELECT Address FROM Account WHERE id=" + Account.getLoggedID() + ");";
            rs = MySQL.stmt.executeQuery(query);
            try{
                if(rs.next()){
                    infos[0] = rs.getString(1);
                    infos[1] = rs.getString(2);
                    infos[2] = rs.getString(3);
                    infos[3] = rs.getString(4);
                }
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            
            query = "SELECT email, password, telephoneNumber FROM Account WHERE id=" + Account.getLoggedID() + ";";
            rs = MySQL.stmt.executeQuery(query);
            try{
                if(rs.next()){
                    infos[4] = rs.getString(1);
                    infos[5] = rs.getString(2);
                    infos[6] = rs.getString(3);
                }
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            
            query = "SELECT name FROM Company WHERE id=" + Account.getLoggedID() + ";";
            rs = MySQL.stmt.executeQuery(query);
            try{
                if(rs.next()){
                    infos[7] = rs.getString(1);
                    
                }
            }
            catch(SQLException e){
                System.out.println("SQLException when calling getString(String query) --> rs.next() & str = rs.getString(1) : " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        
        catch(SQLException e){
            System.out.println("SQLException when calling getInt(String query) --> stmt.executeQuery(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
        return infos;
    }
     
     public static String[][] getJobList(String userSearch){
         int numberOfRows = -1;
         try{
             stmt = MySQL.conn.createStatement();
             query = "SELECT name FROM Job WHERE name LIKE '%"+ userSearch +"%';";
             rs = MySQL.stmt.executeQuery(query);
             try{
                  rs.last();
                  numberOfRows = rs.getRow();
                  rs.beforeFirst();
             }
             catch (SQLException e)
             {
                 System.out.println("SQLException when calling getJobList(String userSearch) --> rs.last(), rs.getRow(), rs.beforeFirst() : " + e.getMessage());
                 System.out.println("SQLState: " + e.getSQLState());
                 System.out.println("VendorError: " + e.getErrorCode());
             }
             
             String[][] jobList = new String[numberOfRows][4];
             
             try{ //add job name
                 while(rs.next()){
                    jobList[rs.getRow()-1][0] = rs.getString(1);
                }
             }
             catch(SQLException e){
                 System.out.println("SQLException when calling getJobList(String userSearch) --> add job name to ResultSet : " + e.getMessage());
                 System.out.println("SQLState: " + e.getSQLState());
                 System.out.println("VendorError: " + e.getErrorCode());
             }
             
             query = "SELECT name FROM Company WHERE id IN (SELECT company FROM Job WHERE name LIKE '%"+ userSearch +"%');";
             rs = MySQL.stmt.executeQuery(query);
             try{ //add company name
                 while(rs.next()){
                    jobList[rs.getRow()-1][1] = rs.getString(1);
                 }
             }
             catch(SQLException e){
                 System.out.println("SQLException when calling getJobList(String userSearch) --> add company name to ResultSet : " + e.getMessage());
                 System.out.println("SQLState: " + e.getSQLState());
                 System.out.println("VendorError: " + e.getErrorCode());
             }
             
             query = "SELECT city FROM Address WHERE id IN (SELECT address FROM Job WHERE name LIKE '%"+ userSearch +"%');";
             rs = MySQL.stmt.executeQuery(query);
             try{ //add city name
                 while(rs.next()){
                    jobList[rs.getRow()-1][2] = rs.getString(1);
                }
             }
             catch(SQLException e){
                 System.out.println("SQLException when calling getJobList(String userSearch) --> add company name to ResultSet : " + e.getMessage());
                 System.out.println("SQLState: " + e.getSQLState());
                 System.out.println("VendorError: " + e.getErrorCode());
             }
             
             query = "SELECT country FROM Address WHERE id IN (SELECT address FROM Job WHERE name LIKE '%"+ userSearch +"%');";
             rs = MySQL.stmt.executeQuery(query);
             try{ //add country name
                 while(rs.next()){
                    jobList[rs.getRow()-1][3] = rs.getString(1);
                }
             }
             catch(SQLException e){
                 System.out.println("SQLException when calling getJobList(String userSearch) --> add company name to ResultSet : " + e.getMessage());
                 System.out.println("SQLState: " + e.getSQLState());
                 System.out.println("VendorError: " + e.getErrorCode());
             }
             return jobList;
        }
        
         
         
         
        catch(SQLException e){
            String[][]jobList = null;
            System.out.println("SQLException when calling getInt(String query) --> stmt.executeQuery(query) : " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return jobList;
        }
        
        finally{ //realease resources
            if(rs != null){
                try{
                    rs.close();
                }
                catch(SQLException sqlEx){}
                rs = null;
                }
            
            if(stmt != null){
                try{
                    stmt.close();
                }
                catch(SQLException sqlEx){}
                stmt = null;
            }
        }
    }
    
}