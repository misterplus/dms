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
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/repair.jsp">查看维修单</a>
                    </li>
                    <li class="nav-item mt-1 mb-1">
                        <a class="side-link" href="${pageContext.request.contextPath}/admin/repair/#">增加维修单</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="col-3">
            <form class="needs-validation" novalidate name="dorms">
                <div class="form-group">
                    <label for="rsno">报修人学号</label>
                    <input type="text" class="form-control" name="rsno" id="rsno" placeholder="请输入报修人学号">
                    <div class="invalid-feedback">
                        报修人学号不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label for="reman">维修人姓名</label>
                    <input type="text" class="form-control" name="reman" id="reman" placeholder="请输入维修人姓名">
                    <div class="invalid-feedback">
                        维修人姓名不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label for="remanno">维修工工号</label>
                    <input type="text" class="form-control" name="remanno" id="remanno" placeholder="请输入维修人姓名">
                    <div class="invalid-feedback">
                        维修人姓名不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label for="rereason">故障原因</label>
                    <input type="text" class="form-control" name="rereason" id="rereason" placeholder="请输入故障原因">
                    <div class="invalid-feedback">
                        故障原因不能为空!
                    </div>

                </div>
                <div class="form-group">
                    <label for="recost">维修金额</label>
                    <input type="text" class="form-control" name="recost" id="recost" placeholder="请输入维修金额">
                    <div class="invalid-feedback">
                        维修金额不能为空!
                    </div>
                </div>
                <div class="form-group">
                    <label>维修进度</label><br>
                    <div class="form-check form-check-inline mx-auto pb-2">
                        <input type="radio" class="form-check-input" name="method" id="0" value="待分配" checked>
                        <label class="form-check-label" for="0">待分配</label>
                    </div>
                    <div class="form-check form-check-inline mx-auto pb-2">
                        <input type="radio" class="form-check-input" name="method" id="12" value="维修中">
                        <label class="form-check-label" for="12">维修中</label>
                    </div>
                    <div class="form-check form-check-inline mx-auto pb-2">
                        <input type="radio" class="form-check-input" name="method" id="34" value="完成维修">
                        <label class="form-check-label" for="34">完成维修</label>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" onclick="">新增</button>

            </form>
        </div>
    </div>
</div>
</body>
</html>