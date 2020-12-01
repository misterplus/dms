<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>报修</title>
</head>
<body>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/static/js/user/repairSheet.js"></script>

    <form class="needs-validation" novalidate name="repairSheet" onsubmit="getRepairSheet()" method="post">
        <h1 class="h3 mb-3 font-weight-normal text-center">报修申请</h1>

        <div class="form-group" align="center">
            报修种类：
            <select>
                <option>----请选择报修类型----</option>
                <option>水电</option>
                <option>木工</option>
                <option>水泥工</option>
                <option>空调</option>
                <option>其他</option>
            </select><br>
            报修内容：<input type="text" aria-rowcount="5" class="text-area" name="rcon" placeholder="请输入内容"><br>
            <div class="invalid-feedback">
                内容不能为空!
            </div>
            <button type="submit" class="btn btn-primary btn-lg">提交</button>
        </div>
    </form>

</body>
</html>