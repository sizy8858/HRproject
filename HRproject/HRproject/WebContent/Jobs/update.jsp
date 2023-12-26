<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원업무 수정</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<form action="/HRproject/Jobs/updateDB.jobs" method="post">
	<table border="1" width="90%" id="jobs">
		<tr>
			<th>job_id</th>
			<th>job_title</th>
			<th>min_salary</th>
			<th>max_salary</th>	
		</tr>
		<tr>
			<input type="hidden" name="job_id" value="${requestScope.dto.job_id }">
			<td>${requestScope.dto.job_id }</td>
			<td>${requestScope.dto.job_title }</td>
			<td><input type="text" name="min_salary" value="${requestScope.dto.min_salary }"></td>
			<td>${requestScope.dto.max_salary}</td>
			
			
		</tr>
	</table>
	<a href="/HRproject/Jobs/selectAllupdate.jobs" class="btn">목록가기</a>
	<input type="submit" value="수정" class="btn">
</form>
</body>
</html>