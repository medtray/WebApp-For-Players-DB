<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>
    <sql:setDataSource
    var="myDS"
        driver = "com.ibm.db2.jcc.DB2Driver"
        user = "m0trab01"
        password = "Spring2017"
        
        url = "jdbc:db2://216.249.138.85:50000/m0trab01"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM CLUB
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of clubs</h2></caption>
            <tr>
                <th>Club Name</th>
                <th>Country of club</th>
                
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.CLUB_NAME}" /></td>
                    <td><c:out value="${user.COUNTRY_NAME}" /></td>
                    <td><a href="DeleteClub?id=${user.CLUB_NAME}">Delete</a></td> 
                    <td><a href="UpdateCLub?id='value'">Update</a></td> 
                    
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="ClubsManipulations.jsp">
 
        
        
        <input type="submit" value="Go Back"/>
</body>
</html>