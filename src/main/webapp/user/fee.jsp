<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dashboard.css">
    <title>水电费</title>
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
                </ul>
            </div>
        </nav>
    </div>
    <h1 class="h3 mb-3 font-weight-normal text-center">水电费缴纳情况</h1>
    <div class="row">
        <nav class="col-1 d-md-block bg-light sidebar collapse">
            <div class="sidebar-sticky pt-3">
                <ul class="nav flex-column text-center" style="font-size: 13px;">
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="#" onclick="">更改密码</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="col-11">
            <div id="f">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">时间</th>
                        <th scope="col">金额</th>
                        <th scope="col">种类</th>
                        <th scope="col">是否缴纳</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="fee in fees">
                        <td v-text="fee.fdate"></td>
                        <td v-text="fee.famount"></td>
                        <td v-text="fee.ftype"></td>
                        <td v-text="fee.fpaid"></td>
                        <td><input name="pay" type="button" value="缴纳" onclick="getDate(this)"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var info = getCredentials(false, true);

    function getFpaid(fpaid) {
        if(fpaid)
            return '已缴纳';
        else
            return '未缴纳';
    }
    var cookies = getCookieMap(document.cookie);
    new Vue({
        el: '#f',
        data: {
            fees: []
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
                    "action": "selectFeesWithSno"
                },
                dataType: "json",
                async: false,
                statusCode: {
                    200: function(response) {
                        for (var i in response) {
                            response[i]["fpaid"] = getFpaid(response[i]["fpaid"]);
                        }
                        self.fees = response;
                    }
                }
            });
        }
    })
    function getDate(tag) {
        var fdate = $(tag).parent().siblings()[0].innerHTML;
        alert(fdate);
    }
</script>

</body>
</html>