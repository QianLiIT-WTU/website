<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>资源界面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/source.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
<script type="text/javascript" src='${pageContext.request.contextPath }/js/jquery-1.4.4.min.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//      loadSelect("1","useritem","dict_item.dict_id", <s:if test="#user.dict_item!=null">,<s:property value="#user.dict_item.dict_id" /></s:if>);
		loadSelect("2", "sourceItem", "bbid");
		$("select").show();
	});
</script>
</head>
<%@ include file="header.jsp"%>
<body>
	<div class="wrapper">
		<div class="main">
			<div class="filter-bar">
				<form action="${pageContext.request.contextPath }/source/getAllSource" method="post">
					<div class="filter-item" id="sourceItem"></div>
					<div id='pstitem' class="filter-item">
						<input type="text" name="sname" placeholder="请输入资源名" autocomplete="off" class="layui-input">
						<input type="text" name="username" placeholder="请输入作者用户名" autocomplete="off" class="layui-input">
					</div>
					<input class="filter-btn" type="submit" value="搜索">

					<a class="new-post-btn mr0" href="${pageContext.request.contextPath}/view/jsp/uploadFileSource.jsp">上传文件</a>

					<a class="new-post-btn" href="${pageContext.request.contextPath}/view/jsp/uploadVideoSource.jsp">上传视频</a>

					<a class="new-post-btn" href="${pageContext.request.contextPath}/view/jsp/uploadPictureSource.jsp">上传图片</a>
					<!-- 隐藏域.当前页码 -->
					<input type="hidden" name="pn" id="currentPageInput" value="${page.pageNum }" />
				</form>
			</div>
			<ul class="work">

				<c:forEach items="${pageInfo.list }" var="source">

					<li class="work-item">
						<div class="work-pic">
							<c:if test="${source.bid.bid eq 6}">
								<a href="${pageContext.request.contextPath }/source/lookPic?sid=${source.sid }">
									<img src="${pageContext.request.contextPath }/${source.slink }">
								</a>
							</c:if>
							<c:if test="${source.bid.bid eq 7  }">
								<a href="${pageContext.request.contextPath }/source/lookVid?sid=${source.sid }">
									<img src="${pageContext.request.contextPath }/${source.videoImg }">
								</a>
							</c:if>
							<c:if test="${source.bid.bid eq 8 }">
								<a href="${pageContext.request.contextPath }/source/lookFile?sid=${source.sid }">
									<img src="${pageContext.request.contextPath }/${source.videoImg }">
								</a>
							</c:if>
						</div>
						<div class="work-label">
							<i class="work-name">${source.sname }</i>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="page">
				<a href="${pageContext.request.contextPath }/source/getAllSource?pn=${pageInfo.navigateFirstPage}&bbid=${source.bid.bid }">首页</a>
				<c:if test="${pageInfo.hasPreviousPage}">
					<a href="${pageContext.request.contextPath }/source/getAllSource?pn=${pageInfo.prePage}&bbid=${source.bid.bid }">上一页</a>
				</c:if>
				<c:if test="${!pageInfo.hasPreviousPage}">
					<a class="disabled-link">上一页</a>
				</c:if>
				<c:if test="${pageInfo.hasNextPage}">
					<a href="${pageContext.request.contextPath }/source/getAllSource?pn=${pageInfo.nextPage}&bbid=${source.bid.bid }">下一页</a>
				</c:if>
				<c:if test="${! pageInfo.hasNextPage}">
					<a class="disabled-link">下一页</a>
				</c:if>
				<a href="${pageContext.request.contextPath }/source/getAllSource?pn=${pageInfo.navigateLastPage}&bbid=${source.bid.bid }">尾页</a>
				<p class="page-info">总共${pageInfo.pages}页，当前是第${pageInfo.pageNum }页，共有${pageInfo.total }条数据</p>
			</div>
		</div>
		<!--             <div class="group"> -->
		<!--                 <div class="wrap"> -->
		<!--                     <div class="row"> -->
		<!--                         <div class="cell"> -->
		<!--                             <div class="icon"> -->
		<!--                                 <i class="iconfont">&#xe67e;</i> -->
		<!--                             </div> -->
		<!--                             <span><strong>热门</strong><br />推荐</span></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"><span>更多<br>${pageContext.request.contextPath}.</span></div> -->
		<!--                     </div> -->
		<!--                     <div class="row"> -->
		<!--                         <div class="cell"> -->
		<!--                             <div class="icon"> -->
		<!--                                 <i class="iconfont">&#xe6b8;</i> -->
		<!--                             </div> -->
		<!--                             <span><strong>Java</strong><br />推荐</span> -->
		<!--                         </div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"><span>更多<br>${pageContext.request.contextPath}.</span></div> -->
		<!--                     </div> -->
		<!--                     <div class="row"> -->
		<!--                         <div class="cell"> -->
		<!--                             <div class="icon"> -->
		<!--                                 <i class="iconfont">&#xe602;</i> -->
		<!--                             </div> -->
		<!--                             <span><strong>Web</strong><br />推荐</span> -->
		<!--                         </div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"><span>更多<br>${pageContext.request.contextPath}.</span></div> -->
		<!--                     </div> -->
		<!--                     <div class="row"> -->
		<!--                         <div class="cell"> -->
		<!--                             <div class="icon"> -->
		<!--                                 <i class="iconfont">&#xe664;</i> -->
		<!--                             </div> -->
		<!--                             <span><strong>设计</strong><br />推荐</span> -->
		<!--                         </div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"><span>更多<br>${pageContext.request.contextPath}.</span></div> -->
		<!--                     </div> -->
		<!--                     <div class="row"> -->
		<!--                         <div class="cell"> -->
		<!--                             <div class="icon"> -->
		<!--                                 <i class="iconfont">&#xe661;</i> -->
		<!--                             </div> -->
		<!--                             <span><strong>微信</strong><br />推荐</span> -->
		<!--                         </div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"></div> -->
		<!--                         <div class="cell"><span>更多<br>${pageContext.request.contextPath}.</span></div> -->
		<!--                     </div> -->
		<!--                 </div> -->
		<!--             </div> -->
	</div>
</body>

<%@ include file="footer.jsp"%>

</html>