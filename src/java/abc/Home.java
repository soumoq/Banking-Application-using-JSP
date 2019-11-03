package abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		
		String upBal=request.getParameter("bal");
		String submit=request.getParameter("submit");
		
		
		request.setAttribute("bal", bal);
		request.setAttribute("message", uName);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		if(submit.equals("Login"))
		{
			request.setAttribute("message", "wow");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		
		
	}

	

}
