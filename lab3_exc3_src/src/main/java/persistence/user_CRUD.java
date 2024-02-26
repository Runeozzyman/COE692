package persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import helper.userInfo;

public class user_CRUD {
    
    private static Connection getCon(){
        
    Connection con = null;
    
    try{
    
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS?autoReconnect=true&useSSL=false", "root", "student");
        System.out.println("Connection established");
    
    }catch(Exception e){System.out.println(e);}
        
        return con;
    
    }
    
 public static int getUserID(String username){
    int userId = 0;
    
    try{
        
        Connection con = getCon();
         
        String q = "SELECT id FROM USER WHERE username LIKE ?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, "%" + username + "%");
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            
            userId = rs.getInt("id");
            
            
        }
        con.close();
        
    }catch(Exception e){System.out.println(e);}
    
    return userId;
}    
        
    
public static userInfo read(String username, String password){
    userInfo bean = null;
    
    try{
        
        Connection con = getCon();
         
        String q = "SELECT * FROM USER WHERE username LIKE ?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, "%" + username + "%");
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            
            String pass = rs.getString("password");
            
            if(pass.equals(password)){
                
                bean = new userInfo();
            }
            
        }
        con.close();
        
    }catch(Exception e){System.out.println(e);}
    
    return bean;
}    
       
}
