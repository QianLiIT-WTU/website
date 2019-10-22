<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet">
<style>
.hidden {
	display: none;
}
</style>
<title>千里IT-找回密码</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
</head>


<body>
	<div class="nav-simple">
		<div class="login-wrapper">
			<div class="logo"></div>
		</div>
	</div>
	<div class="register-center-wrap">
		<div class="login-wrapper">
			<form action="${pageContext.request.contextPath }/user/findPsw" id="register-form" class="register" method="post">
				<div class="user-con">
					<div class="user-title">找回密码</div>
					<div class="user-box">


						<div class="error-item">
							<i class="fa fa-minus-circle error-icon"></i>
							<p class="error-msg" id="cue">${error }</p>
						</div>



						<div class="user-item">
							<label class="user-label">用户名</label>
							<input class="user-content" name="username" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" placeholder="请输入用户名" autocomplete="off">
						</div>

						<button type="button" class="btn btn-submit" id="username-btn" onclick="getQuestion()">确定</button>


						<div class="user-item hidden">
							<label class="user-label">新密码</label>
							<input class="user-content" name="password" onkeyup="this.value=this.value.replace(/\s+/g,'').replace(/[\u4e00-\u9fa5]/g, '')" type="password" placeholder="请输入密码"
								autocomplete="off">
						</div>
						<div class="user-item hidden">
							<label class="user-label">确认密码</label>
							<input class="user-content" name="password-confirm" onkeyup="this.value=this.value.replace(/\s+/g,'').replace(/[\u4e00-\u9fa5]/g, '')" type="password"
								placeholder="请再次输入密码以确认" autocomplete="off">
						</div>

						<div class="user-item hidden">
							<label class="user-label">问题</label>
							<input class="user-content" name="question" disabled onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" autocomplete="off">
						</div>
						<div class="user-item hidden">
							<label class="user-label">答案</label>
							<input class="user-content" name="answer" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="password" placeholder="请输入找回密码答案" autocomplete="off">
						</div>
						<button type="button" class="btn btn-submit hidden" id="alter-psw-btn" onclick="check()">重置密码</button>
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
				<a href="#" class="link">图文</a>
				|
				<a href="#" class="link">视频</a>
				|
				<a href="#" class="link">教程</a>
			</div>
			<p class="copyright">千里之行，始于足下。</p>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			//loadSelect("1","useritem","dict_item.dict_id", <s:if test="#user.dict_item!=null">,<s:property value="#user.dict_item.dict_id" /></s:if>);
			loadSelect("1", "useritem", "bbid");
		});

		//获取表单、错误提示、字段
		let registerForm = document.getElementById("register-form");
		let cue = document.getElementById("cue");
		let usr = document.getElementsByName("username")[0];
		let psw = document.getElementsByName("password")[0];
		let psw2 = document.getElementsByName("password-confirm")[0];
		let question = document.getElementsByName("question")[0];
		let answer = document.getElementsByName("answer")[0];
		let usernameBtn = document.getElementById("username-btn");
		let alterPswBtn = document.getElementById("alter-psw-btn");

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
			if (checkUsr(usr.value) && checkPsw(psw.value) && confirmPsw(psw2.value) && checkAnswer(answer.value)) {
				cue.parentNode.style.display = "none";
				registerForm.submit();
			}
		}

		function getQuestion() {
			$.post("${pageContext.request.contextPath }/user/findUser", {
				username : usr.value
			}, function(data) {
				if (data === null) {
					cue.innerText = "该用户不存在";
					cue.parentNode.style.display = "block";
				} else {
					cue.parentNode.style.display = "none";
					question.value = data.question;
					usr.parentNode.style.display = "none";
					usernameBtn.style.display = "none";
					psw.parentNode.style.display = "block";
					psw2.parentNode.style.display = "block";
					question.parentNode.style.display = "block";
					answer.parentNode.style.display = "block";
					alterPswBtn.style.display = "block";
				}
			}, "json");
		}
	</script>

</body>

</html>