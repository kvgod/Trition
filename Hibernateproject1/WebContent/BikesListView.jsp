<%@page import="com.thbs.HibernateBike.Bikes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee list</title>
</head>
<body bgcolor="gray">
	
	
	<button style="color: red;" align="right"> <a href="logout" >Logout</a></button>
	<h2 align="center">Your Bike Lists..</h2>
	

	<table width="80%" border="1" style="background-color: gray;" align="center">
				<tr>
					<td style="color: maroon;" bgcolor="gray" align="center"> **Click to Id edit specifications of bike...** <td>
				</tr>
	</table>
	
	<table width="80%" border="1" style="background-color: teal;" align="center">
    	<%
		    ArrayList<Bikes> list1=null;
			list1=(ArrayList<Bikes>)request.getSession(false).getAttribute("bikeList");
			int sl=0;
			if(list1!=null)
			{
		%>
					<tr>
		         		<td align="center"> <%= "Sl_no." %> </td>
		               
		                <td> <%= "Name" %> </td>
		                <td> <%= "engine" %> </td>
		                <td> <%= "price" %> </td>
		                <td> <%= "mileage" %> </td>
		                <td> <%= "image" %> </td>
		                 
		           </tr>
				<%
				for (Iterator iterator = list1.iterator(); iterator.hasNext();) 
				{
					Bikes bean = (Bikes) iterator.next();					
					%>
                	 <tr>                 	 	 
	                    <td > <a href="editBike?id=<%=bean.getBike_id()%>&name=<%=bean.getName()%>&engine=<%=bean.getEngine()%>&price=<%=bean.getPrice()%>&mileage=<%=bean.getMileage()%>&image=<%=bean.getImage()%>"><button style="color: teal; font-style: oblique;font: cursive; " type="button" ><%= bean.getBike_id()%></button></a> </td>
	                    <td> <%=bean.getName()%> </td>
	                    <td> <%=bean.getEngine()%> </td>
	                    <td> <%=bean.getPrice()%> </td>
	                    <td> <%=bean.getMileage()%> </td>
	                    <td> <%=bean.getImage() %>
	                    <td> <img src="/HibernateBike1/WebContent/WEB-INF/pics"+<%=bean.getName()%>+".jpeg" alt="Smiley face" height="42" width="42">	
	                    <td> <a href="deleteBike?id=<%=bean.getBike_id()%>&name=<%=bean.getName()%>&engine=<%=bean.getEngine()%>&price=<%=bean.getPrice()%>&mileage=<%=bean.getMileage()%>"><button style="color: red;" type="submit" name="Delete" value="<%= bean.getBike_id()%>">Delete Bike</button></a> </td>	                
                	</tr> 
          		  <% 
				}
			}
		%>
	</table>
	
	
</body>
</html>