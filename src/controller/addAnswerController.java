package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 * Servlet implementation class addAnswerController
 */
@WebServlet("/addAnswerController")
public class addAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAnswerController() {
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
		int q_id=Integer.parseInt(request.getParameter("q_id"));
		String q_type=request.getParameter("q_type");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		HttpSession session=request.getSession();
		String user_email=(String)session.getAttribute("email");
		
		
		//current systen data
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String currentDate=dateFormat.format(date);
		
		//current system time
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currenTime=sdf.format(cal.getTime());
		
		User user=new User();
		user.setQ_id(q_id);
		user.setQ_type(q_type);
		user.setQuestion(question);
		user.setAnswer(answer);
		user.setEmail(user_email);
		user.setAns_date(currentDate);
		user.setAns_time(currenTime);
		
		UserService userService=new UserServiceImpl();
		if(userService.addAnswer(user))
		{
			System.out.println("Answer added successfully...");
			request.getRequestDispatcher("allAnswers.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Answer not added...Try again..");
			request.getRequestDispatcher("allAnswers.jsp").forward(request, response);
		}
		
	}

}
