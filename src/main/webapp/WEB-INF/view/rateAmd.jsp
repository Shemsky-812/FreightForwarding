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
		var roleId = "${roleId}";
		var toCustId = "${toCustId}";
		var rateType = "${rateType}";
	</script>
	
	<%@ include file="common/importCss.jsp"%>
    <%@ include file="common/importJs.jsp"%>
    <script src="${ctx}/assets/users/js/rateAmd.js" type="text/javascript"></script>
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
                    <div class="caption">手续费-修改</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="rateAmdForm" name="rateAmdForm" >
	                    <div class="form-body">
	                        <br>
	                        <input type="hidden" class="form-control" id="rateId" name="rateId" value="${rateId}">
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 类型</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="rateType" name="rateType">
                                	<c:choose>
									<c:when test="${rateType=='1'}">
										<option value="1" selected>转账手续费</option>
	                                	<option value="2" >提现手续费</option>
									</c:when>
									<c:when test="${rateType=='2'}">
										<option value="1" >转账手续费</option>
	                                	<option value="2" selected>提现手续费</option>
									</c:when>
									<c:otherwise>
										<option value="1" >转账手续费</option>
	                                	<option value="2" >提现手续费</option>
									</c:otherwise>
							 		</c:choose>
	                                </select>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="rateName" name="rateName" value="${rateName}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 角色</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="roleId" name="roleId">
	                                </select>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 费率</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="rate" name="rate" value="${rate}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<div class="col-md-2"></div>
	                            <label class="control-label col-md-1"> 收取机构</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="toCustId" name="toCustId">
	                                	<option >请选择...</option>
	                                </select>
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