package service;

import java.sql.ResultSet;

import bean.Admin;

public interface AdminService {

	Admin selectAdmin(String email, String password);
	public ResultSet selectAllUser();
	boolean authenticateUser(int u_id, String status);
	boolean deleteUser(int u_id);

}
