


import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class DbConnection {
    private Connection con;
    private Statement st;
    private PreparedStatement insertUser,checkLogin;
    
    public DbConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gkart",
                "root","aman");
        st=con.createStatement();
 
   insertUser=con.prepareStatement(
                "insert into customerinfo values (?,?,?,?)");
   checkLogin=con.prepareStatement(
           "select * from customerinfo where email=? and password=?");
   System.out.println("Success");
    }
    
    public String insertUser(String e,String p,String n,String ph) throws SQLException {
        try{        
 insertUser.setString(1, e);
 insertUser.setString(2, p);
 insertUser.setString(3, n);
 insertUser.setString(4, ph);
int x=insertUser.executeUpdate();

        
if(x==1)
 return "Done";
else 
 return "Error";
        
        }
catch(java.sql.SQLIntegrityConstraintViolationException ex){
            ex.printStackTrace();
           return "Already";
        }
        
        
    }
    public HashMap checkLogin(String e,String p) throws SQLException
    {
    	checkLogin.setString(1,e);
    	checkLogin.setString(2,p);
    	
    	System.out.println(e+"    "+p);
    	ResultSet r=checkLogin.executeQuery();
    	if(r.next()){
    		
    		System.out.println(r.getString("name")+"    "+r.getString("email"));
    	    java.util.HashMap UserDetails=new java.util.HashMap();
    	    UserDetails.put("email",r.getString("email"));
    	    UserDetails.put("name",r.getString("name"));
    	    UserDetails.put("phone",r.getString("phone"));
    	    return UserDetails;
    	}
    	else
    	{
    		return null;
    	}
    }
}
    

    
    
    

