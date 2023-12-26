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
<h1>특정 사원업무 정보 출력</h1>
<%
    request.setCharacterEncoding("utf-8");
    String job_id = request.getParameter("job_id");
    JobsDto dto = new JobsDto();
    dto.setJob_id(job_id);
    JobsDao dao = new JobsDao();
    ArrayList<JobsDto> empList = dao.selectAll();
%>
<table width="100%" id="jobs">

	<tr>
		<th>job_id</th>
		<th>job_title</th>
		<th>min_salary</th>
		<th>max_salary</th>
	</tr>
	
	<tr>
		<td><%=dto.getJob_id() %></td>
		<td><%=dto.getJob_title() %></td>
		<td><%=dto.getMin_salary() %></td>
		<td><%=dto.getMax_salary() %></td>
	</tr>	
</table>
</body>
</html>