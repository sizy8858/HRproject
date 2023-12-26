<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 성공</title>
<style>
	html {
		height: 100%;
	}
	
	body {
		margin: 0;
		padding: 0;
		font-family: sans-serif;
		background: #243b55;
	}
	
	.admin_success {
		position: absolute;
		top: 50%;
		left: 50%;
		width: 450px;
		padding: 50px;
		transform: translate(-50%, -50%);
		background: rgba(0, 0, 0, .5);
		box-sizing: border-box;
		box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
		border-radius: 10px;
		text-align: center;
	}
	
	.admin_success h2 {
		margin: 0 0 30px;
		padding: 0;
		color: #fff;
		text-align: center;
	}
	
	.box {
		position: relative;
		left: 50px;
		display: flex;
		justify-content: center;
		align-items: center;
        width: 250px;
        height: 250px;
        border-radius: 70%;
        overflow: hidden;
    }
	
	.profile{
		width: 100%;
		height: 100%;
		object-fit: cover;
		display: block;
		margin: auto;
	}
	
	.bin{
		margin: 20px 0 0 10px;
	}
	
	p{
		margin: 0 0 30px;
		padding: 0;
		color: #fff;
		text-align: center;
		font-family: sans-serif;
	}
	
	a input {
		position: relative;
		display: inline-block;
		color: #ffffff;
		font-size: 16px;
		background: rgba(0, 0, 0, .5);
		text-decoration: none;
		text-transform: uppercase;
		overflow: hidden;
		transition: .5s;
		margin-top: 40px;
		letter-spacing: 4px;
	}
	
	.a1 input{
		padding: 10px 34px;
	}
	
	.a2 input{
		margin-left: 10px;
		padding: 10px 20px;
	}

</style>
</head>
<body>
	<%
		String lastName = (String) request.getAttribute("last_name");
	%>
	<div class="admin_success">
		<h2>ABC에 오신 것을 환영합니다!</h2>
		<div class="box">
			<img class="profile" src="../img/admin.png">
		</div>
		<div class="bin">
		
		</div>
		<p><%=lastName%>님</p>
		<a class="a1" href="/HRproject/Login/adminhtml.jsp"> <input type="submit" value="main"></a>
		<a class="a2" href="/HRproject/Login/login.Controller"> <input type="submit" value="logout"></a>
	</div>
</body>
</html>