<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="home" method="post">
		<table style="background-color: balck">
		
			<tr><td><h3 style="color: Blue">Hi ${message}</h3></td></tr>
			<tr><td>Your account balance is: ${bal}</td><td> </td></tr>
			
			<tr><td> Enter the deposited amount : </td><td> <input type="text" name = "bal"></td></tr>
			<tr><td> <input type="submit" name="submit" value="Login"></td><td><a href="register.jsp">Registation</a></td></tr>
		</table>
		
	</form>
	
	
	
	

</body>
</html>