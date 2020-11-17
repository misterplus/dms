function swapPlaceholder(type) {
    document.getElementById('username').setAttribute('placeholder', '请输入' + type);
    document.getElementsByClassName('invalid-feedback')[0].innerHTML = type + '不能为空!';
}