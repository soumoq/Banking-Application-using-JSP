package abc;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
        super();

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String pass1=request.getParameter("pass1");
		String pass2=request.getParameter("pass2");
		
		PrintWriter out=response.getWriter();
		
		if(name.equals(null) && pass1.equals(null) && pass2.equals(null))
		{
			request.setAttribute("message", "Somthing went wrong !!!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else
		{
		if(pass1.equals(pass2))
		{
			Con con=new Con();
			int i=con.register(name, pass1);
			if(i==1)
			{
				request.setAttribute("message", "Registation successfull");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message", "Somthing went wrong !!!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("message", "Password Don't match");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		}
	}

}
