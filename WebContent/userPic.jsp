
<%@page import="connection.ConnectionUtils"%>

<%@ page import="java.sql.*,java.io.*,java.util.*" %> 

<%@ page trimDirectiveWhitespaces="true" %>
<%


int u_id=Integer.parseInt(request.getParameter("u_id"));

System.out.println("uid on profilePic.jsp page:..."+u_id);
		PreparedStatement pstmt = ConnectionUtils.getConnection().prepareStatement("Select profilePic From registration where u_id=?");
		pstmt.setInt(1, u_id);
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