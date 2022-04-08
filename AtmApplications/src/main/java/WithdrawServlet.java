
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WithdrawServlet() {
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
			
			String withdraw0 = request.getParameter("withdraw");
			
			int withdraw = Integer.parseInt(withdraw0);
			int balance;
			
            HttpSession session = request.getSession();
		    
			String cardno0 = (String)session.getAttribute("cardno");
			int cardno = Integer.parseInt(cardno0);
			
			response.setContentType("text/html");
            PrintWriter prnt = response.getWriter();
			
			
			Statement st3 = con.createStatement();
            query = "Select balance From details Where card_number='"+cardno+"';";
            ResultSet rs3 = st3.executeQuery(query);
            
            rs3.next();
            balance = rs3.getInt("balance");
            
               
            if(balance >= withdraw)  
            {  
         	    balance = balance - withdraw;  
         	   
         	    Statement st4 = con.createStatement();
                query = "Update details Set balance='"+balance+"' Where card_number='"+cardno+"';";
                st4.executeUpdate(query);
                
                Statement st5 = con.createStatement();
                query = "Select balance From details Where card_number='"+cardno+"';";
                ResultSet rs5 = st5.executeQuery(query);
                
                rs5.next();
                balance = rs5.getInt("balance");
                
                Statement st10 = con.createStatement();
                query = "Insert Into transaction ( card_number, trans_type, amount, balance)"
             		   +"Values ('"+cardno+"', 'debit', '"+withdraw+"', '"+balance+"');";
                st10.executeUpdate(query);
                
                response.setContentType("text/html");
                prnt.println("<br><br><br>");
                prnt.println("<p style=\"font-family:sans-serif; color:green; text-align:center;\">");
                prnt.println("_______ Please collect your money _______");
                prnt.println("<br><br>");
                prnt.println(withdraw+" Rupees is been Debited.");
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
                
                
            }  
            else  
            {   
            	
            	prnt.println("<br><br><br>");
                prnt.println("<p style=\"font-family:sans-serif; color:green; text-align:center;\">");
                prnt.println("------- Insufficient Balance -------");
                prnt.println("<br>");
                prnt.println("</p>");
                
                prnt.println("<form action=\"option.jsp\">");
         	    prnt.println("<p style=\"text-align:center;\">");
         	    prnt.println("<input type=\"submit\" value=\"OK\">");
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
