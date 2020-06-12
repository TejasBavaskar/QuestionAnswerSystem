package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.AdminServiceImpl;

/**
 * Servlet implementation class authenticateController
 */
@WebServlet("/authenticateController")
public class authenticateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticateController() {
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
	RequestDispatcher rd=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int u_id=Integer.parseInt(request.getParameter("u_id"));
		String status=request.getParameter("status");
		
		
		AdminService adminService=new AdminServiceImpl();
		if(adminService.authenticateUser(u_id,status))
		{
			request.getRequestDispatcher("authenticateUser.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("authenticateUser.jsp").forward(request, response);
		}
		
	}

}
