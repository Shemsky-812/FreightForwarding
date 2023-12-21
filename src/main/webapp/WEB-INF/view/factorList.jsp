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
		var insertBtn = "${insertBtn}";
		var updateBtn = "${updateBtn}";
		var deleteBtn = "${deleteBtn}";
		var addCheck = "${addCheck}";
		var factorLoan = "${factorLoan}";
		var loanCheck = "${loanCheck}";
		var loanAction = "${loanAction}";
		var factorAction = "${factorAction}";
	</script>
	
	<%@ include file="common/importCss.jsp"%>
    <%@ include file="common/importJs.jsp"%>
    <script src="${ctx}/assets/users/js/factorList.js" type="text/javascript"></script>
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
                    <div class="caption">保理合同</div>
                </div>
                <div class="portlet-body">
                    <div id="sample_2_wrapper" class="dataTables_wrapper no-footer">
                    	<div id="factorTb">
	                        <div class="row">
	                            <div class="col-md-3">
	                                <label class="control-label">合同编号</label>
	                                <input type="text" class="form-control" id="factorCode" name="factorCode">
	                            </div>
	                        </div>
	                        <div class="row margin-bottom-10">
	                            <div class="col-md-12 text-right">
	                                <button class="btn default" onclick="initTable()"><i class=" fa fa-search"></i> 查询 </button>
	                            <c:choose>
								<c:when test="${insertBtn!='' && insertBtn!=null}">
									<a class="btn green" href="${ctx}${insertBtn}"><i class=" fa fa-plus"></i> 录入 </a>
								</c:when>
								<c:otherwise>
								</c:otherwise>
						 		</c:choose>
                                </div>
	                        </div>
                        </div>
                        <table id="factorDg" class="table table-striped table-bordered table-hover " style="white-space :nowrap"></table>
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