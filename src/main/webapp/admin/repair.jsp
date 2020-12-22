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
        window.location.href = "../../user/main.jsp";
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
                            <a class="nav-link" href="#">维修</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/contest.jsp">卫生评比</a>
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
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/repair/queryrepairsheet.jsp">查看报修单</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="col-11">
            <div id="app">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">维修单号</th>
                        <th scope="col">报修单号</th>
                        <th scope="col">维修工姓名</th>
                        <th scope="col">维修工工号</th>
                        <th scope="col">故障原因</th>
                        <th scope="col">维修金额</th>
                        <th scope="col">维修进度</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="resheet in resheets">
                        <td v-text="resheet.reno" scope="row"></td>
                        <td v-text="resheet.rsno"></td>
                        <td v-text="resheet.reman"></td>
                        <td v-text="resheet.remanno"></td>
                        <td v-text="resheet.rereason"></td>
                        <td v-text="resheet.recost"></td>
                        <td v-text="resheet.restatus"></td>
                        <td><input name="change" type="button" value="修改状态" onclick="change(this)"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var info = getCredentials(false, true);

    function change(tag) {
        var reno = $(tag).parent().siblings()[0].innerHTML;
        var restatus = prompt("请输入维修状态");
        if(restatus!=null){
            if(restatus!==""){
                $.ajax({
                    type: "POST",
                    url: "/api/editServlet",
                    headers: {
                        "dms_token": cookies.get("dms_token")
                    },
                    data: {
                        "action": "updateRpSheetStatus",
                        "reno":reno,
                        "restatus":restatus,
                    },
                    dataType: "json",
                    async: false,
                    statusCode: {
                        200: function(response) {
                            location.reload();
                            alert("修改成功");
                        },
                        621: function() {
                            alert("修改失败");
                        }
                    }
                });
            }else alert("维修状态不能为空！")
        }

    }

    var cookies = getCookieMap(document.cookie);
    new Vue({
        el: '#app',
        data: {
            resheets: []
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
                    "action": "selectReplySheets"
                },
                dataType: "json",
                async: false,
                statusCode: {
                    200: function(response) {
                        self.resheets = response;
                    }
                }
            });
        }
    })
</script>
</body>
</html>