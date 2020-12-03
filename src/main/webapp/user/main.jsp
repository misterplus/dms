<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dashboard.css">
    <title>学生宿舍管理系统</title>
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
                </ul>
            </div>
        </nav>
        </div>
        <div class="row">
            <nav class="col-1 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column text-center" style="font-size: 13px;">
                        <li class="nav-item mt-1 mb-1">
                            <a href="#" onclick="resetPass(this)">更改密码</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="col-6">
                <div id="app">
                    <table class="table table-bordered table-striped">
                        <tbody>
                        <th scope="col">学号</th>
                        <tr v-text="student.sno" scope="col"></tr>
                        <th scope="col">姓名</th>
                        <tr v-text="student.sname"></tr>
                        <th scope="col">宿舍楼</th>
                        <tr v-text="student.dbno"></tr>
                        <th scope="col">宿舍楼向</th>
                        <tr v-text="student.dbd"></tr>
                        <th scope="col">宿舍号</th>
                        <tr v-text="student.drbno"></tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var info = getCredentials(false, true);

        function getDormDirection(dbd) {
            switch (dbd) {
                case "0":
                    return "无";
                case "1":
                    return "东";
                case "2":
                    return "南";
                case "3":
                    return "西";
                case "4":
                    return "北";
            }
        }
        var cookies = getCookieMap(document.cookie);
        new Vue({
            el: '#app',
            data: {
                student: ""
            },
            created: function () {
                var self = this;
                $.ajax({
                    type: "POST",
                    url: "/api/infoServlet",
                    headers: {
                        "dms_token": cookies.get("dms_token")
                    },
                    data: {
                        "action": "selectStudentWithSno"
                    },
                    dataType: "json",
                    async: false,
                    statusCode: {
                        200: function(response) {
                            response["dbd"] = getDormDirection(response["dbd"]);
                            self.student = response;
                        }
                    }
                });
            }
        })

        function resetPass() {
            var newpass = prompt("请输入新密码");
            var passagain = prompt("请再次输入密码");
            if(newpass != passagain)
                alert("两次输入不一致，请重试");
            else{
                $.ajax({
                    type: "POST",
                    url: "/api/editServlet",
                    headers: {
                        "dms_token": cookies.get("dms_token")
                    },
                    data: {
                        "action": "updateStudentPass",
                        "spass": newpass
                    },
                    dataType: "json",
                    async: false,
                    statusCode: {
                        200: function(response) {
                            alert("更改成功！");
                            location.reload();
                        },
                        621: function () {
                            alert("更改失败！");
                        }
                    }
                });
            }

        }
    </script>

</body>
</html>