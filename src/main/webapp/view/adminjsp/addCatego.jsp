<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>千里IT后台管理系统-添加分类</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<jsp:include page="adminHeader.jsp" flush="true" />

		<div class="page-content">
			<form class="layui-form" action="${pageContext.request.contextPath }/basedict/saveOrUpdate" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">选择主题</label>
					<div class="layui-input-block">
						<select name="dict_type_code" class="layui-input">
							<option value="" disabled selected>请选择主题</option>
							<option value="1" <c:if test="${basedict.dict_type_code==1 }">selected</c:if>>小组类别</option>
							<option value="2" <c:if test="${basedict.dict_type_code==2 }">selected</c:if>>资源类型</option>
							<option value="3" <c:if test="${basedict.dict_type_code==3 }">selected</c:if>>帖子类型</option>
						</select>
					</div>
				</div>
				<input type="hidden" name="bbid" value='${basedict.bid }' />
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">分类名</label>
					<div class="layui-input-block">
						<input type="text" name="dict_item_name" required lay-verify="required" value="${basedict.dict_item_name }" placeholder="请输入分类名" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn">提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			<h2 align="center" style="color: red">${error}</h2>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/layui/layui.all.js "></script>
</body>

</html>