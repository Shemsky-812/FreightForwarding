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
    <script src="${ctx}/assets/users/js/companyCheck.js" type="text/javascript"></script>
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
                    <div class="caption">企业信息-审核</div>
                </div>
                <div class="portlet-body">
	                <form class="form-horizontal" id="companyCheckForm" name="companyCheckForm" >
	                    <div class="form-body">
	                    	<input type="hidden" class="form-control" id="regId" name="regId" value="${regId}">
	                        <br>
	                        <div class="form-group">
	                            <label class="control-label col-md-2"> 公司名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="custName" name="custName" value="${custName}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 营业执照编号</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="paperNo" name="paperNo" value="${paperNo}" readonly>
	                            </div>
	                            <label class="control-label col-md-2">营业执照</label>
                                <div class="col-md-3">
                                    <a href="${ctx}${paperPath}" class="btn green"> 点击查看营业执照 </a>
                                </div>
                                <input type="hidden" class="form-control" id="paperPath" name="paperPath" value="${paperPath}" readonly>
	                        </div>
                            <div class="form-group">
	                        	<label class="control-label col-md-2"> 开户行</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountBank" name="accountBank" value="${accountBank}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 开户名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountName" name="accountName" value="${accountName}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 对公账户</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountNum" name="accountNum" value="${accountNum}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 联系电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="telNo" name="telNo" value="${telNo}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMail" name="eMail" value="${eMail}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="address" name="address" value="${address}" readonly>
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
	                                <input type="text" class="form-control" id="loginNameInp" name="loginNameInp" value="${loginNameInp}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 登录名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="loginNameApp" name="loginNameApp" value="${loginNameApp}" readonly>
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
	                                <input type="text" class="form-control" id="userNameInp" name="userNameInp" value="${userNameInp}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 姓名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userNameApp" name="userNameApp" value="${userNameApp}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 性别</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="sexInp" name="sexInp" value="${sexInp}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 性别</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="sexApp" name="sexApp" value="${sexApp}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="mobileNoInp" name="mobileNoInp" value="${mobileNoInp}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="mobileNoApp" name="mobileNoApp" value="${mobileNoApp}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMailInp" name="eMailInp" value="${eMailInp}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMailApp" name="eMailApp" value="${eMailApp}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="addressInp" name="addressInp" value="${addressInp}" readonly>
	                            </div>
	                            <label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="addressApp" name="addressApp" value="${addressApp}" readonly>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="control-label col-md-2"> 角色</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="roleIdInp" name="roleIdInp">
	                                	<option >请选择...</option>
	                                </select>
	                            </div>
	                            <label class="control-label col-md-2"> 角色</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="roleIdApp" name="roleIdApp">
	                                	<option >请选择...</option>
	                                </select>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>
	                                <a class="btn btn-danger" onclick="backCompanyAmd();">不通过</a>
									<button class="btn btn-success" >通过</button>
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
<script type="text/javascript">
function backCompanyAmd(){
	regId=$("#regId").val();
	$.ajax({
        url : ctx+"/companyController/backCompanyAmd"+"?regId="+regId,
        type : "post",
        dataType : "json"
		}).done(function (data){
			swal({title: '成功',
        		  text: data.errMsg,
        		  type: 'success',
        		  confirmButtonText: '确定',
              },function(){
            	  history.go(-1);
              }); 
		}).error(function (data){
			swal({title: '失败',
        		  text: data.errMsg,
        		  type: 'error',
        		  confirmButtonText: '确定',
              },function(){
            	  location.reload();
              }); 
    });
}
</script>
</body>
</html>