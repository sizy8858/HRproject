<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
<%@page import="com.board.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

	//list.jsp에서 num을 가져온다
	int num = Integer.parseInt(request.getParameter("num"));
	//list.jsp에서 pageNum을 가져온다
	String pageNum = request.getParameter("pageNum");

	//검색
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");

	if (searchValue != null) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
	} else {
		searchKey = "subject";
		searchValue = "";
	}

	Connection conn = DBConn.getInstance();
	BoardDao dao = new BoardDao();

	//조회수 증가
	dao.updateViewCount(num);

	//글 가져오기
	BoardDto dto = dao.getReadData(num);

	if (dto == null) {
		response.sendRedirect("lists.jsp");
	}

	//글 엔터를 <br/>로 변경
	dto.setContent(dto.getContent().replace("\n", "<br />"));

	//검색
	String param = "";

	//null이 아니면 검색을 한 것이다.
	if (!searchValue.equals("")) {
		//검섹 주소 생성
		param = "&searchKey=" + searchKey;
		param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
	}

	DBConn.dbClose();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="board.css">
</head>
<body>
	<div class="page-title">
		<div class="container">
			<h3>공지사항</h3>
		</div>
	</div>
	<div id="board-list">
		<div class="container">
			<table class="board-table">
				<tr>
					<th width="200">제목</th>
					<td class="td-left"><%=dto.getSubject()%></th>
				</tr>
				<tr>
					<th>작성자</th>
					<td class="td-left"><%=dto.getName()%></td>
				</tr>
				<tr>
					<th>등록일</td>
					<td class="td-left"><%=dto.getReg_date()%></td>
				</tr>
				<tr>
					<th>조회수</td>
					<td class="td-left"><%=dto.getView_cnt()%></td>
				</tr>
				<tr>
					<td colspan=2 class="td-left"><%=dto.getContent()%></td>
				</tr>
			</table>
		</div>
	</div>
	<br>
	<br>
	<div class="find-btn">
		<input type="button" value=" 리스트 " class="btn-dark find-btn1"
		onclick="javascript:location.href='userList.jsp?pageNum=<%=pageNum%><%=param%>';" />
	</div>
</body>
</html>