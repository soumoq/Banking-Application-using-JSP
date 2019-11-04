package abc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;


@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Home() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=(int)request.getAttribute("i");
		String uName=(String) request.getAttribute("uName");
		Con con=new Con();
		int bal=con.checkBal(i);
		
               
		
		HttpSession session=request.getSession();
                    session.setAttribute("username", uName);
                    session.setAttribute("bal", bal);
                    response.sendRedirect("home.jsp");
                
                
                
		
		
		
	}

	

}
