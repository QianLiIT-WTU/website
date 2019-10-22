<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/userMsg.css" rel="stylesheet">
<title>千里IT-站内消息</title>
</head>

<%@ include file="header.jsp"%>

<body>
	<div class="wrapper">
		<div class="user-con">
			<ul class="user-navbar">
				<li>
					<a href="${pageContext.request.contextPath }/user/findByUid?uid=${user.uid }">个人信息</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/view/jsp/alterInfo.jsp">资料修改</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/view/jsp/alterPsw.jsp">密码修改</a>
				</li>

				<li>
					<a href="${pageContext.request.contextPath }/post/mypost?uid=${user.uid}">我的帖子</a>
				</li>
				<li>
					<a class="active" href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}">站内消息</a>
				</li>
			</ul>

			<div class="user-content">
				<ul class="msg-list f-light">
					<c:forEach items="${pageInfo.list }" var="flag">
						<li>
							<div class="msg-list-basic">
								<div class="msg-list-left">
									<div class="status">
										<c:if test='${flag.status  eq true }'>已读</c:if>
										<c:if test='${flag.status  eq false }'>未读</c:if>
									</div>
									<div class="title">${flag.mid.title}</div>
								</div>
								<div class="msg-list-right">
									<div class="action">
										<c:if test='${flag.status  eq false }'>
											<a href="${pageContext.request.contextPath }/flag/updateStatus?fid=${flag.fid}&uid=${user.uid}">标记已读</a>
										</c:if>
										<a href="${pageContext.request.contextPath }/flag/delete?fid=${flag.fid}&uid=${user.uid}">删除</a>
									</div>
									<div class="date">${flag.mid.create_time }</div>
								</div>
							</div>
							<div class="msg-list-content">${flag.mid.content}</div>
						</li>
					</c:forEach>
				</ul>

				<div class="page">
					<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}&pn=${pageInfo.navigateFirstPage}">首页</a>
					<c:if test="${pageInfo.hasPreviousPage}">
						<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}&pn=${pageInfo.prePage}">上一页</a>
					</c:if>
					<c:if test="${!pageInfo.hasPreviousPage}">
						<a class="disabled-link">上一页</a>
					</c:if>
					<c:if test="${pageInfo.hasNextPage}">
						<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}&pn=${pageInfo.nextPage}">下一页</a>
					</c:if>
					<c:if test="${! pageInfo.hasNextPage}">
						<a class="disabled-link">下一页</a>
					</c:if>
					<a href="${pageContext.request.contextPath }/flag/AnnunceList?uid=${user.uid}&pn=${pageInfo.navigateLastPage}">尾页</a>
					<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
				</div>
			</div>
		</div>
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

<%@ include file="footer.jsp"%>

</html>