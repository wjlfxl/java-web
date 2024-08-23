<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/27
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <%--通过表单上传文件
  get:上传文件有大小限制
  post:上传文件没有大小限制
 --%>
  <form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
      上传用户:<input type="text" name="username">
      <p>  <input type="file" name ="file"></p>
  <p> <input type="submit" value="提交"> </p>



    </form>

  </body>
</html>
