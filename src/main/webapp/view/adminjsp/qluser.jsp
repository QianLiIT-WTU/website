<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>千里IT后台管理系统-会员列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<script>
	$(document).ready(function() {
		//loadSelect("1","useritem","dict_item.dict_id", <s:if test="#user.dict_item!=null">,<s:property value="#user.dict_item.dict_id" /></s:if>);
		loadSelect("1", "useritem", "bbid");
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
				<form class="layui-form layui-col-md12 we-search" id="pageForm" action="${pageContext.request.contextPath }/user/findqlUser" method="post">
					<!-- 隐藏域.当前页码 -->
					<input type="hidden" name="pn" id="currentPageInput" value="${page.pageNum }" />
					搜索：
					<div class="layui-inline" id="useritem"></div>
					<div class="layui-inline">
						<select name="root" class="layui-input">
							<option value="">请选择用户身份</option>
							<option value="1">未激活账号</option>
							<option value="2">注册会员</option>
							<option value="3">千里会员</option>
							<option value="4">管理员</option>
						</select>
					</div>
					<div class="layui-inline">
						<select name="year" class="layui-input">
							<option value="" disabled selected>请选择加入时间</option>
							<option value="2009年">2009年</option>
							<option value="2010年">2010年</option>
							<option value="2011年">2011年</option>
							<option value="2012年">2012年</option>
							<option value="2013年">2013年</option>
							<option value="2014年">2014年</option>
							<option value="2015年">2015年</option>
							<option value="2016年">2016年</option>
							<option value="2017年">2017年</option>
							<option value="2018年">2018年</option>
						</select>
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
						<th>用户名</th>
						<th>年份</th>
						<th>小组类别</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>账号级别</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageInfo.list }" var="u">
						<tr>
							<td>${u.uid }</td>
							<td>${u.username }</td>
							<td>${u.year}</td>
							<td>${u.bid.dict_item_name}</td>
							<td>
								<c:if test="${u.sex eq false}"> 男 </c:if>
								<c:if test="${u.sex eq true}">  女</c:if>
							</td>
							<td>${u.mail}</td>
							<td>
								<c:choose>
									<c:when test="${u.root eq 1 }">未激活账号</c:when>
									<c:when test="${u.root eq 2 }">注册会员</c:when>
									<c:when test="${u.root eq 3 }">千里会员</c:when>
									<c:when test="${u.root eq 4 }">管理员</c:when>
									<c:when test="${u.root eq 5 }">超级管理员</c:when>
									<c:otherwise>状态未知</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
				<a href="${pageContext.request.contextPath }/user/findqlUser?pn=${pageInfo.navigateFirstPage}">首页</a>
				<c:if test="${pageInfo.hasPreviousPage}">
					<a href="${pageContext.request.contextPath }/user/findqlUser?pn=${pageInfo.prePage}">上一页</a>
				</c:if>
				<c:if test="${!pageInfo.hasPreviousPage}">
					<a class="disabled-link">上一页</a>
				</c:if>
				<c:if test="${pageInfo.hasNextPage}">
					<a href="${pageContext.request.contextPath }/user/findqlUser?pn=${pageInfo.nextPage}">下一页</a>
				</c:if>
				<c:if test="${! pageInfo.hasNextPage}">
					<a class="disabled-link">下一页</a>
				</c:if>
				<a href="${pageContext.request.contextPath }/user/findqlUser?pn=${pageInfo.navigateLastPage}">尾页</a>
				<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
</body>

</html>