<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

</head>

<body>
	<h1>Welcome to Admin home page</h1>
	
	<form action="checkAdmin" method="post">
		Enter your MemberId: <input type="text" name="username" id="mail"/>
		<br> Enter your password: <input type="password" name="password" id="passw"/>
		<br> <button type="submit">Submit</button>

	</form>
	<h2>${error}</h2>
</body>
</html>