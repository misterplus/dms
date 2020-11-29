function swapPlaceholder(type) {
    $("#username").setAttribute('placeholder', '请输入' + type);
    $(".invalid-feedback")[0].innerHTML = type + '不能为空!';
}