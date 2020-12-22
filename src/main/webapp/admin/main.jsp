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
    <script src="${pageContext.request.contextPath}/webjars/vue/2.6.11/vue.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/verify.js"></script>
    <script type="text/javascript">
        var info = getCredentials(false, true);
        if (info["usertype"] !== "admin") {
            window.location.href = "/user/main.jsp";
        }
    </script>
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #448ef6;">
                    <a class="navbar-brand h1" href="#">管理面板</a>
                    <div class="collapse navbar-collapse">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/main.jsp">用户</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/dorm.jsp">宿舍</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/fee.jsp">水电</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/repair.jsp">维修</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/contest.jsp">卫生评比</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/contest.jsp">通知</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/item/item.jsp">物品存取</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/guest.jsp">访客</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/query.jsp">查看统计</a>
                            </li>
                        </ul>
                    </div>
                    <div class="btn-group dropdown">
                        <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            导入学生名单
                        </button>
                        <div class="dropdown-menu">
                            <form name="import" action="${pageContext.request.contextPath}/api/importServlet" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="file">上传名单</label>
                                    <input type="file" class="form-control" name="list" id="file">
                                </div>
                                <button type="submit">导入</button>
                            </form>
                        </div>
                    </div>
                    <button class="btn btn-danger my-2 my-sm-0" type="button" onclick="logout()">登出</button>
                </nav>
            </div>
        </div>
        <div class="row">
            <nav class="col-1 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column text-center" style="font-size: 13px;">
                        <li class="nav-item mt-1 mb-1">
                            <a class="side-link" href="#">学生名单</a>
                        </li>
                        <li class="nav-item mt-1 mb-1">
                            <a class="side-link" href="${pageContext.request.contextPath}/admin/main/admins.jsp">管理名单</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="col-11">
                <div id="app">
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th scope="col">学号</th>
                            <th scope="col">姓名</th>
                            <th scope="col">宿舍楼</th>
                            <th scope="col">宿舍楼向</th>
                            <th scope="col">宿舍号</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="student in students">
                            <td v-text="student.sno" scope="row"></td>
                            <td v-text="student.sname"></td>
                            <td v-text="student.dbno"></td>
                            <td v-text="student.dbd"></td>
                            <td v-text="student.drbno"></td>
                            <td><a href="#" onclick="resetPass(this)">重置密码</a></td>
                            <td><a href="#" onclick="changeDorm(this)">更改宿舍</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">

        function getNumberDirection(dir) {
            switch (dir) {
                case "无":
                    return "0";
                case "东":
                    return "1";
                case "西":
                    return "2";
                case "南":
                    return "3";
                case "北":
                    return "4";
                default:
                    return "";
            }
        }

        function changeDorm(tag) {
            var sno = $(tag).parent().siblings()[0].innerHTML;
            var dbno = prompt("请输入新的宿舍楼");
            if (dbno === "")
                return;
            var dbd = getNumberDirection(prompt("请输入新的宿舍楼向"));
            if (dbd === "")
                return;
            var drbno = prompt("请输入新的宿舍号");
            if (drbno === "")
                return;
            $.ajax({
                type: "POST",
                url: "/api/editServlet",
                headers: {
                    "dms_token": cookies.get("dms_token")
                },
                data: {
                    "action": "updateStudentDorm",
                    "sno": sno,
                    "dbno": dbno,
                    "dbd": dbd,
                    "drbno": drbno
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

        function resetPass(tag) {
            var sno = $(tag).parent().siblings()[0].innerHTML;
            $.ajax({
                type: "POST",
                url: "/api/editServlet",
                headers: {
                    "dms_token": cookies.get("dms_token")
                },
                data: {
                    "action": "resetStudentPass",
                    "sno": sno
                },
                dataType: "json",
                async: false,
                statusCode: {
                    200: function(response) {
                        alert("重置成功！");
                        location.reload();
                    },
                    621: function () {
                        alert("重置失败！");
                    }
                }
            });
        }

        function getDormDirection(dbd) {
            switch (dbd) {
                case "0":
                    return "无";
                case "1":
                    return "东";
                case "2":
                    return "西";
                case "3":
                    return "南";
                case "4":
                    return "北";
            }
        }
        var cookies = getCookieMap(document.cookie);
        new Vue({
            el: '#app',
            data: {
                students: []
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
                        "action": "selectStudents"
                    },
                    dataType: "json",
                    async: false,
                    statusCode: {
                        200: function(response) {
                            for (var i in response) {
                                response[i]["dbd"] = getDormDirection(response[i]["dbd"]);
                            }
                            self.students = response;
                        }
                    }
                });
            }
        })
    </script>
</body>
</html>