package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionUtils;
import bean.Admin;

public class AdminDaoImpl implements AdminDao{

	String query=null;
	ResultSet rs=null;
	
	@Override
	public Admin selectAdmin(String email, String password) {
		Admin admin=new Admin();
		try{
			
		query="select * from admin where email='"+email+"' and password='"+password+"'";
	
		Statement stmt=ConnectionUtils.getConnection().createStatement();
		rs=stmt.executeQuery(query);
		if(rs.next())
		{
			admin.setId(rs.getInt(1));
			
			admin.setEmail(rs.getString(2));
			admin.setPassword(rs.getString(3));	
			admin.setUname(rs.getString(4));
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public ResultSet selectAllUser() {
		try {
			Statement stmt;
			query="select * from registration";
			stmt=ConnectionUtils.getConnection().createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	@Override
	public boolean authenticateUser(int u_id, String status) {
		boolean flag = false;
		if(status.equalsIgnoreCase("Inactive"))
			status="Active";
		else
			status = "Inactive";
		
		String sql = "Update registration Set status=? Where u_id=?";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, u_id);
			int index=pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return flag;
	}

	@Override
	public boolean deleteUser(int u_id) {
boolean flag = false;
		
		String sql = "delete from registration Where u_id=?";
		try {
			PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement(sql);
			pstmt.setInt(1, u_id);
			int index=pstmt.executeUpdate();
			if(index>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return flag;
	}

}
