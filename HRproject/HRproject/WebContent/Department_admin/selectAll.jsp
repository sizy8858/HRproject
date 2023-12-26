<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 조회 및 수정</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>부서 정보</h1>
	<a href="/HRproject/Login/adminhtml.jsp">메인 홈페이지 접속(관리자)</a>
	<form action="/HRproject/Department_admin/selectOne.deptAdmin" method="post" style="margin-right: 20px;">
        해당 부서ID: <input type="text" name="department_id" placeholder="department_id입력">
        <input type="submit" value="조회" class="btn">
    </form>
	<table width="100%" id="departments">
		<tr>
			<th>department_id</th>
			<th>department_name</th>
			<th>manager_id</th>
			<th>location_id</th>


		</tr>
		<c:forEach items="${dtos }" var="departmentsDto">
			<tr>
				<td>${departmentsDto.department_id}</td>
				<td>${departmentsDto.department_name}</td>
				<td><a
					href='/HRproject/Department_admin/selectOne.deptAdmin?department_id=${departmentsDto.department_id }'>${departmentsDto.manager_id }</a></td>
				<td>${departmentsDto.location_id}</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>