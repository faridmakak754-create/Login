package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		
		if(user.equals("farid121") && pass.equals("1234")) {
			HttpSession session=request.getSession();
			session.setAttribute("premjit", user);
			response.sendRedirect("dashboard.jsp");
			
		}
		else {
			PrintWriter pw= response.getWriter();
			pw.println("Username or password is incorrect");
			
		}
		
	
		
	
	}

}
