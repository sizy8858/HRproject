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
    Integer employee_id = Integer.parseInt(request.getParameter("employee_id"));
    EmployeesDto dto = new EmployeesDto();
    dto.setEmployee_id(employee_id);
    EmployeesDao dao = new EmployeesDao();
    ArrayList<EmployeesDto> empList = dao.selectAll();
%>
<table width="100%" id="employees">
	<tr>
		<th>employee_id</th>
		<th>first_name</th>
		<th>last_name</th>
		<th>email</th>
		<th>phone_number</th>
		<th>hire_date</th>
		<th>job_id</th>
		<th>salary</th>
		<th>commission_pct</th>
		<th>manager_id</th>
		<th>department_id</th>

	</tr>
	
	<tr>
		<td><%=dto.getEmployee_id() %></td>
		<td><%=dto.getFirst_name() %></td>
		<td><%=dto.getLast_name() %></td>
		<td><%=dto.getEmail() %></td>
		<td><%=dto.getPhone_number() %></td>
		<td><%=dto.getHire_date() %></td>
		<td><%=dto.getJob_id() %></td>
		<td><%=dto.getSalary() %></td>
		<td><%=dto.getCommission_pct() %></td>
		<td><%=dto.getManager_id() %></td>
		<td><%=dto.getDepartment_id() %></td>

</table>
</body>
</html>