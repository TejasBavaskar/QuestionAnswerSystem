package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String email=null;
       String password=null;
       HttpSession session=null;
   	   RequestDispatcher rd=null;
    
    public UserLoginController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		email=request.getParameter("useremail");
		password=request.getParameter("userpassword");
		System.out.println(email);
		System.out.println(password);
		
       /* Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time1=sdf.format(cal.getTimeInMillis());
        String time=sdf.format(cal.getTime());
        
        System.out.println("Current system time is:"+time);
        System.out.println("Current system time in milliseconds:"+time1);*/
		
		
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		UserService userService=new UserServiceImpl();
		try
		
		{
			System.out.println("hiiiii......");
			HttpSession session=request.getSession();
			ResultSet rs=userService.loginUser(user);
			
			if(rs.next())
			{
				System.out.println("welcome user.....");
				
				if(rs.getString(8).equalsIgnoreCase("Active")){
					
				session=request.getSession();
				session.setAttribute("email",rs.getString(3));
				session.setAttribute("userName", rs.getString(2));
				System.out.println("Login successfully");
				/*rd=request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);*/
				 response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Login Done...!!!');");
					out.println("location='homepage.jsp';");
					out.println("</script>");
				}
				else
				{
					/*request.setAttribute("ErrMsg", "You are not Authenticate User....Wait for Authentication..!!");
					rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);*/	
					 response.setContentType("text/html");  
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('You are not Authenticate User....Wait for Authentication..!!');");
						out.println("location='userLogin.jsp';");
						out.println("</script>");
				}
				
				
			}
				
			else
			{
				/*request.setAttribute("ErrMsg", "Invalid User Name or Password");
				rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);	*/
				 response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Sorry, Invalid User Name or Password...!!!');");
					out.println("location='userLogin.jsp';");
					out.println("</script>");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
