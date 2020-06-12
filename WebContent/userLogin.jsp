<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ant Colony  | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="asset/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="asset/bootstrap/font-awesome/4.1.0/css/font-awesome.min.css">
    <!-- Icon icons -->
    <link rel="stylesheet" href="asset/bootstrap/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="asset/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="asset/plugins/iCheck/square/blue.css">

    
  </head>
  <body class="hold-transition skin-blue-light login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="index.jsp" style="font-family: Cambria;color: blue;">Optimization Ant Colony Algorithm</a>
        <br>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg" style="font-family: Cambria;font-size: 27px;">Sign In</p>
      

        
     
        <form  action="UserLoginController" method="post">
        
     
          <div class="form-group has-feedback">
            <input type="email" name="useremail" id="useremail" class="form-control" placeholder="Email"
            pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" title="Enter valid email id" required="required"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          
          <div class="form-group has-feedback">
            <input type="password" name="userpassword" id="userpassword"  class="form-control" placeholder="Password"
            pattern="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$" title="Password must contain 6 characters.In that at least 1 uppercase,1 lowercase,1 special symbol(!,@,#,$,%,^,&,*) and 1 number"
		    required="required"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          
                             <%
         							String msg = (String)request.getAttribute("ErrMsg");
         							if(msg != null){  		
         
        					 %>
                      			<p style="color:red"><%=msg %></p>
        					 <%} %>                             
          
                            <%
         						String msg1 = (String)request.getAttribute("regsuccess");
         						if(msg1 != null){  		
         
        					 %>
                   		  	 <p style="color:red"><%=msg1 %></p>
         					<%} %>
         					
          
         					<%
         						String msg2 = (String)request.getAttribute("mailidexist");
         						if(msg2 != null){  		
         
        					 %>
                   		     <p style="color:red"><%=msg2 %></p>
         					<%} %>
         					
         					
          
          
          <div class="form-group has-feedback">
            <button type="submit" id="btnuserlogin" class="btn btn-primary btn-block btn-flat">Sign In</button>
            <span class="form-control-feedback"></span>
          </div>
          
           <div class="box-footer clearfix">
                   <a href="registeruser.jsp" class="text-center pull-left">Register Here</a><a href="forgotpassword.jsp" class="text-center pull-right">I forgot my Password</a>
                </div>
        </form>
     

       
       

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="asset/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="asset/bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    
     </body>
    <script type="text/javascript" src="bootstrapvalidator/vendor/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrapvalidator/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrapvalidator/dist/js/formValidation.js"></script>
	<script type="text/javascript" src="bootstrapvalidator/dist/js/framework/bootstrap.js"></script>
<!-- 	<script type="text/javascript">
		$(document)	.ready(	function() {
						$('#userlogin')
								.formValidation(
										{
											message : 'This value is not valid',
											icon : {
												valid : 'fa fa-ok fa-fw',
												invalid : 'fa fa-remove fa-fw',
												validating : 'fa fa-refresh fa-fws'
											},
											fields : {
												
												userpassword : {
													validators : {
														notEmpty : {
															message : 'The password is required and can\'t be empty'
														}
													}
												},

												useremail : {
													validators : {
														notEmpty : {
															message : 'The email address is required'
														},
														emailAddress : {
															message : 'The input is not a valid email address'
														}
													}
												},

											}
										});
					});
</script>
 -->
     
</html>
 --%>
 
 
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INQUISITOR  | User Log in</title>
<link href="Admin/css/bootstrap.min.css" rel="stylesheet">
<link href="Admin/css/datepicker3.css" rel="stylesheet">
<link href="Admin/css/styles.css" rel="stylesheet">

<!--Icons-->
<script src="Admin/js/lumino.glyphs.js"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"  style="font-family: Cambria;font-size: 23px;padding-left: 450px;"><span>INQUISITOR  </span>For Programming Languages</a>
				<!-- <ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> admin <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
							<li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
							<li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul>
					</li>
				</ul> -->
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<!-- <input type="text" class="form-control" placeholder="Search"> -->
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="index1.jsp"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Home</a></li>
			<li class="active"><a href="userLogin.jsp"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>User Login</a></li>
			<li><a href="adminLogin.jsp"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>Admin Login</a></li>
			
			
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">User</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			
	<!--/.row-->
		
		<br>
		<div class="row" style="padding-left: 270px;">
		<!-- <div class="col-xs-5 col-sm-4 col-md-2 col-md-offset-2" align="right">
		<img alt="Sign-In" src="Images/admin.jpg">
		</div> -->
		<div class="col-xs-10 col-sm-8 col-md-5 col-md-offset-1">
			<div class="login-panel panel panel-default">
				<div class="panel-heading" align="center" style="font-family: Cambria;font-size: 23px;">User Log In</div>
				<div class="panel-body">
					<form role="form"  action="UserLoginController" method="post">
						<fieldset>
							<div class="form-group">
							<!-- 	<input class="form-control" placeholder="E-mail" name="email" type="email" autofocus=""> -->
							
								 <input type="email" size="100" name="useremail" id="useremail" class="form-control" placeholder="Email Id"
           						 pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" title="Enter valid email id" required="required"/>          			 
            
							</div>
							
							<div class="form-group">
								 <input type="password" size="100" name="userpassword" id="userpassword"  class="form-control" placeholder="Password"
          						 pattern="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$" title="Password must contain 6 characters.In that at least 1 uppercase,1 lowercase,1 special symbol(!,@,#,$,%,^,&,*) and 1 number"
		    					 required="required"/>	
							</div>
							
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">Remember Me
								</label>
							</div>
							 
 							 <%
         							String msg = (String)request.getAttribute("ErrMsg");
         							if(msg != null){  		
         
        					 %>
                      			<p style="color:red"><%=msg %></p>
        					<%} %>                             
          
                            <%
         						String msg1 = (String)request.getAttribute("regsuccess");
         						if(msg1 != null){  		
         
        					 %>
                   		  	 <p style="color:red"><%=msg1 %></p>
         					<%} %>
         					
          
         					<%
         						String msg2 = (String)request.getAttribute("mailidexist");
         						if(msg2 != null){  		
         
        					 %>
                   		     <p style="color:red"><%=msg2 %></p>
         					<%} %>
         												
							
							
							
							<button type="submit" class="btn btn-primary">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-primary">Reset</button>
							<br><br>
							 <a href="registeruser.jsp" class="text-center pull-left">Register Here</a>
							
							 
							 <a href="forgotpassword.jsp" class="text-center pull-right">I forgot my Password</a>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
		
	</div><!-- /.row -->	
	
								
		
	</div>	<!--/.main-->

	<script src="Admin/js/jquery-1.11.1.min.js"></script>
	<script src="Admin/js/bootstrap.min.js"></script>
	<script src="Admin/js/chart.min.js"></script>
	<script src="Admin/js/chart-data.js"></script>
	<script src="Admin/js/easypiechart.js"></script>
	<script src="Admin/js/easypiechart-data.js"></script>
	<script src="Admin/js/bootstrap-datepicker.js"></script>
	<script>
		$('#calendar').datepicker({
		});

		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 