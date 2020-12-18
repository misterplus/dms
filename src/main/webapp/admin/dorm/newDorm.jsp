<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/dashboard.css">
    <title>学生宿舍管理系统</title>
</head>
<body>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
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
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/dorm.jsp">宿舍名单</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="#">新增宿舍</a>
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
                    <label for="height">楼层数</label>
                    <input type="text" class="form-control" name="height" id="height" placeholder="请输入宿舍楼层数" required
                           onkeyup="this.value=this.value.replace(/\D/g, '')">
                    <div class="invalid-feedback">
                        楼层数不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label for="rooms">每层房间数</label>
                    <input type="text" class="form-control" name="rooms" id="rooms" placeholder="请输入宿舍楼每层房间数" required
                           onkeyup="this.value=this.value.replace(/\D/g, '')">
                    <div class="invalid-feedback">
                        每层房间数不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label>分楼模式</label>
                    <div class="form-check form-check-inline mx-auto pb-2">
                        <input type="radio" class="form-check-input" name="method" id="0" value="0" checked>
                        <label class="form-check-label" for="0">无分楼</label>
                    </div>
                    <div class="form-check form-check-inline mx-auto pb-2">
                        <input type="radio" class="form-check-input" name="method" id="12" value="12">
                        <label class="form-check-label" for="12">东西</label>
                    </div>
                    <div class="form-check form-check-inline mx-auto pb-2">
                        <input type="radio" class="form-check-input" name="method" id="34" value="34">
                        <label class="form-check-label" for="34">南北</label>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" onclick="newDorm()">新增</button>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    function newDorm() {
        var cookies = getCookieMap(document.cookie);
        var form = document.forms["dorms"];
        $.ajax({
            type: "POST",
            url: "/api/editServlet",
            headers: {
                "dms_token": cookies.get("dms_token")
            },
            data: {
                "action": "newDorm",
                "dbno": form["dbno"].value,
                "height": form["height"].value,
                "rooms": form["rooms"].value,
                "method": form["method"].value
            },
            dataType: "json",
            async: false,
            statusCode: {
                200: function(response) {
                    alert("新增成功！");
                }
            }
        });
    }
</script>
</body>
</html>