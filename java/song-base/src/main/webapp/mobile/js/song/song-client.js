//888888888888888888888888手机相关方法888888888888888888888888888888888$.extend(song, {    client: {        ua: function () {            return navigator.userAgent.toLowerCase();        },        ios: function () {            var u = song.client.ua();            if (u.indexOf("iphone") > -1 || u.indexOf("ipod") > -1 || u.indexOf("ipad") > -1) {                return true;            }            return false;        },        android: function () {            var u = song.client.ua();            if (u.indexOf("android") > -1 || u.indexOf("linux")) {                return true;            }            return false;        },        wx: function () {            var ua = song.client.ua();            if (ua.match(/MicroMessenger/i) == 'micromessenger') {                return true;            } else {                return false;            }        },        app: function () {            var ua = song.client.ua();            if (ua.indexOf("10086") > -1) {                return true;            }            return false;        },        test: function (tests) {            for (var i = 0; i < tests.length; i++) {                var obj = tests[i];                if (song.client[obj]()) {                    return obj;                }            }            return "";        },        type: function () {            //获取客户端类型            return song.client.test(["wx", "app"]);        },        system: function () {            //获取手机系统类型            return song.client.test(["ios", "android"]);        },        paramter: function (client, system) {            return {"clienttype": client || song.client.type(), "systemtype": system || song.client.system()};        }    }});