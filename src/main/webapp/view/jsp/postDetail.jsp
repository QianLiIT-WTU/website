<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/postDetail.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<title>千里IT-帖子详情</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#sent").click(function() {
			var options = {
				url : '${pageContext.request.contextPath }/conmment/Psavecomment',
				type : 'post',
				dataType : "json",//预期服务器返回的数据类型
				data : $("#saveComment").serialize(),
				success : function(data) {
					alert("发布成功");
					location.reload();
				
				},error:function() {
					alert("发布失败");
					location.reload();
				
				}
			};
			$.ajax(options);
			$("#content").text(" ");
			return false;
		});
	});
</script>

</head>
<%@ include file="header.jsp"%>
<body>
	<div class="wrapper">
		<div class="post-detail-con">
			<div class="post-detail">
				<h1 class="title">${post.title }</h1>
				<div class="author-info-block">
					<span class="catego">${post.bid.dict_item_name}</span>
					<span class="author">作者：${post.uid.username }</span>
					<span class="date">${post.create_time }</span>
					<span class="click">${post.click}点击</span>
				</div>
				<div class="content">
					<p>${post.content }</p>
				</div>
			</div>
			<c:if test="${post.status  eq  true }">
			<ul class="rely-con" id="commentlist">
				<li class="rely">
					<form id="saveComment">
						<textarea name="ccontent" class="new-rely" placeholder="请输入评论"></textarea>
						<input type="hidden" name="ppid" value="${post.pid }">
						<input type="hidden" name="uuid" value="${user.uid }">
						<div class="save-comment">
							<button id="sent">发布评论</button>
						</div>
					</form>
				</li>
				<c:forEach items="${post.commentList}" var="comment">
					<li class="rely">
						<div class="rely-info">
							<span class="users">${ comment.uid.username}</span>
							评论时间：<span class="date">${comment.ccreate_time }</span>
						</div>
						<div class="rely-content">${comment.ccontent}</div>
					</li>
				</c:forEach>
			</ul>
			</c:if>
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>
<%@ include file="footer.jsp"%>
</html>