<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.board.util.MyUtil"%>
<%@page import="com.board.util.DBConn"%>
<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");
	String cp=request.getContextPath();
	
	Connection conn=DBConn.getInstance();
	BoardDao dao=new BoardDao();
	MyUtil myUtil=new MyUtil();
	
	//get으로 넘어온 페이지 번호
	String pageNum=request.getParameter("pageNum");
	
	//첫 시작 시 현재 페이지
	int currentPage=1;
	
	//페이지를 넘어온 경우 현재 페이지 값
	if(pageNum!=null){
		currentPage=Integer.parseInt(pageNum);
	}
	
	//검색 키-값
	String searchKey=request.getParameter("serachKey");
	String searchValue=request.getParameter("searchValue");
	
	//검색 값이 있을 경우
	if(searchValue!=null){
		if(request.getMethod().equalsIgnoreCase("GET")) {
			searchValue=URLDecoder.decode(searchValue,"UTF-8");
		}
	//검색 값이 없을 경우
	}else {
		searchKey="subject";
		searchValue="";
	}
	
	//전체 데이터 갯수
	int dataCount=dao.getDataCount(searchKey, searchValue);
	
	//1페이지 당 표시할 글의 수
	int numPerPage=3;
	
	//전체 페이지 갯수
	int totalPage=myUtil.getPageCount(numPerPage, dataCount);
	
	//글 삭제하여 페이지 감소 시
	if(currentPage>totalPage) {
		currentPage=totalPage;
	}
	
	//DB에서 가져올 데이터의 시작과 끝
	int start=(currentPage-1)*numPerPage+1;
	int end=currentPage*numPerPage;
	
	//DB에서 데이터 가져옴
	List<BoardDto> lists=dao.getLists(start, end, searchKey, searchValue);
	
	//검색
	String param="";
	if(!searchValue.equals("")) {
		param="?searchKey="+searchKey;
		param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
	}
	
	//페이징
	String listUrl="list.jsp"+param;
	String pageIndexList=myUtil.pageIndexList(currentPage, totalPage, listUrl);
	//글 보기
	String articleUrl=cp+"/Board/userArticle.jsp";
	
	if(param.equals("")) {//검색하지 않았을 시의 주소
		articleUrl+="?pageNum="+currentPage;
	}else {
		articleUrl+=param+"&pageNum="+currentPage;
	}
	
	DBConn.dbClose();
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="board.css">
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
	<div class="page-title">
		<div class="container">
			<h3>공지사항</h3>
		</div>
	</div>
	<div id="board-list">
		<div class="container">
			<table class="board-table">
				<thead>
					<tr>
						<th scope="col" class="th-num">번호</th>
						<th scope="col" class="th-title">제목</th>
						<th scope="col" class="th-name">작성자</th>
						<th scope="col" class="th-date">작성일</th>
						<th scope="col" class="th-view">조회수</th>
					</tr>
				</thead>
				<tbody>
				<%
				    for (BoardDto dto : lists) {
				        int num = dto.getNum();
				        String subject = dto.getSubject();
				        String name = dto.getName();
				        String reg_date = dto.getReg_date();
				        int view_cnt = dto.getView_cnt();
				%>
					<tr>
					<td><%= num %></td>
						<td class="subject"><a
							href="<%=articleUrl %>&num=<%=dto.getNum()%>"> <%= subject %></a>
						</td>
						<td><%= name %></td>
						<td><%= reg_date %></td>
						<td><%= view_cnt %></td>
					</tr>
				<% } %>
				</tbody>
			</table>
		</div>
	</div>
	<div class="container">
		<br>
		<br><%=pageIndexList %>
	</div>
</body>
</html>