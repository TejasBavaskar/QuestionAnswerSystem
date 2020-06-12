package dao;

import java.sql.ResultSet;

import bean.Admin;

public interface AdminDao {

	Admin selectAdmin(String email, String password);
	ResultSet selectAllUser();
	boolean authenticateUser(int u_id, String status);
	boolean deleteUser(int u_id);
}
