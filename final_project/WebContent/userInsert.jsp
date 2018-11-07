<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert User Record</title>
</head>
<body>
	<%
	    String member = "?";
		String tempMember = request.getAttribute("mem_id").toString();
	    if (tempMember != null)
	        member = tempMember;
	%>
	Hi,
	<%=member%>!
</body>
</html>