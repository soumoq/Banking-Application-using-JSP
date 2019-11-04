package abc;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Deposit")


public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depbal=request.getParameter("depnum");
               
                Con con=new Con();
                int i=con.getId();
                con.balance(Integer.parseInt(depbal),i);
                response.sendRedirect("home.jsp");
                
                
		
	}
}