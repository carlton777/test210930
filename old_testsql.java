<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "tiger";
	String sql = "select * from emp";
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>�����ȣ</td>
			<td>�����</td>
			<td>����</td>
			<td>�����ȣ</td>
			<td>�Ի�����</td>
			<td>�޿�</td>
			<td>Ŀ�̼�</td>
			<td>�μ���ȣ</td>
		</tr>
		<%
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next())
				{
		%>
					<tr>
						<td><%= rs.getString("empno") %></td>
						<td><%= rs.getString("ename") %></td>
						<td><%= rs.getString("job") %></td>
						<td><%= rs.getString("mgr") %></td>
						<td><%= rs.getString("hiredate") %></td>
						<td><%= rs.getString("sal") %></td>
						<td><%= rs.getString("comm") %></td>
						<td><%= rs.getString("deptno") %></td>
					</tr>
		<%
				}
		    }
			catch(SQLException se)
			{
	       	  se.printStackTrace();
	      	}
		    finally
		    {
	        	 try
	        	 {
	            	if(rs != null){rs.close();}
	            	if(stmt != null){stmt.close();}
	            	if(conn != null){conn.close();}
	         	 }
	         	 catch(SQLException se){
	             	se.printStackTrace();
	         	 }
	      	}
		%>
		
	</table>
</body>
</html>
