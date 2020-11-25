function getCookieMap(cookie) {
    let cookiePattern = /^(\S+)=(\S+)$/;
    let cookieArray = cookie.split("; ");
    let cookieMap = new Map();
    for(let item of cookieArray) {
        let resultArray = cookiePattern.exec(item);
        if (resultArray == null)
            return cookieMap;
        cookieMap.set(resultArray[1], resultArray[2]);
    }
    return cookieMap;
}

function getCredentials(toMain, toLogin) {
    var cookies = getCookieMap(document.cookie);
    var content = null;
    if (cookies.has("dms_token")) {
        $.ajax({
            type: "POST",
            url: "/api/loginServlet",
            headers: {
                "dms_token": cookies.get("dms_token")
            },
            data: {
                "action": "verify"
            },
            dataType: "json",
            async: false,
            statusCode: {
                200: function(response) {
                    if (toMain) {
                        window.location.href = "/user/main.jsp";
                    }
                    else {
                        content = response;
                    }
                },
                510: function() {
                    alert("凭证已过期，请重新登录！");
                    window.location.href = "/index.jsp";
                }
            }
        });
    }
    else if (toLogin) {
        window.location.href = "/index.jsp";
    }
    return content;
}