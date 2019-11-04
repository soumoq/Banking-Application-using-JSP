<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            if(session.getAttribute("username")==null)
            {
                response.sendRedirect("login.jsp");
            }
        %>
    
    
	<form action="home" method="post">
		<table style="background-color: balck">
		
			<tr><td><h3 style="color: Blue">Hi ${username}</h3></td></tr>
			<tr><td>Your account balance is: ${bal}</td><td> </td></tr>
		</table>
		
	</form>
        
                <form action="Deposit">
                Enter amount <input type="number" name="depnum">
            <input type="submit" value="Deposit" name="dpbtn">
                Enter amount <input type="number" name="depnum1">
            <input type="submit" value="withdrawal" name="dpbtn">
            
        </form>
                
        <form action="Logout">
            <input type="submit" value="Logout">
        </form>
                
                <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file" multiple/>
            <input type="submit">
        </form>

</body>
</html>