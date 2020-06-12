package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.UserServiceImpl;
import algorithms.BayesClassifier;
import algorithms.Classifier;
import algorithms.StopWordRemoval;
import algorithms.StringSimilarity;

/**
 * Servlet implementation class searchAnsController
 */
@WebServlet("/searchAnsController")
public class searchAnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchAnsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet()is used when small amount of data and insensitive data like a query has to be sent as a request.
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost called in response to an HTTP POST request
		PrintWriter out=response.getWriter();
		// TODO Auto-generated method stub
		try{
			HttpSession session=request.getSession();
			String user_email=(String)session.getAttribute("email");
		    String searchQuery=request.getParameter("searchQuery");
		    
		    UserService userService=new UserServiceImpl();
		    
		    if(userService.addHistory(searchQuery,user_email))
		    {
		  
		    	int counter = 1;
		        for (int i=0;i<=searchQuery.length()-1;i++) // to find number of spaces in searched query
		        {
		            if (searchQuery.charAt(i) == ' ' && searchQuery.charAt(i+1)!=' ')
		            {
		                counter++;
		            }
		        }
		        String stopWordRemoveStr = searchQuery;
		        while(counter>0)
				{
				
		        	stopWordRemoveStr=StopWordRemoval.stopWordRemoval(stopWordRemoveStr);	
					counter--;
				}
		
		System.out.println("Search query after removing stopword:"+stopWordRemoveStr);
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		ArrayList<Integer> al_AnsID=new ArrayList<Integer>();
		ArrayList<Integer> AnsID=new ArrayList<Integer>();
		ArrayList<Integer> bestAnsId_al=new ArrayList<Integer>();
		ArrayList<Integer> tot_count=new ArrayList<Integer>();
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		Map<Integer,Integer> BstAnsCount=new HashMap<Integer, Integer>();
		
		ResultSet rs=userService.getAllQuestion();
		while(rs.next())
		{
			int q_id=rs.getInt(1);
			String question=rs.getString(3).trim(); //eliminates leading and trailing spaces
			//System.out.println("First question before stop wrd:"  + question);
			
			
		//-----------------------	
			
			
			 int count = 1;
		        for (int i=0;i<=question.length()-1;i++)
		        {
		            if (question.charAt(i) == ' ' && question.charAt(i+1)!=' ')
		            {
		                count++;
		            }
		        }
		        
			
		        String stopWordRemoveQue = question;
			
			while(count>0)
			{
			
				
				stopWordRemoveQue=StopWordRemoval.stopWordRemoval(stopWordRemoveQue);
			
				count--;
			}
			
			
			
	   //----------------------------------------------		
			
			System.out.println("Question after removing stopword:"+stopWordRemoveQue);
			String matchStr=StringSimilarity.printSimilarity(stopWordRemoveStr, stopWordRemoveQue);
			System.out.println("matchStr:"+matchStr);
			double match=Double.parseDouble(matchStr);
			if(match>=0.700)
			{
				al.add(q_id);
			}
			
		}
		System.out.println("Matched question id:"+al);
		
		//------------------------------------------------
		
        final Classifier<String, String> bayes =new BayesClassifier<String, String>();
        
        //Read positive word file
        Scanner sc = new Scanner(new File("F:/CQA_Project_Workspace1/System_cQA/WebContent/Files/Positive.txt"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
          lines.add(sc.nextLine());
        }
        final String[] positiveText = lines.toArray(new String[0]); // array of string containing positive words
     //   System.out.println("positive text:" + positiveText[0] );
        bayes.learn("positive", Arrays.asList(positiveText)); // (category, feature)
        
        //Read Negative word file
        Scanner sc1 = new Scanner(new File("F:/CQA_Project_Workspace1/System_cQA/WebContent/Files/Negative.txt"));
        List<String> lines1 = new ArrayList<String>();
        while (sc1.hasNextLine()) {
          lines1.add(sc1.nextLine());
        }

        final String[] negativeText = lines1.toArray(new String[0]);
        /*for(int i=0;i<negativeText.length;i++)
        {
        	System.out.println(negativeText[i]);
        }*/
        bayes.learn("negative", Arrays.asList(negativeText));
		
		for(int q_id: al)
		{
			ResultSet r=userService.getAnsId(q_id);
			while(r.next())
			{
				
				al_AnsID.add(r.getInt(1));
			}
			System.out.println("AnsID of question "+q_id+":"+al_AnsID);
		
		for(int ans_id: al_AnsID)
		{
	
			ResultSet rr=userService.getComment(ans_id);
			while(rr.next())
			{
				
			 final String[] comment = rr.getString(4).split("\\s");
			 String category=bayes.classify(Arrays.asList(comment)).getCategory();
			 System.out.println("For"+ans_id+":"+category);
			 if(category.equalsIgnoreCase("Positive"))
			 {
				 AnsID.add(ans_id);
			 }
			}		
		}
		
		
		/*AnsID.clear();*/
		al_AnsID.clear();
		
		}
		System.out.println("Positive ans:"+AnsID);
		
		//Count all with frequency
		Set<Integer> uniqueAnsSet = new HashSet<Integer>(AnsID);
		for (int a_id : uniqueAnsSet) {
			map.put(a_id, Collections.frequency(AnsID, a_id));
		}
		System.out.println("AnsId with positiveCount:"+map);
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		    int likeCount=0;
		    ResultSet rset=userService.likeCount(entry.getKey());
		    while(rset.next())
		    {
		    	 likeCount=rset.getInt(1);
		    }
		    
		    System.out.println("likeCount:"+likeCount+" "+"positiveCount:"+entry.getValue());
		    int totalCount=likeCount+entry.getValue();
		   // String str_totalCount=String.valueOf(totalCount);
		    BstAnsCount.put(entry.getKey(), totalCount); //map
		    tot_count.add(totalCount);
		    Collections.sort(tot_count);
		    /*System.out.println("Maximum Element After Sorting - "
		      + tot_count.get(tot_count.size() - 1));*/

		    
		}
		System.out.println("After sorting totalCount:"+tot_count);
		System.out.println("BstAns with totalCount:"+BstAnsCount);
		
		for (int i = tot_count.size() - 1 ; i >= 0 ; i--) {
		  
			String str_totalCount=String.valueOf(tot_count.get(i));
			System.out.println("Str_totalCount:::"+str_totalCount);
			for (Map.Entry<Integer, Integer> ent : BstAnsCount.entrySet())
			{
				String col_tCount=String.valueOf(ent.getValue());
				System.out.println("Col_tCount:::"+col_tCount);
			 if(col_tCount.equalsIgnoreCase(str_totalCount))
					 {
				        bestAnsId_al.add(ent.getKey());
					 }
			}
		}
		
		//get best ans id
		int finalbestAnsId=0;
		 int maxCount=(Collections.max(BstAnsCount.values()));
		 for (Map.Entry<Integer,Integer> entry : BstAnsCount.entrySet())
		 {
			 if(entry.getValue()==maxCount)
			 {
				 finalbestAnsId=entry.getKey(); 
				 bestAnsId_al.remove(entry.getKey());
			 }
			 
		 }
		 System.out.println("Final bestAnsId is:"+finalbestAnsId);
		 System.out.println("Final related bestAnsId_al:"+bestAnsId_al);
		 
		 /*//remove best id from arraylist
		 for(int i:bestAnsId_al){
		 	 if(bestAnsId_al.contains(finalbestAnsId))
			 {
				 bestAnsId_al.remove(finalbestAnsId);
			 }
		
		 }*/
		
		
		if(finalbestAnsId!=0)
		{
			request.setAttribute("bestAnsId_al", bestAnsId_al);
			request.setAttribute("finalbestAnsId", finalbestAnsId);
			request.getRequestDispatcher("displayBestAns.jsp").forward(request, response);
		}
		else {
			/*request.setAttribute("Msg", "Wait for Answer.....!!");
			request.getRequestDispatcher("homepage.jsp").forward(request, response);*/
			 response.setContentType("text/html");  
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Wait for Answer.....!!');");
				out.println("location='homepage.jsp';");
				out.println("</script>");
		 }
			
		    }
		    else{
		    	/*request.setAttribute("Msg", "History not maintain..Please,Search Again!!!!");
		    	request.getRequestDispatcher("homepage.jsp").forward(request, response);*/
		    	 response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('History not maintain..Please,Search Again!!!!');");
					out.println("location='homepage.jsp';");
					out.println("</script>");
		    }
		}catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
	}

}
