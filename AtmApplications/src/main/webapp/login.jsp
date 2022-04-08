<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorpage.jsp" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
      
</head>

<body style="background-image:url('https://www.avanade.com/~/media/images/content/background/thinking/the-everyday-bank.jpg');">
    <div class="container">
    
         <div class="row">
         
              <div class="col m6 offset-m3"><br><br><br>
              
                   <div class="card">
                   
                        <div class="card-content">
                        
                             <h3 style="margin-top:10px;" class="center-align">Welcome to Our ATM</h3>
                             
                             <div class="form center-align">
                             
                                  <form action="LogServlet" method="post">
                                  
                                        <input type="text" name="cardno" placeholder="Enter ATM Card No.">
                                        <input type="password" name="pinno" placeholder="Enter PIN No.">
                                        
                                        <button type="reset" class="btn orange lighten-1">Reset</button>
                                        &nbsp; &nbsp; &nbsp; &nbsp;
                                        <button type="submit" class="btn">Submit</button>
                                        
                                  </form>
                                  
                             </div>
                             
                        </div>
                   
                   </div>
              
              </div>
         
         </div>
    
    </div>

</body>

</html>