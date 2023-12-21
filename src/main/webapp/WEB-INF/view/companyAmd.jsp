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
    <script src="${ctx}/assets/users/js/companyAmd.js" type="text/javascript"></script>
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
                    <div class="caption">企业信息-修改</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="companyAmdForm" name="companyAmdForm" >
	                    <div class="form-body">
	                    	<input type="hidden" class="form-control" id="regId" name="regId" value="${regId}">
	                        <br>
	                        <div class="form-group">
	                            <label class="control-label col-md-2"> 公司名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="custName" name="custName" value="${custName}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 营业执照编号</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="paperNo" name="paperNo" value="${paperNo}">
	                            </div>
	                            <label class="control-label col-md-2">营业执照</label>
                                <div class="col-md-3">
                                    <input type="file" id ="paperFile" name="file" onchange="fileUploadBtn('paperFile');">
                                    <input type="hidden" class="form-control" id="paperPath" name="paperPath" value="${paperPath}">
                                </div>
                                <div class="col-md-2">
                                    <a href="${ctx}${paperPath}" class="btn green"> 点击查看营业执照 </a>
                                </div>
	                        </div>
                            <div class="form-group">
	                        	<label class="control-label col-md-2"> 开户行</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountBank" name="accountBank" value="${accountBank}">
	                            </div>
	                            <label class="control-label col-md-2"> 开户名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountName" name="accountName" value="${accountName}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 对公账户</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountNum" name="accountNum" value="${accountNum}">
	                            </div>
	                            <label class="control-label col-md-2"> 联系电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="telNo" name="telNo" value="${telNo}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMail" name="eMail" value="${eMail}">
	                            </div>
	                            <label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="address" name="address" value="${address}">
	                            </div>
	                        </div>
	                        <hr>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> &nbsp;</label>
	                            <label class="control-label col-md-3"> 操作人员信息</label>
	                            <label class="control-label col-md-2"> &nbsp;</label>
	                            <label class="control-label col-md-3"> 审核人员信息</label>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 登录名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="loginNameInp" name="loginNameInp" value="${loginNameInp}">
	                            </div>
	                            <label class="control-label col-md-2"> 登录名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="loginNameApp" name="loginNameApp" value="${loginNameApp}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 初始密码</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="passwdInp" name="passwdInp" value="123456" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 初始密码</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="passwdApp" name="passwdApp" value="123456" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 姓名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userNameInp" name="userNameInp" value="${userNameInp}">
	                            </div>
	                            <label class="control-label col-md-2"> 姓名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userNameApp" name="userNameApp" value="${userNameApp}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 性别</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="sexInp" name="sexInp" >
	                                <c:choose>
									<c:when test="${sexInp=='男'}">
										<option selected >男</option>
									</c:when>
									<c:when test="${sexInp=='女'}">
										<option selected >女</option>
									</c:when>
									<c:otherwise>
									</c:otherwise>
							 		</c:choose>
	                                </select>
	                            </div>
	                            <label class="control-label col-md-2"> 性别</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="sexApp" name="sexApp" >
	                                <c:choose>
									<c:when test="${sexApp=='男'}">
										<option selected >男</option>
									</c:when>
									<c:when test="${sexApp=='女'}">
										<option selected >女</option>
									</c:when>
									<c:otherwise>
									</c:otherwise>
							 		</c:choose>
	                                </select>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="mobileNoInp" name="mobileNoInp" value="${mobileNoInp}">
	                            </div>
	                            <label class="control-label col-md-2"> 电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="mobileNoApp" name="mobileNoApp" value="${mobileNoApp}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMailInp" name="eMailInp" value="${eMailInp}">
	                            </div>
	                            <label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMailApp" name="eMailApp" value="${eMailApp}">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="addressInp" name="addressInp" value="${addressInp}">
	                            </div>
	                            <label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="addressApp" name="addressApp" value="${addressApp}">
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>
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