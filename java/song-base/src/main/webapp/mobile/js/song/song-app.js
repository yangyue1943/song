//888888888888888888888888APP公用方法888888888888888888888888888888888$.extend(song, {    app: {        shareing:false,        onekeyCheck: function () {            //一键检测            var class_name_ios = "OneKeyCheckoutController";            var class_name_android = "zz.dela.cmcc.traffic.activity.OneKeyCheckActivity";            var class_name_src = "xizangyingxiao";            window.g_service.clickServiceOnMobile(class_name_android, class_name_ios, class_name_src);        },        share:function (param,success) {            //app分享            if (song.app.shareing){                return false;            }            var ios=song.client.ios(),                android=song.client.android();            if (!ios && !android){                return false;            }            song.app.shareing=true;            //app分享            var shareData={                "activityId":750,                "type":0,                "normaltem":param,                "specialList":[]            };            if (android && window.g_share){                window.g_share.clickOnAndroid(encodeURIComponent(JSON.stringify(shareData)));            }else if (ios) {                window.location.href = "ios://callShare?data="+ JSON.stringify(shareData);            }            success && success();            setTimeout(function () {                song.app.shareing = false;            }, 1500);        },        exists:function (success) {            //检测是否app打开            if (!song.client.app()) {                song.gotoUrl(song.buildUrl("common/apperror.jsp"));            }else{                success && success();            }        }    }});