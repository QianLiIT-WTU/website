<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/alterPsw.css" rel="stylesheet">
<title>千里IT-密码修改</title>
</head>

<%@ include file="header.jsp"%>

<body>
	<div class="wrapper">
		<div class="user-con">
			<ul class="user-navbar">
				<li>
					<a href="${pageContext.request.contextPath }/user/findByUid?uid=${user.uid }">个人信息</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/view/jsp/alterInfo.jsp">资料修改</a>
				</li>
				<li>
					<a class="active" href="${pageContext.request.contextPath }/view/jsp/alterPsw.jsp">密码修改</a>
				</li>

				<li>
					<a href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}">我的帖子</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}">站内消息</a>
				</li>
			</ul>

			<div class="user-content">
				<form action="${pageContext.request.contextPath }/user/updatePsw" method="post">
					<input type="hidden" name="uid" value="${user.uid}">
					<input type="password" name="password" placeholder="原密码">
					<input type="password" name="password1" placeholder="新密码">
					<input type="password" placeholder="确认新密码">
					<input type="submit" value="确认修改">
				</form>
				<h2 align="center" style="color: red">${error}</h2>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

<%@ include file="footer.jsp"%>

</html>