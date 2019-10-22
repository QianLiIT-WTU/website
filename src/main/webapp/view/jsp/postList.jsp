<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/postList.css" rel="stylesheet">
<title>千里IT-帖子列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		loadSelect("3", "postitem", "bbid");
	});

</script>
</head>
<%@ include file="header.jsp"%>
<body>
	<div class="wrapper">
		<div class="post-list-con">
			<div class="filter-bar">
				<form action="${pageContext.request.contextPath }/post/postlist" method="post">
					<div class="catego-search filter-item" id="postitem"></div>
					<!-- 隐藏域.当前页码 -->
					<input type="hidden" name="pn" id="currentPageInput" value="${page.pageNum }" />
					<div id='pstitem' class="filter-item">
						<input type="text" name="title" placeholder="请输入标题" autocomplete="off">
						<input type="text" name="username" placeholder="请输入作者" autocomplete="off">
					</div>
					<input class="filter-btn" type="submit" value="筛选">
					<a class="new-post-btn" href="${pageContext.request.contextPath}/view/jsp/newPost.jsp">发布新帖</a>
				</form>
			</div>
			<ul class="post-list f-light">
				<c:forEach items="${pageInfo.list }" var="post">
					<li onclick="window.open('${pageContext.request.contextPath }/post/Info?pid=${post.pid}')">
						<div class="post-list-left">
							<div class="catego">${post.bid.dict_item_name }</div>
							<div class="title">${post.title}</div>
							<div class="author">${post.uid.username }</div>

						</div>
						<div class="post-list-right">
							<div class="click">${post.click }浏览</div>
							<div class="date">${post.create_time }</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="page">
				<a href="${pageContext.request.contextPath }/post/postlist?pn=${pageInfo.navigateFirstPage}">首页</a>
				<c:if test="${pageInfo.hasPreviousPage}">
					<a href="${pageContext.request.contextPath }/post/postlist?pn=${pageInfo.prePage}">上一页</a>
				</c:if>
				<c:if test="${!pageInfo.hasPreviousPage}">
					<a class="disabled-link">上一页</a>
				</c:if>
				<c:if test="${pageInfo.hasNextPage}">
					<a href="${pageContext.request.contextPath }/post/postlist?pn=${pageInfo.nextPage}">下一页</a>
				</c:if>
				<c:if test="${! pageInfo.hasNextPage}">
					<a class="disabled-link">下一页</a>
				</c:if>
				<a href="${pageContext.request.contextPath }/post/postlist?pn=${pageInfo.navigateLastPage}">尾页</a>
				<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
			</div>
		</div>
	</div>
</body>


<%@ include file="footer.jsp"%>
</html>