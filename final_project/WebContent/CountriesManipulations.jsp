<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="DisplayCountries.jsp"> 
        
        <input type="submit" value="Display Countries"/>
 
    </form>
    
    Add a country:
    <form action="add_country" method="post">
 
        
        Country Name:<input type="text" name="country_name" /><br/>
        Capital:<input type="text" name="capital" /><br/>
        Continent:<input type="text" name="continent" /><br/>
        
        <input type="submit" value="Add Country"/>
 
    </form>
    
    <% if(null!=request.getAttribute("Message"))
{
    out.println(request.getAttribute("Message"));
}%>

    <form action="ListOfCountries.jsp"> 
        
        <input type="submit" value="Delete country"/>
 
    </form>
    <form action="ListOfCountries"> 
        
        <input type="submit" value="update countries"/>
 
    </form>
    
    <form action="application_page.jsp">
 
        
        
        <input type="submit" value="Go Back"/>
</body>
</html>