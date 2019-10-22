<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>千里IT后台管理系统-分类列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT type="text/javascript">
	function changePage(pageNum) {
		//1 将页码的值放入对应表单隐藏域中
		$("#currentPageInput").val(pageNum);
		//2 提交表单
		$("#pageForm").submit();
	};
</SCRIPT>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<jsp:include page="adminHeader.jsp" flush="true" />

		<div class="page-content">
			<div class="layui-row">
				<form class="layui-form" id="pageForm" action="${pageContext.request.contextPath }/basedict/list" method="post">
					<!-- 隐藏域.当前页码 -->
					<input type="hidden" name="pn" id="currentPageInput" value="${page.pageNum }" />
					<div class="layui-inline">
						<select name="dict_type_code" class="layui-input">
							<option value="">请选择主题</option>
							<option value="1">小组类别</option>
							<option value="2">资源类型</option>
							<option value="3">帖子类型</option>
						</select>
					</div>
					<div class="layui-inline">
						<button class="layui-btn">确定</button>
					</div>
				</form>
			</div>
			<span class="fr" style="line-height: 40px">共有数据：${pageInfo.total } 条</span>
			<table class="layui-table">
				<thead>
					<tr>
						<th>主题</th>
						<th>分类名</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<c:forEach items='${pageInfo.list }' var="bd">
						<tr>
							<td>${bd.dict_type_name}</td>
							<td>${bd.dict_item_name}</td>
							<td class="td-manage">
								<a title="删除" href="${pageContext.request.contextPath }/basedict/deleteItem?bid=${bd.bid}">
									<button class="layui-btn layui-btn-sm">删除</button>
								</a>
								<a title="修改" href="${pageContext.request.contextPath }/basedict/editItem?bid=${bd.bid}">
									<button class="layui-btn layui-btn-sm">编辑</button>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
				<a href="${pageContext.request.contextPath }/basedict/list?pn=${pageInfo.navigateFirstPage}">首页</a>
				<c:if test="${pageInfo.hasPreviousPage}">
					<a href="${pageContext.request.contextPath }/basedict/list?pn=${pageInfo.prePage}">上一页</a>
				</c:if>
				<c:if test="${!pageInfo.hasPreviousPage}">
					<a class="disabled-link">上一页</a>
				</c:if>
				<c:if test="${pageInfo.hasNextPage}">
					<a href="${pageContext.request.contextPath }/basedict/list?pn=${pageInfo.nextPage}">下一页</a>
				</c:if>
				<c:if test="${! pageInfo.hasNextPage}">
					<a class="disabled-link">下一页</a>
				</c:if>
				<a href="${pageContext.request.contextPath }/basedict/list?pn=${pageInfo.navigateLastPage}">尾页</a>
				<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/layui/layui.all.js "></script>
</body>
</html>