package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

/**
 * Servlet implementation class likeController
 */
@WebServlet("/likeController")
public class likeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likeController() {
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
	    int q_id=Integer.parseInt(request.getParameter("q_id"));
	    /*String question=request.getParameter("question");
		String description=request.getParameter("description");*/
	    int ans_id=Integer.parseInt(request.getParameter("ans_id"));
	    int like=Integer.parseInt(request.getParameter("like"));
	    String u_email=request.getParameter("user_email");
	    
	    
	    
	    User user=new User();
	    user.setQ_id(q_id);
	    user.setAns_id(ans_id);
	    user.setEmail(u_email);
	    user.setLike(like);
	    
	    UserService userService=new UserServiceImpl();
	    if(userService.isAlreadyLike(u_email,ans_id))
	    {
	    	System.out.println("Already Like..");
	    	request.getRequestDispatcher("selectAnswer.jsp").forward(request, response);
	    }
	    else
	    {
	    	if(userService.addLike(user))
	    	{
	    		System.out.println(" Like  added successfully..");
	    		request.getRequestDispatcher("selectAnswer.jsp").forward(request, response);
	    	}
	    	else
	    	{
	    		System.out.println(" Like not added...");
	    		request.getRequestDispatcher("selectAnswer.jsp").forward(request, response);
	    	}
	    }
	    
	}

}
