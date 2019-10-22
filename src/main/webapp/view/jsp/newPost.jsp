<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/newPost.css" rel="stylesheet">
<title>千里IT-发布帖子</title>
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
		<div class="post-con">
			<c:if test="${post  ==null }">
				<h1>发布新贴</h1>
			</c:if>
			<c:if test="${post  !=null }">
				<h1>修改贴子</h1>
			</c:if>
			<form action="${pageContext.request.contextPath }/post/saveOrUpatePost" id="post" method="post" onsubmit='return buildForm()'>
				<input type="hidden" name="uid.uid" value="${user.uid }" />
				<c:if test="${post  !=null }">
					<input type="hidden" name="pid" value="${post.pid}" />
				</c:if>
				<div class="post-item">
					<div class="title">帖子类型</div>
					<div class="content">
						<div id="postitem"></div>
					</div>
				</div>
				<div class="post-item">
					<div class="title">帖子标题</div>
					<div class="content">
						<input type="text" name="title" value="${post.title}" id="post-title" placeholder="请输入标题">
					</div>
				</div>
				<div class="post-item">
					<div class="title">帖子正文</div>
					<div class="content" id="editor"></div>
					<input type="hidden" name="content" value="${post.content}" id="post-content" placeholder="请输入正文">
				</div>
				<div class="post-item">
					<input class="submit" type="submit" value="发布">
				</div>
			</form>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
	<script type="text/javascript">
		var catego = document.getElementsByName('bbid')[0];
		var title = document.getElementById('post-title');
		var content = document.getElementById('post-content');
		var E = window.wangEditor;
		var editor = new E('#editor');
		editor.customConfig.menus = [ 'head', // 标题
		'bold', // 粗体
		'fontSize', // 字号
		'fontName', // 字体
		'italic', // 斜体
		'underline', // 下划线
		'strikeThrough', // 删除线
		'foreColor', // 文字颜色
		'link', // 插入链接
		'list', // 列表
		'justify', // 对齐方式
		'quote', // 引用
		'undo', // 撤销
		'redo' // 重复
		];
		editor.create();
		if (content.value) {
			editor.txt.html(content.value);
		}
		function buildForm() {
			content.value = editor.txt.html();
			if (catego.value && title.value && content.value) {
				return true;
			} else {
				alert("请填写必要信息！");
				return false;
			}
		}
	</script>
</body>
<%@ include file="footer.jsp"%>
</html>
