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
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/statics/js/bootstrap.js"></script>
</head>
<body>


<div class="container-fluid">

    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <h1 class="text-center">城市管理</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped table-bordered table-hover" >
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>录入时间</th>
                    <th>当前城市就业人数</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${cities}" var="city">
                    <tr>
                        <td>${city.id}</td>
                        <td>${city.name}</td>
                        <td><fmt:formatDate value="${city.createtime}" pattern="yyyy年MM月dd日" /></td>
                        <td>${city.numbers}</td>
                        <td>
                            <button id="editCityBtn" class="btn btn-info btn-sm">修改</button>
                            <a href="" class="btn btn-danger btn-sm">删除</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>

    <%--添加城市--%>
    <div class="row">
        <div class="col-sm-12">
            <form class="form-inline" id="inputForm" action="${pageContext.request.contextPath}/city/save" method="post">
                <div class="form-group">
                    <label for="name">城市名称:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="输入城市名称">
                </div>
                <button type="submit" class="btn btn-success">添加城市信息</button>
            </form>
        </div>
    </div>

</div>

<!-- 修改市场活动的模态窗口 -->
<div class="modal fade" id="editCityModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 40%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel2">修改城市就业人数</h4>
            </div>
            <div class="modal-body">

<%--                <form class="form-horizontal" role="form">--%>
<%--                    <input type="hidden" id="edit-id">--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="edit-marketActivityOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>--%>
<%--                        <div class="col-sm-10" style="width: 300px;">--%>
<%--                            <select class="form-control" id="edit-marketActivityOwner">--%>
<%--                                <option>zhangsan</option>--%>
<%--                                <option>lisi</option>--%>
<%--                                <option>wangwu</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <label for="edit-marketActivityName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>--%>
<%--                        <div class="col-sm-10" style="width: 300px;">--%>
<%--                            <input type="text" class="form-control" id="edit-marketActivityName" >--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="edit-startDate" class="col-sm-2 control-label time">开始日期</label>--%>
<%--                        <div class="col-sm-10" style="width: 300px;">--%>
<%--                            <input type="text" class="form-control" id="edit-startDate" >--%>
<%--                        </div>--%>
<%--                        <label for="edit-endDate" class="col-sm-2 control-label time">结束日期</label>--%>
<%--                        <div class="col-sm-10" style="width: 300px;">--%>
<%--                            <input type="text" class="form-control" id="edit-endDate" >--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="edit-cost" class="col-sm-2 control-label">成本</label>--%>
<%--                        <div class="col-sm-10" style="width: 300px;">--%>
<%--                            <input type="text" class="form-control" id="edit-cost" >--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="edit-description" class="col-sm-2 control-label">描述</label>--%>
<%--                        <div class="col-sm-10" style="width: 81%;">--%>
<%--                            <textarea class="form-control" rows="3" id="edit-description"></textarea>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                </form>--%>


    <input type="text" class="form-control" id="numbers" >
            </div>
            <div class="modal-footer">
                <button type="button" id="modalClose" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="updateBtn" class="btn btn-primary" data-dismiss="modal">更新</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(function(){
        //提交事件
        $("#inputForm").submit(function () {
            if (!$("#name").val()) {
                alert('城市名称不能为空!!!');
                return false; //
            }
        });

        $("#editCityBtn").click(function (){
            // $("#editCityModal").modal("show");
        })

    })
</script>
</body>
</html>
