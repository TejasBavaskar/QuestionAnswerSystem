package dao;

import java.sql.ResultSet;

import bean.User;

public interface UserDao {

	public boolean isAlreadyAvailable(User user);

	public boolean registerUser(User user);

	public ResultSet loginUser(User user);

	public ResultSet userForgotPass(User user);
	
	public boolean userChangePassword(String email, String confirm_password, String old_password);

	public ResultSet selectUser(String username);

	public boolean updateUserProfile(User user);

	public boolean changeProfilePic(User user);

	public ResultSet getWSLinks();

	public boolean createQuestion(User user);
	public ResultSet selectQuestions(int q_id);
	public ResultSet selectQuestions(String que);
	public ResultSet selectQuestions();
	public boolean addAnswer(User user);

	public ResultSet selectAnswers();

	public boolean isAlreadyLike(String u_email,int ans_id);

	public boolean addLike(User user);
	public ResultSet likeCount(int ans_id);
	public ResultSet selectComments(int ans_id);

	public boolean addComment(User user);
	public ResultSet commentCount(int ans_id);
	public ResultSet answerCount(int q_id);
	public ResultSet getAllQuestion();
	public ResultSet getAnswer(int q_id);
	public ResultSet getComment(int q_id);
	public ResultSet getAnsId(int q_id);
	public ResultSet selectAnswers(int q_id);
	public ResultSet BestAnswers(int ans_id);
	public ResultSet getQuestion(int q_id);

	public boolean addHistory(String searchQuery, String user_email);
	public boolean isAlready(String user_email,String searchQuery);
	public ResultSet getUserQuestions(String email);

	public ResultSet getMachedUser(String que,String email);
}
