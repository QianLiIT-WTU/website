<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/userInfo.css" rel="stylesheet">
<title>千里IT-个人信息</title>
</head>

<%@ include file="header.jsp"%>

<body>
	<div class="wrapper">
		<div class="user-con">
			<ul class="user-navbar">
				<li>
					<a class="active" href="${pageContext.request.contextPath }/user/findByUid?uid=${user.uid }">个人信息</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/view/jsp/alterInfo.jsp">资料修改</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/view/jsp/alterPsw.jsp">密码修改</a>
				</li>

				<li>
					<a href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}">我的帖子</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}">站内消息</a>
				</li>
			</ul>
			<div class="user-content">
				<div class="item">
					<div class="title">头像</div>
					<div class="item-content">
						<c:choose>
							<c:when test="${user.photoaddress eq null}">
								<img class="avater" src="${pageContext.request.contextPath}/img/header_photo.jpg">
							</c:when>
							<c:otherwise>
								<img class="avater" src="${user.photoaddress}">
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="item">
					<div class="title">用户名 </div>
					<div class="item-content">${user.username }</div>
				</div>
				<div class="item">
					<div class="title">加入时间</div>
					<div class="item-content">${user.year}</div>
				</div>
				<div class="item">
					<div class="title">性别</div>
					<div class="item-content">
						<c:if test="${user.sex eq false}"> 男  </c:if>
						<c:if test="${user.sex eq true}"> 女  </c:if>
					</div>
				</div>
				<div class="item">
					<div class="title">邮箱</div>
					<div class="item-content">${user.mail}</div>
				</div>
					<div class="item">
					<div class="title">手机</div>
					<div class="item-content">${user.phone}</div>
				</div>
				<div class="item">
					<div class="title">权限</div>
					<div class="item-content">
						<div class="item-content">
							<c:if test="${user.root eq 1}"> 账号未激活  </c:if>
							<c:if test="${user.root eq 2}"> 注册会员  </c:if>
							<c:if test="${user.root eq 3}">千里会员</c:if>
							<c:if test="${user.root eq 4}">管理员</c:if>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="title">组别</div>
					<div class="item-content">${user.bid.dict_item_name}</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

<%@ include file="footer.jsp"%>

</html>