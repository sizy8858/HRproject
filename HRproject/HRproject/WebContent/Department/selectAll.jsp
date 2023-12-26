<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 조회</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>부서 정보</h1>
<form action="/HRproject/Department/selectOne.departments" method="post" style="margin-right: 20px;">
        해당 사번: <input type="text" name="department_id" placeholder="department_id 입력">
        <input type="submit" value="조회" class="btn">
    </form>
<table  width="100%" id="departments">
	<tr>
		<th>department_id</th>
		<th>location_id</th>
		<th>department_name</th>
		<th>manager_id</th>
	</tr>
	<c:forEach items="${dtos }" var="departmentsDto">	
		<tr>
			<td>${departmentsDto.department_id}</td>
			<td>${departmentsDto.location_id}</td>        	      	
        	<td>${departmentsDto.department_name}</td>
        	<td>${departmentsDto.manager_id}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>