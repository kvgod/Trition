<%@page import="com.thbs.HibernateBike.Bikes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bike Details</title>
</head>
<body>
	
	<%-- <c:forEach var="bike" items="${compBikes}">
		<c:out value="${bike}"></c:out>
	</c:forEach> --%>
	<button style="color: red;" align="right"> <a href="logout" >Logout</a></button>
	<h1 align="center">Bike Details</h1>
	<table border="1" width="75%" align="center">
		<tr>
			<th align="center">Name</th>
			<th align="center">Engine</th>
			<th align="center">Mileage</th>
			<th align="center">Price</th>
		</tr>
		<c:forEach var="bike" items="${compBikes}">
			<tr>
				<td align="center"><c:out value="${bike.getName()}" /></td>
				<td align="center"><c:out value="${bike.getEngine()}" /></td>
				<td align="center"><c:out value="${bike.getMileage()}" /></td>
				<td align="center"><c:out value="${bike.getPrice()}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h2 align="center"><form action="compareBikes"  method="get">
		<input type="hidden" name="bike_one" value="<%=session.getAttribute("bike_one")%>">
		<input type="hidden" name="bike_two" value="<%=session.getAttribute("bike_two")%>">
		<select name="compareType" >
			<option>Engine
			<option>Mileage
			<option>Price
		</select>
		<input type="submit">
	</form>
	</h2>

	<%
	if(request.getAttribute("result")!=null )
		out.println("<h1 align=\"center\" style=\"color: maroon;\"> Result = "
			+request.getAttribute("result").toString()+"</h1>");
	%>
</body>
</html>