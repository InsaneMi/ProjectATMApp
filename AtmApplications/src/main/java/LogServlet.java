import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
    public LogServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			String url = "jdbc:postgresql://localhost:5432/sample";
			String uname = "postgres";
			String pass = "Postgres";
			String query = "";
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			String cardno0 = request.getParameter("cardno");
			String pinno0 = request.getParameter("pinno");
			
			if(cardno0=="" || pinno0=="")
			{
				RequestDispatcher dis = request.getRequestDispatcher("errorpage.jsp");
				dis.forward(request, response);
			}
			
			int cardno = Integer.parseInt(cardno0);
			int pinno = Integer.parseInt(pinno0);
			
			query = "Select card_number From details Where card_number='"+cardno+"';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			response.setContentType("text/html");
			PrintWriter prnt = response.getWriter();
			
			if(rs.next()==true)
			{
				
				query = "Select name From details Where card_number='"+cardno+"';";
				Statement st1 = con.createStatement();
				ResultSet rs1 = st1.executeQuery(query);

				rs1.next();
				String name = rs1.getString("name");
				
				
				
				query = "Select pin From details Where card_number='"+cardno+"';";
				Statement st2 = con.createStatement();
				ResultSet rs2 = st2.executeQuery(query);

				rs2.next();
				int pin = rs2.getInt("pin");
				
				if(pinno==pin)
				{
					HttpSession session = request.getSession();
					session.setAttribute("cardno", cardno0);
					session.setAttribute("name", name);
					
					request.setAttribute("cname", name);
					request.setAttribute("ccardno", cardno0);
					
					RequestDispatcher dis = request.getRequestDispatcher("option.jsp");
					dis.forward(request, response);
					
					con.close();
				}
				else
				{
					
					prnt.println("<br><br><br>");
					prnt.println("<p style=\"font-family:sans-serif; color:green; text-align:center;\">");
					prnt.println("You filled the invalid Details");
					prnt.println("<br> <br>");
					prnt.println("Please TRY AGAIN");
					prnt.println("</p>");
					
					prnt.println("<form action=\"login.jsp\">");
		     	    prnt.println("<p style=\"text-align:center;\">");
		     	    prnt.println("<input type=\"submit\" value=\"Retry\">");
		     	    prnt.println("</p>");
		     	    prnt.println("</form>");
					
					
					con.close();
				}
				
			}
			
			else
			{
				
				prnt.println("<br><br><br>");
				prnt.println("<p style=\"font-family:sans-serif; color:green; text-align:center;\">");
				prnt.println("Your Card no. was NOT Found in Our DataBase");
				prnt.println("<br> <br>");
				prnt.println("Please TRY AGAIN");
				prnt.println("</p>");
				
				prnt.println("<form action=\"login.jsp\">");
	     	    prnt.println("<p style=\"text-align:center;\">");
	     	    prnt.println("<input type=\"submit\" value=\"Retry\">");
	     	    prnt.println("</p>");
	     	    prnt.println("</form>");
				
				
				con.close();
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
	}

}


