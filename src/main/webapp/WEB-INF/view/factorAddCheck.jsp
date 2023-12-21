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
                    <div class="caption">保理合同-录入复核</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" >
	                    <div class="form-body">
	                    	<input type="hidden" class="form-control" id="factorId" name="factorId" value="${factorId}" readonly>
	                        <br>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理合同编号 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="factorCode" name="factorCode" value="${factorCode}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 卖方</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="custSellName" name="custSellName" value="${custSellName}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理商</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="custfactorName" name="custfactorName" value="${custfactorName}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理金额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="factorAmt" name="factorAmt" value="${factorAmt}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 还款方式</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="payment" name="payment" value="${payment}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理利率</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="rate" name="rate" value="${rate}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理利息</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="interest" name="interest" value="${interest}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理期限</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="tenor" name="tenor" value="${tenor}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 开始日期</label>
	                            <div class="col-md-3">
	                                <input type="date" class="form-control" id="startDate" name="startDate" value="${startDate}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 到期日期</label>
	                            <div class="col-md-3">
	                                <input type="date" class="form-control" id="endDate" name="endDate" value="${endDate}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
                                <label class="control-label col-md-3">保理合同附件</label>
                                <div class="col-md-3">
                                	<a class="btn default" href='${ctx}${filePath}'>查看保理合同</a>
                                </div>
                            </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 备注</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="remark" name="remark" value="${remark}" readonly>
	                            </div>
	                        </div>
	                    </div>
	                </form>
					<div class="row">
	    				<div class="col-md-offset-3 col-md-9">
	        				<a class="btn default" onclick="history.go(-1)">返回</a>&nbsp;
							<a class="btn btn-success" href="#checkModal" data-toggle="modal">复核</a>
	                    </div>
	                </div>
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
                    <span>录入复核</span>
                </h4>
            </div>
            <div class="modal-body">
                <form id="checkForm" name="checkForm" novalidate="novalidate">
                	<div class="form-body">
                		<input type="hidden" class="form-control" id="txType" name="txType" value="factor">
                		<input type="hidden" class="form-control" id="txId" name="txId" value="${factorId}">
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