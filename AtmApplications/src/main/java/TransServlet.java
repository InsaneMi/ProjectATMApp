import java.sql.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/TransServlet")
public class TransServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TransServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		    HttpSession session = request.getSession();
		    
			String cardno0 = (String)session.getAttribute("cardno");
			String option0 = request.getParameter("option");
			
			//int cardno = Integer.parseInt(cardno0);
			int option = Integer.parseInt(option0);
			
			response.setContentType("text/html");
			
			
	        switch(option)  
	        {  
	            case 1:
	            	   RequestDispatcher wdis = request.getRequestDispatcher("withdraw.jsp");
					   wdis.forward(request, response);
	                     
	                        
	                      
	                   break;  

	            case 2:
	            	   RequestDispatcher ddis = request.getRequestDispatcher("deposit.jsp");
					   ddis.forward(request, response);
	            	   
	                    
	                   
	            	   break;

	            case 3:
	            	   RequestDispatcher sdis = request.getRequestDispatcher("ShowBalServlet");
					   sdis.forward(request, response);
	            	   
	            	   
	            	   
	                   break;
	                   
	            case 4:
	            	   RequestDispatcher mdis = request.getRequestDispatcher("MiniStatServlet");
					   mdis.forward(request, response);
	            	   
	            	   
	            	   
	            	   break;
	            	   
	            case 5:
	            	   
	            	   RequestDispatcher edis = request.getRequestDispatcher("logout.jsp");
					   edis.forward(request, response);
	            	   
	            	   
	            	   
	            	   break;
	            	   
	                   
	            default:
	            	    RequestDispatcher defdis = request.getRequestDispatcher("def.jsp");
					    defdis.forward(request, response);
	            	    
	            	   
		    } 
		
	}

}
