<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>cQA System| Registration</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="asset/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="asset/bootstrap/css/font-awesome/4.1.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="asset/bootstrap/css/ionicons.min.css">


<!-- Select2 -->
<link rel="stylesheet" href="asset/plugins/select2/select2.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="asset/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="asset/dist/css/skins/_all-skins.min.css">
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<!-- <div class="register-logo">
			 <a href="index.jsp" style="font-family: Cambria;color: blue;">Optimization Ant Colony Algorithm</a>
		</div> -->

		<div class="register-box-body">
			<p class="login-box-msg" style="font-family: Cambria;font-size: 27px;">Registration</p>
			
			<%-- <%
				if(request.getAttribute("responsemessage")!=null)
				{
					
			%>
				<div class="alert alert-danger">

					<a href="#" class="close" data-dismiss="alert">&times;</a>
												
					<%out.println(request.getAttribute("responsemessage")); %>
				</div>
			<%	
				}
												
			%> --%>
			
			<form action="UserRegisterController" method="post" enctype="multipart/form-data">
				
				
				<div class="form-group has-feedback">
					<input type="text" id="username" name="username" 
						class="form-control" placeholder="Enter User Name"/> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<input type="email" id="useremail" name="useremail" pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" 
					title="Enter valid email id" required="required"
						class="form-control" placeholder="Enter your Email"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<input type="password" id="userpassword" name="userpassword" pattern="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$" 
					title="Password must contain 6 characters.In that at least 1 uppercase,1 lowercase,1 special symbol(!,@,#,$,%,^,&,*) and 1 number"
					 required="required"
						class="form-control" placeholder="Enter your Password"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				
				<div class="form-group has-feedback">
					<input type="text" id="usermobile" name="usermobile" pattern="([7-9]{1}[0-9]{9})" 
					title="Enter valid mobile no" required="required"
						class="form-control" placeholder="Enter your Mobile Number"> <span
						class="glyphicon glyphicon-phone form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					Upload ProfilePic <input type="file"  name="profilePic" >
				</div>
				
      							 <%
         							String msg2 = (String)request.getAttribute("regfail");
         							if(msg2 != null){  		
       	  
       							  %>
                     			 <p style="color:red"><%=msg2 %></p>
         						<%} %>
         						
				<div class="form-group has-feedback">
          <button type="submit" class="btn  btn-primary btn-block btn-flat">Register</button>
            
          </div>
				
		   <div class="box-footer clearfix">
                  <a href="userLogin.jsp" class="text-center">I already have a Membership</a>
           </div>
			</form>



			
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery 2.1.4 -->
	<script src="asset/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="asset/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- SlimScroll 1.3.0 -->
	<script src="asset/plugins/slimScroll/jquery.slimscroll.min.js"></script>

	<!-- FastClick -->
	<script src="asset/plugins/fastclick/fastclick.min.js"></script>
	<!-- AdminLTE App -->
	<script src="asset/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="asset/dist/js/demo.js"></script>
	<!-- Page script -->
	
	<script type="text/javascript" src="bootstrapvalidator/vendor/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrapvalidator/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrapvalidator/dist/js/formValidation.js"></script>
	<script type="text/javascript" src="bootstrapvalidator/dist/js/framework/bootstrap.js"></script>

<!-- 	<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#registrationform')
								.formValidation(
										{
											message : 'This value is not valid',
											icon : {
												valid : 'fa fa-ok fw',
												invalid : 'fa fa-remove fw',
												validating : 'fa fa-refresh fw'
											},
											fields : {

												username : {
													message : 'The Username is not valid',
													validators : {
														notEmpty : {
															message : 'The Username is required and can\'t be empty'
														},
														stringLength : {
															min : 2,
															max : 30,
															message : 'The Username must be more than 6 and less than 30 characters long'
														}
													}
												},

												userpassword : {
													validators : {
														notEmpty : {
															message : 'The Password is required and can\'t be empty'
														}
													}
												},
											
												useremail : {
													validators : {
														notEmpty : {
															message : 'The Email address is required'
														},
														emailAddress : {
															message : 'The Input is not a valid email address'
														}
													}
												},												
																		
												usermobile : {
													message : 'The Mobile Number is not valid',
													validators : {
														notEmpty : {
															message : 'The Mobile number is required and can\'t be empty'
														},
														stringLength : {
															min : 10,
															max : 10,
															message : 'The Mobile number must be more  10 digit long'
														},
														regexp : {
															regexp : /^[0-9\.]+$/,
															message : 'The Mobile number can only  number '
														}
													}
												},
												
												userprofession : {
													validators : {
														notEmpty : {
															message : 'Profession is required and can\'t be empty'
														}
													}
												},												
																							
											}
										});

						$("#cancel").on("click", function() { // or $("button[type='reset']").on(...)
							$("registerForm").data('bootstrapValidator').resetForm();
						});
					});
</script> -->
<!-- Select2 -->
	<script src="asset/plugins/select2/select2.full.min.js"></script>

	<script>
		$(function() {
			//Initialize Select2 Elements
			$(".select2").select2();

		});
	</script>
	
</body>
</html>
