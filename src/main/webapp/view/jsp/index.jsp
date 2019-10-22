<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<base target="main">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">
<title>千里IT-首页</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="wrapper">
		<!-- 图片轮播 S-->
		<div class="in exhibition_hall">
			<div class="roundabout_box">
				<ul id="image">
				</ul>
			</div>
		</div>
		<!-- 图片轮播 E-->
		<div class="course-wrapper">
			<ul id="video" class="course">
			</ul>
			<a href="${pageContext.request.contextPath }/source/getAllSource" class="btn">全部资源</a>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/roundabout/2.4.2/jquery.roundabout.min.js"></script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					//图片轮播
					$.ajax({
						type : 'post',
						url : '${pageContext.request.contextPath }/image/findAllToJsp',
						dataType : "json",//预期服务器返回的数据类型
						success : function(data) {
							let content = "";
							$.each(data, function(n, img) {
								content += "<li><a href='" + img.ilink + "'target='_blank'><img src='"+img.ilink +"'></a><span class='text'>" + img.title + "</span></li>";
							});
							$("#image").html(content);
							$('.roundabout_box ul').roundabout({
								duration : 600,//运动速度
								minScale : 0.6,//非焦点图片的尺寸
								autoplay : true,//自动播放
								autoplayDuration : 2000,//自动播放速度
								minOpacity : 0.2,//最低透明度
								maxOpacity : 1,//最高透明度
								reflect : false,//从左向右移动
								startingChild : 1,//默认显示第几张图片
								autoplayInitialDelay : 200,//第一次从第几毫秒开始自动播放
								autoplayPauseOnHover : true,//鼠标悬停时停止自动播放
								enableDrag : true
							//允许拖拽（针对移动端）
							});
						}
					});
					//教程
					$.ajax({
						type : 'post',
						url : '${pageContext.request.contextPath }/source/getHotSource',
						dataType : "json",//预期服务器返回的数据类型
						success : function(data) {
							
							
							let content = "";
							$.each(data.list, function(n, source) {
								
								if(source.bid.bid == 6){
									content += "<li class='course-item' onclick='window.open("+'"${pageContext.request.contextPath }/source/lookPic?sid=' + source.sid + '"'+")'>"
									+ "<div class='course-pic'><img src='" + ("${pageContext.request.contextPath }/"+source.videoImg || "${pageContext.request.contextPath}/img/default-thumbnail.jpg") + "'><i class='course-author'>上传者："
									+ source.uid.username + "</i></div>" + "<div class='course-label f-light'>" + source.sname + "</div></li>";
								}else  if(source.bid.bid == 7){
									content += "<li class='course-item' onclick='window.open("+'"${pageContext.request.contextPath }/source/lookVid?sid=' + source.sid + '"'+")'>"
									+ "<div class='course-pic'><img src='" + ("${pageContext.request.contextPath }/"+source.videoImg || "${pageContext.request.contextPath}/img/default-thumbnail.jpg") + "'><i class='course-author'>上传者："
									+ source.uid.username + "</i></div>" + "<div class='course-label f-light'>" + source.sname + "</div></li>";
								}else  if(source.bid.bid == 8){
									content += "<li class='course-item' onclick='window.open("+'"${pageContext.request.contextPath }/source/lookFile?sid=' + source.sid + '"'+")'>"
									+ "<div class='course-pic'><img src='" + ("${pageContext.request.contextPath }/"+source.videoImg || "${pageContext.request.contextPath}/img/default-thumbnail.jpg") + "'><i class='course-author'>上传者："
									+ source.uid.username + "</i></div>" + "<div class='course-label f-light'>" + source.sname + "</div></li>";
								}
							
							});
							$("#video").html(content);
						}
					});
				});
	</script>

	<%@ include file="footer.jsp"%>

</body>
</html>