<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="login_page.jsp">   
<input type="submit" value="Go to login"><br/>  
</form> 
You are registred, login now
<div class="success">
<% if(null!=request.getAttribute("successMessage"))
{
    out.println("You are registred, login now");
}%>
</div>

</body>
</html>