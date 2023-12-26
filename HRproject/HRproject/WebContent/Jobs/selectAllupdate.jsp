<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>직원 정보</h1>
<%
	java.time.LocalDateTime ld = java.time.LocalDateTime.now();
	request.setAttribute("ld", ld);
%>
<hr>
현재시간
<hr>
-${requestScope.ld }-
<fmt:parseDate value="${requestScope.ld }" 
pattern="yyyy-MM-dd'T'HH:mm:ss.SSS"
var="now" type="both" ></fmt:parseDate>
<hr>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"></fmt:formatDate>
<hr>
<a href="/HRproject/Login/adminhtml.jsp">메인 홈페이지 접속</a>
<hr>
<table border="1" width="90%" id="jobs">
	<tr>
		<th>job_id</th>
		<th>job_title</th>
		<th>min_salary</th>
		<th>max_salary</th>		
	</tr>
	<c:forEach items="${dtos }" var="jobsDto">	
		<tr>
			<td>${jobsDto.job_id}</td>
			<td><a href='/HRproject/Jobs/selectOne.jobs?job_id=${jobsDto.job_id }'>${jobsDto.job_title }</a></td>
			<td>${jobsDto.min_salary}</td>        	      	
        	<td>${jobsDto.max_salary}</td>
        	 
        	
		</tr>
	</c:forEach>
</table>
<a href="/HRproject/Jobs/register.jsp" class="btn">사원 업무 추가</a>
</body>
</html>