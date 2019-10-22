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
<script type="text/javascript" src='${pageContext.request.contextPath }/js/jquery-1.4.4.min.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
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
			<form class="layui-form" action="${pageContext.request.contextPath }/image/upload" method="post" enctype="multipart/form-data">
				<div class="layui-form-item">
					<label class="layui-form-label">幻灯片标题</label>
					<div class="layui-input-block">
						<input type="text" name="title" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<label class="layui-form-label">选择文件</label>
					<div class="layui-input-block">
						<input type="file" name="image">
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-block">
						<input type="radio" name="status" value="0" title="未使用" />
						<input type="radio" name="status" value="1" title="使用中" checked="" />
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="">上传</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/layui/layui.all.js "></script>
</body>

</html>