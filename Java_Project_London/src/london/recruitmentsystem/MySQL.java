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
            catch(SQLException e) {
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
            catch(SQLException e) {
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
     
     public static String[] getLoggedInCVInfos(){
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
            catch(SQLException e) {
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
    
}