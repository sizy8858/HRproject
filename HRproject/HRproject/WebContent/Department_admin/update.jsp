<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서정보 수정</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<form action="/HRproject/Department_admin/updateDB.deptAdmin" method="post">
	<table width="100%" id="departments">
		<tr>
			<th>department_id</th>
			<th>location_id</th>
			<th>department_name</th>
			<th>manager_id</th>
		
		</tr>
		<tr>
			<input type="hidden" name="department_id" value="${requestScope.dto.department_id }">
			<td>${requestScope.dto.department_id }</td>
			<td>${requestScope.dto.location_id}</td>
			<td>${requestScope.dto.department_name}</td>
			<td><input type="text" name="manager_id" value="${requestScope.dto.manager_id }"></td>
			
		</tr>
	</table>
	<a href="/HRproject/Department_admin/selectAllupdate.deptAdmin" class="btn">목록가기</a>
	<input type="submit" value="수정" class="btn">
</form>
</body>
</html>