package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;
import mailUtils.RecommandAns;

/**
 * Servlet implementation class recommandAnsController
 */
@WebServlet("/recommandAnsController")
public class recommandAnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recommandAnsController() {
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
		String question=request.getParameter("question");
		  String description=request.getParameter("description");
	      String u_email=request.getParameter("u_email");
		int q_id=Integer.parseInt(request.getParameter("q_id"));
		int ans_id=Integer.parseInt(request.getParameter("ans_id"));
		String email=request.getParameter("email");
		String emailToRecommand=request.getParameter("emailToRecommand");
		try{
		if(emailToRecommand!=null)
		{
			UserService userService=new UserServiceImpl();
			ResultSet rs=userService.BestAnswers(ans_id);
			while(rs.next())
			{
				String answer=rs.getString(5);
			    RecommandAns recommandAns=new RecommandAns();
			    recommandAns.sendOnMail(emailToRecommand, question, description, answer);
			    
			    request.setAttribute("Msg", "Recommandation Done Successfully...");
				request.setAttribute("question", question);
				request.setAttribute("description", description);
				request.setAttribute("u_email", u_email);
				request.setAttribute("q_id", q_id);
				request.setAttribute("ans_id", ans_id);
				
				request.getRequestDispatcher("recommandAns1.jsp").forward(request, response);
				
			    
			}
		}
		else
		{
			request.setAttribute("Msg", "Please,Enter valid Id");
			request.setAttribute("question", question);
			request.setAttribute("description", description);
			request.setAttribute("u_email", u_email);
			request.setAttribute("q_id", q_id);
			request.setAttribute("ans_id", ans_id);
			
			request.getRequestDispatcher("recommandAns1.jsp").forward(request, response);
			
			
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
