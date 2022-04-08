import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MiniStatServlet")
public class MiniStatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public MiniStatServlet() {
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
			
			
            HttpSession session = request.getSession();
		    
			String cardno0 = (String)session.getAttribute("cardno");
			int cardno = Integer.parseInt(cardno0);
			
			response.setContentType("text/html");
            PrintWriter prnt = response.getWriter();
            
			
            prnt.println("<br><br><br>");
            prnt.println("<p style=\"font-family:sans-serif; color:green; text-align:center;\">");
			prnt.println("Your Last Five Trancations are :");
			prnt.println("<br><br>");
			
			
			Statement st11 = con.createStatement();
     	    query = "Select balance From transaction Where card_number='"+cardno+"' Order By id Desc Limit 1 ;";
     	    ResultSet rs11 = st11.executeQuery(query);
     	    
     	    rs11.next();
     	    int cbalance = rs11.getInt("balance");
     	    
     	    prnt.println("Closing balance is : "+cbalance);
     	    
     	    prnt.println("<br>");
     	    prnt.println("--------------------------------------------------");
     	    prnt.println("<br>");
     	    prnt.println("Transaction-Type &nbsp; &nbsp; Amount &nbsp; &nbsp; Balance");
     	    prnt.println("<br>");
     	    
     	    
			
     	    Statement st12 = con.createStatement();
     	    query = "Select trans_type, amount, balance From transaction Where card_number='"+cardno+"' Order By id Desc Limit 5 ;";
     	    ResultSet rs12 = st12.executeQuery(query);
     	   
     	    while(rs12.next())
     	    {
     		    String minis = rs12.getString("trans_type")+" &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; "+rs12.getInt("amount")+" &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; "+rs12.getInt("balance");
     		    prnt.println(minis);
     		    prnt.println("<br>");
     	    }
     	    prnt.println("--------------------------------------------------");
     	    prnt.println("<br>");
     	    
     	    
     	    Statement st13 = con.createStatement();
    	    query = "Select balance From transaction Where card_number='"+cardno+"' Order By id Desc Limit 6 ;";
    	    ResultSet rs13 = st13.executeQuery(query);
    	    
    	    int obalance=0;
    	    while(rs13.next())
    	    {
    	    	obalance = rs13.getInt("balance");
    	    }
    	    
    	    
    	    prnt.println("Opening balance was : "+obalance);
     	    
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
