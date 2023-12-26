<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원업무 데이터베이스 등록</title>
<style>
	html {
	  height: 100%;
	}
	body {
	  margin:0;
	  padding:0;
	  font-family: sans-serif;
	  background: #243b55;
	}
	
	.login-box {
	  position: absolute;
	  top: 50%;
	  left: 50%;
	  width: 400px;
	  padding: 40px;
	  transform: translate(-50%, -50%);
	  background: rgba(0,0,0,.5);
	  box-sizing: border-box;
	  box-shadow: 0 15px 25px rgba(0,0,0,.6);
	  border-radius: 10px;
	}
	
	.login-box h2 {
	  margin: 0 0 30px;
	  padding: 0;
	  color: #fff;
	  text-align: center;
	}
	
	.login-box .user-box {
	  position: relative;
	}
	
	.login-box .user-box input {
	  width: 100%;
	  padding: 10px 0;
	  font-size: 16px;
	  color: #fff;
	  margin-bottom: 30px;
	  border: none;
	  border-bottom: 1px solid #fff;
	  outline: none;
	  background: transparent;
	}
	.login-box .user-box label {
	  position: absolute;
	  top:0;
	  left: 0;
	  padding: 10px 0;
	  font-size: 16px;
	  color: #fff;
	  pointer-events: none;
	  transition: .5s;
	}
	
	.login-box .user-box input:focus ~ label,
	.login-box .user-box input:valid ~ label {
	  top: -20px;
	  left: 0;
	  color: #fff;
	  font-size: 12px;
	}
	
	.login-box form a input {
	  position: relative;
	  display: inline-block;
	  padding: 10px 20px;
	  color: #ffffff;
	  font-size: 16px;
	  background: rgba(0,0,0,.5);
	  text-decoration: none;
	  text-transform: uppercase;
	  overflow: hidden;
	  transition: .5s;
	  margin-top: 5px;
	  letter-spacing: 4px
	}
	
	
	.login-box a span {
	  position: absolute;
	  display: block;
	}

</style>
</head>
<body>
	<div class="login-box">
  <h2>Insert</h2>
  <form action="/HRproject/Jobs/insertDB.jobs" method="post">
    <div class="user-box">
      <input type="text" name="job_id" required="">
      <label>job_id</label>
    </div>
    <div class="user-box">
      <input type="text" name="job_title" required="">
      <label>job_title</label>
    </div>
    <div class="user-box">
      <input type="text" name="min_salary" required="">
      <label>min_salary</label>
    </div>
    <div class="user-box">
      <input type="text" name="max_salary" required="">
      <label>max_salary</label>
    </div>
    
     <a>
      <input type="submit" value="Register">
    </a>
    </form>
</body>
</html>