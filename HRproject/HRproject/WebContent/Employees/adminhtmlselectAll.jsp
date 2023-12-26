<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="adminstyle.css">
</head>
<body>
	<div class="header">
		<div class="logo">
			<h1>LOGO</h1>
		</div>
		<div class="logout">
			<button>LOGOUT</button>
		</div>
	</div>
	<ul class="menu">
		<li>
			<a href="#">사원 관리</a>
			<ul class="submenu one">
				<li><a href="#">사원 정보 수정</a></li>
				<li><a href="/HRproject/Employees/adminhtmlselectAll.jsp">전체 사원 조회</a></li>
			</ul>
		</li>
		<li>
			<a href="#">사원 업무 관리</a>
			<ul class="submenu two">
				<li><a href="#">사원 업무 조회</a></li>
			</ul>
		</li>
		<li>
			<a href="#">부서 관리</a>
			<ul class="submenu three">
				<li><a href="#">부서 조회</a></li>
			</ul>
		</li>
	</ul>
	<div class="result">
		결과물 출력
	</div>
	<br><br><br>
	<a href="/HRproject/Employees/selectAll.employees">직원정보조회</a>
	
</body>
</html>