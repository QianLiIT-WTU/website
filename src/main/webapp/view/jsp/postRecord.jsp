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
    <link href="${pageContext.request.contextPath}/css/postRecord.css" rel="stylesheet">
    <title>千里IT-帖子收藏</title>
</head>

<body>
    <div class="wrapper">
        <div class="user-con">
            <ul class="user-navbar">
            <li><a href="userInfo.jsp">个人信息</a></li>
                 <li><a href="UserAction_edit?uid=${user.uid }">资料修改</a></li>
               <li><a href="alterPsw.jsp">密码修改</a></li>
                <li><a href="postRecord.jsp">帖子收藏</a></li>
                <li><a href="myPost.jsp">我的帖子</a></li>
                <li><a href="userMsg.jsp">站内消息</a></li>
            </ul>


            <div class="post-record">

                <div class="list-title">收藏列表</div>
                <div class="post-list">
                    <ul>
                        <li class="post-item">
                            <div class="date">2018-06-02</div>
                            <div class="catego">学习贴</div>
                            <div class="title">帖子标题帖子标题帖子标题帖子标题</div>
                            <div class="author">王小明</div>
                        </li>
                        <li class="post-item">
                            <div class="date">2018-06-02</div>
                            <div class="catego">学习贴</div>
                            <div class="title">帖子标题帖子标题帖子标题帖子标题</div>
                            <div class="author">王小明</div>
                        </li>
                        <li class="post-item">
                            <div class="date">2018-06-02</div>
                            <div class="catego">学习贴</div>
                            <div class="title">帖子标题帖子标题帖子标题帖子标题</div>
                            <div class="author">王小明</div>
                        </li>
                        <li class="post-item">
                            <div class="date">2018-06-02</div>
                            <div class="catego">学习贴</div>
                            <div class="title">帖子标题帖子标题帖子标题帖子标题</div>
                            <div class="author">王小明</div>
                        </li>
                        <li class="post-item">
                            <div class="date">2018-06-02</div>
                            <div class="catego">学习贴</div>
                            <div class="title">帖子标题帖子标题帖子标题帖子标题</div>
                            <div class="author">王小明</div>
                        </li>

                        <li class="post-item">
                            <div class="date">2018-06-02</div>
                            <div class="catego">学习贴</div>
                            <div class="title">帖子标题帖子标题帖子标题帖子标题</div>
                            <div class="author">王小明</div>
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
        </div>
    </div>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>

</html>