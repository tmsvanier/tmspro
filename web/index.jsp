 
<%@ page import="java.net.*, java.io.*, java.sql.*, java.util.*, tmsModelLayer.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% if(request.getParameter("signout")!=null) session.invalidate();  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
           <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
           <link rel="stylesheet" href="css/form.css">
           <meta http-equiv="X-UA-Compatible" content="IE=edge" />
           <script type="text/javascript">
                function passConfirm() {
               var pass1 = document.getElementById("inputPasswordReg").value;
               var pass2 = document.getElementById("inputPasswordConf").value;
               if (pass1 != pass2) {
                    alert("Passwords Do not match");
                   document.getElementById("inputPasswordReg").style.borderColor = "#E34234";
                    document.getElementById("inputPasswordConf").style.borderColor = "#E34234";
                 return false;
                }
                else {
                   //  alert("Passwords Match!!!");
                     return true;
                }
               
               }
           </script>
    </head>
    <body background="images/loginbg.jpg"><h2 align="center"><span class="label label-pill label-primary">TMS Project</span></h2>
        
        <div class="container">
                   

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#login">Login</a></li>
    <li><a data-toggle="tab" href="#registration">Registration</a></li>

  </ul>
            

  <div class="tab-content">
    <div id="login" class="tab-pane fade in active">
        
           <!-- login section-->
        <form action="Login"  method="post" class="form-signin" name="login">
        <h2 class="form-signin-heading">Please login</h2>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-user"></i></div>
        <label for="inputUsername" class="sr-only" >Account Number</label>
        <input type="text" id="inputUsername" class="form-control" placeholder="User Name" required autofocus name="username">
        </div>
        
      
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required  name="pass">
        </div>
        <p></p>
        
        <div class="input-group">
            <div class="input-group-addon"><i class="glyphicon glyphicon-menu-hamburger"></i></div>
        <select name="role" class="form-control">
            <option value="1">Client</option>
            <option value="2">Provider</option> 
            <option value="3">Carrier</option>
            <option value="4">Driver</option>
        </select>    
        </div><p> </p> 
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit2" value="Login">Login</button>
      </form>
 
    </div>
      
      
    <div id="registration" class="tab-pane fade">
        
        <form action="Registration" onsubmit="return passConfirm()"  method="post" class="form-signin" name="registration">
        <h2 class="form-signin-heading">Registration</h2>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-user"></i></div>  
        <label for="inputName" class="sr-only" >Full Name or Organization</label>
        <input type="text" id="inputName" class="form-control" placeholder="Full Name or Organization" required autofocus name="name">
        </div>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-home"></i></div>    
        <label for="inputAddress" class="sr-only" >Address (including postal code)</label>
        <input type="text" id="inputAddress" class="form-control" placeholder="Address (including postal code)" required autofocus name="address">
        </div>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></div>  
        <label for="inputTelephone" class="sr-only" >Telephone Number</label>
        <input type="text" id="inputTelephone" class="form-control" placeholder="Telephone Number" required autofocus name="telephone">
        </div>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></div>
        <label for="inputEmail" class="sr-only" >Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email Address" required autofocus name="email">
        </div>
        <p></p>
        
        <div class="input-group">
            <div class="input-group-addon"><i class="glyphicon glyphicon-menu-hamburger"></i></div>
         <select name="roleRegistering" class="form-control">
            <option> Choose your role</option>
            <option value="1">Client</option>
            <option value="3">Carrier</option>
            <option value="4">Driver</option>
             </optgroup>
        </select>        
        </div>
        <p></p>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-user"></i></div>        
        <label for="inputUserName" class="sr-only" >Choose Username</label>
        <input type="text" id="inputUserName" class="form-control" placeholder="Choose Username" required autofocus name="usernamereg">
        </div>     
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>
        <label for="inputPasswordReg" class="sr-only">Password</label>
        <input type="password" id="inputPasswordReg" class="form-control" placeholder="Password" required  name="passwordreg">
        </div>
     
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>
        <label for="inputPasswordConf" class="sr-only">Confirm Password</label>
        <input type="password" id="inputPasswordConf" class="form-control" placeholder="Confirm Password" required  name="passwordconf">
          </div>
        <p></p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submitregister" value="Register" >Register</button>
      </form>
  
    </div>
  </div>
</div>

        

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>        
    </body>
</html>
