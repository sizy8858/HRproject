<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.hr.dao.CountriesDao" %>
<%@ page import="com.hr.dto.CountriesDto" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Countries List</title>
</head>
<body>
<%
	CountriesDao dao = new CountriesDao();
	ArrayList<CountriesDto> dtos = dao.selectAll();
%>
	<h1>Countries List</h1>
	<hr>
	<table border="1" width="90%" id="country">
		<tr>
			<th>country_id</th>
			<th>country_name</th>
			<th>region_id</th>
		</tr>
<%
		for(int i=0; i<dtos.size(); i++) {
			CountriesDto dto= dtos.get(i);
			String country_id = dto.getCountry_id();
			String country_name = dto.getCountry_name();
			int region_id = dto.getRegion_id();
			out.print("<tr><td>" + country_id 
						+ "</td><td>" + country_name + "</td><td>" + region_id + "</td>");
		}
%>
	</table>
</body>
</html>