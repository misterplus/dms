function getDorm() {
    var cookies = getCookieMap(document.cookie);
    var content = null;
    if (cookies.has("dms_token")) {
        $.ajax({
            type: "POST",
            url: "/api/infoServlet",
            headers: {
                "dms_token": cookies.get("dms_token")
            },
            data: {
                "action": "selectRepairSheetsWithSno"
            },
            dataType: "json",
            async: false,
            statusCode: {
                200: function(response) {
                    content = response;
                },
                620: function() {
                    alert("查看失败")
                }
            }
        });
    }
    return content;
}