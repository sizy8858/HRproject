<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원업무 조회</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<table width="100%" id="jobs">
	<tr>
		<th>job_id</th>
		<th>job_title</th>
		<th>min_salary</th>
		<th>max_salary</th>
	</tr>

	<tr>
		<td>${requestScope.dto.job_id }</td>
		<td>${requestScope.dto.job_title }</td>
		<td>${requestScope.dto.min_salary}</td>
		<td>${requestScope.dto.max_salary }</td>
		
	</tr>
</table>
	<a href="/HRproject/Login/userhtml.jsp">메인 홈페이지로 이동</a>


</body>
</html>