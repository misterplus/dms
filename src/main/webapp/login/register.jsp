<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/form.css">
    <title>学生宿舍管理系统</title>
</head>
<body>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/static/js/validation.js"></script>
    <form class="needs-validation" novalidate name="credentials" onsubmit="validateRegister()" action="${pageContext.request.contextPath}/api/loginServlet" method="post">
        <h1 class="h3 mb-3 font-weight-normal text-center">学生注册</h1>
        <div class="form-group">
            <input type="text" class="form-control" name="username" id="username" placeholder="请输入学号" required onkeyup="this.value=this.value.replace(/\D/g, '')">
            <div class="invalid-feedback">
                学号不能为空!
            </div>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码" required>
            <div class="invalid-feedback">
                密码不能为空!
            </div>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="rePassword" id="rePassword" placeholder="请输入确认密码" required>
            <div class="invalid-feedback">
                确认密码不能为空!
            </div>
        </div>
        <input type="text" name="usertype" value="user" hidden>
        <input type="text" name="action" value="register" hidden>
        <button type="submit" class="btn btn-primary btn-lg btn-block">注册</button>
    </form>
</body>
</html>
