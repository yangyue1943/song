<%--  Created by IntelliJ IDEA.  User: song  Date: 2018/1/10  Time: 15:52  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/layout/header.jsp"%><script type="text/javascript" src="js/codebuilder.js"></script><script type="text/javascript">    var root = "/page/codebuilder/js/";    viewCode.builder().setRoute({        loadTree:root+"tree.json"    });</script><%@ include file="/layout/footer.jsp"%>