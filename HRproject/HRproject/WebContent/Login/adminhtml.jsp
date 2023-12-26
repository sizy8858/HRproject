<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(관리자용)인사관리</title>
<link rel="stylesheet" href="adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="header">
		<div class="logo">
		<a href="/HRproject/Login/adminhtml.jsp">
			<img src="/HRproject/img/logo.JPG" width="52px" height="52px">
		</a>	
		</div>
		<div class="logout">
			<button type="button" onclick="location.href='/HRproject/Login/login.Controller'">LOGOUT</button>
		</div>
	</div>

	<ul class="menu">
		<li>
			<a href="#">공지 사항</a>
			<ul class="submenu">
				<li><a href="/HRproject/Board/list.jsp">게시판</a></li>
			</ul>
		</li>
		<li>
			<a href="#">사원 관리</a>
			<ul class="submenu">
				<li><a href="/HRproject/Employees/register.jsp">사원 등록</a></li>
				<li><a href="/HRproject/Employees/selectAll.employees">전체 사원 조회 및 수정</a></li>
			</ul>
		</li>
		<li>
			<a href="#">사원 업무 관리</a>
			<ul class="submenu">
				<li><a href="/HRproject/Jobs/register.jsp">사원 업무 등록</a></li>
				<li><a href="/HRproject/Jobs/selectAll.jobs">사원 업무 조회 및 수정</a></li>
			</ul>
		</li>
		<li>
			<a href="#">부서 관리</a>
			<ul class="submenu">
				<li><a href="/HRproject/Department_admin/register.jsp">부서 등록</a></li>
				<li><a href="/HRproject/Department_admin/selectAll.deptAdmin">부서 조회 및 수정</a></li>
			</ul>
		</li>
	</ul>
	<div class="result" id="allEmployees">
		<script>
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/Employees/selectAll.employees']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/Employees/selectAll.employees");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/Jobs/selectAll.jobs']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/Jobs/selectAll.jobs");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/Department_admin/selectAll.deptAdmin']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/Department_admin/selectAll.deptAdmin");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/Employees/selectOne.employees']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/Employees/selectOne.employees");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	
	
	</script>
	</div>
</body>
</html>