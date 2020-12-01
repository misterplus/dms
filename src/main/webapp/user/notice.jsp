<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>通知</title>
</head>
<body>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/static/js/user/notice.js"></script>

<form class="needs-validation" novalidate name="notice" onload="getNotice()" method="post">
    <h1 class="h3 mb-3 font-weight-normal text-center">通知</h1>

    <div class="form-group" align="center">
        通知时间：<input type="text" class="text" name="rtime" readonly><br>
        通知标题：<input type="text" class="text" name="ntitle" readonly><br>
        通知内容：<input type="text" class="text-area" name="ncontent" readonly><br>
        <br>
        <button type="submit" class="btn btn-primary">查看历史通知</button>
    </div>

</form>
</body>
</html>