<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet">
<title>千里IT-注册</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
</head>


<body>
	<div class="nav-simple">
		<div class="login-wrapper">
			<div class="logo"></div>
		</div>
	</div>
	<div class="register-center-wrap">
		<div class="login-wrapper">
			<form action="${pageContext.request.contextPath }/user/regist" id="register-form" class="register" method="post">
				<div class="user-con">
					<div class="user-title">用户注册</div>
					<div class="user-box">
						<div class="error-item">
							<i class="fa fa-minus-circle error-icon"></i>
							<p class="error-msg" id="cue">${error }</p>
						</div>
						<div class="user-item">
							<label class="user-label">用户名 </label>
							<input class="user-content" name="username"  value="${user.username }" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" placeholder="请输入用户名" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label">密码</label>
							<input class="user-content" name="password"   value="${user.password }" onkeyup="this.value=this.value.replace(/\s+/g,'').replace(/[\u4e00-\u9fa5]/g, '')" type="password" placeholder="请输入密码"
								autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label">确认密码</label>
							<input class="user-content" name="password-confirm"  value="${user.password }" onkeyup="this.value=this.value.replace(/\s+/g,'').replace(/[\u4e00-\u9fa5]/g, '')" type="password"
								placeholder="请再次输入密码以确认" autocomplete="off">
						</div>
						<div class="user-item">
							<select name="year">
								<option value='' disabled selected style='display: none;'>请选择加入年份</option>
								<option value="2009年">2007年</option>
								<option value="2009年">2008年</option>
								<option value="2009年">2009年</option>
								<option value="2010年">2010年</option>
								<option value="2011年">2011年</option>
								<option value="2012年">2012年</option>
								<option value="2013年">2013年</option>
								<option value="2014年">2014年</option>
								<option value="2015年">2015年</option>
								<option value="2016年">2016年</option>
								<option value="2017年">2017年</option>
								<option value="2018年">2018年</option>
									<option value="2018年">2019年</option>
							</select>
						</div>
						<div class="user-item">
							<select name="sex">
								<option value='' disabled selected style='display: none;'>请选择性别</option>
								<option value="0">男</option>
								<option value="1">女</option>
							</select>
						</div>
						<div class="user-item" id="useritem"></div>
						<div class="user-item">
							<label class="user-label">邮箱</label>
							<input class="user-content" name="mail" value="${user.mail }" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="email" placeholder="请输入常用邮箱地址" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label">电话</label>
							<input class="user-content" name="phone" value="${user.phone }" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="email" placeholder="请输入常用电话" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label">设置问题</label>
							<input class="user-content" name="question" value="${user.question }" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" placeholder="请输入找回密码问题" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label">设置答案</label>
							<input class="user-content" name="answer" value="${user.answer }"  onkeyup="this.value=this.value.replace(/\s+/g,'')" type="password" placeholder="请输入找回密码答案" autocomplete="off">
						</div>
						<button type="button" class="btn btn-submit" onclick="check()">注册</button>
						<div class="link-item">
							<a class="link" href="${pageContext.request.contextPath }/view/login.jsp" target="_self">点此登录</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<div class="login-wrappper">
			<div class="links">
				<a href="#" class="link">论坛</a>
				|
				<a href="#" class="link">作品</a>
				|
				<a href="#" class="link">教程</a>
				|
				<a href="#" class="link">链接</a>
			</div>
			<p class="copyright">千里之行，始于足下。</p>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			loadSelect("1", "useritem", "bbid");
		});

		//获取表单、错误提示、字段
		let registerForm = document.getElementById("register-form");
		let cue = document.getElementById("cue");
		let usr = document.getElementsByName("username")[0];
		let psw = document.getElementsByName("password")[0];
		let psw2 = document.getElementsByName("password-confirm")[0];
		let year = document.getElementsByName("year")[0];
		let sex = document.getElementsByName("sex")[0];
		let mail = document.getElementsByName("mail")[0];
		let question = document.getElementsByName("question")[0];
		let answer = document.getElementsByName("answer")[0];

		if (cue.innerText) {
			cue.parentNode.style.display = "block";
		}

		function checkUsr(value) {
			if (value) {
				if (value.length < 3) {
					cue.innerText = "用户名至少为3个字符";
					return false;
				} else if (value.length > 10) {
					cue.innerText = "用户名至多为10个字符";
					return false;
				} else {
					return true;
				}
			} else {
				cue.innerText = "请输入用户名";
				return false;
			}
		}

		function checkPsw(value) {
			if (value) {
				if (value.length < 6) {
					cue.innerText = "密码至少为6个字符";
					return false;
				} else if (value.length > 20) {
					cue.innerText = "密码至多为20个字符";
					return false;
				} else if (!/[^\d]/g.test(value)) {
					cue.innerText = "密码不能全为数字";
					return false;
				} else if (!/[^a-zA-Z]/g.test(value)) {
					cue.innerText = "密码不能全为字母";
					return false;
				} else {
					return true;
				}
			} else {
				cue.innerText = "请输入密码";
				return false;
			}
		}

		function confirmPsw(value) {
			if (value) {
				if (value !== psw.value) {
					cue.innerText = "两次输入的密码不一致";
					return false;
				} else {
					return true;
				}
			} else {
				cue.innerText = "请确认密码";
				return false;
			}
		}

		function checkYear(value) {
			if (value) {
				return true;
			} else {
				cue.innerText = "请选择加入年份";
				return false;
			}
		}

		function checkSex(value) {
			if (value) {
				return true;
			} else {
				cue.innerText = "请选择性别";
				return false;
			}
		}

		function checkMail(value) {
			if (value) {
				if (!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(value)) {
					cue.innerText = "邮箱格式有误";
					return false;
				} else {
					return true;
				}
			} else {
				cue.innerText = "请输入邮箱";
				return false;
			}
		}

		function checkQuestion(value) {
			if (value) {
				return true;
			} else {
				cue.innerText = "请输入找回密码问题";
				return false;
			}
		}

		function checkAnswer(value) {
			if (value) {
				return true;
			} else {
				cue.innerText = "请输入找回密码答案";
				return false;
			}
		}

		function check() {
			cue.parentNode.style.display = "block";
			if (checkUsr(usr.value) && checkPsw(psw.value) && confirmPsw(psw2.value) && checkYear(year.value) && checkSex(sex.value) && checkMail(mail.value)
					&& checkQuestion(question.value) && checkAnswer(answer.value)) {
				cue.parentNode.style.display = "none";
				registerForm.submit();
			}
		}
	</script>

