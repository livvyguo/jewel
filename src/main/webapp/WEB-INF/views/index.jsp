<%--
  Created by IntelliJ IDEA.
  User: livvy
  Date: 15/6/27
  Time: 下午2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
hello world ${name}
<br/>
   <c:forEach items="${allUser}" var="user">
     <c:out value="${user.name}"/> <br/>
   </c:forEach>
</body>
</html>
