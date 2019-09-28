/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class Register extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session=request.getSession();
        try{
    String email=request.getParameter("email");
    String pass=request.getParameter("password");
    String name=request.getParameter("name");
    String phone=request.getParameter("phone");
    DbConnection db=(DbConnection)session.getAttribute("db");
    if(db==null){
        db=new DbConnection();
        session.setAttribute("db",db);
    }
    String m=db.insertUser(email, pass, name, phone);
    if(m.equalsIgnoreCase("Done")){
        java.util.HashMap UserDetails=new java.util.HashMap();
        UserDetails.put("email",email);
        
        UserDetails.put("pass",pass);
        UserDetails.put("name",name);
        UserDetails.put("phone",phone);
        session.setAttribute("UserDetails", UserDetails);
        
        response.sendRedirect("home.jsp");
    }else if(m.equalsIgnoreCase("Already")){
        session.setAttribute("msg","Email ID Already Registered.");
        response.sendRedirect("Login.jsp");
    }else{
        session.setAttribute("msg","Registration Failed");
        response.sendRedirect("Login.jsp");
       
    }
        }catch(Exception ex){
            session.setAttribute("msg",ex.getMessage());
            response.sendRedirect("Login.jsp");
        }
    }
}