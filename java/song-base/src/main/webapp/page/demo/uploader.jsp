<%--  Created by IntelliJ IDEA.  User: song  Date: 2018/1/3  Time: 10:25  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="../layout/header.jsp" %><link rel="stylesheet" href="../js/uploader/webuploader.css"/><script type="text/javascript" src="../js/uploader/webuploader.min.js"></script><script type="text/javascript" src="../js/cmp/cmp.uploader.js"></script><div id="dialog">    <div id="uploader"></div>    <button id="uploadButton">获取上传数据</button>    <button id="btnClearUpload">重置控件</button></div><script type="text/javascript">    window.view = new cmp.view({        ready: function () {            var that=this;            this.dialog = new cmp.dialog("#dialog",{                width:400,                height:300            });            this.uploader = new cmp.uploader("#uploader", {                showUploadButton:true,                data:[{id:"ds",size:21,name:"aaa.txt"}]            });            //获取上传数据            $("#uploadButton").click(function () {                var data=that.uploader.getData();                alert(JSON.stringify(data));            });            $("#btnClearUpload").click(function () {                that.uploader.clear();            });            this.dialog.open();        }    });</script><%@ include file="../layout/footer.jsp" %>