 

<%@ page import="java.net.*, java.io.*, java.sql.*, java.util.*,tmsModelLayer.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% 
         int placing,confirm,cancel,deliverd,ship;
         confirm=0;cancel=0;deliverd=0;ship=0;placing=0;
           Client myuser=(Client) session.getAttribute("clientpage");
           Set<Orders> myorder=(Set<Orders>)session.getAttribute("orders");
           List<Itemcategory> myCategory=(ArrayList<Itemcategory>)session.getAttribute("category");
           //List<Item> items_request=new ArrayList();
          // Orders order_Request=new Orders();
          // Iterator it=myorder.iterator();
            
           for(Orders test:myorder){
               if(test.getStatusid()==2)placing++;
               else if(test.getStatusid()==3)confirm++;
               else if(test.getStatusid()==4)ship++;
               else if(test.getStatusid()==5)deliverd++;
               if(test.getStatusid()==6)cancel++;}
           
           
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
    if(num==2)type="label-info" ;else if(num==3)type="label-info" ;
     else if(num==4)type="label-primary"; else if(num==5)type="label-success";
     else if(num==6)type="label-danger";
    return type;
}
public void showIem(Orders Tmp){
    for (Item element:Tmp.getItemCollection()){
         System.out.println("<tr>");
    System.out.println("<td>"+element.getItemweight()+"</td>");
    System.out.println("<td>"+element.getItemqty()+"</td>");
    System.out.println("<td>"+element.getItemvolume()+"</td>");
   System.out.println("</tr></br>"); 
    } 
}
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
              <span class="label label-danger"><%=confirm%></span>
            </a>
            <ul class="dropdown-menu">
                <li class="header">You have<%=deliverd%> tasks</li>
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
        <li><a data-toggle="pill" href="#order"><i class="fa fa-plus"></i> <span>Place an Order</span></a></li>
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
        <div class="row">
        
            <div class="col-md-4">
                 <div id="orderstats"   ></div>  </div>
 
 
 
 
 
 
 <div class="col-md-4">
          <div class="box box-primary">
            <div class="box-body no-padding">
              <!-- THE CALENDAR -->
              <div id="calendar" class="fc fc-ltr fc-unthemed"><div class="fc-toolbar"><div class="fc-left"><div class="fc-button-group"><button type="button" class="fc-prev-button fc-button fc-state-default fc-corner-left"><span class="fc-icon fc-icon-left-single-arrow"></span></button><button type="button" class="fc-next-button fc-button fc-state-default fc-corner-right"><span class="fc-icon fc-icon-right-single-arrow"></span></button></div><button type="button" class="fc-today-button fc-button fc-state-default fc-corner-left fc-corner-right fc-state-disabled" disabled="disabled">today</button></div><div class="fc-right"><div class="fc-button-group"><button type="button" class="fc-month-button fc-button fc-state-default fc-corner-left fc-state-active">month</button><button type="button" class="fc-agendaWeek-button fc-button fc-state-default">week</button><button type="button" class="fc-agendaDay-button fc-button fc-state-default fc-corner-right">day</button></div></div><div class="fc-center"><h2>July 2016</h2></div><div class="fc-clear"></div></div><div class="fc-view-container" style=""><div class="fc-view fc-month-view fc-basic-view"><table><thead><tr><td class="fc-widget-header"><div class="fc-row fc-widget-header" style=""><table><thead><tr><th class="fc-day-header fc-widget-header fc-sun">Sun</th><th class="fc-day-header fc-widget-header fc-mon">Mon</th><th class="fc-day-header fc-widget-header fc-tue">Tue</th><th class="fc-day-header fc-widget-header fc-wed">Wed</th><th class="fc-day-header fc-widget-header fc-thu">Thu</th><th class="fc-day-header fc-widget-header fc-fri">Fri</th><th class="fc-day-header fc-widget-header fc-sat">Sat</th></tr></thead></table></div></td></tr></thead><tbody><tr><td class="fc-widget-content"><div class="fc-day-grid-container"><div class="fc-day-grid"><div class="fc-row fc-week fc-widget-content"><div class="fc-bg"><table><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-other-month fc-past" data-date="2016-06-26"></td><td class="fc-day fc-widget-content fc-mon fc-other-month fc-past" data-date="2016-06-27"></td><td class="fc-day fc-widget-content fc-tue fc-other-month fc-past" data-date="2016-06-28"></td><td class="fc-day fc-widget-content fc-wed fc-other-month fc-past" data-date="2016-06-29"></td><td class="fc-day fc-widget-content fc-thu fc-other-month fc-past" data-date="2016-06-30"></td><td class="fc-day fc-widget-content fc-fri fc-past" data-date="2016-07-01"></td><td class="fc-day fc-widget-content fc-sat fc-past" data-date="2016-07-02"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-number fc-sun fc-other-month fc-past" data-date="2016-06-26">26</td><td class="fc-day-number fc-mon fc-other-month fc-past" data-date="2016-06-27">27</td><td class="fc-day-number fc-tue fc-other-month fc-past" data-date="2016-06-28">28</td><td class="fc-day-number fc-wed fc-other-month fc-past" data-date="2016-06-29">29</td><td class="fc-day-number fc-thu fc-other-month fc-past" data-date="2016-06-30">30</td><td class="fc-day-number fc-fri fc-past" data-date="2016-07-01">1</td><td class="fc-day-number fc-sat fc-past" data-date="2016-07-02">2</td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td class="fc-event-container"><a class="fc-day-grid-event fc-event fc-start fc-end fc-draggable" style="background-color:#f56954;border-color:#f56954"><div class="fc-content"><span class="fc-time">12a</span> <span class="fc-title">All Day Event</span></div></a></td><td></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content"><div class="fc-bg"><table><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-past" data-date="2016-07-03"></td><td class="fc-day fc-widget-content fc-mon fc-past" data-date="2016-07-04"></td><td class="fc-day fc-widget-content fc-tue fc-past" data-date="2016-07-05"></td><td class="fc-day fc-widget-content fc-wed fc-past" data-date="2016-07-06"></td><td class="fc-day fc-widget-content fc-thu fc-past" data-date="2016-07-07"></td><td class="fc-day fc-widget-content fc-fri fc-past" data-date="2016-07-08"></td><td class="fc-day fc-widget-content fc-sat fc-past" data-date="2016-07-09"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-number fc-sun fc-past" data-date="2016-07-03">3</td><td class="fc-day-number fc-mon fc-past" data-date="2016-07-04">4</td><td class="fc-day-number fc-tue fc-past" data-date="2016-07-05">5</td><td class="fc-day-number fc-wed fc-past" data-date="2016-07-06">6</td><td class="fc-day-number fc-thu fc-past" data-date="2016-07-07">7</td><td class="fc-day-number fc-fri fc-past" data-date="2016-07-08">8</td><td class="fc-day-number fc-sat fc-past" data-date="2016-07-09">9</td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content"><div class="fc-bg"><table><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-past" data-date="2016-07-10"></td><td class="fc-day fc-widget-content fc-mon fc-past" data-date="2016-07-11"></td><td class="fc-day fc-widget-content fc-tue fc-past" data-date="2016-07-12"></td><td class="fc-day fc-widget-content fc-wed fc-past" data-date="2016-07-13"></td><td class="fc-day fc-widget-content fc-thu fc-past" data-date="2016-07-14"></td><td class="fc-day fc-widget-content fc-fri fc-past" data-date="2016-07-15"></td><td class="fc-day fc-widget-content fc-sat fc-past" data-date="2016-07-16"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-number fc-sun fc-past" data-date="2016-07-10">10</td><td class="fc-day-number fc-mon fc-past" data-date="2016-07-11">11</td><td class="fc-day-number fc-tue fc-past" data-date="2016-07-12">12</td><td class="fc-day-number fc-wed fc-past" data-date="2016-07-13">13</td><td class="fc-day-number fc-thu fc-past" data-date="2016-07-14">14</td><td class="fc-day-number fc-fri fc-past" data-date="2016-07-15">15</td><td class="fc-day-number fc-sat fc-past" data-date="2016-07-16">16</td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content"><div class="fc-bg"><table><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-past" data-date="2016-07-17"></td><td class="fc-day fc-widget-content fc-mon fc-past" data-date="2016-07-18"></td><td class="fc-day fc-widget-content fc-tue fc-past" data-date="2016-07-19"></td><td class="fc-day fc-widget-content fc-wed fc-past" data-date="2016-07-20"></td><td class="fc-day fc-widget-content fc-thu fc-past" data-date="2016-07-21"></td><td class="fc-day fc-widget-content fc-fri fc-past" data-date="2016-07-22"></td><td class="fc-day fc-widget-content fc-sat fc-past" data-date="2016-07-23"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-number fc-sun fc-past" data-date="2016-07-17">17</td><td class="fc-day-number fc-mon fc-past" data-date="2016-07-18">18</td><td class="fc-day-number fc-tue fc-past" data-date="2016-07-19">19</td><td class="fc-day-number fc-wed fc-past" data-date="2016-07-20">20</td><td class="fc-day-number fc-thu fc-past" data-date="2016-07-21">21</td><td class="fc-day-number fc-fri fc-past" data-date="2016-07-22">22</td><td class="fc-day-number fc-sat fc-past" data-date="2016-07-23">23</td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td class="fc-event-container" colspan="2"><a class="fc-day-grid-event fc-event fc-start fc-not-end fc-draggable" style="background-color:#f39c12;border-color:#f39c12"><div class="fc-content"><span class="fc-time">12a</span> <span class="fc-title">Long Event</span></div></a></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content"><div class="fc-bg"><table><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-past" data-date="2016-07-24"></td><td class="fc-day fc-widget-content fc-mon fc-past" data-date="2016-07-25"></td><td class="fc-day fc-widget-content fc-tue fc-past" data-date="2016-07-26"></td><td class="fc-day fc-widget-content fc-wed fc-today fc-state-highlight" data-date="2016-07-27"></td><td class="fc-day fc-widget-content fc-thu fc-future" data-date="2016-07-28"></td><td class="fc-day fc-widget-content fc-fri fc-future" data-date="2016-07-29"></td><td class="fc-day fc-widget-content fc-sat fc-future" data-date="2016-07-30"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-number fc-sun fc-past" data-date="2016-07-24">24</td><td class="fc-day-number fc-mon fc-past" data-date="2016-07-25">25</td><td class="fc-day-number fc-tue fc-past" data-date="2016-07-26">26</td><td class="fc-day-number fc-wed fc-today fc-state-highlight" data-date="2016-07-27">27</td><td class="fc-day-number fc-thu fc-future" data-date="2016-07-28">28</td><td class="fc-day-number fc-fri fc-future" data-date="2016-07-29">29</td><td class="fc-day-number fc-sat fc-future" data-date="2016-07-30">30</td></tr></thead><tbody><tr><td class="fc-event-container" rowspan="2"><a class="fc-day-grid-event fc-event fc-not-start fc-end fc-draggable" style="background-color:#f39c12;border-color:#f39c12"><div class="fc-content"> <span class="fc-title">Long Event</span></div></a></td><td rowspan="2"></td><td rowspan="2"></td><td class="fc-event-container"><a class="fc-day-grid-event fc-event fc-start fc-end fc-draggable" style="background-color:#0073b7;border-color:#0073b7"><div class="fc-content"><span class="fc-time">10:30a</span> <span class="fc-title">Meeting</span></div></a></td><td class="fc-event-container"><a class="fc-day-grid-event fc-event fc-start fc-end fc-draggable" href="http://google.com/" style="background-color:#3c8dbc;border-color:#3c8dbc"><div class="fc-content"><span class="fc-time">12a</span> <span class="fc-title">Click for Google</span></div></a></td><td rowspan="2"></td><td rowspan="2"></td></tr><tr><td class="fc-event-container"><a class="fc-day-grid-event fc-event fc-start fc-end fc-draggable" style="background-color:#00c0ef;border-color:#00c0ef"><div class="fc-content"><span class="fc-time">12p</span> <span class="fc-title">Lunch</span></div></a></td><td class="fc-event-container"><a class="fc-day-grid-event fc-event fc-start fc-end fc-draggable" style="background-color:#00a65a;border-color:#00a65a"><div class="fc-content"><span class="fc-time">7p</span> <span class="fc-title">Birthday Party</span></div></a></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content" style="height: 59px;"><div class="fc-bg"><table><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-future" data-date="2016-07-31"></td><td class="fc-day fc-widget-content fc-mon fc-other-month fc-future" data-date="2016-08-01"></td><td class="fc-day fc-widget-content fc-tue fc-other-month fc-future" data-date="2016-08-02"></td><td class="fc-day fc-widget-content fc-wed fc-other-month fc-future" data-date="2016-08-03"></td><td class="fc-day fc-widget-content fc-thu fc-other-month fc-future" data-date="2016-08-04"></td><td class="fc-day fc-widget-content fc-fri fc-other-month fc-future" data-date="2016-08-05"></td><td class="fc-day fc-widget-content fc-sat fc-other-month fc-future" data-date="2016-08-06"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-number fc-sun fc-future" data-date="2016-07-31">31</td><td class="fc-day-number fc-mon fc-other-month fc-future" data-date="2016-08-01">1</td><td class="fc-day-number fc-tue fc-other-month fc-future" data-date="2016-08-02">2</td><td class="fc-day-number fc-wed fc-other-month fc-future" data-date="2016-08-03">3</td><td class="fc-day-number fc-thu fc-other-month fc-future" data-date="2016-08-04">4</td><td class="fc-day-number fc-fri fc-other-month fc-future" data-date="2016-08-05">5</td><td class="fc-day-number fc-sat fc-other-month fc-future" data-date="2016-08-06">6</td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div></div></div></td></tr></tbody></table></div></div></div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /. box -->
        </div>
 
 
 
 
 
 
 
        </div>
 <script>
     
     new Morris.Donut({ 
  element: 'orderstats',
  data: [
      {label: "Created", value: <%=placing%>},
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
     
     
    <div id="order" class="tab-pane fade">
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
          Place an Order
        <small>You can place your order here</small>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content">

<form action="Client_order"  method="post" class="form-update" name="order" >
    <input type=hidden id="client_id" name="client_id" value=<%=myuser.getClientId()%>>
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-home"></i></div>  
        <label for="departure" class="sr-only" >Departure(Enter Address)</label>
        <input type="text" id="departure" class="form-control" placeholder="Departure (Enter Address)" required autofocus name="departure">
        </div>

         
        <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-send"></i></div>    
        <label for="destination" class="sr-only" >Destination(Enter Address)</label>
        <input type="text" id="destination" class="form-control" placeholder="Destination (Enter Address)" required autofocus name="destination">
        </div>
    
    <p > </br>To carry your order, which following options do you prefer to be considered ? (optional)</p>
    
    
      <div class="btn-group" data-toggle="buttons"> 
   
  <label class="btn btn-primary active">
    <input type="radio" name="radiobtn"  autocomplete="off" checked value="1">TMS Suggestion
  </label>
    <label class="btn btn-primary">
    <input type="radio" name="radiobtn"  autocomplete="off" value="2"> Cost  
  </label>
  <label class="btn btn-primary">
    <input type="radio" name="radiobtn"  autocomplete="off" value="3"> Time
  </label>
   <label class="btn btn-primary">
    <input type="radio" name="radiobtn"  autocomplete="off" value="4"> Carrier Reputation  
   </label> &nbsp;
                <select class="form-control-static " name="transportType" id="transportType">
                    <option value="0"> Transport type</option>
                    <option value="2"> Airplane</option>
                    <option value="3"> Train</option>
                    <option value="4"> Truck</option>
                    <option value="5"> Marine</option> 
                </select>
      
</div>
    <p>
        
        <script type="text/javascript">
                  
function calcCost(){
    for(var i=1;i<3;i++){
   document.getElementById('order'+i+'price').value=
           document.getElementById('order'+i+'qty').value
          *(document.getElementById('order'+i+'weight').value*5
           +document.getElementById('order'+i+'volume').value*5);
   
   }
}

</script>
 
 <% for (int i = 1; i<3; i++) { %>
 
  <div class="input-group"><div class="input-group-addon"><i class="glyphicon glyphicon-plus"></i></div>    
       <div class="row">
                           <div class="col-xs-4">
                  <input type="text" class="form-control" placeholder="Item <% out.print(i); %>. Description" name="item<% out.print(i); %>desc" >
                </div>
                <div class="col-xs-2" >
                  <select class="form-control" name="item<% out.print(i); %>category">
                    <option value="0">Category</option>
                    <% for (int j = 1; j<7; j++) { %>
                    <option value="<% out.print(j+1); %>"> <%=myCategory.get(j-1).getItemcategorydesc()%></option>
                        <% } %>

                  </select>
                </div>
                <div class="col-xs-1">
                    <input type="text" class="form-control" id="order<% out.print(i); %>qty" placeholder="Qty" name="item<% out.print(i); %>qty" onkeypress="calcCost()">
                </div>
                <div class="col-xs-1">
                  <input type="text" class="form-control" id="order<% out.print(i); %>volume" placeholder="volume (in liters)" name="item<% out.print(i); %>volume" onkeypress="calcCost()">
                </div>
                <div class="col-xs-1">
                  <input type="text" class="form-control" id="order<% out.print(i); %>weight" placeholder="weight (in kg)" name="item<% out.print(i); %>weight" onkeypress="calcCost()">
                </div>
                <div class="col-xs-2">
                    <input   type="text" class="form-control" id="order<% out.print(i); %>price"  placeholder="Price" name="item<% out.print(i); %>price" onblur="calcCost()" >
                </div>
              </div>    
        
        </div>
                  <% } %>
    <p>

                  
                  
    
  

        <p></p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="orderbtn" value="order">Place an Order</button>
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
                  <th>Track/Feedback </th>
 
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
                            if( element.getStatusid()==5 ) {
                    out.println("<td><a href=# data-toggle=modal data-target=#"+element.getOrderid()+">Leave a feedback</a>"); } 
                            else { 
                    out.println("<td><a href=# data-toggle=modal data-target=#"+element.getOrderid()+">Track</a>"); } 
                    out.println("</tr>");  
                    out.println("<div class='modal fade' tabindex='-1' role=dialog aria-hidden=true id="+element.getOrderid()+">");              
                    out.println(" <div class='modal-dialog modal-lg'><div class=modal-content>"); 
                    out.println(" <div class='modal-header'>"); 
                    out.println(" <button type='button' class='close' data-dismiss='modal'>&times;</button>"); 
                    out.println(" <h4 class='modal-title'>Details of order # "+element.getOrderid()+"</h4> </div>"); 
                    out.println(" <div class='modal-body'>");

                        
                 %>
             
<form action="Client_order"  method="post" class="form-update" name="order" >
  
  <% if( element.getStatusid()==5 ) {  
      
  for (Item items:element.getItemCollection()) {%>  

 
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
               <% } } else {
for (Item items:element.getItemCollection()) {%>
                
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
                  <%} };%></p>
 
         
   
    </form>
                  
                  <% if( element.getStatusid()==5 ) { %>
                  
                  <script>
                    function feedback() {
                       var dropcost = document.getElementById('costfeedbackweight');
                        var droptime = document.getElementById('timefeedbackweight');
                        var dropnod = document.getElementById('nodfeedbackweight');
                        var cost = dropcost.options[dropcost.selectedIndex].value;
                        var time = droptime.options[droptime.selectedIndex].value;
                        var nod = dropnod.options[dropnod.selectedIndex].value; 
           
                         var sum =  parseInt(cost)+parseInt(time)+parseInt(nod);
                            if(sum == 100 && cost!=0 && nod!=0 && time!=0) {
                                document.getElementById('costfeedbackweight').style.borderColor="green";
                                document.getElementById('timefeedbackweight').style.borderColor="green";
                                document.getElementById('nodfeedbackweight').style.borderColor="green";
                            }
                            else if (sum != 100 && cost!=0 && nod!=0 && time!=0){
                                alert("Total weight % must be exactly 100");
                                document.getElementById('costfeedbackweight').style.borderColor="red";
                                document.getElementById('timefeedbackweight').style.borderColor="red";
                                document.getElementById('nodfeedbackweight').style.borderColor="red";
                            }
                            else
                            return 0;
                    }
                    function feedbackvalue() {
                        if (parseInt(document.getElementById('costfeedback').value)>100 || parseInt(document.getElementById('costfeedback').value)<0) {
                            document.getElementById('costfeedback').style.borderColor="red";
                            alert("Please enter value between 0 and 100");
                        }
                        else if(parseInt(document.getElementById('costfeedback').value)<100 && parseInt(document.getElementById('costfeedback').value)>0) 
                            document.getElementById('costfeedback').style.borderColor="green";
                        
                        if (parseInt(document.getElementById('timefeedback').value)>100 || parseInt(document.getElementById('timefeedback').value)<0) {
                            document.getElementById('timefeedback').style.borderColor="red";
                            alert("Please enter value between 0 and 100");
                        }
                        else if(parseInt(document.getElementById('timefeedback').value)<100 && parseInt(document.getElementById('timefeedback').value)>0) 
                            document.getElementById('timefeedback').style.borderColor="green";
                        
                        if (parseInt(document.getElementById('nodfeedback').value)> 100 || parseInt(document.getElementById('nodfeedback').value)<0) {
                            document.getElementById('nodfeedback').style.borderColor="red";
                            alert("Please enter value between 0 and 100");
                        }
                        else if(parseInt(document.getElementById('nodfeedback').value)<100 && parseInt(document.getElementById('nodfeedback').value)>0)
                            document.getElementById('nodfeedback').style.borderColor="green";                        
                    }
                  </script>
                  
                <form role="form">
                    <label for="sel1">Please Leave a Feedback based on your satisfaction of our Service, the total number of weight should be 100%</label>
                    <div class="input-group">
   
                     <div class="row"> 
                    <div class="col-xs-7">
                        <select class="form-control" id="costfeedbackweight" onchange="feedback()">
                       <option  value="0">Choose Cost Weight</option>
                       <script>for(i=0; i<=100; i=i+5) {
                           if(i==0) document.writeln("<option value='1'>1</option>"); 
                           else document.writeln("<option value='"+i+"'>"+i+"</option>"); }
                       </script>
                     </select>
                                           
                     </div>
                      
                         <div class="col-xs-5">  <input type="text" placeholder="Cost Value (0-100)" class="form-control" id="costfeedback"  onblur="feedbackvalue()"></div>
                     
                     
                      </div> 
                        
                     <div class="row"> 
                    <div class="col-xs-7">
                     <select class="form-control" id="timefeedbackweight" onchange="feedback()">
                       <option  value="0">Choose Time Weight</option>
                       <script>for(i=0; i<=100; i=i+5) {
                           if(i==0) document.writeln("<option value='1'>1</option>"); 
                           else document.writeln("<option value='"+i+"'>"+i+"</option>"); }
                       </script>
                     </select>
                                           
                     </div>
                      
                  <div class="col-xs-5">  <input type="text" placeholder="Time Value (0-100)" class="form-control" id="timefeedback" onblur="feedbackvalue()"></div>
                     
                     
                      </div>     
                        
                        
                     <div class="row"> 
                    <div class="col-xs-7">
                     <select class="form-control" id="nodfeedbackweight" onchange="feedback()">
                       <option  value="0">Choose Weight Number of Defects</option>
                       <script>for(i=0; i<=100; i=i+5) {
                           if(i==0) document.writeln("<option value='1'>1</option>"); 
                           else document.writeln("<option value='"+i+"'>"+i+"</option>"); }
                       </script>
                     </select>
                                           
                     </div>
                      
                  <div class="col-xs-5">  <input type="text" placeholder="NOD Value (0-100)" class="form-control" id="nodfeedback"  onblur="feedbackvalue()"></div>
                     
                     
                      </div>                          
                    <div class="row"> 
                    <div class="col-xs-12">
                        <input type="submit" value="Leave a Feedback" class="col-xs-12" name="feedbackbutton">
                                           
                     </div>
  
                      </div>           
                  </div>
                 </form>
 
 
                
                <% } else {%>
                    
                GPS Map Position of the vehicle:<br>
                
               
                <iframe src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyAoliW0rF36cTvpCZ_TzZyphrmQ_MYm_24&origin=<% out.print(element.getDeparture()); %>&destination=<% out.print(element.getArrival()); %>&waypoints=ottawa|44.222416, -77.143885" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>

                    <% }//iner loop 
                        out.println("</div><div class='modal-footer'>"); 
                        out.println("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"); 
                        out.println("</div></div></div></div>");  
                    };%>
                     
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
<!--
    <script>

        function initMap() { 
            
            var map = new google.maps.Map(document.getElementById('map'), {
              zoom: 12,
              center: {lat: 45.515675, lng: -73.675706},
              mapTypeId: 'terrain'
            });

            var gpsPositions = [
              {lat: 45.515675, lng: -73.675706},
              {lat: 45.512547, lng: -73.685405},
              {lat: 45.513652, lng: -73.687948},
              {lat: 45.517997, lng: -73.697422}

            ];
            var flightPath = new google.maps.Polyline({
              path: gpsPositions,
              geodesic: true,
              strokeColor: '#FF0000',
              strokeOpacity: 1.0,
              strokeWeight: 4
            });

            var DeparMarker = new google.maps.Marker ( {
                            position: new google.maps.LatLng(45.515675, -73.675706),
                            map: map,
                            title: 'Departure'
                    }
            );		

            var DestinMarker = new google.maps.Marker ( {
                            position: new google.maps.LatLng(45.517997, -73.697422),
                            map: map,
                            title: 'Destination'
                    } 
            );			 
    
            flightPath.setMap(map);
        }
	 
    </script>
        
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDjtVv6l5sx4Jl9gGjZWjE2q0HXLGit6KU&callback=initMap">
    </script>
 -->
</body>
</html>
