 

<%@ page import="java.net.*, java.io.*, java.sql.*, java.util.*,tmsModelLayer.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%!
public String getStatusDesc(int num){
    String str="";
   
    switch(num){
        case 2:{
            str="Submited";break;
        }
        case 3:{
            str="Confirmed";break;
        }
         case 4:{
            str="Shipped";break;
        }
          case 5:{
            str="Delivered";break;
        }
          case 6:{
            str="Cancelled";break;
        }
          default:{
               str="undefined";break;
          }
          
    }//end switch
    return str;
}
public String gettype(int num){
    String type="";
    if(num==2)type="label-info" ;else if(num==3)type="label-info" ;
     else if(num==4)type="label-primary"; else if(num==5)type="label-success";
     else if(num==6)type="label-danger";
    return type;
}
public void showIem(Orders Tmp){
  //  ArrayList mylist=new ArrayList();
    for (Item element:Tmp.getItemCollection()){
         System.out.println("<tr>");
    System.out.println("<td>"+element.getItemweight()+"</td>");
    System.out.println("<td>"+element.getItemqty()+"</td>");
    System.out.println("<td>"+element.getItemvolume()+"</td>");
   System.out.println("</tr></br>"); 
    } 
}
%>
      <% 
           Client myuser=(Client) session.getAttribute("clientpage");
           Set<Orders> myorder=(Set<Orders>)session.getAttribute("orders");
           
           Iterator it=myorder.iterator();
      %>      
<html  >
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
         
            <%= myuser.getFullName()%>

            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
 

                <p>
                    
                  <%= myuser.getFullName()%> - Client
                  <small>
                         <% 
  
           out.println("Client ID: "+myuser.getClientId()); %><br>
          <%  out.println("Address: "+myuser.getAddress());%><br>
           <%  out.println("Email: "+myuser.getEmail());%><br>
         <%   out.println("Telephone: "+myuser.getPhone());
       %></small>
       
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

