<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dashboard.css">
    <title>报修</title>
</head>
<body>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/static/js/verify.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/vue/2.6.11/vue.js"></script>


    <div class="container-fluid">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #448ef6;">
                <a class="navbar-brand h1" href="./main.jsp" id="usertype">首页</a>
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/repair.jsp">报修</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/fee.jsp">水电</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/contest.jsp">卫生</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/notice.jsp">通知</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">退出</a>
                        </li>
                    </ul>
                </div>
                <button class="btn btn-danger my-2 my-sm-0" type="button" onclick="logout()">登出</button>
            </nav>
        </div>
        <div class="row">
            <nav class="col-1 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column text-center" style="font-size: 13px;">
                        <li class="nav-item mt-1 mb-1">
                            <a class="side-link" href="${pageContext.request.contextPath}/user/rprogress.jsp">查看维修进度</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="col-11">
                <form class="needs-validation" novalidate name="repairSheet" onsubmit="getRepairSheet()" method="post">
                <h1 class="h3 mb-3 font-weight-normal text-center">报修申请</h1>
                <div class="form-group" align="center">
                    报修种类：
                    <select name="rtype">
                        <option value="">----请选择报修类型----</option>
                        <option value="水电">水电</option>
                        <option value="木工">木工</option>
                        <option value="水泥工">水泥工</option>
                        <option value="空调">空调</option>
                        <option value="其他">其他</option>
                    </select><br>
                    报修内容：<textarea name="rcon" rows="8" cols="30" placeholder="请输入报修内容"></textarea><br>
                    <button type="submit" class="btn btn-primary btn-lg">提交</button>
                </div>
            </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var info = getCredentials(false, true);

        var cookies = getCookieMap(document.cookie);
        function getRepairSheet() {
            var cookies = getCookieMap(document.cookie);
            var form = document.forms["repairSheet"];
            if(form["rcon"].value==="")
                alert("提交失败，内容不能为空");
            else {
                if(form["rtype"].value==="")
                    alert("提交失败，请选择报修类型");
                else {
                    if (cookies.has("dms_token")) {
                        $.ajax({
                            type: "POST",
                            url: "/api/editServlet",
                            headers: {
                                "dms_token": cookies.get("dms_token")
                            },
                            data: {
                                "action": "insertRepairSheet",
                                "rtype":form["rtype"].value,
                                "rcon":form["rcon"].value,
                            },
                            dataType: "json",
                            async: false,
                            statusCode: {
                                200: function() {
                                    alert("提交成功");
                                },
                                622: function() {
                                    alert("提交失败");
                                }
                            }
                        });
                    }
                }

            }

        }
    </script>
</body>
</html>