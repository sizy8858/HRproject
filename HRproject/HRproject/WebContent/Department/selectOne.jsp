<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서정보 조회 및 수정</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<table width="100%" id="departments">
	<tr>
		<th>department_id</th>
		<th>location_id</th>
		<th>department_name</th>
		<th>manager_id</th>
	</tr>

	<tr>
		<td>${requestScope.dto.department_id }</td>
		<td>${requestScope.dto.location_id }</td>
		<td>${requestScope.dto.department_name}</td>
		<td>${requestScope.dto.manager_id }</td>
	</tr>
</table>
	<a href="/HRproject/Login/userhtml.jsp">메인 홈페이지로 이동</a>
</body>
</html>