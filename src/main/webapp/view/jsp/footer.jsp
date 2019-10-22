<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<style>
.footer {
	width: 100%;
	background: url("${pageContext.request.contextPath}/img/bg.jpg") no-repeat;
	background-size: cover;
	font-size: 30px;
	color: #fff;
}

.footer-background {
	background: rgba(17, 47, 85, .6);
	padding: 50px 0;
}

.footer .inner {
	width: 980px;
	margin: 0 auto;
	overflow: hidden;
}

.footer .inner h2 {
	font-size: 20px;
	padding-bottom: 10px;
	border-bottom: 1px solid #fff;
}

.footer .intr {
	width: 560px;
	float: left;
	font-size: 12px;
	line-height: 24px;
}

.footer .intr h2 {
	margin-bottom: 40px;
}

.footer .contact {
	width: 280px;
	float: right;
}

.footer .contact h2 {
	margin-bottom: 20px;
}

.qr-code li {
	width: 90px;
	height: 90px;
	margin-right: 40px;
	float: left;
	position: relative;
	padding-bottom: 20px;
}

.qr-code .wechat {
	background: url("${pageContext.request.contextPath}/img/qr-wechat.jpg") content-box;
	background-size: cover;
}

.qr-code .qq {
	background: url("${pageContext.request.contextPath}/img/qr-qq.jpg") content-box;
	background-size: cover;
}

.qr-code span {
	width: 90px;
	text-align: center;
	font-size: 12px;
	top: 90px;
	position: absolute;
}
</style>
</head>

<body>
	<div class="footer">
		<div class="footer-background">
			<div class="inner">
				<div class="intr">
					<h2>学会介绍</h2>
					<p>千里IT学会创建于2007年9月29日，名称寓意“千里之行，始于足下”的实干精神。</p>
					<p>团队创立之初，由武汉纺织大学管理学院信管电商专业的学生组成，自成立以来，团队成员在对专业知识进行探讨、研究的同时，也开发了一批批IT项目，其中包括学校、企业、政府网站和App。</p>
				</div>
				<div class="contact">
					<h2>相关链接</h2>
					<ul class="qr-code">
						<li class="wechat">
							<span>微信公众号</span>
						</li>
						<li class="qq">
							<span>官方QQ号</span>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>

</html>