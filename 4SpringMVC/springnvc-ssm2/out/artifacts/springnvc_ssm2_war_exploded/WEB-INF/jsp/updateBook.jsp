<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/12/5
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
<%--        取的是查询一本书得到的数据--%>
        <input type="hidden" name="id" value="${book.id}"/>
            <label>图书名称：</label><input type="text" name="name" value="${book.name}"><br>
            <label>图书作者：</label><input type="text" name="author" value="${book.author}"><br>
            <label>出版社&nbsp;&nbsp;&nbsp;：</label><input type="text" name="publish" value="${book.publish}"><br>
            <label>页数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label><input type="text" name="pages" value="${book.pages}"><br>
            <label>价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label><input type="text" name="price" value="${book.price}"><br>
            <label>类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label><input type="text" name="bookcaseid" value="${book.bookcaseid}"><br>
            <label>审核状态：</label><input type="text" name="abled" value="${book.abled}"><br>
        <input type="submit" value="提交"/>
    </form>

</div>
</body>
</html>
