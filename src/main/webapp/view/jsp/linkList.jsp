<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<%@ include file="footer.jsp"%>



   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/linkList.css" rel="stylesheet">
    <title>千里IT-链接列表</title>
</head>

<body>
    <div class="wrapper">
        <div class="link-con">
            <h1>链接列表</h1>
            <ul class="link-list">
                <li class="link">
                    <div class="link-info">
                        <a>
                            <h2 class="title">链接标题（点击可直接跳转到相应页面）</h2>
                        </a>
                    </div>
                    <div class="link-content">链接介绍</div>
                </li>
                <li class="link">
                    <div class="link-info">
                        <a>
                            <h2 class="title">链接标题（点击可直接跳转到相应页面）</h2>
                        </a>
                    </div>
                    <div class="link-content">链接介绍</div>
                </li>
                <li class="link">
                    <div class="link-info">
                        <a>
                            <h2 class="title">链接标题（点击可直接跳转到相应页面）</h2>
                        </a>
                    </div>
                    <div class="link-content">链接介绍</div>
                </li>
                <li class="link">
                    <div class="link-info">
                        <a>
                            <h2 class="title">链接标题（点击可直接跳转到相应页面）</h2>
                        </a>
                    </div>
                    <div class="link-content">链接介绍</div>
                </li>
                <li class="link">
                    <div class="link-info">
                        <a>
                            <h2 class="title">链接标题（点击可直接跳转到相应页面）</h2>
                        </a>
                    </div>
                    <div class="link-content">链接介绍</div>
                </li>
            </ul>

            <div class="pager-con">
                <ul class="pager">
                    <li class="first">
                        <a href="javascript:void(0)">首页</a>
                    </li>
                    <li class="prev">
                        <a href="javascript:void(0)">上一页</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">1</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">2</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">3</a>
                    </li>
                    <li class="next">
                        <a href="javascript:void(0)">下一页</a>
                    </li>
                    <li class="last">
                        <a href="javascript:void(0)">尾页</a>
                    </li>
                </ul>
            </div>


        </div>
    </div>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

</html>