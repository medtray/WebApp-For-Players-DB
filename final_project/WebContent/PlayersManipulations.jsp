<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="DisplayPlayers.jsp"> 
        
        <input type="submit" value="Display Players"/>
 
    </form>
    
    Add a player:
    <form action="add_player" method="post">
 
        
        First Name:<input type="text" name="first_name" /><br/>
        Last Name:<input type="text" name="last_name" /><br/>
        Club:<input type="text" name="club" /><br/>
        Country:<input type="text" name="country" /><br/>
        Position:<input type="text" name="position" /><br/>
        
        <input type="submit" value="Add Player"/>
 
    </form>
    
    <% if(null!=request.getAttribute("Message"))
{
    out.println(request.getAttribute("Message"));
}%>

    <form action="ListOfPlayers.jsp"> 
        
        <input type="submit" value="Delete players"/>
 
    </form>
    <form action="ListOfPlayers.jsp"> 
        
        <input type="submit" value="update players"/>
 
    </form>
    
    <form action="application_page.jsp">
 
        
        
        <input type="submit" value="Go Back"/>
</body>
</html>