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
			<form
				action="${pageContext.request.contextPath }/source/getPicture?bid=6"
				method="post" class="search-area">
				<div class="search-con">
					<input name="sname" placeholder="请输入资源名搜索" type="text"
						class="search">
				</div>
				<input type="hidden" name="pn" id="currentPageInput"
					value="${page.pageNum }" /> <input type="submit" value="">
			</form>
		</div>
		<ul class="work">
			<c:forEach items="${pageInfo.list }" var="pic">
				<li class="work-item">
					<div class="work-pic">
						<a href="${pageContext.request.contextPath }/source/lookPic?sid=${pic.sid }"> <img src="${pageContext.request.contextPath }/${pic.slink }" width="460"
							height="270" />
						</a>
					</div>
					<div class="work-label">
						<i class="work-name">${pic.sname }</i> <a class="author">${pic.uid.username }</a>
					</div>
				</li>
			</c:forEach>
		</ul>
        <div class="page">
                    <div>

					<a
						href="${pageContext.request.contextPath }/source/getPicture?pn=${pageInfo.navigateFirstPage}&bbid=6">首页</a>
					<c:if test="${pageInfo.hasPreviousPage}">
						<a
							href="${pageContext.request.contextPath }/source/getPicture?pn=${pageInfo.prePage}&bbid=6">上一页</a>
					</c:if>
					<c:if test="${!pageInfo.hasPreviousPage}">上一页</c:if>

					<c:if test="${pageInfo.hasNextPage}">
						<a
							href="${pageContext.request.contextPath }/source/getPicture?pn=${pageInfo.nextPage}&bbid=6">下一页</a>
					</c:if>
					<c:if test="${! pageInfo.hasNextPage}">下一页</c:if>

					<a
						href="${pageContext.request.contextPath }/source/getPicture?pn=${pageInfo.navigateLastPage}&bbid=6">最后页</a>
					<p>一共${pageInfo.pages}页 --当前页是${pageInfo.pageNum } --
						共有${pageInfo.total }条数据</p>
				</div>
                </div>
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
</body>
<%@ include file="footer.jsp"%>
</html>