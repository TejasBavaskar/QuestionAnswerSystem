package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

/**
 * Servlet implementation class addCommentController
 */
@WebServlet("/addCommentController")
public class addCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCommentController() {
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
		// TODO Auto-generated method stub
		
		String question=request.getParameter("question");
		  String description=request.getParameter("description");
	      String u_email=request.getParameter("u_email");
	      System.out.println("addCommController question :"+question);
	      System.out.println("addCommController description :"+description);
	      System.out.println("addCommController u_email :"+u_email);
		
		int q_id=Integer.parseInt(request.getParameter("q_id"));
		int ans_id=Integer.parseInt(request.getParameter("ans_id"));
		String email=request.getParameter("email");
		String comment=request.getParameter("comment");
		
		User user=new User();
		user.setQ_id(q_id);
		user.setAns_id(ans_id);
		user.setEmail(email);
		user.setComment(comment);
		
		UserService userService=new UserServiceImpl();
		if(userService.addComment(user))
		{ 
			System.out.println("Comment added successfully..");
			request.setAttribute("question", question);
			request.setAttribute("description", description);
			request.setAttribute("u_email", u_email);
			request.setAttribute("q_id", q_id);
			  
			  
			request.getRequestDispatcher("comment1.jsp").forward(request, response);
		}
		else
		{ 
			 System.out.println("Comment not added successfully..");
			 request.setAttribute("q_id", q_id);
			 request.setAttribute("question", question);
				request.setAttribute("description", description);
				request.setAttribute("u_email", u_email);
			request.getRequestDispatcher("comment1.jsp").forward(request, response);
		}
		
	}

}
