function encrypted(data) {
    var encrypt = new JSEncrypt();
    var pubkey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzMkN5QPdxkRqUyDKEhz+5LKScCiukgYX\n" +
        "Q0PjusJLOxB25aX91WEMiNNRVdZdpYjhj7B1cGki2DQFiCWyO6kW5hYHIzjSebmt7qGq/t5oAJpc\n" +
        "1zi59xLdjxaIXrSRkHeJ4tISPZ2Pwtvc4p+j22e5bbLA5QkMVJMqzT//6w+0uxdi/g9x6Ok6EdSe\n" +
        "7/6M1zCsrgxqZXCKX+Rcio9UejDlH8XUqqyLS762AdM5JgmK5C4+gfVSsgrexLw1QiRyzmzd5kLe\n" +
        "thHOYsi33gfuBFdNdYRCCntxUoN2bEXa5uuRzxtwE3CZplmLDlr9vfS0NrVsVdv/eSBwq6m8KhjL\n" +
        "2kUJOQIDAQAB";
    encrypt.setPublicKey(pubkey);
    return encrypt.encrypt(data);
}

/**
 * 获取参数
 * @param name
 * @returns {string}
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) {
        return decodeURIComponent(r[2]);
    }
    return '';
}


/**
 * 添加cookie
 * @param name cookie名字
 * @param value 值
 */
function setCookie(name, value, Days)
{
    if(Days == null|| Days == ''){
        Days = 30;
    }

    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

/**
 * 获取cookie
 * @param name cookie名称
 * @returns cookie的值
 */
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null) return unescape(arr[2]);
    return null;
}

/**
 * 删除cookie
 * @param name cookie名字
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) {
        // 这里删除操作其实是将expires过期时间设置为当前时间，使cookie立即过期
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    }
}

/**
 * 获取当前时间
 */
function getTime() {
    let  date = new Date();
    return date.toLocaleString('chinese', { hour12: false });
}

/**
 * 字符串格式化
 * @returns {string}
 */
String.prototype.format = function () {
    var values = arguments;
    return this.replace(/\{(\d+)\}/g, function (match, index) {
        if (values.length > index) {
            return values[index];
        } else {
            return "";
        }
    });
};