</body>

<!--
<body>
	<h2 align="center" style="color: red">${error}</h2>
	<div class="wrapper">
		<div class="register-con">
			<form action="${pageContext.request.contextPath }/user/regist" class="register" method="post">
				<h1 class="title">用户注册</h1>
				<input type="text" name="username" placeholder="用户名">
				<br>
				<input type="password" name="password" placeholder="密码">
				<br>
				<input type="password" id="password-confirm" placeholder="确认密码">
				<br>
				<select name="year">
					<option value="2009年">2009年</option>
					<option value="2010年">2010年</option>
					<option value="2011年">2011年</option>
					<option value="2012年">2012年</option>
					<option value="2013年">2013年</option>
					<option value="2014年">2014年</option>
					<option value="2015年">2015年</option>
					<option value="2016年">2016年</option>
					<option value="2017年">2017年</option>
					<option value="2018年">2018年</option>

				</select>
				<br>
				<select name="sex">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
				<br>
				<span id="useritem"></span>
				<br>
				<input type="email" name="mail" placeholder="邮箱">
				<br>
				<input type="text" name="question" placeholder="找回密码问题">
				<br>
				<input type="text" name="answer" placeholder="找回密码答案">
				<br>
				<input type="submit" value="注册">
			</form>
			<div class="login-link">
				<a href="login.jsp">已有账号？点此登录</a>
			</div>
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>
-->

</html>