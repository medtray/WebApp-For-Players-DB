<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

ID of player:
<% 

    out.println(request.getAttribute("a"));
%>

<form action="UpdatePlayer2" method="post">
 
        <input type="hidden" name="id" value="<%=request.getAttribute("a") %>"/><br/>
        First Name:<input type="text" name="first" value="<%=request.getAttribute("b") %>"/><br/>
        Second Name:<input type="text" name="last"  value="<%=request.getAttribute("c") %>"/><br/>
        Club:<input type="text" name="club"  value="<%=request.getAttribute("d") %>"/><br/>
        Country:<input type="text" name="country"  value="<%=request.getAttribute("e") %>"/><br/>
        Position:<input type="text" name="position"  value="<%=request.getAttribute("f") %>"/><br/>
        
        <input type="submit" value="Submit"/>
 
    </form>




</body>
</html>