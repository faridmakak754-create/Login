package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	String URL="jdbc:mysql://localhost:3306/school";
	String USER="root";
	String PASS="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	
	
	
	public void init() {
//		driver load
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver load Success");
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		
//		connection
		
		try {
			con=DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Connection success");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
		
		
		/*
		 * if(user.equals("farid121") && pass.equals("1234")) { HttpSession
		 * session=request.getSession(); session.setAttribute("premjit", user);
		 * response.sendRedirect("dashboard.jsp");
		 * 
		 * } else { PrintWriter pw= response.getWriter();
		 * pw.println("Username or password is incorrect");
		 * 
		 * }
		 */
		
		try {

			String user=request.getParameter("name");
			String pass=request.getParameter("email");
			
			pstmt=con.prepareStatement("SELECT * FROM student WHERE name=? AND email=?");
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			
			res=pstmt.executeQuery();
			
			while(res.next()==true) {
				HttpSession session =request.getSession();
				session.setAttribute("a", user);
				response.sendRedirect("dashboard.jsp");
					
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	
	}

}
