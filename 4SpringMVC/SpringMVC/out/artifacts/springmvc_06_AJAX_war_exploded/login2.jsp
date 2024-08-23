<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 2021/4/5
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/js/jquery-3.6.0.js"></script>
    
    <script>
        function a1(){
            $.post({
                url:"${pageContext.request.contextPath}/a4",
                data:{'name':$("#name").val(),'pwd':$("#pwd").val()},
                success:function (data) {
                    if (data.toString()=='OK'){
                        $("#btnInfo").css("color","green");
                    }else {
                        $("#btnInfo").css("color","red");
                    }
                    $("#btnInfo").html(data);
                }
            });
        }

    </script>
</head>
<body>

    <p>
        <%--onblur：失去焦点事件--%>
        用户名：<input type="text" id="name">
    </p>

    <p>
        <%--onblur：失去焦点事件--%>
        密 码：<input type="password" id="pwd">
    </p>
    <p>
        <%--onblur：失去焦点事件--%>
        密 码：<input type="button" id="btn" value="提交" onclick="a1()">
        <span id="btnInfo"></span>
    </p>
</body>
</html>
