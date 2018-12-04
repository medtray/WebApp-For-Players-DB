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
        user = ""
        password = ""
        
        url = ""
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM USERS
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>ID</th>
                <th>PASSWORD</th>
                <th>FIRST NAME</th>
                <th>LAST NAME</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.ID}" /></td>
                    <td><c:out value="${user.PASSWORD}" /></td>
                    <td><c:out value="${user.FIRST_NAME}" /></td>
                    <td><c:out value="${user.SECOND_NAME}" /></td>
                    <td><a href="DeleteUser?id=${user.ID}&password=${user.PASSWORD}">Delete</a></td> 
                    <td><a href="UpdateUser?id='value'">Update</a></td> 
                </tr>
            </c:forEach>
        </table>
    </div>
    
    <form action="UsersManipulations.jsp">
 
        
        
        <input type="submit" value="Go Back"/>
</body>
</html>
