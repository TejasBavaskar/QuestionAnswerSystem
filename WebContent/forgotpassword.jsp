<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ant Colony | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="asset/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="asset/bootstrap/font-awesome/4.1.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="asset/bootstrap/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="asset/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="asset/plugins/iCheck/square/blue.css">

    
  </head>
  <body class="hold-transition login-page">
       <br><br><br><br><br>
    <div class="login-box">
      <div class="login-logo">
     
      </div><!-- /.login-logo -->
      <div class="login-box-body">
      
      
 
        <p class="login-box-msg" style="font-family: Cambria;font-size: 27px;">Forgot Password</p>

        <form  action="UserForgotPassController" method="post">
        
       
          <div class="form-group has-feedback">
            <input type="email" name="useremail" id="useremail" class="form-control" placeholder="Email"
             pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" title="Enter valid email id" required="required"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          
          
                   			 <%
         						String msg = (String)request.getAttribute("sendPass");
         						if(msg != null){  		
         
        					 %>
                   		     <p style="color:red"><%=msg %></p>
         					<%} %>
          
                   			 <%
         						String msg1 = (String)request.getAttribute("notsend");
         						if(msg1 != null){  		
         
        					 %>
                   		     <p style="color:red"><%=msg1 %></p>
         					<%} %>          
          
          
          <div class="form-group has-feedback">
            <button type="submit" id="btnuserlogin" class="btn btn-primary btn-block btn-flat">Submit</button>
            <span class="form-control-feedback"></span>
          </div>
          
          <div class="box-footer clearfix">
                   <a href="registeruser.jsp" class="text-center pull-left">Register New Membership</a>
                   <a href="userLogin.jsp" class="text-center pull-right">Back to Login</a>
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

</html>
