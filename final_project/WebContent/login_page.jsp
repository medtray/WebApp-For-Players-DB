<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="checklogin2" method="POST"> 
 Enter your ID:<br> 
<input type="text" name="id"> </br>
 Enter your password :<br> 
<input type="password" name="password"></br>
Login : <br> 
<input type="submit" value="login"><br/> 
</form> 
<div class="error">
<% if(null!=request.getAttribute("errorMessage"))
{
    out.println(request.getAttribute("errorMessage"));
}%>
</div>
<br>
<br>
<form action="register" method="post">
 
        ID:<input type="text" name="userName"/><br/>
        Password:<input type="password" name="password"/><br/>
        First Name:<input type="text" name="first_name" /><br/>
        Last Name:<input type="text" name="last_name" /><br/>
        
        <input type="submit" value="Register"/>
 
    </form>




</body>
</html>