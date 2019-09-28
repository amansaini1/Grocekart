<%@page import="java.util.HashMap"%>
<%@page  errorPage="Error.jsp" %>
<%
    HashMap UserDetails=(HashMap)session.getAttribute("UserDetails");
    if(UserDetails!=null){ 
%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Grocekart</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">
	
	<script language="Javascript" src="js/jquery.js"></script>
	<script type="text/JavaScript" src='js/state.js'></script>
  </head>
  <body data-spy="scroll" data-target="#my-navbar">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="profile.jsp">Grocekart</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
                                    <li><div class="navbar-text"><p>Welcome: <%= UserDetails.get("name") %></p></div></li>
					<li><a href="profile.jsp">Home</a></li>
					<li><a href="Logout.jsp">Logout</a><li>
				</ul>			
			</div>
		</div>
	</nav>
	</br>
	</br>
        <%
                    String m=(String)session.getAttribute("msg");
                    if(m!=null){
                    %>
                        <div class="panel">
                            <div class="panel-body bg-danger text-center">
                                <%=m%>
                            </div>
                        </div>
                    <%   
                        session.setAttribute("msg",null);
                    }
                    %>
		<div class="container">
			<section>
			<div class="row">
				<div class="col-lg-6">
					<div class="col-lg-4">
                                               						
					</div>
					<div class="col-lg-6">
                                                <div class="form-group">
                                                        <label for="email" class="control-label">Name: <font color="grey"><%= UserDetails.get("name") %></font></label>
                                                </div><!--end form group-->
                                                <div class="form-group">
                                                        <label for="name" class="control-label">Email:<font color="grey"> <%= UserDetails.get("email") %></font></label>
                                                </div><!--end form group-->
                                                
                                                <div class="form-group">
                                                        <div class="col-lg-10 form-group">
                                                            <a href="editprofile.jsp" class="btn btn-primary">Edit Profile</a>
                                                            <a href="changepassword.jsp" class="btn btn-primary">Change Password</a>
                                                        </div>		
                                                </div>
					</div>
			</div>
		</section>
	</div>
	<!--footer-->
	<div class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="container">
			<div class="navbar-text pull-left">
				<p>Design and Develop by Binary Beast</p>
			</div>
	
		</div>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
<%
}else{
        session.setAttribute("msg","Plz Login first");
        response.sendRedirect("home.jsp");
}
%>