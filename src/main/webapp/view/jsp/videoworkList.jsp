<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/workList.css" rel="stylesheet">
<title>千里IT-作品列表</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div class="wrapper">

		<div class="toolbar">
			<h1 class="title">千里作品展示</h1>
			<form action="${pageContext.request.contextPath }/VideoAction_list"
				method="post" class="search-area">
				<div class="search-con">
					<input name="vdname" placeholder="请输入作品名或作者名搜索" type="text"
						class="search">
				</div>
				<input type="submit" value="">
			</form>
		</div>
		<ul class="work">
			<s:iterator value="#pageBeanvideo.list" var="video">
				<li class="work-item">
					<div class="work-video">
						<a href="${pageContext.request.contextPath }/VideoAction_getById?vid=<s:property value='#video.vid' />"><img src="<s:property value='#video.plink' />" width="460" height="270"/></a>
					</div>
					<div class="work-label">
						<i class="work-name"><s:property value="#video.vdname" /></i> <a
							class="author">作者</a>
					</div>
				</li>
			</s:iterator>
		</ul>

		<div class="more">
			<a>查看更多</a> <a href="uploadWork.jsp">上传作品</a>
		</div>
	</div>
	<script>
        window.onload = function() {
            Array.from(document.querySelectorAll(".work-item")).forEach((i, p) => {
                if (0 === (p + 1) % 2) {
                    addClass("mr0", i);
                }
            });
        }

        function hasClass(cla, element) {
            if (element.className.trim().length === 0) return false;
            var allClass = element.className.trim().split(" ");
            return allClass.indexOf(cla) > -1;
        }

        function addClass(cla, element) {
            if (!hasClass(cla, element)) {
                if (element.setAttribute) {
                    element.setAttribute("class", element.getAttribute("class") + " " + cla);
                } else {
                    element.className = element.className + " " + cla;
                }
            }
        }
    </script>
	<s:debug></s:debug>
</body>
<%@ include file="footer.jsp"%>
</html>