<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>注册页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <script src="../../js/jquery-3.7.0.js"></script>
</head>
<body>
<div class="container">

    <form class="form-signin" action="/seckill/register" method="post">
        <h2 class="form-signin-heading">请注册！</h2>
        <label for="inputEmail" class="sr-only">手机号码</label>
        <input type="email" id="inputEmail" class="form-control" name="phone" placeholder="手机号码" required autofocus>
        <label for="inputPassword1" class="sr-only">密码</label>
        <input type="password" id="inputPassword1" class="form-control" placeholder="密码" required>
        <label for="inputPassword2" class="sr-only">请再次确认密码！</label>
        <input type="password" id="inputPassword2" class="form-control" name="password" placeholder="请再次确认密码！" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div> <!-- /container -->



</body>
</html>
