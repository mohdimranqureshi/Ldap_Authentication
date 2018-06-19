<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <script src="js/live.js"></script>
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Login Form</title>
<link rel="stylesheet" href="css/style.css">


<script>
	function validateForm() {
		var user = document.forms["myForm"]["userName"].value;
		var pass = document.forms["myForm"]["password"].value;
		if (user == null || user == "") {
			alert("Please Enter Username, It cannot be Blank!!!");
			
			return false;
		}

		if (pass == null || pass == "") {
			alert("Please Enter Password, It cannot be Blank!!!");
			return false;
		}
		
	}
	
</script>
</head>
<body>
				
	<h4 style="color:blue;"> User Login</h4>
	
	
			<form:form method="POST" name="myForm"
				action="/ldapAuthentication/dologin"
				onsubmit="return validateForm()" modelAttribute="Employee">
				
				<p>
					<input type="text" name="userName" value="" placeholder="Username">
				</p>
				<p>
					<input type="password" name="password" value=""
						placeholder="Password">
				</p>

				<p class="submit">
					<input type="submit" name="commit" value="Login" >
				</p>
			</form:form>
			 <c:if test="${not empty errorMessage}">
		   			<b><p style="color:red">${errorMessage}</p></b>
			</c:if>
		</div>

			<p> Copyright &copy; 2016 Xavient.com</p>
	
</body>
</html>