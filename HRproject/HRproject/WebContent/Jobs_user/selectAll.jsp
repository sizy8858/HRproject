<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 업무 조회</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>사원 업무 정보</h1>
<form action="/HRproject/Jobs_user/selectOne.jobsUser" method="post" style="margin-right: 20px;">
        해당 사번: <input type="text" name="job_id" placeholder="job_id 입력">
        <input type="submit" value="조회" class="btn">
    </form>
<table width="100%" id="jobs">
	<tr>
		<th>job_id</th>
		<th>job_title</th>
		<th>min_salary</th>
		<th>max_salary</th>
	</tr>
	<c:forEach items="${dtos }" var="jobsDto">	
		<tr>
			<td>${jobsDto.job_id}</td>
			<td>${jobsDto.job_title}</td>        	      	
        	<td>${jobsDto.min_salary}</td>
        	<td>${jobsDto.max_salary}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>