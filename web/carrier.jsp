 
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.net.*,java.util.Date, java.io.*, java.sql.*, java.util.*,tmsModelLayer.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    int placing,confirm,cancel,deliverd,ship;
         confirm=0;cancel=0;deliverd=0;ship=0;placing=0;
          Carrier myuser1=(Carrier) session.getAttribute("carrierpage");
          Set<Orders> myorder=(Set<Orders>)session.getAttribute("orders");
          List<Drivers> mydriver=(ArrayList<Drivers>)session.getAttribute("drivers");
          boolean find=false;
            for(Orders test:myorder){
               if(test.getStatusid()==2)placing++;
               else if(test.getStatusid()==3)confirm++;
               else if(test.getStatusid()==4)ship++;
               else if(test.getStatusid()==5)deliverd++;
               if(test.getStatusid()==6)cancel++;}
           
        SimpleDateFormat sdf = new SimpleDateFormat("E dd MMM yyyy hh:mm:ss a");
        Date date=new Date();
      %>    
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
    if(num==2)type="label-warning" ;else if(num==3)type="label-info" ;
     else if(num==4)type="label-primary"; else if(num==5)type="label-success";
     else if(num==6)type="label-danger";
    return type;
}
%>
        
<html  >
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title >TMS | Carrier's Dashboard  </title>
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
  
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

    <link rel='stylesheet' href='plugins/fullcalendar/fullcalendar.css' /> 
    <script src='dist/js/moment.js'></script>
    
    <script src='plugins/fullcalendar/fullcalendar.min.js'></script>
    <link href='plugins/fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
 
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
    <a href="/" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>T</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Carrier Dashboard </b>TMS</span>
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
 
          <li class="dropdown tasks-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger"><% out.print(ship); %></span>
            </a>
            <ul class="dropdown-menu">
                <%if (confirm!=0)
                 out.println("<li class='header'><b>You have <i>"+confirm+" </i>  shipped orders </br> please do not forget to choose a driver</b></li>");
                %>
                <li>
                <!-- Inner menu: contains the tasks -->
                
              </li>
              <li class="footer" >
                <a data-toggle="pill" href="#list">View all Orders</a>
              </li>
            </ul>
          </li>
         
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
         
            <%= myuser1.getFullName()%>

            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
 

                <p>
                    
                  <%= myuser1.getFullName()%> - Carrier
                  <small>
                      
          <%  out.println("Address: "+myuser1.getAddress());%><br>
           <%  out.println("Email: "+myuser1.getEmail());%><br>
         <%   out.println("Telephone: "+myuser1.getPhone());
       %></small>
       
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
 
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
               <li class="active"><a data-toggle="pill" href="#home"><i class="fa fa-home"></i> <span>Main Page</span></a></li>

        <li ><a data-toggle="pill" href="#list"><i class="fa fa-list-ul"></i> <span>List of Orders</span></a></li>
        <li><a data-toggle="pill" href="#clients"><i class="fa fa-list-ul"></i> <span>List of Drivers</span></a></li>
 
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
       
          <span>    <%=sdf.format(date).toString()%></span> </br>
        Dashboard
      </h1>
        
       
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
        
            <div class="col-md-4">
                 <div id="orderstats"   ></div>  </div>
 
 
 
 
 
 
 <div class="col-md-4">
     
        </div>
 
 
 
 
 
 
 
        </div>
 <script>
     
     new Morris.Donut({ 
  element: 'orderstats',
  data: [
      {label: "submited", value: <%=placing%>},
    {label: "Confirmed", value:<%=confirm%>},
    {label: "Shipped", value: <%=ship%>},
    {label: "Delivered", value: <%=deliverd%>},
    {label: "Cancelled", value:<%=cancel%>}],
        
  colors: ['#f39c12', '#00c0ef', '#3c8dbc', '#00a65a', '#dd4b39' ]
 
}); 
 </script>
 
 
