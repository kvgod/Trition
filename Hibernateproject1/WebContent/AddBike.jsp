<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Bike</title>
</head>
<body>
	<h1 >Add new Bike </h1>  <button style="color: red;" align="left"> <a href="logout" >Logout</a></button>
		<form action="addBike" method ="post" >
		Enter the bike name:<input type="text" name="name" id="name" onblur="validateName()">
								<b style="color: red;" id="errorName"></b><br><br>
		Enter the bike engine:<input type="text" name="engine"><br><br>
		Enter the bike price:<input type="text" name="price" id="price" onblur="validatePrice()">
								<b style="color: red;" id="errorPrice"></b><br><br><br>
		Enter the bike mileage:<input type="text" name="mileage" id="mileage" onblur="validateMileage()">
								<b style="color: red;" id="errorMileage"></b><br><br>
		Enter the bike image:<input type="file"	name="Bike"><br><br>	
								<input type="submit" value="Add Bike" id="AddBike">
						
		</form>
	
</body>

	<script type="text/javascript">
	
		function validateName()
		{
			var b=document.getElementById("name").value
			if(b.length<3)
			{
				document.getElementById("errorName").innerHTML="Name Length should be greater than 3";
				document.getElementById("AddBike").disabled=true;
			}
			else
			{
				document.getElementById("errorName").innerHTML="";
				document.getElementById("AddBike").disabled=false;
			}
		}

		function validatePrice()
		{
			var b=document.getElementById("price").value;
			if(!/^[0-9]+$/.test(b))
				{
				document.getElementById("errorPrice").innerHTML="Please enter the numbers only";
				document.getElementById("AddBike").disabled=true;
				}
			else{
				document.getElementById("errorPrice").innerHTML="";
				document.getElementById("AddBike").disabled=false;
				}
		}
		
		function validateMileage()
		{
			var b=document.getElementById("mileage").value;
			if(!/^[0-9]+$/.test(b))
			{
			document.getElementById("errorMileage").innerHTML="Please enter the numbers only";
			document.getElementById("AddBike").disabled=true;
			}
		else{
			document.getElementById("errorMileage").innerHTML="";
			document.getElementById("AddBike").disabled=false;
			}
		}
	</script>
</html>