<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div class="layui-header">
		<div class="layui-logo">千里IT官网后台管理系统</div>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<img src="${admin_user.photoaddress }" class="layui-nav-img">
				<span>${admin_user.username }</span>
			</li>
			<li class="layui-nav-item">
				<a href="${pageContext.request.contextPath }/user/AClear">退出</a>
			</li>
		</ul>
	</div>
	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<ul class="layui-nav layui-nav-tree">
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">用户管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/user/findAll">用户列表</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/user/findqlUser">会员列表</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">分类管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/basedict/list">分类列表</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/view/adminjsp/addCatego.jsp">添加分类</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">论坛管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/post/flist">未审帖子</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/post/tlist">过审帖子</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">资源管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/source/getToAdminFile">文件管理</a>
							
						</dd>
						<dd><a href="${pageContext.request.contextPath }/source/getToAdminPicture">图片管理</a></dd>
						<dd>	<a href="${pageContext.request.contextPath }/source/getToAdminVideo">视频管理</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">网站管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/view/adminjsp/new-announcement.jsp">新增公告</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/announce/find">公告管理</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/image/findAll">幻灯片管理</a>
						</dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>

</body>
</html>