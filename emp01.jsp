<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<td>사원번호</td> 
		<td>사원명</td> 
		<td>직급</td> 
		<td>상관번호</td> 
		<td>입사일자</td> 
		<td>급여</td> 
		<td>커미션</td> 
		<td>부서번호</td> 
	</tr>
	<% 
			//데이터베이스를 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			
		try{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pwd="tiger";
			String sql="select * from emp";
			
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			//쿼리 생성
			rs = stmt.executeQuery(sql);
			
		while(rs.next()){
	%>
	<tr>
	<td><%= rs.getInt("empno")%></td>
	<td><%= rs.getString("ename")%></td>
	<td><%= rs.getString("job")%></td>
	<td><%= rs.getString("mgr")%></td>
	<td><%= rs.getString("hiredate")%></td>
	<td><%= rs.getInt("sal")%></td>
	<td><%= rs.getString("comm")%></td>
	<td><%= rs.getInt("deptno")%></td>
	</tr>
	<% 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	%>
	</table>
</body>
</html>
