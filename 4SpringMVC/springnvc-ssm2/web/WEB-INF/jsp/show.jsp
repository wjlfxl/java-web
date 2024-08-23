<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'borrow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="../../css/index.css" type="text/css" rel="stylesheet">
	  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<%--	  /*搜索框提示字体*/--%>
	  <style type="text/css">

	::-webkit-input-placeholder { /* WebKit browsers */
		color: #999;
	}
	:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
		color: #999;
	}
	::-moz-placeholder { /* Mozilla Firefox 19+ */
		color: #999;
	}
	:-ms-input-placeholder { /* Internet Explorer 10+ */
		color: #999;
	}
</style>
  </head>
  
  <body>


  	<div id="main">
		<div class="navigation">
				当前位置:&nbsp;&nbsp;<a href="/book/allBook">首页</a>
				<div id="readerBlock">欢迎回来&nbsp;:${reader.name }&nbsp;<a href="/logout">注销</a></div>
		</div>
		<div class="img_block">
			<img src="../../images/main_booksort.gif" class="img" />
		</div>
		<div>
			<a class="btn" href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a>
			<a class="btn" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
			<form action="${pageContext.request.contextPath}/book/getBookNameAuthor" method="post" style="float: right">
				<input type="text" name="nameAuthor" placeholder="请输入作者名或书名">
				<input class="btn" type="submit" value="搜索书籍">
			</form>
		</div>
		<table class="table" cellspacing="0">
			<tr>
				<td>编号</td>
				<td>图书名称</td>
				<td>图书作者</td>
				<td>出版社</td>
				<td>页数</td>
				<td>价格</td>
				<td>类型</td>
				<td>审核状态</td>
				<td>操作</td>
			</tr>
<%--			items="${requestScope.get('list')}"--%>
			<c:forEach items="${list}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.author}</td>
					<td>${book.publish}</td>
					<td>${book.pages}</td>
					<td>${book.price}</td>
					<td>${book.bookcase.name}</td>
					<td>${book.abled}</td>
					<td>
						<span style="color: #6A3E03">${error}</span>  <%--显示未查到效果--%>
						<a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.id}">更改</a> |
						<a href="${pageContext.request.contextPath}/book/del/${book.id}">删除</a>
					</td>
				</tr>
			</c:forEach>

		</table>
		<hr class="hr"/>
		<div id="pageControl">
			<div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>
			<div class="pageControl_item" id="last">最后一页</div>
			<div class="pageControl_item" id="next">下一页</div>
			<div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font></div>
			<div class="pageControl_item" id="previous">上一页</div>
			<div class="pageControl_item" id="first">首页</div>
		</div>
	</div>


  </body>
</html>
