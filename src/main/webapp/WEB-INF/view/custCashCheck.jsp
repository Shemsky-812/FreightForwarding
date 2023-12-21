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
    <script src="${ctx}/assets/users/js/checkTx.js" type="text/javascript"></script>
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
                    <div class="caption">交易复核-提现</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="custCashForm" name="custCashForm" >
	                    <div class="form-body">
	                    	<input type="hidden" class="form-control" id="tradId" name="tradId" value="${tradId}">
	                        <br>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 提现企业 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="tradFromName" name="tradFromName" value="${tradFromName}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 可用余额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="amtFree" name="amtFree" value="${amtFree}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 提现金额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="tradAmt" name="tradAmt" value="${tradAmt}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 开户行 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountBank" name="accountBank" value="${accountBank}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 开户名称 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountName" name="accountName" value="${accountName}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 收款账号 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountNum" name="accountNum" value="${accountNum}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 支付机构</label>
	                            <div class="col-md-3">
	                            	<input type="text" class="form-control" id="tradToName" name="tradToName" value="${tradToName}" readonly>
	                        	</div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 手续费率</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="chargeRate" name="chargeRate" value="${chargeRate}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 手续费金额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="rateAmt" name="rateAmt" value="${rateAmt}" readonly>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>&nbsp;
									<a class="btn btn-success" href="#checkModal" data-toggle="modal">复核</a>
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
<div id="checkModal" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <span>转账复核</span>
                </h4>
            </div>
            <div class="modal-body">
                <form id="checkForm" name="checkForm" novalidate="novalidate">
                	<div class="form-body">
                		<input type="hidden" class="form-control" id="txType" name="txType" value="cashCheck">
                		<input type="hidden" class="form-control" id="txId" name="txId" value="${tradId}">
                		<input type="hidden" class="form-control" id="txStatus" name="txStatus" value="${status}">
	                    <div class="form-group ">
	                        <label>复核信息</label>
	                        <textarea class="form-control" rows="3" id="checkMsg" name="checkMsg" required="required"></textarea>
	                    </div>
	                    <input type="hidden" class="form-control" id="checkStatus" name="checkStatus">
                		<input type="hidden" class="form-control" id="checkId" name="checkId" value="${checkId}">
                		<input type="hidden" class="form-control" id="checkFilePath" name="checkFilePath" value="null">
                    </div>
					<div class="form-actions">
						<button type="button" class="btn default close-button" data-dismiss="modal">取消</button>
						<button class="btn btn-warning" onclick="$('#checkStatus').val('refuse')">不通过</button>
						<button type="submit" class="btn btn-success" onclick="$('#checkStatus').val('agree')">通过</button>
					</div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>