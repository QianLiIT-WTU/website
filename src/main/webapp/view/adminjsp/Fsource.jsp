<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>千里IT后台管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/sockjs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		loadSelect("2", "sourceItem", "bbid");
		//发送消息
		$(document).ready(function() {
			$("#F").on("click", function() {
				sendMsg("该资源不符合要求");
			});
			$("#T").on("click", function() {
				sendMsg("该资源成功发布");
			});
		});
	});
</script>
<script type="text/javascript">
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

	//监听消息
	//onmessage事件提供了一个data属性，它可以包含消息的Body部分。消息的Body部分必须是一个字符串，可以进行序列化/反序列化操作，以便传递更多的数据。
	websocket.onmessage = function(event) {
		console.log('Client received a message', event);
		//var data=JSON.parse(event.data);
		var data = event.data;
		console.log("WebSocket:收到一条消息", data);

	};

	//监听WebSocket的关闭
	websocket.onclose = function(event) {

		console.log("WebSocket:已关闭：Client notified socket has closed", event);
	};

	//监听异常
	websocket.onerror = function(event) {

		console.log("WebSocket:发生错误 ", event);
	};

	//发送消息
	function sendMsg(msg) {
		//对象为空了
		if (websocket == undefined || websocket == null) {
			//alert('WebSocket connection not established, please connect.');
			alert('未连接session');
			return;
		}
		//获取用户要发送的消息内容

		var data = {};
		data["title"] = "资源审核";
		data["content"] = msg;

		data["touser"] = $("input:hidden[name='Userid']").val();

		//发送消息
		websocket.send(JSON.stringify(data));

	}

	//关闭Websocket连接
	function closeWebsocket() {
		if (websocket != null) {
			websocket.close();
			websocket = null;
		}

	}
</script>


</head>


<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<jsp:include page="adminHeader.jsp" flush="true" />

		<div class="page-content">
			<div class="layui-row" style="margin-bottom: 10px;">
				<a class="layui-btn" href="${pageContext.request.contextPath}/view/jsp/uploadPictureSource.jsp">上传文件</a>
				
			</div>
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search" action="${pageContext.request.contextPath }/source/getToAdmin" method="post">
					搜索：
					

					<div class="layui-inline">
						<input type="text" name="sname" placeholder="请输入资源名" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-inline">
						<input type="text" name="username" placeholder="请输入作者用户名" autocomplete="off" class="layui-input">
					</div>
					<button class="layui-btn">
						<i class="layui-icon">&#xe615;</i>
					</button>
					<!-- 隐藏域.当前页码 -->
					<input type="hidden" name="pn" id="currentPageInput" value="${page.pageNum }" />
				</form>
			</div>
			<span class="fr" style="line-height: 40px">共有数据：${pageInfo.total } 条</span>
			<table class="layui-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>标题</th>
						<th>缩略图</th>
						<th>上传时间</th>
						<th>状态</th>
						<th>所属分类</th>
						<th>作者</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list }" var="source">
						<tr>
							<td>${source.sid }</td>
							<td>${source.sname }</td>
							<c:if test="${empty source.videoImg }">
								<td>
									<img class="list-preview" src="${pageContext.request.contextPath }/${source.slink }">
								</td>
							</c:if>
							<c:if test="${not empty source.videoImg }">
								<td>
									<img class="list-preview" src="${pageContext.request.contextPath }/${source.videoImg }">
								</td>
							</c:if>
							<td>${source.create_time }</td>
							<td>
								<c:if test="${ source.status  eq  true }">过审</c:if>
								<c:if test="${ source.status  eq  false }">未过审</c:if>
							</td>
							<td>${source.bid.dict_item_name }</td>
							<td>${source.uid.username }</td>
							<td class="td-manage">
								<div class="layui-btn-group">
										<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }//source/AlookFile?sid=${source.sid }">浏览</a>
									<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/source/Fdelete?sid=${source.sid }">删除</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
				<a href="${pageContext.request.contextPath }/source/getToAdminFile?pn=${pageInfo.navigateFirstPage}&bbid=6">首页</a>
				<c:if test="${pageInfo.hasPreviousPage}">
					<a href="${pageContext.request.contextPath }/source/getToAdminFile?pn=${pageInfo.prePage}&bbid=6">上一页</a>
				</c:if>
				<c:if test="${!pageInfo.hasPreviousPage}">
					<a class="disabled-link">上一页</a>
				</c:if>
				<c:if test="${pageInfo.hasNextPage}">
					<a href="${pageContext.request.contextPath }/source/getToAdminFile?pn=${pageInfo.nextPage}&bbid=6">下一页</a>
				</c:if>
				<c:if test="${! pageInfo.hasNextPage}">
					<a class="disabled-link">下一页</a>
				</c:if>
				<a href="${pageContext.request.contextPath }/source/getToAdminFile?pn=${pageInfo.navigateLastPage}&bbid=6">尾页</a>
				<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/layui/layui.all.js "></script>
</body>

</html>