<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/postDetail.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/course.css" />
<style>
.view-img {
	width: 800px;
	margin: 40px auto;
}

.img-con img {
	width: 100%;
}

.img-info {
	width: 400px;
	font-size: 14px;
	margin: 0 auto;
	margin-top: 20px;
	color: #777;
}

.download-img {
	display: block;
	width: 140px;
	height: 36px;
	line-height: 36px;
	margin: 20px auto;
	border-radius: 10px;
	font-size: 18px;
	color: #fff;
	transition: 0.2s all linear;
	background: #5991d4;
	text-align: center;
}

.download-img:hover {
	color: #fff;
	box-shadow: #d8dde1 2px 4px 8px;
}

.rely-con {
	width: 800px;
	margin: 0 auto;
}

.rely-con, .rely {
	padding: 20px 20px;
}

.rely {
	border-top: 1px solid #f1f1f1;
}

.rely .new-rely {
	width: 100%;
	height: 100px;
	padding: 8px;
	box-sizing: border-box;
}

.save-comment {
	text-align: right;
	margin-top: 20px;
}

.save-comment button {
	width: 70px;
	height: 28px;
	border-radius: 2px;
	background: #5991d4;
	color: #fff;
	border: none;
	font-size: 12px;
	line-height: 28px;
	text-align: center;
}

.rely-info {
	text-align: left;
	color: #71777c;
	font-size: 12px;
}

.rely-content {
	min-height: 40px;
	margin-top: 20px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#sent").click(function() {
			var options = {
				url : '${pageContext.request.contextPath }/conmment/Ssavecomment',
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
		<div class="video-con">
			<video src="${pageContext.request.contextPath }/${source.slink }" controls="controls">您的浏览器不支持播放视频。</video>
		</div>
        <div class="img-info">
			<p>标题：${source.sname } 上传者：${source.uid.username }</p>
			<p>介绍：${source.info }</p>
		</div>
			<a class="download-img" href="${pageContext.request.contextPath }/source/downloadVic?sid=${source.sid }">下载</a>
	</div>
<!--  -->
	<ul class="rely-con" id="commentlist">
				<li class="rely">
					<form id="saveComment">
						<textarea name="ccontent" class="new-rely" placeholder="请输入评论"></textarea>
						<input type="hidden" name="sid" value="${source.sid }">
						<input type="hidden" name="uuid" value="${user.uid }">
						<div class="save-comment">
							<button id="sent">发布评论</button>
						</div>
					</form>
				</li>
				<c:forEach items="${source.commentList}" var="comment">
					<li class="rely">
						<div class="rely-info">
							<span class="users">${ comment.uid.username}</span>
							评论时间：<span class="date">${comment.ccreate_time }</span>
						</div>
						<div class="rely-content">${comment.ccontent}</div>
					</li>
				</c:forEach>
			</ul>
	

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

</body>
<%@ include file="footer.jsp"%>
</html>