<div id='calendar' style="max-width: 600px; margin: 0 auto;"></div>

 
 
    </section>
    <!-- /.content -->
    
    
  </div>
  <!-- /.content-wrapper -->
    </div> 
     
    <div id="list" class="tab-pane fade in">
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
              <h3 class="box-title">All Orders</h3>

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
              <table id="orders" class="table table-hover">
                <tr>
                  <th>Order ID</th>
                  <th>Departure</th>
                  <th>Arrival</th>
                  <th>Status</th>
             
                  <th>Driver Name</th>
                  <th>Request Date</th>
                  <th>Details</th>
                </tr>
                
       <% for(Orders element:myorder){    
                     find=false;
                    out.println("<tr>");
                    out.println("<td><a href=# data-toggle=modal data-target=#"+element.getOrderid()+">"+element.getOrderid()+ "</a>"); 
                    out.println("<td>"+element.getDeparture()+"</td>");
                    out.println("<td>"+element.getArrival()+"</td>");
                    out.println("<td class='"+gettype(element.getStatusid())+"'>"+getStatusDesc(element.getStatusid())+"</td>");
                    // out.println("<td>"+element.getDriverid()+"</td>");
                     for(Drivers d:mydriver){
                         if(element.getDriverid()==d.getDriverId()){
                              out.println("<td>"+ d.getFullName()  +"</td>");
                              find=true;
                             break;
                         }   }       
                         if(!find)
                              out.println("<td> Driver has not been chosen  </td>");                    
                   
                    out.println("<td>"+element.getOrderdate()+"</td>");
                     if(element.getStatusid()==5) out.println("<td> The order was successfully delivered!</td>");
                     else if(element.getStatusid()==4 || element.getStatusid()==3)
                        out.println("<td><a href=# data-toggle=modal data-target=#"+element.getOrderid()+">Track the order</a>");
                     else out.println("<td>There are no details on this order</td>"); 
                   
                    out.println("</tr>"); 
                
                
                    out.println("<div class='modal fade' tabindex='-1' role=dialog aria-hidden=true id="+element.getOrderid()+">");              
                    out.println(" <div class='modal-dialog modal-lg'><div class=modal-content>"); 
                    out.println(" <div class='modal-header'>"); 
                    out.println(" <button type='button' class='close' data-dismiss='modal'>&times;</button>"); 
                    out.println(" <h4 class='modal-title'>Details of order # "+element.getOrderid()+"</h4>");                                   
                    out.println(" <div class='modal-body'>");
                                                         
                 %>
             
<form action="OrderAction"  method="post" class="form-update" name="order<%=element.getOrderid()%>" >
            
             <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></div>  
        <label for="fullname" class="sr-only" >Client's ID, Full Name and Order Date</label>
        <input type="text" id="fullname" disabled  class="form-control" placeholder="Order #<%= element.getOrderid() %>, created on <%= element.getOrderdate() %>, by client #<%= element.getClientid() %>" required autofocus name="departure">
        </div>
    
         <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-home"></i></div>  
        <label for="departure" class="sr-only" >Departure(Enter Address)</label>
        <input type="text" id="departure" disabled class="form-control" placeholder="<%= element.getDeparture() %>" required autofocus name="departure">
        </div>
        <input  type="hidden" id="orderNum" class="form-control" name="ordership"  value="<%=element.getOrderid()%>">
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-send"></i></div>    
        <label for="destination" class="sr-only" >Destination(Enter Address)</label>
        <input type="text" id="destination" disabled class="form-control" placeholder="<%= element.getArrival() %>" required autofocus name="destination">
        </div>

 
    <p>
         
  <% for (Item items:element.getItemCollection()) { %>
 
  <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></div>    
       <div class="row">
                           <div class="col-xs-3">
                               <input disabled type="text"  class="form-control" placeholder=" <%=items.getItemDesc()%>"name="itemdesc" >
                </div>
                <div class="col-xs-2">
                  <input disabled type="text" size="30" class="form-control" placeholder="<%=items.getCategoryDetail()%>" name="itemqty">
                </div>
                
                <div class="col-xs-1">
                  <input  disabled type="text" class="form-control" placeholder="<%=items.getItemqty()%>" name="itemqty">
                </div>
                <div class="col-xs-1">
                  <input disabled type="text" class="form-control" placeholder="<%=items.getItemvolume()%>" name="itemvolume">
                </div>
                <div class="col-xs-2">
                  <input disabled type="text" class="form-control" placeholder="<%=items.getItemweight()%> ( kg)" name="itemweight">
                    </div>
                    <div class="col-xs-3">
                  <input disabled type="text" class="form-control" placeholder="<%=items.getItemprice()%> $" name="itemprice">               
                </div>
              </div>    
        
        </div>
    
                  <% };%></p>
 

    &nbsp;<p></p>
    <select class="form-control-static" name="Driver" id="transportType">;
                   
              <option value="0">Choose One Driver</option>
              <% for (Drivers Dr:mydriver){
                  if(element.getStatusid()==3){
                 
                       out.println("<option value="+Dr.getDriverId()+"> Driver Id: "+Dr.getDriverId()+" , Driver Name: "+Dr.getFullName()+"</option>");
            
                       }
              }
              out.println(" </select> ");    
              if(element.getStatusid()==3){
                 out.println("  <p></p>");        
                 out.println("<button class='btn btn-lg btn-primary btn-block' type='submit' name='shipmentbtn' value='order'>Send This Order to selected Driver</button>"); 
                out.println(" <button class='btn btn-lg bg-red btn-primary btn-block' type='submit' name='waitingbtn' value='order'>I have No Driver Right Now</button>");
              } 

                if(element.getStatusid()==4) { %>
                              
                        GPS Map Position of the vehicle:<br>
                      
                 <iframe src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyAoliW0rF36cTvpCZ_TzZyphrmQ_MYm_24&origin=<% out.print(element.getDeparture()); %>&destination=<% out.print(element.getArrival()); 
                      %>&waypoints=<% out.print(element.getDeparture()); %> <% for(Gps gprecord:element.getGps()){
                     out.print("|" + gprecord.getGpsx()+","+gprecord.getGpsy()); }%>" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>               
            
                     <%     
              }
              
              
              
              
              %>
             
         </form>
                    <%//iner loop
                        out.println(" </div> <div class='modal-footer'>"); 
                        out.println("   <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"); 
                        out.println("  </div></div></div></div>");  
                    };%>
              </table> 
            </div> 
          </div>
          <!-- /.box -->
         
          
    </section>
            
  </div>
  <!-- /.content-wrapper -->
    </div>
 

 
  <div id="clients" class="tab-pane fade">
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        List of Drivers
        <small>List of all Drivers</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content">

 
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">All Drivers</h3>

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
                  <th>Drivers ID</th>
                  <th>Drivers Name</th>
                  <th>Drivers Email</th>              
                  <th>Drivers Address</th>
                  <th>Drivers Phone</th>
                  <th>Drivers UserName</th>
                   
                </tr>
             <% 
                   for( Drivers element:mydriver){
   
                    out.println("<tr >");
                    out.println("<td>"+ element.getDriverId()+"</td>");
                    out.println("<td>"+element.getFullName()+"</td>");
                    out.println("<td>"+element.getEmail()+"</td>");
                    out.println("<td>"+element.getAddress()+"</td>");
                    out.println("<td>"+element.getPhone()+"</td>");
                    out.println("<td>"+element.getUsername()+"</td>");
                    out.println("</tr>"); 
             
              
                   };
                    %>   
              </table>
     
            </div>
            
          </div>
          <!-- /.box -->
         
          
    </section>
            
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
