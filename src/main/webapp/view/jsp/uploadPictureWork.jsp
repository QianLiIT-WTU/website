<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/uploadSource.css" rel="stylesheet">
<title>千里IT-图片作品上传</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div class="wrapper">
		<div class="upload-source">
			<form class="uploadPicture" action="${pageContext.request.contextPath }/PictureAction_upload"
				method="post" enctype="multipart/form-data">
				<h1>上传图片</h1>
				<span>请选择图片文件：</span> 
				<input type="file" class="picture" name="picturefile"><br>
				<span>请为你的图片取个名字：</span>
                <input type="text" class="pname" name="pname"><br> 
				<input type="submit" value="上传">
			</form>
		</div>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

</html>