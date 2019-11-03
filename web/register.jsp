<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		<table style="background-color: Lightgreen">
			<tr><td><h3 style="color: red"> ${message}</h3></td></tr>
			<tr><td> Username : </td><td> <input type="text" name = "name"></td></tr>
			<tr><td> Password : </td><td> <input type="password" name = "pass1"></td></tr>
			<tr><td> Re-Enter Password : </td><td> <input type="password" name = "pass2"></td></tr>
			<tr><td> <input type="submit" name="submit" value="Register"></td></tr>
			
		</table>
	</form>
</body>
</html>