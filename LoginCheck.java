

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */

public class LoginCheck extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    HttpSession session=request.getSession();
    
 
   try{
	    String e=request.getParameter("e");
	    String p=request.getParameter("p");
	    
	    DbConnection db=(DbConnection)session.getAttribute("db");
	    
	    if(db==null){
	        db=new DbConnection();
	        session.setAttribute("db",db);
	    }
	    java.util.HashMap<String,String> UserDetails=db.checkLogin(e,p);
	    
	    if(UserDetails!=null){
	            session.setAttribute("UserDetails",UserDetails);
	            System.out.println("running");
	           response.sendRedirect("home.jsp");
	            
	    }
	    else{
	            session.setAttribute("msg","Invalid Id or Password");
	            
	            response.sendRedirect("Login.jsp");
	    	}
   		}
   catch(Exception ex){
	   
	   session.setAttribute("msg",ex.getMessage());
       response.sendRedirect("Login.jsp");
   }
}

}
