<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息通知</title>
<style>
.error-con {
	margin: 40px auto;
	width: 600px;
	height: 160px;
	border: 1px solid #ccc;
	background-color: #fdfdfd;
}

.error-msg {
	margin: 0 auto;
	padding: 40px 0;
	font-size: 18px;
	font-weight: normal;
	text-align: center;
	color:#5991d4;
}

.error-con a {
	display: block;
	color: #bbb;
	font-size: 14px;
	text-align: center;
}

.error-con a:hover {
	color: #999;
}
</style>
</head>

<%@ include file="header.jsp"%>

<body>
	<div class="error-con">
		<%-- <c:if  test=" ${  not  empty msg }"> --%>
		<h1 class="error-msg">信息提示：${msg }</h1>
		<a href="${pageContext.request.contextPath}/view/jsp/index.jsp">点此进入主页</a>
		<%-- </c:if> --%>

		<c:if test="${  not  empty error }">
			<h1 class="error-msg">错误提示：${error }</h1>
			<a href="${pageContext.request.contextPath}/view/login.jsp">点此进入登录页面</a>
		</c:if>
	</div>
</body>
</body>

<%@ include file="footer.jsp"%>

</html>