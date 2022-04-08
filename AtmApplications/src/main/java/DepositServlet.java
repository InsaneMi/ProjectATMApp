
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DepositServlet() {
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
			
            String deposit0 = request.getParameter("deposit");
			
			int deposit = Integer.parseInt(deposit0);
			int balance;
			
            HttpSession session = request.getSession();
		    
			String cardno0 = (String)session.getAttribute("cardno");
			int cardno = Integer.parseInt(cardno0);
			
			response.setContentType("text/html");
            PrintWriter prnt = response.getWriter();
            
            Statement st6 = con.createStatement();
            query = "Select balance From details Where card_number='"+cardno+"';";
            ResultSet rs6 = st6.executeQuery(query);
            
            rs6.next();
            balance = rs6.getInt("balance");
                 
            balance = balance + deposit;  
            
            Statement st7 = con.createStatement();
            query = "Update details Set balance='"+balance+"' Where card_number='"+cardno+"';";
            st7.executeUpdate(query);
            
            Statement st8 = con.createStatement();
            query = "Select balance From details Where card_number='"+cardno+"';";
            ResultSet rs8 = st8.executeQuery(query);
            
            rs8.next();
            balance = rs8.getInt("balance");
            
            Statement st11 = con.createStatement();
            query = "Insert Into transaction ( card_number, trans_type, amount, balance)"
         		   +"Values ('"+cardno+"', 'credit', '"+deposit+"', '"+balance+"');";
            st11.executeUpdate(query);
            
            response.setContentType("text/html");
            prnt.println("<br><br><br>");
            prnt.println("<p style=\"font-family:sans-serif; color:green; text-align:center;\">");
            prnt.println(+deposit+" Rupees is been Credited.");
            prnt.println("<br><br>");
            prnt.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            prnt.println("<br>");
            prnt.println("Current Balance in your Account is "+balance+" Rupees.");
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
