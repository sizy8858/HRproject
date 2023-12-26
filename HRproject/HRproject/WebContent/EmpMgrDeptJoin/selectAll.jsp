<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.hr.dto.EmpMgrDeptDto" %>
<%@ page import="com.hr.dao.EmpMgrDeptDao" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 및 부서정보 조회</title>
<link rel="stylesheet" href="../Login/adminstyle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>직원 및 부서 정보</h1>

<%
    EmpMgrDeptDao dao = new EmpMgrDeptDao();
    ArrayList<EmpMgrDeptDto> dtos = dao.selectAllEmployeeAndDepartments();
    request.setAttribute("dtos", dtos);
%>
<table width="100%" id="employees">
    <tr>
        <th>employee_id</th>
        <th>first_name</th>
        <th>last_name</th>
        <th>email</th>
        <th>phone_number</th>
        <th>hire_date</th>
        <th>job_id</th>
        <th>salary</th>
        <th>commission_pct</th>
        <th>manager_id</th>
        <th>department_id</th>
        <th>department_name</th>
    </tr>
    <c:forEach items="${dtos}" var="empMgrDeptDto">
        <tr>
            <td>${empMgrDeptDto.employee_id}</td>
            <td>${empMgrDeptDto.first_name}</td>
            <td>${empMgrDeptDto.last_name}</td>
            <td>${empMgrDeptDto.email}</td>
            <td>${empMgrDeptDto.phone_number}</td>
            <td>${empMgrDeptDto.hire_date}</td>
            <td>${empMgrDeptDto.job_id}</td>
            <td>${empMgrDeptDto.salary}</td>
            <td>${empMgrDeptDto.commission_pct}</td>
            <td>${empMgrDeptDto.manager_id}</td>
            <td>${empMgrDeptDto.department_id}</td>
            <td>${empMgrDeptDto.department_name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>