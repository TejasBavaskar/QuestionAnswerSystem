package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import service.AdminService;
import service.AdminServiceImpl;


/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       RequestDispatcher rd=null;
    
    public AdminLoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		HttpSession session=request.getSession();
		try
		
		{
			AdminService adminService=new AdminServiceImpl();
			 
			Admin admin=adminService.selectAdmin(email, password);
			if((admin.getEmail()!="" && admin.getPassword()!="") && (admin.getEmail()!=null && admin.getPassword()!=null))
			{
				session=request.getSession();
				session.setAttribute("uid", admin.getId());
				
				session.setAttribute("email", admin.getEmail());
				session.setAttribute("uname", admin.getUname());
				rd=request.getRequestDispatcher("adminHome.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("ErrMsg1", "Please enter valid email and password");
				rd=request.getRequestDispatcher("adminLogin.jsp");
				rd.forward(request, response);	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
