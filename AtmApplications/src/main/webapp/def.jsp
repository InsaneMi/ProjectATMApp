<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
      
</head>
<body style="background-image:url('https://i.pinimg.com/originals/d1/49/23/d14923d5d31b1808ef1fc352e4e93472.jpg');">

<%

   String name = (String)session.getAttribute("name");
    
%>
    <div class="container">
    
         <div class="row">
         
              <div class="col m6 offset-m3"><br><br><br>
              
                   <div class="card">
                   
                        <div class="card-content">
                        
                             <h3 style="margin-top:10px;" class="center-align">Welcome <%= name %></h3>
                             <h4 style="margin-top:10px;" class="center-align">Select an OPTION to Proceed:</h4>
                             
                             <div class="form center-align">
                             
                                  <form method="post" action="TransServlet">
                                  
                                        <p>
                                            <br>
                                            Choose 1 for Withdraw <br> <br>
                                            Choose 2 for Deposit <br> <br>
                                            Choose 3 for Show Balance <br> <br>
                                            Choose 4 for Mini Statement <br> <br>
                                            Choose 5 for Log Out <br> <br>
                                        </p>
                                        <p style="color:red;">
                                            *Invalid Option*
                                        </p>
                                  
                                        <input type="text" name="option" placeholder="Enter Your Choice">
                                        
                                        
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