<%--
  Created by IntelliJ IDEA.
  User: Jean.K
  Date: 2022/2/25
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook"method="post">
<%--        隐藏域--%>
        <input type="hidden" name="bookID" value="${books.bookID}"/>
        书籍名称：<input type="text" name="bookName"value="${books.bookName}"/>
        书籍数量：<input type="text" name="bookCounts"value="${books.bookCounts}"/>
        书籍详情：<input type="text" name="detail" value="${books.detail}"/>
        <input type="submit" value="提交"/>
    </form>

</div>