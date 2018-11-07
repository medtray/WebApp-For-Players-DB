<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(null!=request.getAttribute("successMessage"))
{
    out.println("Welcom "+request.getAttribute("successMessage")+"\n");
}%>
<br>
<br> 
Manipulate Tables
     <form action="option_choice" method="get">
  <select name="item">
    <option value=1>Players</option>
    <option value=2>Clubs</option>
    <option value=3>Countries</option>
    <option value=4>Users</option>
  </select>
  <input type="submit" value="Submit">
</form>
<br> 
<br> 
<br>
<br>
Look for specific information
<br> 
<br>

 <form action="GetPlayersByClub" method="get">
        List players by club:<input type="text" name="club"/><br/>
        <input type="submit" value="Submit"/>
    </form>
    <br> 
    <form action="GetPlayersByCountry" method="get">
        List players by country:<input type="text" name="country"/><br/>
        <input type="submit" value="Submit"/>
    </form>
    <br> 
    <form action="GetPlayersByPosition" method="get">
        List players by position:<input type="text" name="position"/><br/>
        <input type="submit" value="Submit"/>
    </form>
    
    <br> 
    Information of country by player
    <form action="GetInfoCountryByPlayer" method="get">
 
        First Name:<input type="text" name="first_name" /><br/>
        Last Name:<input type="text" name="second_name" /><br/>
        Club:<input type="text" name="club" /><br/>
        
        <input type="submit" value="Get information of country of player"/>
 
    </form>
    <br> 
    <br>
    <form action="GetInfoCountryByClub" method="get">
        Information of country by club:<input type="text" name="club"/><br/>
        <input type="submit" value="Get information of country of club"/>
    </form>
    <br> 
    <form action="login_page.jsp">
        
        <input type="submit" value="Logout"/>
    </form>
    
    
    
</body>
</html>