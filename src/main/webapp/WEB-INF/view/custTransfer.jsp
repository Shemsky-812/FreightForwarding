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
		var saveBtn = "${saveBtn}";
	</script>
	
	<%@ include file="common/importCss.jsp"%>
    <%@ include file="common/importJs.jsp"%>
    <script src="${ctx}/assets/users/js/custTransfer.js" type="text/javascript"></script>
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
                    <div class="caption">账户信息-转账</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="custTransferForm" name="custTransferForm" >
	                    <div class="form-body">
	                    	<input type="hidden" class="form-control" id="custId" name="custId" value="${custId}">
	                        <br>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 转出企业 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="custName" name="custName" value="${custName}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 可用余额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="amtFree" name="amtFree" value="${amtFree}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 转出金额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="tradAmt" name="tradAmt" onkeyup="CountRateAmt();">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 转入企业</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="tradTo" name="tradTo">
	                                	<option >请选择...</option>
	                                </select>
	                                <input type="hidden" class="form-control" id="tradToName" name="tradToName">
	                            </div>
	                        </div>
	                        <div class="form-group">
                                <label class="control-label col-md-3">贸易合同</label>
                                <div class="col-md-3">
                                    <input type="file" id = "paperFile" name="file" onchange="fileUploadBtn('paperFile');">
                                    <input type="hidden" class="form-control" id="filePath" name="filePath" readonly>
                                </div>
                            </div>
                            <div class="form-group">
	                            <label class="control-label col-md-3"> 手续费率</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="chargeRate" name="chargeRate" value="${chargeRate}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 手续费金额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="rateAmt" name="rateAmt" readonly>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>&nbsp;
									<button class="btn green">提交</button>
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