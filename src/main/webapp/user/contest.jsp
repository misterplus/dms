<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>卫生评比</title>
</head>
<body>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/static/js/verify.js"></script>
<script src="${pageContext.request.contextPath}/webjars/vue/2.6.11/vue.js"></script>
    <div class="container-fluid">
        <h1 class="h3 mb-3 font-weight-normal text-center">卫生评比结果</h1>
        <div class="row">
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
        $("#usertype")[0].innerHTML = info["usertype"];

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