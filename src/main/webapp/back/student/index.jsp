<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生管理</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="container-fluid">

    <%--标题--%>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center">学生管理</h1>
        </div>
    </div>

    <%--搜索条件--%>
    <div class="row" style="margin:20px 0px;">
        <div class="col-sm-10 col-sm-offset-1 text-center">
            <form class="form-inline" action="" method="post">
                <div class="form-group">
                    <select class="form-control" name="searchCol" id="searchCol">

                        <option value="s.name"
                                <c:if test="${searchCol=='s.name'}">
                                    selected
                                </c:if>
                        >姓名
                        </option>
                        <option value="s.phone"
                                <c:if test="${searchCol=='s.phone'}">
                                    selected
                                </c:if>
                        >电话
                        </option>
                        <option value="s.qq"
                                <c:if test="${searchCol=='s.qq'}">
                                    selected
                                </c:if>
                        >QQ
                        </option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="searchValue" value="${searchValue}"
                           style="width:500px;" id="searchValue"
                           placeholder="请输入对应的搜索关键词">
                </div>
                <button type="submit" class="btn btn-primary">查询</button>
            </form>
        </div>
    </div>
    <%--添加按钮--%>
    <div class="row" style="margin-bottom: 14px;">
        <div class="col-sm-12">
            <a href="" class="btn btn-success">添加</a>
        </div>
    </div>

    <%--表格--%>
    <div class="row" style="height: 600px;">
        <div class="col-sm-12">
            <c:if test="${students.size()==0}">
                <h1 class="text-center text-info">
                    还没有任何数据～～！！
                </h1>
            </c:if>

            <c:if test="${students.size()!=0}">
                <table class="table table-striped table-hover table-bordered">
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>生日</th>
                        <th>电话</th>
                        <th>QQ</th>
                        <th>生肖</th>
                        <th>星座</th>
                        <th>备注</th>
                        <th>就业城市</th>
                        <th>班级</th>
                        <th>小组</th>
                        <th>标签</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.age}</td>
                            <td><fmt:formatDate value="${student.bir}" pattern="yyyy-MM-dd"/></td>
                            <td>${student.phone}</td>
                            <td>${student.qq}</td>
                            <td>${student.attr}</td>
                            <td>${student.starts}</td>
                            <td>${student.mark}</td>
                            <td>${student.city.name}</td>
                            <td>${student.clazz.name}</td>
                            <td>${student.group.name}</td>
                            <td>
                                <c:forEach items="${student.tags}" var="tag">
                                    ${tag.name},
                                </c:forEach>
                            </td>
                            <td>
                                <a href="" class="btn btn-info">修改</a>
                                <a href="" class="btn btn-danger">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </c:if>
        </div>
    </div>

    <%--分页工具栏--%>
    <div class="row">
        <div class="col-sm-12 text-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="${pageContext.request.contextPath}/student/list?pageNo=${pageNo-1}&searchCol=${searchCol}&searchValue=${searchValue}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

                    <c:forEach begin="1" step="1" end="${pages}" varStatus="state">
                        <li><a href="${pageContext.request.contextPath}/student/list?pageNo=${state.count}&searchCol=${searchCol}&searchValue=${searchValue}">${state.count}</a></li>
                    </c:forEach>

                    <li>
                        <a href="${pageContext.request.contextPath}/student/list?pageNo=${pageNo+1}&searchCol=${searchCol}&searchValue=${searchValue}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</div>


</body>
</html>
