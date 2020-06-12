<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INQUISITOR  | Admin Log in</title>
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
				<a class="navbar-brand" href="#"  style="font-family: Cambria;font-size: 23px;padding-left: 450px;"><span>INQUISITOR </span>For Programming Languages</a>
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
			<li><a href="userLogin.jsp"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>User Login</a></li>
			<li class="active"><a href="adminLogin.jsp"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>Admin Login</a></li>
			
			
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Admin</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			
	<!--/.row-->
		<div align="center">
	
		</div>
		<div class="row">
		<div class="col-xs-5 col-sm-4 col-md-2 col-md-offset-2" align="right">
		<img alt="Sign-In" src="Images\admin.jpg">
		</div>
		<div class="col-xs-10 col-sm-8 col-md-5 col-md-offset-1">
			<div class="login-panel panel panel-default">
				<div class="panel-heading" align="center" style="font-family: Cambria;font-size: 23px;">Admin Log In</div>
				<div class="panel-body">
					<form role="form"  action="AdminLoginController" method="post">
						<fieldset>
						
							<div class="form-group">					
							
								 <input type="email" name="email" id="useremail" class="form-control" placeholder="Email Id"
           						 pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" title="Enter valid email id" required="required"/>          			 
            
							</div>
							
							<div class="form-group">
								 <input type="password" name="password" id="userpassword"  class="form-control" placeholder="Password"
          						 pattern="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$" title="Password must contain 6 characters.In that at least 1 uppercase,1 lowercase,1 special symbol(!,@,#,$,%,^,&,*) and 1 number"
		    					 required="required"/>	
							</div>
							
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">Remember Me
								</label>
							</div>
							
	   <%
			String errMsg = (String)request.getAttribute("ErrMsg1");
			if(errMsg!=null && errMsg!=""){
		%>
				<p style="color:red"><%=errMsg %></p>
		<%
			}
		%>			
														
							<button type="submit" class="btn btn-primary">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-primary">Reset</button>
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
