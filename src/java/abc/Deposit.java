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
                String depbal1=request.getParameter("depnum1");
                String dpbtn=request.getParameter("dpbtn");
                PrintWriter out=response.getWriter();
                
               
                Con con=new Con();
                
                if(dpbtn.equals("Deposit"))
                {
                int i=con.getId();
                con.balance(Integer.parseInt(depbal),i,1);
                response.sendRedirect("home.jsp");
                }
                else if(dpbtn.equals("withdrawal"))
                {
                    int i=con.getId();
                    int a=con.balance(Integer.parseInt(depbal1),i,0);
                    
                    response.sendRedirect("home.jsp");
                    if(a==1)
                         out.print("somthing went wrong");
                }
                
                
		
	}
}