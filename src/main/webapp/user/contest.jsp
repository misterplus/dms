<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/page.css">
    <title>卫生评比</title>
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
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/dorm.jsp">寝室</a>
                    </li>
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/setting.jsp">设置</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
        <h1 class="h3 mb-3 font-weight-normal text-center">卫生评比结果</h1>
        <div class="row">
            <nav class="col-1 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column text-center" style="font-size: 13px;">
                        <li class="nav-item mt-1 mb-1">
                        </li>
                        <li class="nav-item mt-1 mb-1">
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="col-11">
                <div id="c">
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th scope="col">时间</th>
                            <th scope="col">分数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="contest in contests">
                            <td v-text="contest.cdate"></td>
                            <td v-text="contest.cscore"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</div>
    <script type="text/javascript">
        var info = getCredentials(false, true);

        var cookies = getCookieMap(document.cookie);
        new Vue({
            el: '#c',
            data: {
                contests: []
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
                        "action": "selectCleanContestsWithSno"
                    },
                    dataType: "json",
                    async: false,
                    statusCode: {
                        200: function(response) {
                            self.contests = response;
                        }
                    }
                });
            }
        })
    </script>

</body>
</html>