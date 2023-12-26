<%@page import="com.board.dao.BoardDao"%>
<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="board.css">
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String cp = request.getContextPath();

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

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
		BoardDto dto = dao.getReadData(num);
		String oldPw = dto.getPw();

		if (request.getMethod().equals("POST")) {
			String subject = request.getParameter("subject");
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			String pw = request.getParameter("pw");

			if (subject.equals("") || name.equals("") || content.equals("") || pw.equals("")) {
	%>
	<script>
		alert("입력되지 않은 항목이 있습니다.");
	</script>
	<%
		} else if (!oldPw.equals(pw)) {
	%>
	<script>
		alert("패스워드가 일치하지 않습니다.");
	</script>
	<%
		} else {
				dto.setSubject(subject);
				dto.setName(name);
				dto.setContent(content);
				dto.setPw(pw);

				dao.updateData(dto);
	%>
	<script>
		alert("등록되었습니다.");
		window.location.href = 'list.jsp';
	</script>

	<%
		}
		}
		DBConn.dbClose();
	%>
	<div class="page-title">
		<div class="container">
			<h3>작성글 수정</h3>
		</div>
	</div>
	<form method="post" name="myForm">
	<div id="board-list">
		<div class="container">
			
				<table class="board-table">
					<tr>
						<th width="200">제목</th>
						<td class="td-left"><input type="text" name="subject"
							value="<%=dto.getSubject()%>" maxlength="200"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td class="td-left"><input type="text" name="name" value="<%=dto.getName()%>"
							size="65" maxlength="20"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td class="td-left"><textarea rows="12" cols="64" name="content"><%=dto.getContent()%></textarea></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td class="td-left"><input type="password" name="pw" size="65" maxlength="20"></td>
					</tr>
				</table>
			
		</div>
	</div>
	<br><br>
	
	<div class="find-btn">
		<input type="submit" class="btn-dark find-btn1" value="수정하기 ">
		<input type="button" class="btn-dark find-btn1" value="목록으로" onclick="javascript:location.href='list.jsp';">
	</div>
	</form>
</body>
</html>