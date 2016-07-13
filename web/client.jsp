 
<%@ page import="java.net.*, java.io.*, java.sql.*, java.util.*, tms.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
            
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>TMS | Client's Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
  <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
 
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>T</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Client Dashboard </b>TMS</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
 

          
          <!-- Tasks Menu -->
          <li class="dropdown tasks-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">9</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                <!-- Inner menu: contains the tasks -->
                <ul class="menu">
                  <li><!-- Task item -->
                    <a href="#">
                      <!-- Task title and progress text -->
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <!-- The progress bar -->
                      <div class="progress xs">
                        <!-- Change the css width attribute to simulate progress -->
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all Orders</a>
              </li>
            </ul>
          </li>
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
         
            

            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
 

                <p>
                     
                  Client's Name - Client
                  <small>Member since Nov. 2012</small>
                </p>
              </li>

              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a data-toggle="pill" href="#profile" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                    
                    
                    <form name="submitForm" method="POST" action="index.jsp">
                    <input type="hidden" name="signout" value="signout">
                    <a href="javascript:document.submitForm.submit()" class="btn btn-default btn-flat" name="signout">Sign out</a>
                    </form>
    
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
         
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
 

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
       <!-- <li class="header">Main Menu</li>
         Optionally, you can add icons to the links -->
        <li class="active"><a data-toggle="pill"s href="#home"><i class="fa fa-home"></i> <span>Main Page</span></a></li>
        <li><a data-toggle="pill" href="#order"><i class="fa fa-plus"></i> <span>Create an Order</span></a></li>
 	<li><a data-toggle="pill" href="#list"><i class="fa fa-list-ul"></i> <span>List of Orders</span></a></li>
<li><a data-toggle="pill" href="#report"><i class="fa fa-bar-chart "></i> <span>Generate Report</span></a></li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>





 <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Main page for Clients</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content">

     <% 
                      String name=(String)session.getAttribute("accountname"); 
                       out.println("Hi Aslan\nfinally I Got IT: You have enterd ****  \n"+name +"  *****in the first Page: "); 
                       %> 

    </section>
    <!-- /.content -->
    
    
  </div>
  <!-- /.content-wrapper -->
    </div> 
     
     
    <div id="order" class="tab-pane fade">
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Create an Order
        <small>You can create an Order here</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->dfff

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    </div>
 
 
 
     
    <div id="list" class="tab-pane fade">
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        List of Orders
        <small>List of all orders including active and archived ones</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->dfff

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    </div>
 
 
 
     <div id="report" class="tab-pane fade">
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Generate a Report
        <small>Specify a report</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->dfff

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    </div>
 
      <div id="profile" class="tab-pane fade">
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" width="600">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Profile
        <small>Update your Profile</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content" >

       <form action="Update"  method="post" class="form-update" name="update">
 
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></div>  
        <label for="inputName" class="sr-only" >Account number</label>
        <input type="text" id="inputName" class="form-control" placeholder="Account number" disabled autofocus name="accountname">
        </div>
        
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
 
         
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>
        <label for="inputPasswordReg" class="sr-only">Password</label>
        <input type="password" id="inputPasswordReg" class="form-control" placeholder="New Password" required  name="passwordreg">
        </div>
     
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>
        <label for="inputPasswordConf" class="sr-only">Confirm Password</label>
        <input type="password" id="inputPasswordConf" class="form-control" placeholder="Confirm Password" required  name="passwordconf">
          </div>
        <p></p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="submitregister" value="Register" >Update</button>
      </form>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    </div>
 
 
 </div>

















  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      <!-- Anything you want -->
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2016 <a href="#">Omid and Aslanbek</a>.</strong> All rights reserved.
  </footer>

 
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>
