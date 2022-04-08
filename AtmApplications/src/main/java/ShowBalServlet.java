import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ShowBalServlet")
public class ShowBalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowBalServlet() {
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
			
			int balance;
			
            HttpSession session = request.getSession();
		    
			String cardno0 = (String)session.getAttribute("cardno");
			int cardno = Integer.parseInt(cardno0);
			
			response.setContentType("text/html");
            PrintWriter prnt = response.getWriter();
			
			Statement st9 = con.createStatement();
            query = "Select balance From details Where card_number='"+cardno+"';";
            ResultSet rs9 = st9.executeQuery(query);
         
            rs9.next();
            balance = rs9.getInt("balance");
            
            
            prnt.println("<br><br><br>");
            prnt.println("<p style=\"font-family:sans-serif; color:green; text-align:center;\">");
            prnt.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            prnt.println("<br>");
            prnt.println("Current Balance in your Account is "+balance+" Rupees");
            prnt.println("<br>");
            prnt.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            prnt.println("<br>");
            prnt.println("</p>");
            
     	    prnt.println("<form action=\"option.jsp\">");
     	    prnt.println("<p style=\"text-align:center;\">");
     	    prnt.println("<input type=\"submit\" value=\"OK\">");
     	    prnt.println("</p>");
     	    prnt.println("</form>");
			
            con.close();
			
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
