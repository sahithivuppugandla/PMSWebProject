<html> 

<head> 

 <title>JSP Page</title>
  </head> 
  <body>

<%
String username=request.getParameter("username");
String password=request.getParameter("password");
String role=request.getParameter("role");

if(username.equalsIgnoreCase("test")&& password.equalsIgnoreCase("test")&&role.equalsIgnoreCase("Admin")) 

{ 
	
 %> 
 
 <jsp:forward page="/Admin.jsp"> 
 <jsp:param name="pr" value="<%= username.toString() %>" />
  </jsp:forward> 




<%
}
else if(username.equalsIgnoreCase("test")&& password.equalsIgnoreCase("test")&&role.equalsIgnoreCase("Investor"))
{
	%> 
	 
	 <jsp:forward page="/Investor.jsp"> 
	 <jsp:param name="pr" value="<%= username %>" />
	  </jsp:forward> 
	  
<%
}
else if(username.equalsIgnoreCase("test")&& password.equalsIgnoreCase("test")&&role.equalsIgnoreCase("bor")){
	
	%> 
	 
	 <jsp:forward page="/BackOfficeRepresentative.jsp"> 
	 <jsp:param name="pr" value="<%= username %>" />
	  </jsp:forward> 
	  <%
}
else{
	%>
	
	 <jsp:include page="/Error.jsp"> 
	 <jsp:param name="pr" value="<%= username %>" />
	  </jsp:include> 
	<%
	
}
	  %>
	  
</body>
</html>


