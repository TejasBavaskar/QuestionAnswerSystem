package service;

import java.sql.ResultSet;










import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	 UserDao userDao=new UserDaoImpl();
	 
	public boolean isAlreadyAvailable(User user) {
		return userDao.isAlreadyAvailable(user);
	}
	
	public boolean registerUser(User user)
	{
		return userDao.registerUser(user);
	}
	
	public ResultSet loginUser(User user)
	{
		return userDao.loginUser(user);
	}

	@Override
	public ResultSet userForgotPass(User user) {
		
		return userDao.userForgotPass(user);
	}

	@Override
	public boolean userChangePassword(String email, String confirm_password, String old_password) {
		
		return userDao.userChangePassword(email,confirm_password,old_password);
	}

	@Override
	public ResultSet selectUser(String username) {
	
		return userDao.selectUser(username);
	}

	@Override
	public boolean updateUserProfile(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserProfile(user);
	}

	@Override
	public boolean changeProfilePic(User user) {
		// TODO Auto-generated method stub
		return userDao.changeProfilePic(user);
	}

	@Override
	public ResultSet getWSLinks() {
		// TODO Auto-generated method stub
		return userDao.getWSLinks();
	}

	@Override
	public boolean createQuestion(User user) {
		// TODO Auto-generated method stub
		return userDao.createQuestion(user);
	}

	@Override
	public ResultSet selectQuestions(int q_id) {
		// TODO Auto-generated method stub
		return userDao.selectQuestions(q_id);
	}

	@Override
	public boolean addAnswer(User user) {
		// TODO Auto-generated method stub
		return userDao.addAnswer(user);
	}

	@Override
	public ResultSet selectAnswers() {
		// TODO Auto-generated method stub
		return userDao.selectAnswers();
	}

	@Override
	public boolean isAlreadyLike(String u_email,int ans_id) {
		// TODO Auto-generated method stub
		return userDao.isAlreadyLike(u_email,ans_id);
	}

	@Override
	public boolean addLike(User user) {
		// TODO Auto-generated method stub
		return userDao.addLike(user);
	}

	@Override
	public ResultSet likeCount(int ans_id) {
		// TODO Auto-generated method stub
		return userDao.likeCount(ans_id);
	}

	@Override
	public ResultSet selectComments(int ans_id) {
		// TODO Auto-generated method stub
		return userDao.selectComments(ans_id);
	}

	@Override
	public boolean addComment(User user) {
		// TODO Auto-generated method stub
		return userDao.addComment(user);
	}

	@Override
	public ResultSet commentCount(int ans_id) {
		// TODO Auto-generated method stub
		return userDao.commentCount(ans_id);
	}

	@Override
	public ResultSet answerCount(int q_id) {
		// TODO Auto-generated method stub
		return userDao.answerCount(q_id);
	}

	@Override
	public ResultSet getAllQuestion() {
		// TODO Auto-generated method stub
		return userDao.getAllQuestion();
	}

	@Override
	public ResultSet getAnswer(int q_id) {
		// TODO Auto-generated method stub
		return userDao.getAnswer(q_id);
	}

	@Override
	public ResultSet getComment(int ans_id) {
		// TODO Auto-generated method stub
		return userDao.getComment(ans_id);
	}

	@Override
	public ResultSet getAnsId(int q_id) {
		// TODO Auto-generated method stub
		return userDao.getAnsId(q_id);
	}

	@Override
	public ResultSet selectAnswers(int q_id) {
		// TODO Auto-generated method stub
		return userDao.selectAnswers(q_id);
	}

	@Override
	public ResultSet selectQuestions() {
		// TODO Auto-generated method stub
		return userDao.selectQuestions();
	}

	@Override
	public ResultSet BestAnswers(int ans_id) {
		// TODO Auto-generated method stub
		return userDao.BestAnswers(ans_id);
	}

	@Override
	public ResultSet getQuestion(int q_id) {
		// TODO Auto-generated method stub
		return userDao.getQuestion(q_id);
	}

	@Override
	public boolean addHistory(String searchQuery, String user_email) {
		// TODO Auto-generated method stub
		return userDao.addHistory(searchQuery,user_email);
	}

	@Override
	public boolean isAlready(String user_email, String searchQuery) {
		// TODO Auto-generated method stub
		return userDao.isAlready(user_email, searchQuery);
	}

	@Override
	public ResultSet getUserQuestions(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserQuestions(email);
	}

	@Override
	public ResultSet getMachedUser(String que,String email) {
		// TODO Auto-generated method stub
		return userDao.getMachedUser(que,email);
	}

	@Override
	public ResultSet selectQuestions(String que) {
		// TODO Auto-generated method stub
		return userDao.selectQuestions(que);
	}

	
}
