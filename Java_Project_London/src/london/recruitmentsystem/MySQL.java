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
            System.out.println("SQLException: " + e.getMessage());
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
        int id = -1;
        try{
            stmt = MySQL.conn.createStatement();
            id = rs.getInt(query);
        }
        catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
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
        return id;
    }
    
}