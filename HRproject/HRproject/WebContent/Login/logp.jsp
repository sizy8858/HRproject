<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.4.1.js"></script>
</head>
<body>

<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Class.forName("oracle.jdbc.driver.OracleDriver");
    
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String dbid = "hr";
    String dbpw = "hr";
    conn = DriverManager.getConnection(url, dbid, dbpw);
    pstmt = conn.prepareStatement("SELECT employee_id, employee_pw, last_name, isAdmin FROM login WHERE employee_id = ?");
    pstmt.setInt(1, Integer.parseInt(id));
    rs = pstmt.executeQuery();
    
    if (rs.next()) {
        if (id.equals(rs.getString("employee_id")) && pw.equals(rs.getString("employee_pw"))) {
            String isAdmin = rs.getString("isAdmin");
            String last_name = rs.getString("last_name");
            if ("admin".equals(isAdmin)) { 
            	request.setAttribute("last_name", last_name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin_success.jsp");
                dispatcher.forward(request, response);
            } else {
            	request.setAttribute("last_name", last_name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user_success.jsp");
                dispatcher.forward(request, response);
            }
        } else {
%>
        <script>
            alert('사번 또는 비밀번호가 잘못 입력되었습니다.');
            window.location.href = "/HRproject/Login/login.Controller";
        </script>
<%
        }
    }
    
    rs.close();
    pstmt.close();
    conn.close();
%>

</body>
</html>
