<%--  Created by IntelliJ IDEA.  User: song  Date: 2018/1/3  Time: 10:25  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/layout/header.jsp" %><link rel="stylesheet" href="/static/js/uploader/webuploader.css"/><script type="text/javascript" src="/static/js/uploader/webuploader.min.js"></script><script type="text/javascript" src="/static/js/cmp/cmp.uploader.js"></script><%--<div class="uploader" style="width: 600px; margin: 30px;">    <div class="uploader-btns">        <div id="uploaderSelect" class="uploader-select">选择文件</div>        <button id="uploaderStart" class="uploader-btn">开始上传</button>    </div>    <!--用来存放文件信息-->    <div id="uploaderList" class="uploader-list">        &lt;%&ndash;<a class="uploader-item">            <span class="uploader-progress" style="width:20%;"></span>            <span class="uploader-filename">上传的文件名要长一点才能测试.jpg</span>            <span class="uploader-state">上传中(20%)</span>        </a>        <a class="uploader-item">            <span class="uploader-progress" style="width:70%;"></span>            <span class="uploader-filename">上传的文件名要长一点才能测试.jpg</span>            <span class="uploader-state">上传中(70%)</span>        </a>&ndash;%&gt;    </div></div>--%><div id="uploader"></div><script type="text/javascript">    window.view = new cmp.view({        ready:function () {            this.uploader = new cmp.uploader("#uploader", {                width:"800px",                data:[{id:"ew",name:"测试文件名.zip"}]            });        }    });</script><%@ include file="/layout/footer.jsp" %>