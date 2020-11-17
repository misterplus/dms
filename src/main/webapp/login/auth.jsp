<%@ page import="plus.misterplus.dms.sql.query.advanced.UserQuery" %>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>验证中</title>
</head>
<body>
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean register = "register".equals(request.getParameter("register"));
        boolean isAdmin = "admin".equals(request.getParameter("usertype"));
        boolean cache = "cache".equals(request.getParameter("cache"));
        boolean success = UserQuery.login(username, password, register, isAdmin, cache, response);
    %>
</body>
</html>