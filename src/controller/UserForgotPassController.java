package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mailUtils.ForgotPassword;

import bean.User;
import service.UserService;
import service.UserServiceImpl;



/**
 * Servlet implementation class UserForgotPassController
 */
@WebServlet("/UserForgotPassController")
public class UserForgotPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String email=null;
    
    public UserForgotPassController() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email=request.getParameter("useremail");
		User user=new User();
		user.setEmail(email);
		System.out.println(email);
	
	
		try {
			
			UserService userService=new UserServiceImpl();
			ResultSet rs=userService.userForgotPass(user);
			System.out.println("welcome");
		
			if(rs.next()){
					String password=rs.getString(4);
					ForgotPassword forgotPass=new ForgotPassword();
					forgotPass.sendOnMail(email,password);
					request.setAttribute("sendPass", "Your password is sent successfully");
					System.out.println("Your password is sent successfully!...");
					RequestDispatcher rd=request.getRequestDispatcher("forgotpassword.jsp");
					rd.forward(request, response);
					
				}else{
					
					request.setAttribute("notsend", "Please enter valid email id");
					System.out.println("Your password is not sent");
					RequestDispatcher rd=request.getRequestDispatcher("forgotpassword.jsp");
					rd.forward(request, response);

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
