<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*" %>
<%@ page import= "com.hr.dto.*" %>
<%@ page import= "com.hr.dao.*" %>
<%@ page import= "java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>특정 회원 정보 출력</title>
</head>
<body>
<h1>특정 회원 정보 출력</h1>
<%
    request.setCharacterEncoding("utf-8");
    Integer department_id = Integer.parseInt(request.getParameter("department_id"));
    DepartmentsDto dto = new DepartmentsDto();
    dto.setDepartment_id(department_id);
    DepartmentsDao dao = new DepartmentsDao();
    ArrayList<DepartmentsDto> empList = dao.selectAll();
%>
<table width="100%" id="departments">
	<tr>
		<th>department_id</th>
		<th>department_name</th>
		<th>manager_id</th>
		<th>location_id</th>
	</tr>
	
	<tr>
		<td><%=dto.getDepartment_id() %></td>
		<td><%=dto.getDepartment_name() %></td>
		<td><%=dto.getManager_id() %></td>
		<td><%=dto.getLocation_id() %></td>
	</tr>
	
</table>
</body>
</html>