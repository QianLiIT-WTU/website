<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet">
<title>千里IT-登录</title>
</head>

<body>
	<div class="nav-simple">
		<div class="login-wrapper">
			<div class="logo"></div>
		</div>
	</div>
	<div class="login-center-wrap">
		<div class="login-wrapper">
			<form action="${pageContext.request.contextPath }/user/login" id="login-form" class="login" method="post">
				<div class="user-con">
					<div class="user-title">用户登录</div>
					<div class="user-box">
						<div class="error-item">
							<i class="fa fa-minus-circle error-icon"></i>
							<p class="error-msg" id="cue">${error }</p>
						</div>
						<div class="user-item">
							<label class="user-label">用户名 </label>
							<input class="user-content" name="username" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" placeholder="请输入用户名" autocomplete="off">
						</div>
						<div class="user-item">
							<label class="user-label">密码</label>
							<input class="user-content" name="password" onkeyup="this.value=this.value.replace(/\s+/g,'').replace(/[\u4e00-\u9fa5]/g, '')" type="password" placeholder="请输入密码"
								autocomplete="off">
						</div>
							<div>
						
						
							<img id="img" src="${pageContext.request.contextPath }/vcode"/>
								
                                     <input class="user-content" type="text" name="vCode" 
                                     placeholder="请输入验证码"  />
								
						</div>
						<br>
						<button type="button" class="btn btn-submit" onclick="check()">登录</button>
						<div class="link-item">
							<a class="link" href="${pageContext.request.contextPath }/view/findPsw.jsp" target="_self">找回密码</a>
							<a class="link" href="${pageContext.request.contextPath }/view/register.jsp" target="_self">点此注册</a>
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
		//获取表单、错误提示、字段
		let loginForm = document.getElementById("login-form");
		let cue = document.getElementById("cue");
		let usr = document.getElementsByName("username")[0];
		let psw = document.getElementsByName("password")[0];

		if (cue.innerText) {
			cue.parentNode.style.display = "block";
		}

		function checkUsr(value) {
			if (value) {
				return true;

			} else {
				cue.innerText = "请输入用户名";
				return false;
			}
		}

		function checkPsw(value) {
			if (value) {
				return true;
			} else {
				cue.innerText = "请输入密码";
				return false;
			}
		}

		function check() {
			cue.parentNode.style.display = "block";
			if (checkUsr(usr.value) && checkPsw(psw.value)) {
				cue.parentNode.style.display = "none";
				loginForm.submit();
			}
		}
	</script>
</body>

<!--
<body>
    <div class="wrapper">
        <div class="login-con">
            <form action="${pageContext.request.contextPath }/user/login" class="login" method="post">
                <h1 class="title">用户登录</h1>
                <input type="text" name="username" placeholder="用户名"><br>
                <input type="password" name="password" placeholder="密码"><br>
                <input type="submit" value="登录">
            </form>
            <div class="register-link"><a href="register.jsp">没有账号？点此注册</a></div>
        </div>
    </div>
<h2 align="center"  style="color:red"> ${error}</h2>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>
-->

</html>