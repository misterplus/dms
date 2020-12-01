function getContestResult() {
    var cookies = getCookieMap(document.cookie);
    if (cookies.has("dms_token")) {
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
                200: function() {

                },
                620: function() {
                    alert("查看失败")
                }
            }
        });
    }
}