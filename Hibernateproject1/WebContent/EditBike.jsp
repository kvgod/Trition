<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Contact</title>
</head>
<body >
<button style="color: red;" align="right"> <a href="logout" >Logout</a></button>
	<h2 style="color: red;" align="center">Edit Bike</h2><br>

	<form action="updateBike" method="get" style="color: blue;">
		Bike ID  		: <input type="text" name="id"  value="${param.id}" readonly="readonly"><br><br>
		Enter Bike Name 	: <input type="text" name="name" value="${param.name}"><br><br>
		Enter Engine CC 	: <input type="text" name=engine value="${param.engine}"><br><br>
		Enter Price Rs 		: <input type="text" name="price" value="${param.price}"><br><br>
		Enter Mileage 		: <input type="text" name="mileage"  value="${param.mileage}"><br><br>
								  <input type="submit" value="Update Bike">
					
	</form>
	<a style="color: red">${errorMsg}</a>
</body>
</html>