<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>千里IT后台管理系统-帖子详情</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/sockjs.min.js"></script>
<script type="text/javascript">
	


	


</script>

</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<jsp:include page="adminHeader.jsp" flush="true" />

		<div class="page-content">
			<div class="post-detail-con">
				<h2 class="title">帖子详情</h2>
				<div class="post-detail">
					<h2 class="title">${post.title }</h2>
					<div class="info">
						<span class="author">${post.uid.username }</span>
						<span class="date">发布时间：${post.create_time }</span>
						<span class="catego">${post.bid.dict_item_name}</span>
						<span>点击量:${post.click}</span>
						<input type="hidden" name="Userid" value="${post.uid.uid }" />
					</div>
					<div class="content">
						<p>${post.content }</p>
					</div>
				</div>

				<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/post/updateStatus?pid=${post.pid}&status=1">
					<span id="T">过审</span>
				</a>
				<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/post/updateStatus?pid=${post.pid}&status=0">
					<span id="F">不过审</span>
				</a>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

</html>