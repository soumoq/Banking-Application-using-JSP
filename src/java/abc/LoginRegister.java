package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")


public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName=request.getParameter("name");
		String uPass=request.getParameter("pass");
		String submit=request.getParameter("submit");
		
		PrintWriter out=response.getWriter();
		
		
		if(submit.equals("Login"))
		{
			
			Con con=new Con();
			int i=con.insert(uName, uPass);
			//out.println("soumo: "+i);
			
			if(i==0)
			{
				request.setAttribute("message", "Wrong Username");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else if(i!=0)
			{
				
				request.setAttribute("i", i);
				request.setAttribute("uName", uName);
				RequestDispatcher rd=  request.getRequestDispatcher("home");
				rd.forward(request, response);
			}
			
		}
		
		
	}

}
