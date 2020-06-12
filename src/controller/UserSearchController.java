package controller;

import java.io.IOException;
import java.sql.ResultSet;

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
 * Servlet implementation class UserSearchController
 */
@WebServlet("/UserSearchController")
public class UserSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public UserSearchController() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery=request.getParameter("searchQuery");
		System.out.println("searchQuery : "+searchQuery);
		
		String[] searchQ=searchQuery.split(" ");
				
		String cityName=searchQ[searchQ.length-1];
		System.out.println("cityName : "+cityName);
		
		UserService userService=new UserServiceImpl();
		
		ResultSet rs=userService.getWSLinks();
		if(rs!=null)
		{
			System.out.println("webservices found....");
			request.setAttribute("cityName", cityName);
			request.setAttribute("result", rs);
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			System.out.println("webservices not found....");
		}
	}

}
