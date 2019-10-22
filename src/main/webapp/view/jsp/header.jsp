<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<style>
.header {
	width: 100%;
	box-shadow: 0 4px 8px #ebf2fb;
	background: url("${pageContext.request.contextPath}/img/intr.jpg") no-repeat;
	background-size: cover;
	background-position: 0 -300px;
}

.user-background {
	background: rgba(17, 47, 85, .6);
}

.user-wrapper {
	width: 960px;
	max-width: 960px;
	height: 60px;
	margin: 0 auto;
}

.user {
	height: 60px;
	float: right;
	line-height: 60px;
	color: #fff;
}

.user li {
	float: right;
}

.user a {
	width: 60px;
	height: 100%;
	display: block;
	padding: 0;
}

.user .message a {
	width: 80px;
	font-size: 12px;
}

.user .avater img {
	display: block;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	padding: 15px 15px;
}

.nav-background {
	background: rgba(89, 145, 212, .9);
}

.nav-wrapper {
	width: 960px;
	max-width: 960px;
	height: 70px;
	margin: 0 auto;
}

.nav-wrapper .logo {
	float: left;
	width: 140px;
	height: 100%;
	background: url("${pageContext.request.contextPath}/img/logo.png") no-repeat;
	background-position: 0 5px;
}

.nav {
	height: 70px;
	float: right;
	line-height: 70px;
	color: #fff;
}

.nav>li {
	float: left;
}

.nav a {
	width: 70px;
	height: 100%;
	display: block;
	padding: 0;
	text-align: center;
	position: relative;
	transition: 0.2s all linear;
}

.nav .region  a {
	width: 100px;
}

/*下划线跟随效果 S*/
.nav a::before {
	content: "";
	position: absolute;
	top: -3px;
	left: 100%;
	width: 0;
	height: 100%;
	border-bottom: 2px solid #112F55;
	transition: 0.2s all linear;
}

.nav a:hover::before {
	width: 100%;
	top: -3px;
	left: 0;
	transition-delay: 0.1s;
	border-bottom-color: #112F55;
	z-index: 1;
}

.nav a:hover ~ .nav a::before { /*a被li包裹，并不是相邻的，所以这里不起效果*/
	left: 0;
}

.nav a:active {
	background: #112F55;
	color: #fff;
}

/*下划线跟随效果 E*/
@media ( max-width : 980px) {
	.user-wrapper, .nav-wrapper {
		width: 98%;
	}
}

@media ( min-width : 1400px) {
	.nav-wrapper a {
		font-size: 12px;
	}
	.user .message  a {
		width: 130px;
	}
}
</style>
<script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	// 创建一个Socket实例
	//参数为URL，ws表示WebSocket协议。onopen、onclose和onmessage方法把事件连接到Socket实例上。每个方法都提供了一个事件，以表示Socket的状态。
	var websocket;
	//不同浏览器的WebSocket对象类型不同
	
	var host = window.location.host;
	if ('WebSocket' in window) {
		// alert("您的浏览器支持 WebSocket!");
		websocket = new WebSocket("ws://" + host + "/website/websocket/socketServer");
		console.log("=============WebSocket");
		//火狐
	} else if ('MozWebSocket' in window) {
		websocket = new MozWebSocket("ws://" + host + "/website/websocket/socketServer");
		console.log("=============MozWebSocket");
	} else {
		websocket = new SockJS("http://" + host + "/website/sockjs/socketServer");
		console.log("=============SockJS");
	}
	console.log("ws://" + host + "/website/websocket/socketServer");
	//打开Socket,
	websocket.onopen = function(event) {
		console.log("WebSocket:已连接");
	}

	websocket.onmessage = function(evt) {
		console.log('Client received a message', event);
		//var data=JSON.parse(event.data);
		var data = event.data;
		console.log("WebSocket:收到一条消息", data);
		//判断是否是欢迎消息（没用户编号的就是欢迎消息）
		if (data.from == undefined || data.from == null || data.from == "") {
			//===系统消息
			$('#count').text(data);
		}
	}
	websocket.onclose = function() {
		// 关闭 websocket
		// alert("websocket连接已关闭${pageContext.request.contextPath}."); 
	}
	
	websocket.onerror = function(event) {
		
	};
</script>
</head>

<body>
	<div class="header f-focus">
		<div class="user-background">
			<div class="user-wrapper">
				<ul class="user">
					<li class="avater">
						<c:choose>
							<c:when test="${user  eq  null }">
								<img src="${pageContext.request.contextPath}/img/header_photo.jpg">
							</c:when>
							<c:when test="${user.photoaddress  eq  null }">
								<a href="${pageContext.request.contextPath }/user/findByUid?uid=${user.uid }">
							<img src="${pageContext.request.contextPath}/img/header_photo.jpg">
						</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath }/user/findByUid?uid=${user.uid }">
									<img src="${user.photoaddress}">
								</a>
							</c:otherwise>
						</c:choose>
					</li>
					<li class="message">
						<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}">
							未读消息：
							<span id="count"></span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="nav-background">
			<div class="nav-wrapper">
				<div class="logo"></div>
				<ul class="nav">
					<li>
						<a href="${pageContext.request.contextPath}/view/jsp/index.jsp">首页</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/source/getAllSource">资源</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/post/postlist">帖子</a>
					</li>
					<li class="region">
						<a href="${pageContext.request.contextPath}/view/jsp/region.jsp">关于千里</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>

</html>