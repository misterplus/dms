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
                            <a class="nav-link" href="#">宿舍</a>
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/notice.jsp">通知</a>
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
                <button class="btn btn-danger my-2 my-sm-0" type="button" onclick="logout()">登出</button>
            </nav>
        </div>
    </div>
    <div class="row">
        <nav class="col-1 d-md-block bg-light sidebar collapse">
            <div class="sidebar-sticky pt-3">
                <ul class="nav flex-column text-center" style="font-size: 13px;">
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="#">宿舍名单</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/dorm/newDorm.jsp">新增宿舍</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/dorm/deleteDorm.jsp">删除寝室</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/dorm/student.jsp">查看宿舍</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/dorm/dormNotFull.jsp">未满宿舍</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="col-11">
            <div id="app">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">宿舍楼</th>
                        <th scope="col">宿舍楼向</th>
                        <th scope="col">宿舍号</th>
                        <th scope="col">宿舍长</th>
                        <th scope="col">宿舍容量</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="content in contents">
                        <td v-text="content.dbno" scope="row"></td>
                        <td v-text="content.dbd"></td>
                        <td v-text="content.drbno"></td>
                        <td v-text="content.dmno"></td>
                        <td v-text="content.dcap"></td>
                        <td><a href="#" onclick="setMon(this)">修改宿舍长</a></td>
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

    function setMon(tag) {
        var dbno = $(tag).parent().siblings()[0].innerHTML;
        var dbd = getNumberDirection($(tag).parent().siblings()[1].innerHTML);
        var drbno = $(tag).parent().siblings()[2].innerHTML;
        var dmno = prompt("请输入新的宿舍长学号");
        if (dmno!=null){
            if (dmno !== ""){
                $.ajax({
                    type: "POST",
                    url: "/api/editServlet",
                    headers: {
                        "dms_token": cookies.get("dms_token")
                    },
                    data: {
                        "action": "updateDormMonitor",
                        "dbno": dbno,
                        "dbd": dbd,
                        "drbno": drbno,
                        "dmno": dmno
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
            }else {
                alert("宿舍长学号不为空")
            }
        }
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
            contents: []
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
                    "action": "selectDRooms"
                },
                dataType: "json",
                async: false,
                statusCode: {
                    200: function(response) {
                        for (var i in response) {
                            response[i]["dbd"] = getDormDirection(response[i]["dbd"]);
                        }
                        self.contents = response;
                    }
                }
            });
        }
    })
</script>
</body>
</html>