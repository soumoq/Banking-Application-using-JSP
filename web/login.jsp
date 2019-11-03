<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<table style="background-color: skyblue">
			<tr><td><h3 style="color: red"> ${message}</h3></td></tr>
			<tr><td> Username : </td><td> <input type="text" name = "name"></td></tr>
			<tr><td> password : </td><td> <input type="password" name = "pass"></td></tr>
			<tr><td> <input type="submit" name="submit" value="Login"></td><td><a href="register.jsp">Registation</a></td></tr>
		</table>
	</form>
</body>
</html>