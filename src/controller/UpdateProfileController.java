package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

/**
 * Servlet implementation class UpdateProfileController
 */
@WebServlet("/UpdateProfileController")
@MultipartConfig(maxFileSize=1024*1024*50)

public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name=null;
	String email=null;
	String password=null;
	String mobileNo=null;
	
	boolean flag;
	RequestDispatcher rd=null;
    
    public UpdateProfileController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name=request.getParameter("username");
		System.out.println("name : "+name);
		email=request.getParameter("useremail");
		
		password=request.getParameter("userpassword");
		mobileNo=request.getParameter("usermobile");
		System.out.println("email : "+email);
		System.out.println("password : "+password);
		System.out.println("mobileNo : "+mobileNo);
		
		 User user=new User();
		 user.setName(name);
		 user.setEmail(email);
		 user.setPassword(password);
		 user.setMobileNo(mobileNo);
			
		 UserService userService=new UserServiceImpl();	
		 
	     if(userService.updateUserProfile(user))
		 {			
				 request.setAttribute("SuccMsg", "Profile updated successfully...");		
				 rd=request.getRequestDispatcher("userprofile.jsp");
				 rd.forward(request, response); 
		 }
	     else
	     {
		    	 request.setAttribute("ErrMsg", "Profile not updated...");		
				 rd=request.getRequestDispatcher("userprofile.jsp");
				 rd.forward(request, response); 
	     }
		
	}

}
