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
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
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
</style>
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

				},
				error : function() {
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

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<jsp:include page="adminHeader.jsp" flush="true" />
		<div class="wrapper">
			<div class="video-con">
				<video src="${pageContext.request.contextPath }/${source.slink }" controls="controls">您的浏览器不支持播放视频。</video>
			</div>
			<div class="img-info">
				<p>标题：${source.sname } 上传者：${source.uid.username }</p>
				<p>介绍：${source.info }</p>
			    <a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/source/VupdateVStatus?sid=${source.sid}&status=1">
				<span id="T">过审</span>
			</a>
			<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/source/VupdateVStatus?sid=${source.sid}&status=0">
				<span id="F">不过审</span>
			</a>
			</div>
			
		</div>


	</div>
	
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

</html>