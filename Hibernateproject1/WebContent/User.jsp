<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<h1>Welcome to Bike Comparison App</h1><br>
	<form action="compareBikes" method="post">
	
				<%
					List <String> list = (List<String>) request.getAttribute("list");
				%>
		
	Select first bike: <select name="bike_one" id="bike1" >
								<option>Select a Bike
								<% for (String name : list){ %>
					               	 	<option> <%=name%>
								<% } %>
						</select><br><br>		
	Select second bike: <select name="bike_two" id="bike2" onblur="validateBike()" >
								<option>Select a Bike
								<% for (String name : list){ %>
					               	 	<option> <%=name%>
								<% } %>
						</select><b style="color: red;" id="bike2error"></b><br><br>
						
				<input type="submit" value="Compare" id="submitButton" disabled="disabled">
		</form>
</body>

	<script type="text/javascript">
		
	
	
		function validateBike()
			{
				var b1=document.getElementById("bike1").value;
				
				console.log(b1);
				var b2=document.getElementById("bike2").value;
				
				console.log(b2);
				if(b1 =="Select a Bike")
				{
					document.getElementById("submitButton").disabled=true;
				}
				
				else{
					if(b2=="Select a Bike"){
						document.getElementById("submitButton").disabled=true;
					}
				}
				if((b1 == b2) || b1=="Select a Bike" || b2=="Select a Bike")
					{
						document.getElementById("bike2error").innerHTML="Please choose a different bike";
						document.getElementById("submitButton").disabled=true;
					}
				else{
					document.getElementById("submitButton").disabled=false;
			    	document.getElementById("bike2error").innerHTML="";
			    	document.getElementById("submitButton").disabled=false;
				}
			}
			 
	</script>
</html>