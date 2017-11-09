<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to our very first JSP!</h2>
	<h3>Your search query: <% out.println(request.getParameter("query")); %></h3>
	<h4>Here is your list</h4>
		<%= request.getAttribute("listOfDays") %>
		<br><br>
		
		<table>
		
		<c:forEach var="day" items="${ requestScope.listOfDays}">
			<tr><td>
				<u>Day </u>: ${day }
			</td></tr>
		</c:forEach>
		
		</table>
		
<%-- 		<% 	List<String> days = (List<String>)request.getAttribute("listOfDays"); --%>
<%-- 			for(String day : days ) {%> --%>
<!-- 			<tr><td> -->
<%-- 				<u>Day: <%= day %> </u> --%>
<!-- 			</td></tr>	 -->
<%-- 			<% } %> --%>
		
		
		
		<br/><br/><br/><br/><br/><br/><br/><br/>
		Here is your user request attribute:<br/>
		${ requestScope["user"].portfolio.broker["name"] }
		
		<br/>
		Here is your original query parameter: ${ param.query }
		<br/>
		<br/>
		${ initPara.admin_email }
		<br/>
		The value of mega_int is ... ${ application.mega_int }
		<br/>
		
		
</body>
</html>