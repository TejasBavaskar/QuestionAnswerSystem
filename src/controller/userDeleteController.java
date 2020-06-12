package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.AdminServiceImpl;

/**
 * Servlet implementation class userDeleteController
 */
@WebServlet("/userDeleteController")
public class userDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int u_id=Integer.parseInt(request.getParameter("u_id"));
         AdminService adminService=new AdminServiceImpl();
         if(adminService.deleteUser(u_id))
         {
        	 System.out.println("Doctor delete successfully...");
        	 request.getRequestDispatcher("adminDeleteUser.jsp").forward(request, response);
         }
         else
         {
        	 System.out.println("Doctor delete successfully...");
        	 request.getRequestDispatcher("adminDeleteUser.jsp").forward(request, response);
         }
	}

}
