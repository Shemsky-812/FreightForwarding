<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html >
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <link href="${ctx}/assets/users/img/logo.png" rel="shortcut icon" />
    <title>供应链融资管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

	<script type="text/javascript">
		var ctx = "${ctx}";
	</script>
	
	<%@ include file="common/importCss.jsp"%>
    <%@ include file="common/importJs.jsp"%>
    <script src="${ctx}/assets/users/js/orgAdd.js" type="text/javascript"></script>
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">
<%@ include file="common/pageHeader.jsp" %>

<!-- BEGIN HEADER & CONTENT DIVIDER -->
<div class="clearfix"> </div>
<!-- END HEADER & CONTENT DIVIDER -->

<!-- BEGIN CONTAINER -->
<div class="page-container">
	<%@ include file="common/pageMenu.jsp" %>
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <!-- BEGIN CONTENT BODY -->
        <div class="page-content">
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption">用户管理-新增</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="orgAddForm" name="orgAddForm" >
	                    <div class="form-body">
	                        <br>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 机构代码</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="orgCode" name="orgCode" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 机构名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="orgName" name="orgName">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 机构描述</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="orgDesc" name="orgDesc">
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>&nbsp;
									<button class="btn green">保存</button>
	                            </div>
	                        </div>
	                    </div>
	                </form>
                </div>
            </div>
        </div>
        <!-- END CONTENT BODY -->
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<%@ include file="common/pageFooter.jsp" %>
</body>
</html>