<form action="Order"  method="post" class="form-update" name="order">
 
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-home"></i></div>  
        <label for="departure" class="sr-only" >Departure(Enter Address)</label>
        <input type="text" id="departure" class="form-control" placeholder="Departure (Enter Address)" required autofocus name="departure">
        </div>

         
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-send"></i></div>    
        <label for="destination" class="sr-only" >Destination(Enter Address)</label>
        <input type="text" id="destination" class="form-control" placeholder="Destination (Enter Address)" required autofocus name="destination">
        </div>
    Items:
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></div>    
       <div class="row">
                           <div class="col-xs-5">
                  <input type="text" class="form-control" placeholder="Item 1. Description" name="item1desc">
                </div>
                <div class="col-xs-2" >
                  <select class="form-control" name="item1category">
                    <option>Category</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
                <div class="col-xs-1">
                  <input type="text" class="form-control" placeholder="Qty" name="item1qty">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="volume (in liters)" name="item1volume">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="weight (in kg)" name="item1weight">
                </div>
              </div>    
        
        </div>
     <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></div>    
       <div class="row">
                           <div class="col-xs-5">
                  <input type="text" class="form-control" placeholder="Item 2. Description" name="item2desc">
                </div>
                <div class="col-xs-2" >
                  <select class="form-control" name="item2category">
                    <option>Category</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
                <div class="col-xs-1">
                  <input type="text" class="form-control" placeholder="Qty" name="item2qty">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="volume (in liters)" name="item2volume">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="weight (in kg)" name="item2weight">
                </div>
              </div>    
        
        </div>
        
     <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></div>    
       <div class="row">
                           <div class="col-xs-5">
                  <input type="text" class="form-control" placeholder="Item 3. Description" name="item3desc">
                </div>
                <div class="col-xs-2" >
                  <select class="form-control" name="item3category">
                    <option>Category</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
                <div class="col-xs-1">
                  <input type="text" class="form-control" placeholder="Qty" name="item3qty">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="volume (in liters)" name="item3volume">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="weight (in kg)" name="item3weight">
                </div>
              </div>    
        
        </div>
 
     <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></div>    
       <div class="row">
                           <div class="col-xs-5">
                  <input type="text" class="form-control" placeholder="Item 4. Description" name="item4desc">
                </div>
                <div class="col-xs-2" >
                  <select class="form-control" name="item4category">
                    <option>Category</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
                <div class="col-xs-1">
                  <input type="text" class="form-control" placeholder="Qty" name="item4qty">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="volume (in liters)" name="item4volume">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="weight (in kg)" name="item4weight">
                </div>
              </div>    
        
        </div>
    
     <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></div>    
       <div class="row">
                           <div class="col-xs-5">
                  <input type="text" class="form-control" placeholder="Item 5. Description" name="item5desc">
                </div>
                <div class="col-xs-2" >
                  <select class="form-control" name="item5category">
                    <option>Category</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
                <div class="col-xs-1">
                  <input type="text" class="form-control" placeholder="Qty" name="item5qty">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="volume (in liters)" name="item5volume">
                </div>
                <div class="col-xs-2">
                  <input type="text" class="form-control" placeholder="weight (in kg)" name="item5weight">
                </div>
              </div>    
        
        </div>

        <p></p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="orderbtn" value="order" >Create an Order</button>
      </form>
        
        
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

 
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Recent Orders</h3>

              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>Order ID</th>
                  <th>Departure</th>
                  <th>Arrival</th>
                  <th>Status</th>
                  <th>Driver Id</th>
                  <th>Request Date</th>
                   <th>Distance </th>
                </tr>
                <% for(Orders element:myorder){                                
                 out.println("<tr>");
                    out.println("<td><a href=# data-toggle=modal data-target=#"+element.getOrderid()+">"+element.getOrderid()+ "</a>");
                            
                                    
                    out.println("<td>"+element.getDeparture()+"</td>");
                    out.println("<td>"+element.getArrival()+"</td>");
                    out.println("<td class='"+gettype(element.getStatusid())+"'>"+getStatusDesc(element.getStatusid())+"</td>");
                    out.println("<td>"+element.getDriverid()+"</td>");
                    out.println("<td>"+element.getOrderdate()+"</td>");
                     out.println("<td>"+element.getDistance()+"</td>");
                out.println("</tr>"); 
                
                
                out.println("<div class='modal fade' tabindex='-1' role=dialog aria-hidden=true id="+element.getOrderid()+">");              
                out.println(" <div class='modal-dialog modal-lg'><div class=modal-content>"); 
                  out.println("   <div class='modal-header'>"); 
                  out.println("    <button type='button' class='close' data-dismiss='modal'>&times;</button>"); 
                  out.println("    <h4 class='modal-title'>Details of order # "+element.getOrderid()+"</h4> </div>"); 
                  out.println("  <div class='modal-body'>");
                    for(Item record: element.getItemCollection()){
                        out.println("--------------------------------------------------------------------------------------------------</br>");
                    %>
                    <%=  record.toString()%>
                    <%out.println("</br>");}//iner loop
                   out.println(" </div> <div class='modal-footer'>"); 
               out.println("   <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"); 
               out.println("  </div></div></div></div>"); 
 
                }//the outmost loop%>
              </table>
            
            </div>
            
          </div>
          <!-- /.box -->

    </section>
            
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
        <input type="text" id="inputName" class="form-control" placeholder="Account number" disabled autofocus name="accountname" value="<% out.println(myuser.getUsername()); %>">
        </div>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-user"></i></div>  
        <label for="inputName" class="sr-only" >Full Name or Organization</label>
        <input type="text" id="inputName" class="form-control" placeholder="Full Name or Organization" required autofocus name="name" value="<%= myuser.getFullName()%>">
        </div>
 
           <br>
         
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-home"></i></div>    
        <label for="inputAddress" class="sr-only" >Address (including postal code)</label>
        <input type="text" id="inputAddress" class="form-control" placeholder="Address (including postal code)" required autofocus name="address" value="<%out.println(myuser.getAddress());%>">
        </div>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></div>  
        <label for="inputTelephone" class="sr-only" >Telephone Number</label>
        <input type="text" id="inputTelephone" class="form-control" placeholder="Telephone Number" required autofocus name="telephone" value="<%   out.println(myuser.getPhone());%>">
        </div>
        
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></div>
        <label for="inputEmail" class="sr-only" >Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email Address" required autofocus name="email" value="<%  out.println(myuser.getEmail());%>">
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
