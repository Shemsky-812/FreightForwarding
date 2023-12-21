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
		var custSell = "${custSell}";
	</script>
	
	<%@ include file="common/importCss.jsp"%>
    <%@ include file="common/importJs.jsp"%>
    <script src="${ctx}/assets/users/js/factorAmd.js" type="text/javascript"></script>
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
                    <div class="caption">保理合同-修改</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="factorAmdForm" name="factorAmdForm" >
	                    <div class="form-body">
	                    	<input type="hidden" class="form-control" id="factorId" name="factorId" value="${factorId}">
	                        <br>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理合同编号 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="factorCode" name="factorCode" value="${factorCode}" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 卖方</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="custSell" name="custSell" >
	                                </select>
	                                <input type="hidden" class="form-control" id="custSellName" name="custSellName" value="${custSellName}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理商</label>
	                            <div class="col-md-3">
	                            	<input type="hidden" class="form-control" id="custfactor" name="custfactor" value="${custfactor}">
	                                <input type="text" class="form-control" id="custfactorName" name="custfactorName" value="${custfactorName}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理金额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="factorAmt" name="factorAmt" value="${factorAmt}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 还款方式</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="payment" name="payment" value="${payment}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理利率</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="rate" name="rate" value="${rate}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理利息</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="interest" name="interest" value="${interest}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理期限</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="tenor" name="tenor" value="${tenor}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 开始日期</label>
	                            <div class="col-md-3">
	                                <input type="date" class="form-control" id="startDate" name="startDate" value="${startDate}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 到期日期</label>
	                            <div class="col-md-3">
	                                <input type="date" class="form-control" id="endDate" name="endDate" value="${endDate}">
	                            </div>
	                        </div>
	                        <div class="form-group">
                                <label class="control-label col-md-3">保理合同附件</label>
                                <div class="col-md-3">
                                	<a class="btn default" href='${ctx}${filePath}'>查看保理合同</a>
                                </div>
                                <div class="col-md-3">
                                    <input type="file" id = "factorFile" name="file" onchange="fileUploadBtn('factorFile');">
                                    <input type="hidden" class="form-control" id="filePath" name="filePath" value="${filePath}">
                                </div>
                            </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 备注</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="remark" name="remark" value="${remark}">
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>&nbsp;
									<button class="btn green" >提交</button>
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