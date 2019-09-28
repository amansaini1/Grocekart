<!DOCTYPE html>  
<html lang="en">  
<body>
<%
    //HttpSession sessio=request.getSession();
	String e=request.getParameter("email");
    String p=request.getParameter("password");
   // DbConnection db=(DbConnection)session.getAttribute("db");
   // if(db==null){
      DbConnection  db=new DbConnection();
        session.setAttribute("db",db);
 //   }
    java.util.HashMap<String,String> UserDetails=db.checkLogin(e,p);
    System.out.println("success");
    if(UserDetails!=null){
            session.setAttribute("UserDetails",UserDetails);
            response.sendRedirect("home.jsp");
    }
    else{
            response.sendRedirect("home.jsp");
    }
%>
</body>
</html>