function getRepairSheet() {
    var cookies = getCookieMap(document.cookie);
    var form = document.forms["repairSheet"]
    if (cookies.has("dms_token")) {
        $.ajax({
            type: "POST",
            url: "/api/editServlet",
            headers: {
                "dms_token": cookies.get("dms_token")
            },
            data: {
                "action": "insertRepairSheet",
                "rtype":form["rtype"].value,
                "rcon":form["rcon"].value,
            },
            dataType: "json",
            async: false,
            statusCode: {
                200: function() {
                    alert("提交成功");
                },
                622: function() {
                    alert("提交失败");
                }
            }
        });
    }
}