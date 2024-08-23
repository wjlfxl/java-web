<%--
  Created by IntelliJ IDEA.
  User: zhongwuduan
  Date: 2022/2/13
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
//scope:作用域
     public void setAttribute(String name, Object attribute, int scope) {
        switch(scope) {
        case 1:
            this.mPage.put(name, attribute);
            break;
        case 2:
            this.mRequest.put(name, attribute);
            break;
        case 3:
            this.mSession.put(name, attribute);
            break;
        case 4:
            this.mApp.put(name, attribute);
            break;
        default:
            throw new IllegalArgumentException("Bad scope " + scope);
        }

    }
--%>
<%

    pageContext.setAttribute("hello1","hello1",pageContext.SESSION_SCOPE);
    //session.setAttribute()
    //设置作用的范围是和session一个等级
%>
</body>
</html>
