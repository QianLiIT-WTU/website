<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/region.css" rel="stylesheet">
<title>千里IT-千里专区</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div class="wrapper">
		<div class="feature-con">
			<h1 class="title">千里IT</h1>
			<img src="${pageContext.request.contextPath}/img/line.png" class="line">
			<ul class="feature">
				<li class="feature-item">
					<div class="feature-pic"></div>
					<h2>特点一</h2>
				</li>
				<li class="feature-item">
					<div class="feature-pic"></div>
					<h2>特点二</h2>
				</li>
				<li class="feature-item">
					<div class="feature-pic"></div>
					<h2>特点三</h2>
				</li>
			</ul>
		</div>
		<div class="group-con">
			<ul class="group">
				<li class="group-item java-group">
					<div class="group-icon"></div>
					<p>小组介绍</p>
					<p>能学到什么</p>
					<p>可以从事的职业</p>
				</li>
				<li class="group-item web-group">
					<div class="group-icon"></div>
					<p>从网页到微信小程序到App再到桌面程序，从前端到MEAN全栈，JS无处不在。</p>
					<p>或者也许你想写写爬虫和机器学习什么的？</p>
				</li>
				<li class="group-item design-group">
					<div class="group-icon"></div>
					<p>小组介绍</p>
					<p>能学到什么</p>
					<p>可以从事的职业</p>
				</li>
				<li class="group-item wechat-group">
					<div class="group-icon"></div>
					<p>小组介绍</p>
					<p>能学到什么</p>
					<p>可以从事的职业</p>
				</li>
			</ul>
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>
<%@ include file="footer.jsp"%>
</html>