<%@page import="com.board.dao.BoardDao"%>
<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.util.DBConn"%>
<%@page import="java.sql.Connection"%>
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
		} else {
				BoardDto dto = new BoardDto();
				BoardDao dao = new BoardDao();
				Connection conn = DBConn.getInstance();
				int maxNum = dao.getMaxNum();

				dto.setSubject(subject);
				dto.setName(name);
				dto.setContent(content);
				dto.setPw(pw);
				dto.setNum(maxNum + 1);

				dao.insertData(dto);
				DBConn.dbClose();
	%>
	<script>
		alert("등록되었습니다.");
		window.location.href = 'list.jsp';
	</script>

	<%
		}
		}
	%>
	<div class="page-title">
		<div class="container">
			<h3>공지사항 작성</h3>
		</div>
	</div>
	<form method="post" name="myForm">
	<div id="board-list">
		<div class="container">
			<table class="board-table">
				<tr>
					<th width="200">제목</th>
					<td class="td-left"><input type="text" name="subject"
						maxlength="200"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td class="td-left"><input type="text" name="name"
						maxlength="20"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td class="td-left"><textarea rows="12" cols="64"
							name="content"></textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td class="td-left"><input type="password" name="pw"
						maxlength="20"></td>
			</table>

		</div>
	</div>
	<br>
	<br>
	<div class="find-btn">
			<input type="submit" class="btn-dark find-btn1" value="등록 ">
			<input type="reset" class="btn-dark find-btn1" value="리셋"> 
			<input type="button" class="btn-dark find-btn1" value="리스트" onclick="window.location.href='list.jsp'">
		
	</div>
	</form>
</body>
</html>