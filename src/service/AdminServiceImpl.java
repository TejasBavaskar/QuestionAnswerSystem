package service;

import java.sql.ResultSet;

import bean.Admin;
import dao.AdminDao;
import dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService{
	
	AdminDao adminDao=new AdminDaoImpl();

	@Override
	public Admin selectAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return adminDao.selectAdmin(email, password);
	}

	@Override
	public ResultSet selectAllUser() {
		// TODO Auto-generated method stub
		return adminDao.selectAllUser();
	}

	@Override
	public boolean authenticateUser(int u_id, String status) {
		// TODO Auto-generated method stub
		return adminDao.authenticateUser(u_id,status);
	}

	@Override
	public boolean deleteUser(int u_id) {
		// TODO Auto-generated method stub
		return adminDao.deleteUser(u_id);
	}
	
	
}
