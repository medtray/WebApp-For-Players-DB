<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="DisplayClubs.jsp"> 
        
        <input type="submit" value="Display Clubs"/>
 
    </form>
    
    Add a club:
    <form action="add_club" method="post">
 
        
        Club Name:<input type="text" name="club_name" /><br/>
        Country of club:<input type="text" name="country_name" /><br/>
        
        
        <input type="submit" value="Add Club"/>
 
    </form>
    
    <% if(null!=request.getAttribute("Message"))
{
    out.println(request.getAttribute("Message"));
}%>

    <form action="ListOfClubs.jsp"> 
        
        <input type="submit" value="Delete club"/>
 
    </form>
    <form action="ListOfClubs"> 
        
        <input type="submit" value="update clubs"/>
 
    </form>
    
    <form action="application_page.jsp">
 
        
        
        <input type="submit" value="Go Back"/>
</body>
</html>