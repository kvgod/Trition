<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<button style="color: red;" align="right"> <a href="logout" >Logout</a></button>
	<h1 >Welcome Admin</h1><br><br>
	<a href="openBikesView">Show Bikes list</a><br><br>
	<a href="openAddBikeView">Add Bike </a><br><br>
	<h3><a style="color: green;" a>${addSuccess}</a></h2><br><br></h3>
</body>
</html>