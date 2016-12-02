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
    <title>项目资源分布情况</title>
    <link rel="stylesheet" href='<c:url value="/resources/thirdparty/bootstrap/css/bootstrap.min.css"/>'>
    <link href="<c:url value="/resources/thirdparty/bootstrap/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css"/>" rel="stylesheet">
</head>
<body>


<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">
            添加项目
        </h3>
    </div>
    <div class="panel-body">

        <form class="form-horizontal" role="form" id="addProjectForm">
            <div class="form-group">
                <label class="col-sm-2 control-label">需求描述</label>
                <div class="col-sm-10">
                    <input class="form-control" name="name" id="name" type="text"  placeholder="请输入需求描述">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">项目类型</label>
                <div class="col-sm-10">
                    <select class="form-control" name="type" id="type">
                        <c:forEach items="${projectTypes}" var="item">
                            <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">交付时间</label>
                <div class="col-sm-10">
                    <input class="form-control" name="deliveryDate" id="deliveryDate" type="text"
                           placeholder="请输入项目交付日期 如 2017-10-12">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <button type="button" class="btn btn-primary" id="btnAddProject">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">
            所有项目资源使用情况
        </h3>
    </div>
    <div class="panel-body">
        <div id="main" style="width: 1300px;height:600px;"></div>
    </div>
</div>


</body>
<script type="text/javascript" src="<c:url value="/resources/thirdparty/echarts/echarts.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/thirdparty/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/thirdparty/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/thirdparty/bootstrap/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"/>"></script>
<script src="<c:url value="/resources/thirdparty/bootstrap/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/index.js?v=5"/>"></script>
</html>
