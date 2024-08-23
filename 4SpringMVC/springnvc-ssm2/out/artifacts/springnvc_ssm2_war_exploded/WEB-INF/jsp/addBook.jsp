<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>添加书籍</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
<%--        编号&nbsp;&nbsp;:<input type="text" name="bookName"><br>  id自增长--%>
<%--        name与表名一致    required 表单为空不提交  --%>
    <label>图书名称：</label><input type="text" name="name" required><br>
    <label>图书作者：</label><input type="text" name="author" required><br>
    <label>出版社&nbsp;&nbsp;&nbsp;：</label><input type="text" name="publish" required><br>
    <label>页数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label><input type="text" name="pages" required><br>
    <label>价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label><input type="text" name="price" required><br>
    <label>类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label><input type="text" name="bookcaseid" required><br>
    <label>审核状态：</label><input type="text" name="abled" required><br>
        <input class="btn" type="submit" value="添加"><br>
    </form>

</div>
</body>
</html>
