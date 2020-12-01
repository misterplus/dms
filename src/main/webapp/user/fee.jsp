<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>水电费</title>
</head>
<body>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/static/js/verify.js"></script>
<script src="${pageContext.request.contextPath}/webjars/vue/2.6.11/vue.js"></script>

<div class="container-fluid">
    <div class="row">
        <div class="col-11">
            <div id="f">
                <form name="fee" onsubmit="">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">宿舍楼</th>
                        <th scope="col">宿舍楼向</th>
                        <th scope="col">宿舍号</th>
                        <th scope="col">水电费</th>
                        <th scope="col">是否缴纳</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td v-text="fee.dbno"></td>
                        <td v-text="fee.dbd"></td>
                        <td v-text="fee.drbno"></td>
                        <td v-text="fee.ftype"></td>
                        <td v-text="fee.fpaid"></td>
                        <td><input type="submit" value="缴纳"></td>
                    <tr>
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var info = getCredentials(false, true);
    $("#usertype")[0].innerHTML = info["usertype"];

    function getFpaid(fpaid) {
        if(fpaid)
            return '是';
        else
            return '否';
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
</script>

</body>
</html>