<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>千里IT后台管理系统-过审帖子</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<script>
	$(document).ready(function() {
		//loadSelect("1","useritem","dict_item.dict_id", <s:if test="#user.dict_item!=null">,<s:property value="#user.dict_item.dict_id" /></s:if>);
		loadSelect("3", "postitem", "bbid");
		function changePage(pageNum) {
			//1 将页码的值放入对应表单隐藏域中
			$("#currentPageInput").val(pageNum);
			//2 提交表单
			$("#pageForm").submit();
		}
	});
</script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<jsp:include page="adminHeader.jsp" flush="true" />

		<div class="page-content">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search" action="${pageContext.request.contextPath }/post/tlist" method="post">
					搜索：
					<div class="layui-inline" id="postitem"></div>
					<div class="layui-inline">
						<input type="text" name="title" placeholder="请输入帖子标题" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-inline">
						<input type="text" name="username" placeholder="请输入作者用户名" autocomplete="off" class="layui-input">
					</div>

					<button class="layui-btn">
						<i class="layui-icon">&#xe615;</i>
					</button>
				</form>
			</div>
			<span class="fr" style="line-height: 40px">共有数据：${pageInfo.total } 条</span>
			<table class="layui-table">
				<thead>
					<tr>
						<th>标题</th>
						<th>发布时间</th>
						<th>状态</th>
						<th>所属分类</th>
						<th>作者</th>
						<th>操作</th>
						<th>点击量</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list }" var="post">
						<tr>
							<td>${post.title}</td>
							<td>${post.create_time }</td>
							<td>${post.status}
							<c:if test="${post.status eq true}"  >已过审</c:if></td>
							<td>${post.bid.dict_item_name }</td>
							<td>${post.uid.username }</td>
							<td class="td-manage">
								<div class="layui-btn-group">
									<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/post/findPost?pid=${post.pid}">浏览</a>
									<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/post/delete?pid=${post.pid}">删除</a>
								</div>
							</td>
							<td>${post.click }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="page">
					<a href="${pageContext.request.contextPath }/post/tlist?pn=${pageInfo.navigateFirstPage}">首页</a>
					<c:if test="${pageInfo.hasPreviousPage}">
						<a href="${pageContext.request.contextPath }/post/tlist?pn=${pageInfo.prePage}">上一页</a>
					</c:if>
					<c:if test="${!pageInfo.hasPreviousPage}">
						<a class="disabled-link">上一页</a>
					</c:if>
					<c:if test="${pageInfo.hasNextPage}">
						<a href="${pageContext.request.contextPath }/post/tlist?pn=${pageInfo.nextPage}">下一页</a>
					</c:if>
					<c:if test="${! pageInfo.hasNextPage}">
						<a class="disabled-link">下一页</a>
					</c:if>
					<a href="${pageContext.request.contextPath }/post/tlist?pn=${pageInfo.navigateLastPage}">尾页</a>
					<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/layui/layui.all.js "></script>
</body>

</html>