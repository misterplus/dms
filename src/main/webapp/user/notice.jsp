<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dashboard.css">

    <title>通知</title>
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
            </nav>
        </div>
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
                <h1 class="h3 mb-3 font-weight-normal text-center">通知</h1>
                <div id="n">
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th scope="col">通知时间</th>
                            <th scope="col">通知标题</th>
                            <th scope="col">通知内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="notice in notices">
                            <td v-text="notice.ntime"></td>
                            <td v-text="notice.ntitle"></td>

                            <td>
                                <div id="accordion">
                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse" href="#collapseOne">
                                                单击查看
                                            </a>
                                        </div>
                                        <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                            <div class="card-body" v-text="notice.ncontent">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>

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
            el: '#n',
            data: {
                notices: []
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
                        "action": "selectNotices"
                    },
                    dataType: "json",
                    async: false,
                    statusCode: {
                        200: function(response) {
                            self.notices = response;
                        }
                    }
                });
            }
        })
    </script>
</body>
</html>