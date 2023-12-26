<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.board.dao.BoardDao"%>
<%@page import="com.board.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp=request.getContextPath();
	
	int num=Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");
	
	Connection conn=DBConn.getInstance();
	BoardDao dao=new BoardDao();
	
	dao.deleteData(num);
	
	String searchKey=request.getParameter("searchKey");
	String searchValue=request.getParameter("searchValue");
	
	if(searchValue!=null) {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			searchValue=URLDecoder.decode(searchValue, "UTF-8");
		}
	}else {
		searchKey="subject";
		searchValue="";
	}
	
	String param="";
	if(!searchValue.equals("")) {
		param="&searchKey="+searchKey;
		param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
	}
	
	DBConn.dbClose();
	
	response.sendRedirect("list.jsp?pageNum=" + pageNum + param);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
</body>
</html>