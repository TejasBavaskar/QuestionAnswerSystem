package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class UserChangePassController
 */
@WebServlet("/UserChangePassController")
public class UserChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		String old_password=null;
		
		String confirm_password=null;
		String email;
    public UserChangePassController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		old_password=request.getParameter("old_password");
		confirm_password=request.getParameter("confirm_password");
		String new_password=request.getParameter("new_password");
		
		HttpSession session=request.getSession();
		email=(String)session.getAttribute("email");
		UserService userService=new UserServiceImpl();
		
		if(new_password.equals(confirm_password))
		{
			if(userService.userChangePassword(email, confirm_password, old_password))
			{    
				request.setAttribute("SucMsg", "Password Changed Successfully...");
				RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
				rd.include(request, response);
				
			}
			else
			{
				request.setAttribute("ErrMsg", "Password not Change...");
				RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
				rd.include(request, response);
						
			}
		}
		else
		{
			request.setAttribute("ErrMsg1", "New password not matched with confirm password...");
			RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
			rd.include(request, response);
		}
		
	}

}
