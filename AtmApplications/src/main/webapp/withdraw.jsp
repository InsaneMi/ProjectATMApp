<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
     

</head>
<body style="background-image:url('https://cdn.wallpapersafari.com/37/77/3ALVrN.jpg');">

    <div class="container">
    
         <div class="row">
         
              <div class="col m6 offset-m3"><br><br><br>
              
                   <div class="card">
                   
                        <div class="card-content">
                        
                             <h4 style="margin-top:10px;" class="center-align">Please Enter the Amount</h4>
                             <h4 style="margin-top:10px;" class="center-align">You want to Withdraw</h4>
                             
                             <div class="form center-align">
                             
                                  <form method="post" action="WithdrawServlet">
                                  
                                        <br><br>
                                        <input type="text" name="withdraw" placeholder="Enter Amount">
                                        
                                        
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