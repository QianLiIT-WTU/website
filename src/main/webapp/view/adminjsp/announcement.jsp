<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>千里IT后台管理系统-公告管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function changePage(pageNum) {
		//1 将页码的值放入对应表单隐藏域中
		$("#currentPageInput").val(pageNum);
		//2 提交表单
		$("#pageForm").submit();
	};
</script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<jsp:include page="adminHeader.jsp" flush="true" />

		<div class="page-content">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search" action="${pageContext.request.contextPath }/announce/find" method="post">
					搜索：
					<!-- 隐藏域.当前页码 -->
					<input type="hidden" name="pn" id="currentPageInput" value="${page.pageNum }" />
					<div class="layui-inline">
						<input type="text" name="mid" placeholder="请输入公告ID" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-inline">
						<input type="text" name="title" placeholder="请输入公告标题" autocomplete="off" class="layui-input">
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
						<th>ID</th>
						<th>标题</th>
						<th>内容</th>
						<th>时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list }" var="announce">
						<tr>
							<td>${announce.mid}</td>
							<td>${announce.title}</td>
							<td>${announce.content}</td>
							<td>${announce.create_time }</td>
							<td class="td-manage">
								<div class="layui-btn-group">
									<a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath }/announce/delete?mid=${announce.mid}">删除</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
					<a href="${pageContext.request.contextPath }/announce/find?pn=${pageInfo.navigateFirstPage}">首页</a>
					<c:if test="${pageInfo.hasPreviousPage}">
						<a href="${pageContext.request.contextPath }/announce/find?pn=${pageInfo.prePage}">上一页</a>
					</c:if>
					<c:if test="${!pageInfo.hasPreviousPage}">
						<a class="disabled-link">上一页</a>
					</c:if>
					<c:if test="${pageInfo.hasNextPage}">
						<a href="${pageContext.request.contextPath }/announce/find?pn=${pageInfo.nextPage}">下一页</a>
					</c:if>
					<c:if test="${! pageInfo.hasNextPage}">
						<a class="disabled-link">下一页</a>
					</c:if>
					<a href="${pageContext.request.contextPath }/announce/find?pn=${pageInfo.navigateLastPage}">尾页</a>
					<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/layui/layui.all.js "></script>
</body>

</html>