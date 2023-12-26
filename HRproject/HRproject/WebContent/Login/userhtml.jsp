<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(사원용)인사관리</title>
<link rel="stylesheet" href="userstyle.css">
<!-- jQuery 라이브러리를 포함합니다. -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="/HRproject/Login/userhtml.jsp">
			<img src="/HRproject/img/logo.JPG" width="52px" height="52px">
		</a>
		</div>
		<div class="logout">
			<button type="button" onclick="location.href='/HRproject/Login/login.Controller'">LOG OUT</button>
		</div>
	</div>
	<ul class="menu">
      <li>
         <a href="#">공지 사항</a>
         <ul class="submenu">
            <li><a href="/HRproject/Board/userList.jsp">게시판</a></li>
         </ul>
      </li>
      <li>
         <a href="#">사원 관리</a>
         <ul class="submenu">
            <li><a href="/HRproject/Employee_user/selectAll.employeeUser">전체 사원 조회</a></li>
            <li><a href="/HRproject/EmpMgrDeptJoin/selectAll.join">직원 및 부서정보 조회</a></li>
         </ul>
      </li>
      <li>
         <a href="#">사원 업무 관리</a>
         <ul class="submenu">
            <li><a href="/HRproject/Jobs_user/selectAll.jobsUser">사원 업무 조회</a></li>
         </ul>
      </li>
      <li>
         <a href="#">부서 관리</a>
         <ul class="submenu">
            <li><a href="/HRproject/Department/selectAll.departments">부서 조회</a></li>
         </ul>
      </li>
   </ul>

	<div class="result" id="allEmployees">
		<script>
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/Employee_user/selectAll.employeeUser']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/Employee_user/selectAll.employeeUser");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/EmpMgrDeptJoin/selectAll.join']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/EmpMgrDeptJoin/selectAll.join");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/Jobs_user/selectAll.jobsUser']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/Jobs_user/selectAll.jobsUser");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	
	$(document).ready(function() {
	    // "전체 사원 조회" 메뉴를 클릭했을 때, result div에 콘텐츠를 로드합니다.
	    $("a[href='/HRproject/Department/selectAll.departments']").on("click", function(e) {
	        e.preventDefault(); // 기본 링크 동작을 막습니다.

	        // "전체 사원 조회" 콘텐츠를 result div에 로드합니다.
	        $("#allEmployees").load("/HRproject/Department/selectAll.departments");
	        $("#allEmployees").addClass("custom-styles");
	    });
	});
	</script>
	</div>

	
</body>
</html>
