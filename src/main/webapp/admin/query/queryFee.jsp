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
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin/repair.jsp">维修</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">卫生评比</a>
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
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/query/queryFee.jsp">查看水电费情况</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/query/queryRepairProgress.jsp">查看维修情况</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/query/queryRepairProgress.jsp">查看维修情况</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="col-3">
            <form class="needs-validation" novalidate name="dorms">
                <div class="form-group">
                    <label for="dbno">宿舍楼号</label>
                    <input type="text" class="form-control" name="dbno" id="dbno" placeholder="请输入宿舍楼号" required
                           onkeyup="this.value=this.value.replace(/\D/g, '')">
                    <div class="invalid-feedback">
                        宿舍楼号不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label for="dbd">宿舍楼向</label>
                    <input type="text" class="form-control" name="dbd" id="dbd" placeholder="请输入宿舍楼向" required>
                    <div class="invalid-feedback">
                        宿舍楼向不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label for="drbno">宿舍号</label>
                    <input type="text" class="form-control" name="drbno" id="drbno" placeholder="请输入宿舍号" required
                           onkeyup="this.value=this.value.replace(/\D/g, '')">
                    <div class="invalid-feedback">
                        宿舍号不能为空!
                    </div>
                </div>
                <button type="button" class="btn btn-primary" onclick="searchDorm()">查询</button>
            </form>
        </div>
        <div class="col-8">
            <h1 class="h3 mb-3 font-weight-normal text-center">水电费缴纳情况</h1>
            <div id="f">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">序号</th>
                        <th scope="col">时间</th>
                        <th scope="col">金额</th>
                        <th scope="col">种类</th>
                        <th scope="col">是否缴纳</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="fee in fees">
                        <td v-text="fee.fno"></td>
                        <td v-text="fee.fdate"></td>
                        <td v-text="fee.famount"></td>
                        <td v-text="fee.ftype"></td>
                        <td v-text="fee.fpaid"></td>
                        <td><input name="pay" type="button" value="缴纳" onclick="pay(this)"></td>
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
                    "action": "selectFees"
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
    });
    function pay(tag) {
        var fno = $(tag).parent().siblings()[0].innerHTML;
        //alert(fdate);
        var fpaid = $(tag).parent().siblings()[4].innerHTML;
        if(fpaid==="未缴纳"){
            $.ajax({
                type: "POST",
                url: "/api/editServlet",
                headers: {
                    "dms_token": cookies.get("dms_token")
                },
                data: {
                    "action": "payFee",
                    "fno":fno
                },
                dataType: "json",
                async: false,
                statusCode: {
                    200: function(response) {
                        location.reload();
                        alert("缴纳成功");
                    },
                    621: function() {
                        alert("缴纳失败");
                    }
                }
            });
        }
        else
            alert("已缴纳，无需再缴纳");
    }
</script>

</body>
</html>