<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: livvy
  Date: 2016/12/2
  Time: 上午6:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加项目</title>
</head>
<body>
<form action="doAddProject" method="get" >
    项目名称:<input type="text" name="name"/>
    项目类型:
    <select name="type">
        <c:forEach items="${projectTypes}" var="item">
            <option value="${item.id}" >${item.name}</option>
        </c:forEach>
    </select>
    交付日期:<input type="text" name="deliveryDate"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
