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
		var updateBtn = "${updateBtn}";
		var transfer = "${transfer}";
		var cash = "${cash}";
		var history = "${history}";
	</script>
	
	<%@ include file="common/importCss.jsp"%>
    <%@ include file="common/importJs.jsp"%>
    <script src="${ctx}/assets/users/js/custAccount.js" type="text/javascript"></script>
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
            <div class="portlet light bordered">
                <div class="portlet-title">
                    <div class="caption">账户信息</div>
                </div>
                <div class="portlet-body">
                    <div class="row widget-row">
                        <div class="col-md-4">
                            <!-- BEGIN WIDGET THUMB -->
                            <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
                                <h4 class="widget-thumb-heading">账户余额</h4>
                                <div class="widget-thumb-wrap">
                                    <i class="widget-thumb-icon bg-green fa fa-rmb"></i>
                                    <div class="widget-thumb-body">
                                        <span class="widget-thumb-subtitle">RMB</span>
                                        <span class="widget-thumb-body-stat" data-counter="counterup" data-value="${amtAll}" >0</span>
                                    </div>
                                </div>
                            </div>
                            <!-- END WIDGET THUMB -->
                        </div>
                        <div class="col-md-4">
                            <!-- BEGIN WIDGET THUMB -->
                            <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
                                <h4 class="widget-thumb-heading">冻结金额</h4>
                                <div class="widget-thumb-wrap">
                                    <i class="widget-thumb-icon bg-red fa fa-lock"></i>
                                    <div class="widget-thumb-body">
                                        <span class="widget-thumb-subtitle">RMB</span>
                                        <span class="widget-thumb-body-stat" data-counter="counterup" data-value="${amtClock}">0</span>
                                    </div>
                                </div>
                            </div>
                            <!-- END WIDGET THUMB -->
                        </div>
                        <div class="col-md-4">
                            <!-- BEGIN WIDGET THUMB -->
                            <div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
                                <h4 class="widget-thumb-heading">可用金额</h4>
                                <div class="widget-thumb-wrap">
                                    <i class="widget-thumb-icon bg-purple fa fa-check-square-o"></i>
                                    <div class="widget-thumb-body">
                                        <span class="widget-thumb-subtitle">RMB</span>
                                        <span class="widget-thumb-body-stat" data-counter="counterup" data-value="${amtFree}">0</span>
                                    </div>
                                </div>
                            </div>
                            <!-- END WIDGET THUMB -->
                        </div>
                    </div>
                    <br>
                    <div class="row widget-row">
                    	<div class="col-md-4">
	                    	<div class="btn-group btn-group btn-group-justified">
<%--		                        <a href="${ctx}${transfer}" class="btn green"> 转账 </a>--%>
                                <a href="#" class="btn green" onclick="custTransfer()"> 转账 </a>
		                    </div>
                    	</div>
                    	<div class="col-md-4">
	                    	<div class="btn-group btn-group btn-group-justified">
<%--		                        <a href="${ctx}${cash}" class="btn red"> 提现 </a>--%>
                                <a href="#" class="btn red" onclick="custCash()"> 提现 </a>
		                    </div>
                    	</div>
                    	<div class="col-md-4">
	                    	<div class="btn-group btn-group btn-group-justified">
		                        <a href="${ctx}${history}" class="btn purple"> 交易历史 </a>
		                    </div>
                    	</div>
                    </div>
                    <br><hr><br>
		            <div class="note note-info">
		            	<div class="row">
		            		<div class="col-md-6">
								<h4 class="block">公司名称:&nbsp;&nbsp;&nbsp;&nbsp;${custName}</h4>
		                        <br>
				                <p>营业执照:&nbsp;&nbsp;&nbsp;&nbsp;${paperNo}</p>
				                <br>
				                <p>开&nbsp;户&nbsp;行&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;${accountBank}</p>
				                <br>
				                <p>开户名称:&nbsp;&nbsp;&nbsp;&nbsp;${accountName}</p>
				                <br>
				                <p>收款账号:&nbsp;&nbsp;&nbsp;&nbsp;${accountNum}</p>
				                <br>
				                <p>联系电话:&nbsp;&nbsp;&nbsp;&nbsp;${telNo}</p>
				                <br>
				                <p>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:&nbsp;&nbsp;&nbsp;&nbsp;${eMail}</p>
				                <br>
				                <p>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;&nbsp;&nbsp;&nbsp;${address}</p>
		            		</div>
		            		<div class="col-md-6">
		            			<img src="${ctx}${paperPath}" alt="logo" class="logo-default" style="height:320px;"/> 
		            		</div>
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
</body>
</html>