<%--  Created by IntelliJ IDEA.  User: song  Date: 2018/1/3  Time: 10:25  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/layout/simpleHeader.jsp"%><link rel="stylesheet" href="/static/style/global.css"/><link rel="stylesheet" href="/static/js/uploader/webuploader.css"/><script type="text/javascript" src="/static/js/uploader/webuploader.min.js"></script><div id="uploader" class="wu-example">    <!--用来存放文件信息-->    <div id="thelist" class="uploader-list"></div>    <div class="btns">        <div id="picker">选择文件</div>        <button id="btnUpload" class="btn btn-default">开始上传</button>    </div></div><script type="text/javascript">    var state = 'pending',        $btn=$("#btnUpload");    var uploader = WebUploader.create({        auto:false,        // swf文件路径        swf:  "/static/js/uploader/Uploader.swf",        // 文件接收服务端。        server: window.root+'uploader/upload',        // 选择文件的按钮。可选。        // 内部根据当前运行是创建，可能是input元素，也可能是flash.        pick: '#picker',        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！        resize: false,        // 只允许选择文件，可选。        accept: {            title: 'Images',            extensions: 'gif,jpg,jpeg,bmp,png',            mimeTypes: 'image/*'        }    });    uploader.on( 'fileQueued', function( file ) {        /*var file = {            id: "WU_FILE_0",            ext: "zip",            name: "bingo-jar.zip",            type: "application/zip",            size: 212112,            statusText: "",            lastModifiedDate: ""        };*/        $("#thelist").append( '<div id="' + file.id + '" class="item">' +            '<h4 class="info">' + file.name + '</h4>' +            '<p class="state">等待上传...</p>' +            '</div>' );    });    uploader.on( 'uploadProgress', function( file, percentage ) {        var $li = $( '#'+file.id ),            $percent = $li.find('.progress .progress-bar');      /*  // 避免重复创建        if ( !$percent.length ) {            $percent = $('<div class="progress progress-striped active">' +                '<div class="progress-bar" role="progressbar" style="width: 0%">' +                '</div>' +                '</div>').appendTo( $li ).find('.progress-bar');        }        $li.find('p.state').text('上传中');        $percent.css( 'width', percentage * 100 + '%' );*/    });    uploader.on( 'uploadSuccess', function( file ,result) {        $( '#'+file.id ).find('p.state').text('已上传');    });    uploader.on( 'uploadError', function( file ) {        $( '#'+file.id ).find('p.state').text('上传出错');    });    uploader.on( 'uploadComplete', function( file ) {        $( '#'+file.id ).find('.progress').fadeOut();    });    uploader.on( 'all', function( type ) {        if ( type === 'startUpload' ) {            state = 'uploading';        } else if ( type === 'stopUpload' ) {            state = 'paused';        } else if ( type === 'uploadFinished' ) {            state = 'done';        }        if ( state === 'uploading' ) {            $btn.text('暂停上传');        } else {            $btn.text('开始上传');        }    });    $btn.on( 'click', function() {        if ( state === 'uploading' ) {            uploader.stop();        } else {            uploader.upload();        }    });</script><%@ include file="/layout/footer.jsp"%><style type="text/css">    #picker {        display: inline-block;        line-height: 1.428571429;        vertical-align: middle;        margin: 0 12px 0 0;        box-sizing: border-box;    }</style>