<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/11/30
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <%--JSON是JavaScript对象的字符串表示法，它使用文本表示一个JS对象的信息,本质是一个字 符串。--%>

    <script type="text/javascript">
        var user={
            name:"张三",
            age:5,
            sex:"男"
        }
        console.log(user);

        //将js转换成json对象
        var json=JSON.stringify(user);
        console.log(json);

        //将JSON对象转换成js对象
        var js=JSON.parse(json);
        console.log(js);
    </script>
</head>
<body>
$END$
</body>
</html>
