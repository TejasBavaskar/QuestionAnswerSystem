package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

/**
 * Servlet implementation class UserRegisterController
 */
@WebServlet("/UserRegisterController")
@MultipartConfig(maxFileSize=1024*1024*100)
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name=null;
	String email=null;
	String password=null;
	String mobileNo=null;
	
	InputStream profilePic=null;
	String profilePicName="";
	boolean flag;
	
	RequestDispatcher rd=null;
	
    public UserRegisterController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		name=request.getParameter("username");
		System.out.println(name);
		email=request.getParameter("useremail");
		password=request.getParameter("userpassword");
		mobileNo=request.getParameter("usermobile");
		
		 Part part=request.getPart("profilePic");
		 
		 if(part!=null)
		 {
			 profilePic=part.getInputStream();
			 System.out.println("Size is:"+profilePic.available());
			 profilePicName=extractFileName(part);
			 System.out.println("Name is:"+profilePicName);
			
		 }
		 
		 
		 User user=new User();
		 user.setName(name);
		 user.setEmail(email);
		 user.setPassword(password);
		 user.setMobileNo(mobileNo);		
		 user.setProfilePic(profilePic);
		 user.setProfilePicName(profilePicName);
		 user.setStatus("Inactive");
		 
		 UserService userService=new UserServiceImpl();
		 if(userService.isAlreadyAvailable(user))
		 {
			 
				System.out.println("mail id already registered");
				request.setAttribute("mailidexist", "Mail id already exist ");
				
				rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		 }
		 else
		 {
			 if(userService.registerUser(user))
			 {
				 
				 request.setAttribute("regsuccess", "You are registered successfully");
		
				 rd=request.getRequestDispatcher("userLogin.jsp");
				 rd.forward(request, response); 
			 }
			 else
			 {
				
				 	request.setAttribute("regfail", "Registration failed");
					rd=request.getRequestDispatcher("registeruser.jsp");
					rd.forward(request, response); 
				 } 
			 }
		 
	}

	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("contentDisp:"+contentDisp);
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
	
}
