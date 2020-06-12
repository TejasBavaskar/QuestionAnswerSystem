package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.ConnectionUtils;
import bean.User;

public class UserDaoImpl implements UserDao{
	Connection conn=ConnectionUtils.getConnection();
	boolean flag=false;
	ResultSet rs=null;
	String query;
	public boolean isAlreadyAvailable(User user)
	{
		boolean flag=false;
		ResultSet rs;
		query="select * from registration";
		
		try{
			    Statement stmt=conn.createStatement();
			    rs=stmt.executeQuery(query);
				while(rs.next())
				{
					if(rs.getString(3).equals(user.getEmail()))
					{
						flag=true;
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return flag;
	}
	
	public boolean registerUser(User user)
	{
		int index=0;
		query="insert into registration(u_id, name, emailId, password, mobileNo, profilePic, profilePicName,status) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getMobileNo());			
			pstmt.setBlob(6, user.getProfilePic());
			pstmt.setString(7, user.getProfilePicName());
			pstmt.setString(8, user.getStatus());
			
			
			index=pstmt.executeUpdate();
			
			if(index>0)
			{
				flag=true;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	public ResultSet loginUser(User user)
	{
		try {
			 	Statement stmt;
			 	query="select * from registration where emailId='"+user.getEmail()+"' and password='"+user.getPassword()+"'";
			 	System.out.println(query);
			 	stmt=conn.createStatement();
			 	rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet userForgotPass(User user) {
		try {
			Statement stmt;
			query="select * from registration where emailId='"+user.getEmail()+"'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	
	@Override
	public boolean userChangePassword(String email, String confirm_password, String old_password) {
		boolean flag=false;
		String sql = "update registration set password='"+confirm_password+"' where emailId='"+email+"' and password='"+old_password+"'";
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int index = pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ResultSet selectUser(String username) {
		try {
			Statement stmt;
			query="select * from registration where emailId='"+username+"'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}



	@Override
		
	public boolean updateUserProfile(User user) {
		boolean flag=false;
		String sql = "update registration set name='"+user.getName()+"', emailId='"+user.getEmail()+"', password='"+user.getPassword()+"', mobileNo='"+user.getMobileNo()+"' where emailId='"+user.getEmail()+"'";
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int index = pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean changeProfilePic(User user) {
		boolean flag=false;
		String sql = "update registration set profilePic=?, profilePicName=? where emailId=?";
		
		try
		{
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setBlob(1, user.getProfilePic());
			pstmt.setString(2, user.getProfilePicName());
			pstmt.setString(3, user.getEmail());
			
			int index = pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	@Override
	public ResultSet getWSLinks() {
	try {
			Statement stmt;
			query="select * from dataset_tbl where fakeLink='"+1+"'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public boolean createQuestion(User user) {
		int index=0;
		query="insert into question_tbl(q_id,q_type, question,description,email,date) values(?,?,?,?,?,?)";
		PreparedStatement pstmt;
		
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, user.getQ_type());
			pstmt.setString(3, user.getQuestion());
			pstmt.setString(4, user.getDescription());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getDate());			
			
			index=pstmt.executeUpdate();
			
			if(index>0)
			{
				flag=true;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}

	@Override
	public ResultSet selectQuestions(int q_id) {
		try {
			Statement stmt;
			query="select * from question_tbl where q_id="+q_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public boolean addAnswer(User user) {
		int index=0;
		query="insert into answer_tbl(ans_id, q_id, q_type, question, answer, user_email, ans_date, ans_time) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, user.getQ_id());
			pstmt.setString(3, user.getQ_type());
			pstmt.setString(4, user.getQuestion());
			pstmt.setString(5, user.getAnswer());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getAns_date());		
			pstmt.setString(8, user.getAns_time());	
			
			index=pstmt.executeUpdate();
			
			if(index>0)
			{
				flag=true;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}

	@Override
	public ResultSet selectAnswers() {
		try {
			Statement stmt;
			query="select * from answer_tbl";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public boolean isAlreadyLike(String u_email,int ans_id) {
		boolean flag=false;
		ResultSet rs;
		query="select * from like_tbl";
		
		try{
			    Statement stmt=conn.createStatement();
			    rs=stmt.executeQuery(query);
				while(rs.next())
				{
					if(rs.getString(5).equals(u_email)&& rs.getInt(3)==ans_id)
					{
						flag=true;
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return flag;
	}

	@Override
	public boolean addLike(User user) {
		int index=0;
		query="insert into like_tbl(like_id, q_id, ans_id, like_count, user_email) values(?,?,?,?,?)";
		PreparedStatement pstmt;
		
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, user.getQ_id());
			pstmt.setInt(3, user.getAns_id());
			pstmt.setInt(4, user.getLike());
			pstmt.setString(5, user.getEmail());
			index=pstmt.executeUpdate();   
			if(index>0)
			{
				flag=true;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}

	@Override
	public ResultSet likeCount(int ans_id) {
		
		try {
			Statement stmt;
			query="SELECT COUNT(ans_id)FROM like_tbl where ans_id="+ans_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet selectComments(int ans_id) {
		try {
			Statement stmt;
			query="select * from comment_tbl where ans_id="+ans_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public boolean addComment(User user) {
		int index=0;
		query="insert into comment_tbl(com_id, q_id, ans_id, comment, user_email) values(?,?,?,?,?)";
		PreparedStatement pstmt;
		
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, user.getQ_id());
			pstmt.setInt(3, user.getAns_id());
			pstmt.setString(4, user.getComment());
			pstmt.setString(5, user.getEmail());
			
			index=pstmt.executeUpdate();
			
			if(index>0)
			{
				flag=true;
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	}

	@Override
	public ResultSet commentCount(int ans_id) {
		try {
			Statement stmt;
			query="SELECT COUNT(ans_id)FROM comment_tbl where ans_id="+ans_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet answerCount(int q_id) {
		try {
			
			Statement stmt;
			query="SELECT COUNT(q_id)FROM answer_tbl where q_id="+q_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet getAllQuestion() {
		try {
			Statement stmt;
			query="select * from question_tbl";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet getAnswer(int q_id) {
		try {
			Statement stmt;
			query="select * from question_tbl where q_id="+q_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet getComment(int ans_id) {
		try {
			Statement stmt;
			query="select * from comment_tbl where ans_id="+ans_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet getAnsId(int q_id) {
		try {
			Statement stmt;
			query="select * from answer_tbl where q_id="+q_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet selectAnswers(int q_id) {
		try {
			Statement stmt;
			query="select * from answer_tbl where q_id="+q_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet selectQuestions() {
		try {
			Statement stmt;
			query="select * from question_tbl";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet BestAnswers(int ans_id) {
		try {
			Statement stmt;
			query="select * from answer_tbl where ans_id="+ans_id+"";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet getQuestion(int q_id) {
		try {
			Statement stmt;
			query="select * from question_tbl where q_id="+q_id+" ";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public boolean addHistory(String searchQuery, String user_email) {
		int index=0;
		try{
		if(isAlready(user_email, searchQuery))
		{
			flag=true;	
		}
		else
		{	
		query="insert into searchhistory_tbl(s_id, searchQuery, user_email) values(?,?,?)";
		PreparedStatement pstmt;
		
	
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, searchQuery);
			pstmt.setString(3, user_email);
			
			index=pstmt.executeUpdate();
			
			if(index>0)
			{
				flag=true;
			}
		}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		
			return flag;
	}

	@Override
	public boolean isAlready(String user_email, String searchQuery) {
		boolean flag=false;
		ResultSet rs;
		query="select * from searchhistory_tbl";
		
		try{
			    Statement stmt=conn.createStatement();
			    rs=stmt.executeQuery(query);
				while(rs.next())
				{
					if(rs.getString(2).equals(searchQuery) && rs.getString(3).equals(user_email))
					{
						flag=true;
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return flag;
	}

	@Override
	public ResultSet getUserQuestions(String email) {
		try {
			Statement stmt;
			query="select * from searchhistory_tbl where user_email='"+email+"' ";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet getMachedUser(String que,String email) {
		try {
			Statement stmt;
			query="select * from searchhistory_tbl where searchQuery='"+que+"' and "
					+ " user_email <>'"+email+"' "; // not equal to < >
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public ResultSet selectQuestions(String que) {
		try {
			Statement stmt;
			query="select * from question_tbl where question='"+que+"'";
			//query="select * from searchhistory_tbl where question='"+que+"'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
}
