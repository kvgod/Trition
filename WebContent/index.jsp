<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/pickmeup.css" type="text/css" />
<link rel="stylesheet" media="screen" type="text/css" href="demo/demo.css" />
<script type="text/javascript" src="js/pickmeup.js"></script>
<script type="text/javascript" src="demo/demo.js"></script>



<!-- 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
  $( "#datepicker" ).datepicker();
} );
</script>	-->
</head>
<body>

<form action="addNewMember" method="post">
<p><input type="text" maxlength="25" placeholder="FIRST NAME" id="firstName" name="firstName">

<input type="text" maxlength="25" placeholder="MIDDLE NAME" id="middleName" name="middleName">

<input type="text" maxlength="25" placeholder="LAST NAME" id="lastName" name="lastName"></p>

<p><input type="text" maxlength="6" placeholder="MEMBER ID" id="memberId" name="memberId"></p>

 <p><input type="text" name="date" id="datepicker" placeholder="DATE OF BIRTH" ></p>

<p><input type="text" placeholder="ADDRESS" maxlength="120" id="address" name="address"></p>

<p><input type="text" placeholder="CONTACT NUMBER" maxlength="10" id="contactNumber" name="contactNumber"></p>

<p><input type="email" placeholder="EMAIL ADDRESS" id="emailAddress" name="emailAddress"></p>

<button type="submit">Submit</button>

</form>

</body>
</html>