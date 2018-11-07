<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="display_users"> 
        
        <input type="submit" value="Display Users"/>
 
    </form>
    
    Add a user:
    <form action="register2" method="post">
 
        ID:<input type="text" name="userName"/><br/>
        Password:<input type="password" name="password"/><br/>
        First Name:<input type="text" name="first_name" /><br/>
        Last Name:<input type="text" name="last_name" /><br/>
        
        <input type="submit" value="Add User"/>
 
    </form>
    <form action="dispatch_jsp"> 
        
        <input type="submit" value="Delete users"/>
 
    </form>
    <form action="ListOfUsers"> 
        
        <input type="submit" value="update users"/>
 
    </form>
    
    <form action="application_page.jsp">
 
        
        
        <input type="submit" value="Go Back"/>
</body>
</html>