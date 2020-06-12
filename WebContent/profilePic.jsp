
<%@page import="connection.ConnectionUtils"%>

<%@ page import="java.sql.*,java.io.*,java.util.*" %> 

<%@ page trimDirectiveWhitespaces="true" %>
<%

HttpSession sec1=request.getSession();
String userEmail=request.getParameter("userEmail");

System.out.println("uid on profilePic.jsp page:..."+userEmail);
		PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement("Select profilePic From registration where emailId=?");
		pstmt.setString(1, userEmail);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			InputStream is = rs.getBinaryStream(1);
			
				byte[] profilePic = null;
		   			//OutputStream out = response.getOutputStream();
		   		byte[] buffer = new byte[1024*1024*50];
				int bytesRead;		
				if(is!=null){
					while ((bytesRead =is.read(buffer)) != -1)
					{
					    	response.reset();
							response.setContentType("image/jpg");
							response.setHeader("Content-disposition","attachment; filename=" );
					        response.getOutputStream().write(buffer, 0, bytesRead);
					        response.getOutputStream().flush(); 

					 }
				}		
	
		}
		
%>