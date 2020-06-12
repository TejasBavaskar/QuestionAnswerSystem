<%@page import="service.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.*,java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>cQA System| All Answers</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="asset//bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="asset/bootstrap/font-awesome/4.1.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="asset/bootstrap/css/ionicons.min.css">    <!-- Theme style -->
    <link rel="stylesheet" href="asset/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="asset/dist/css/skins/_all-skins.min.css">
 <script language="javascript" type="text/javascript">
	
	function checkconfirmpass()
	{
		if((document.change.new_password.value)==(document.change.confirm_password.value))
			{
				return true;
			}
		else {
				alert("Your password is not matching with confirm password");
				document.change.confirm_password.value="";
				document.change.confirm_password.focus();
				return false;
	}
}
</script>
  
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
<%

	String userName=(String)session.getAttribute("userName");
	String email=(String)session.getAttribute("email");

	
%>
  
  
    <div class="wrapper">

      <header class="main-header">
        <!-- Logo -->
        <a href="timeline.jsp" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>Q</b>M</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg">cQA System</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
             
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  
                  <img src="profilePic.jsp?userEmail=<%=email%>" class="user-image" alt="User Image" >
                  <!-- <img src="asset/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> -->
                  
                  <span class="hidden-xs"><%=userName %></span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                   <img src="profilePic.jsp?userEmail=<%=email%>"  class="img-circle" alt="User Image">
                    <p>
                      <%=userName %> 
                      <!-- <small>Member since Dec 2016</small> -->
                    </p>
                  </li>
                  <!-- Menu Body -->
                  <li class="user-body">
                    <!-- <div class="col-xs-4 text-center">
                      <a href="#">User</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">History</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Log</a>
                    </div> -->
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="userprofile.jsp" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="index.jsp" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
               <img src="profilePic.jsp?userEmail=<%=email%>"  class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p><%=userName %></p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          
        
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview">
              <a href="homepage.jsp">
                <i class="fa fa-dashboard"></i> <span>Home</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              
            </li>
            <li>
              <a href="allAnswers.jsp">
                <i class="fa fa-th"></i> <span>All Answers</span>
              </a>
            </li>
            <li>
              <a href="askQuestion.jsp">
                <i class="fa fa-th"></i> <span>Ask Questions</span>
              </a>
            </li>
           <li>
              <a href="changePassword.jsp">
                <i class="fa fa-th"></i> <span>Change Password</span>
              </a>
            </li>       
            <li>
              <a href="changeProfilePic.jsp">
                <i class="fa fa-users"></i> <span>Change Profile Pic</span> 
              </a>
            </li>
             <li>
              <a href="recommandedQuestions.jsp">
                <i class="fa fa-users"></i> <span>Recommanded Questions</span> 
              </a>
            </li>
            
            <!--
             <li>
              <a href="searchanalysis.jsp">
                <i class="fa fa-envelope"></i> <span>Analysis Chart</span>
                
              </a>
            </li>
            <li>
              <a href="piechart.jsp">
                <i class="fa fa-envelope"></i> <span>Feedback Chart</span>
                
              </a>
            </li>  -->
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
         <!--  <h1>
          Optimization Ant Colony Algorithm
 		  <small>for Composition of Semantic Web Services</small>
          </h1> -->
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Search Home</a></li>
             
          </ol>
        </section>

        <!-- Main content -->
        <section class="col-lg-12 connectedSortable">
             <br><br>
              <div class="nav-tabs-custom">
                <!-- Tabs within a box -->
               <br>
                <center>
                <h3>Search Answers</h3>
                </center> 
               <form action="searchAnsController" method="post">    
            	<div class="input-group sidebar-form">
              	<input type="text" name="searchQuery" id="search_Query" class="form-control" placeholder="Search...">
              	<span class="input-group-btn btn btn-primary">
              	
                <button type="submit" name="search" id="btnsearch" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
              </div>  
                 <br/>
                <div class="box-footer clearfix">
               <center>
               <button class="pull-middle btn btn-primary" id="btnsearch" type="submit">Search <i class="fa fa-arrow-circle-right"></i></button>
               </center>
              <!--  <a href="#" class="pull-right btn btn-primary" >Result <i class="fa fa-arrow-circle-right"></i></a> -->  
                </div>
                </form>  
              </div><!-- /.nav-tabs-custom -->  
         </section>
              
         <div class="col-xs-12 col-sm-10 col-md-10" align="left">
		    <div class="login-panel panel panel-default">
				<!-- <div class="panel-heading" align="left" style="font-family: Cambria;font-size: 23px;">User Log In</div> -->
		     
		       <div class="panel-body"  runat="server" style="overflow-y: scroll; height: 600px">
				     <div class="mid-width wrapItems" style=" height:600px">
				     <div id="Test1" runat="server" width="100%"></div>
                    <div id="Test2" runat="server" width="100%"></div>
                    
            <div class="row">
           <!--  <div class="col-md-1"></div> -->
           <div class="col-md-12">
           <table class="table">
           <tr>
           <th><h4><b>Answers</b></h4></th>
           </tr>
          <% UserService userService=new UserServiceImpl();
 			  ResultSet rs=userService.selectQuestions();
 			   while(rs.next()){%>
                <tr>
                  <td>
                   <div class="col-sm-1">
                        <div class="pull-left image">
                         <img src="userProfilePic.jsp?u_email=<%=rs.getString(5) %>" class="img-circle" width="30px" height="30px" alt="User Image">
                       </div>
                   </div>
                   <div class="col-sm-11">
                        <a href="selectAnswer.jsp?q_id=<%=rs.getInt(1)%>&question=<%=rs.getString(3)%>&description=<%=rs.getString(4)%>&email=<%=rs.getString(5)%>"><b style="font-size: 20px;"><%=rs.getString(3)%>?</b></a><br>
                         <%=rs.getString(4)%><br><br>
                         <a href="addAnswer.jsp?q_id=<%=rs.getInt(1)%>">Add Answer</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <% ResultSet r=userService.answerCount(rs.getInt(1));
                         while(r.next()){%><%=r.getInt(1)%>  Answer<%}%>
                   </div>
                  </td>
               </tr>
             <%}%>
           </table>
           </div> </div> </div></div></div> 
           </div></div>
      </div><!-- /.content-wrapper -->

      <footer class="main-footer">
        <div class="pull-right hidden-xs"></div>
        <strong>Copyright &copy; 2017-2018 <a href="#">cQA System</a>.</strong> All rights reserved.
      </footer>

      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>  
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                    <p>Will be 23 on April 24th</p>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-user bg-yellow"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>
                    <p>New phone +1(800)555-1234</p>
                  </div>
                </a>
              </li>  
            </ul><!-- /.control-sidebar-menu -->
          </div><!-- /.tab-pane -->
          <!-- Stats tab content -->
        
        </div>
        <div  id="getCodeModal" class="modal" role="dialog">
  			<div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body" id="getCode"> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</aside><!-- /.control-sidebar -->
 <!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
<div class="control-sidebar-bg"></div>
    </div><!-- ./wrapper -->

    <!-- jQuery 2.1.4 -->
    <script src="asset/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="asset/bootstrap/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="asset/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="asset/dist/js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="asset/dist/js/demo.js"></script>
    <script src="asset/js/bootbox.min.js"></script>   
  </body>
</html>
