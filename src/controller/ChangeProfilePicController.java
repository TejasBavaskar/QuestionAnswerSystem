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
 * Servlet implementation class ChangeProfilePicController
 */
@WebServlet("/ChangeProfilePicController")
@MultipartConfig(maxFileSize=1024*1024*50)

public class ChangeProfilePicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream profilePic=null;
	String profilePicName="";
	RequestDispatcher rd=null;
	
    public ChangeProfilePicController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email1=(String)session.getAttribute("email"); 
		
		Part part=request.getPart("profilePic");
		 
		 if(part!=null)
		 {
			 profilePic=part.getInputStream();
			 System.out.println("Size is:"+profilePic.available());
			 profilePicName=extractFileName(part);
			 System.out.println("Name is:"+profilePicName);
			
		 }
		 
		 User user=new User();
		 user.setProfilePic(profilePic);
		 user.setProfilePicName(profilePicName);
		 user.setEmail(email1);
		 
		 UserService userService=new UserServiceImpl();	
		 
	     if(userService.changeProfilePic(user))
		 {
	    	 
			 request.setAttribute("SuccMsg", "Profile pic changed successfully...");
				
			 rd=request.getRequestDispatcher("changeProfilePic.jsp");
			 rd.forward(request, response); 
		 }
		 else
		 {
			 request.setAttribute("ErrMsg", "Profile pic not change...");
			 rd=request.getRequestDispatcher("changeProfilePic.jsp");
			 rd.forward(request, response); 
			 
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
