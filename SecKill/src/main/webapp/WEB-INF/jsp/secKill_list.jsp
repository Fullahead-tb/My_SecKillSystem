<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>秒杀商品列表</title>

    <!-- Bootstrap -->
<%--    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
<%--    <link rel="stylesheet" href="../../css/bootstrap.css">--%>
<%--    <link rel="stylesheet" href="../../css/bootstrap-grid.css">--%>
<%--    <link rel="stylesheet" href="../../css/bootstrap-reboot.css">--%>


    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <![endif]-->
<%--    <script src="../../js/jquery-3.7.0.js"></script>--%>
<%--    <script src="../../js/bootstrap.js"></script>--%>
<%--    <script src="../../js/bootstrap.bundle.js"></script>--%>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<%--    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <script src="../../js/jquery-3.7.0.js"></script>
</head>
<body>


    <table class="table table-bordered">
        <h2>商品列表</h2>
        <thead>
        <tr>
            <th>序号</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品数量</th>
            <th>秒杀开始时间</th>
            <th>秒杀结束时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

            <c:forEach items="${requestScope.itemList}" var="item" >
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getName()}</td>
                <td>${item.getNumber()}</td>
                <td>${item.getPrice()}</td>
                <td>${item.getStartTime()}</td>
                <td>${item.getEndTime()}</td>
                <td><a href="/productDetails?id=${item.getId()}">进入抢购</a>
<%--                    <a href="#">取消抢购</a>--%>
                </td>
            </tr>
            </c:forEach>

        </tbody>
    </table>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<%--<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>--%>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
</body>
</html>
