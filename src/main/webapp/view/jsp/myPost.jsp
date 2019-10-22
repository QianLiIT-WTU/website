<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/myPost.css" rel="stylesheet">
<script type="text/javascript" src='${pageContext.request.contextPath }/js/jquery-1.4.4.min.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<title>千里IT-我的帖子</title>
</head>

<%@ include file="header.jsp"%>

<body>
	<div class="wrapper">
		<div class="user-con">
			<ul class="user-navbar">
				<li>
					<a href="${pageContext.request.contextPath }/user/findByUid?uid=${user.uid }">个人信息</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/view/jsp/alterInfo.jsp">资料修改</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/view/jsp/alterPsw.jsp">密码修改</a>
				</li>
				<li>
					<a class="active" href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}">我的帖子</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}">站内消息</a>
				</li>
			</ul>

			<div class="user-content">
				<ul class="post-list f-light">
					<c:forEach items="${pageInfo.list }" var="post">
						<li onclick="window.open('${pageContext.request.contextPath }/post/Info?pid=${post.pid}')">
							<div class="post-list-left">
								<div class="catego">
									<c:if test="${post.status == true}">已过审</c:if>
									<c:if test="${post.status == false}">未过审</c:if>
								</div>
								<div class="title">${post.title}</div>
								<div class="author">${post.click }浏览</div>
							</div>
							<div class="post-list-right">
								<div class="click" onclick="deletePost(event)" pid="${post.pid}">删除</div>
								<c:if test="${post.status == false}">
									<div class="click">
										<a onclick="stopBubble(event)" href="${pageContext.request.contextPath }/post/edit?pid=${post.pid}">修改</a>
									</div>
								</c:if>
								<div class="date">${post.create_time }</div>
							</div>
						</li>
					</c:forEach>
				</ul>
				<div class="page">
					<a href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}&pn=${pageInfo.navigateFirstPage}">首页</a>
					<c:if test="${pageInfo.hasPreviousPage}">
						<a href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}&pn=${pageInfo.prePage}">上一页</a>
					</c:if>
					<c:if test="${!pageInfo.hasPreviousPage}">
						<a class="disabled-link">上一页</a>
					</c:if>
					<c:if test="${pageInfo.hasNextPage}">
						<a href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}&pn=${pageInfo.nextPage}">下一页</a>
					</c:if>
					<c:if test="${! pageInfo.hasNextPage}">
						<a class="disabled-link">下一页</a>
					</c:if>
					<a href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}&pn=${pageInfo.navigateLastPage}">尾页</a>
					<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
				</div>
			</div>
		</div>
	</div>

	<script>
		function stopBubble(e) {//阻止事件冒泡到外层div上（会触发打开帖子的事件），if-else是兼容IE
			if (e && e.stopPropagation) {
				e.stopPropagation();
			} else {
				window.event.cancelBubble = true;
			}
		}

		function deletePost(e) {
			stopBubble(e);
			let src = e.srcElement ? e.srcElement : e.target;//获得触发事件的元素
			let pid = src.getAttribute("pid");//通过自定义属性获得pid
			console.log(pid);
			$.ajax({
				type : "post", //数据提交方式（post/get）
				url : "${pageContext.request.contextPath }/post/mydelete", //提交到的url
				data : {
					"pid" : pid
				},//提交的数据
				dataType : "json",//返回的数据类型格式
				success : function(data) {
					//修改成功
					//修改成功处理代码${pageContext.request.contextPath}.
					alert(data);

					location.reload();//页面刷新
				},
				error : function() {

					alert("删除失败");
					location.reload();//页面刷新
				}

			});

		}
	</script>

</body>

<%@ include file="footer.jsp"%>

</html>