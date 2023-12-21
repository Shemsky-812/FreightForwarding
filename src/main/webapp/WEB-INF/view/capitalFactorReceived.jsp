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
    <script src="${ctx}/assets/users/js/loanDetail.js" type="text/javascript"></script>
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
                    <div class="caption">资金交易-保理收款</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="userAmdForm" name="userAmdForm" >
	                    <div class="form-body">
	                    	<input type="hidden" class="form-control" id="userId" name="userId" value="${userId}">
	                        <br>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理合同编号 </label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="loginName" name="loginName" value="XXXXX" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 卖方</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userName" name="userName" value="XX企业" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理商</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userName" name="userName" value="保理商1" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理金额</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userName" name="userName" value="815.00" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 还款方式</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userName" name="userName" value="到期还本付息" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理利率</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userName" name="userName" value="5%" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理利息</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userName" name="userName" value="900.00" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 保理期限</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userName" name="userName" value="12月" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 开始日期</label>
	                            <div class="col-md-3">
	                                <input type="date" class="form-control" id="userName" name="userName" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 到期日期</label>
	                            <div class="col-md-3">
	                                <input type="date" class="form-control" id="userName" name="userName" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
                                <label class="control-label col-md-3">保理合同附件</label>
                                <div class="col-md-3">
                                    <a href="#" class="btn green"> XXX保理合同.doc </a>
                                </div>
                            </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-3"> 备注</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="address" name="address" value="${address}" readonly>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>&nbsp;
									<a class="btn btn-success" href="#checkModal" data-toggle="modal">确认</a>
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
                    <span>收款确认</span>
                </h4>
            </div>
            <div class="modal-body">
                <form id="ChangePasswordModalForm" name="ChangePasswordModalForm" novalidate="novalidate">
                	<div class="form-body">
                		<input type="hidden" class="form-control" id="userId" name="userId" value="${sessionScope.User.userId}">
	                    <div class="form-group ">
	                        <label>确认信息</label>
	                        <textarea class="form-control" rows="3"></textarea>
	                    </div>
	                    <div class="form-group ">
	                        <label>转账截图</label>
	                        <div class="rows">
                                <div class="fileinput fileinput-new" data-provides="fileinput">
                                    <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 100%; height: auto; line-height: 0px; border:0px;padding:0 0 0 0;"></div>
                                    <div>
                                        <span class="btn red btn-outline btn-file">
                                            <span class="fileinput-new"> 选择图片 </span>
                                            <span class="fileinput-exists"> 换一张 </span>
                                            <input type="hidden" value="" name="..."><input type="file" name=""> </span>
                                        <a href="javascript:;" class="btn red fileinput-exists" data-dismiss="fileinput"> 删除图片 </a>
                                    </div>
                                </div>
                            </div>
	                    </div>
                    </div>
                    <div class="modal-footer">
                    	<button type="button" class="btn default close-button" data-dismiss="modal">取消</button>
                    	<button type="button" class="btn btn-warning" data-dismiss="modal">不通过</button>
                    	<button type="button" class="btn btn-success" data-dismiss="modal">通过</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>