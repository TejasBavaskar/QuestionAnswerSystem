package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

/**
 * Servlet implementation class askQuestionController
 */
@WebServlet("/askQuestionController")
public class askQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public askQuestionController() {
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
		String q_type=request.getParameter("q_type");
		String description=request.getParameter("description");
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String currentDate=dateFormat.format(date);
				
		User user=new User();
		user.setEmail(email);
		user.setQuestion(question);
		user.setDate(currentDate);
		user.setQ_type(q_type);
		user.setDescription(description);
		UserService userService=new UserServiceImpl();
		if(userService.createQuestion(user))
		{
			request.setAttribute("SucMsg", "Question added Successfully...");
			request.getRequestDispatcher("askQuestion.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("ErrMsg", "Question not added Successfully...");
			request.getRequestDispatcher("askQuestion.jsp").forward(request, response);
		}
		
	}

}
