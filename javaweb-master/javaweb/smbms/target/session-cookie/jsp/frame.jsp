﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="/jsp/common/head.jsp" %>
<div class="right">
    <img class="wColck" src="${pageContext.request.contextPath }/images/clock.jpg" alt=""/>
    <div class="wFont">
        <h2>${userSession.userName }</h2>
        <p>欢迎来到超市订单管理系统!</p>
    </div>
</div>
<%@include file="/jsp/common/foot.jsp" %>