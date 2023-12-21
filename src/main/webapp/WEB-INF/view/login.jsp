<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE HTML>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <link href="${ctx}/assets/users/img/logo.png" rel="shortcut icon"/>
    <title>供应链融资管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

	<script type="text/javascript">
		var ctx = "${ctx}";
	</script>
	
	<%@ include file="common/importCss.jsp"%>
    <link href="${ctx}/assets/users/css/login.min.css" rel="stylesheet" type="text/css" /> 
    <script src="${ctx}/assets/users/js/companyAdd.js" type="text/javascript"></script>  
</head>
<!-- END HEAD -->

<body class="login" onload="return username.focus()" style="background-image:url('${ctx}/assets/users/img/loginbg.png');background-size:cover;">
<!-- BEGIN LOGO -->
<div class="logo">
    <img src="${ctx}/assets/users/img/logo-on-dark.png" alt="" />
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
	<form class="login-form" id="loginForm" name="loginForm" action="${ctx}/login/welcome" method="post">
		<h3 class="form-title font-green">登录</h3>
		<div class="form-group" data-bv-notempty data-bv-notempty-message="请输入用户名">
		    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
		    <label class="control-label visible-ie8 visible-ie9">用户名</label>
		    <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" id="username" name="username" /> </div>
		<div class="form-group">
		    <label class="control-label visible-ie8 visible-ie9">密码</label>
		    <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" id="password" name="password" /> </div>
		<div class="form-group">
		    <div class="row">
		        <div class="col-md-7">
		            <label class="control-label visible-ie8 visible-ie9">验证码</label>
		            <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="验证码" id="verifycode" name="verifycode"/>
		        </div>
		        <div class="col-md-5" align="right">
		            <label class="control-label visible-ie8 visible-ie9">&nbsp;</label>
		            <img src="${ctx}/login/image" id="img" onclick="changeImage()" style="margin-top: 5%">
		        </div>
		    </div>
		</div>
		<div class="form-actions">
		    <input type="button" class="btn green uppercase" value="登录" style="width: 100%" id="loginbtn"/>
		</div>
		<div class="create-account">
	    	<p>
                <a href="#companyReg" data-toggle="modal" class="uppercase">企业注册</a>
            </p>
	  	</div>
	</form>
</div>
<div id="companyReg" class="modal fade" tabindex="-1" >
    <div class="modal-dialog" style="width:70%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <span>企业注册</span>
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="companyAddForm" name="companyAddForm" >
	                    <div class="form-body">
	                        <br>
	                        <div class="form-group">
	                            <label class="control-label col-md-2"> 公司名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="custName" name="custName" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 营业执照编号</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="paperNo" name="paperNo" >
	                            </div>
	                            <label class="control-label col-md-2">营业执照</label>
                                <div class="col-md-3">
                                    <input type="file" id ="paperFile" name="file" onchange="fileUploadBtn('paperFile');">
                                    <input type="hidden" class="form-control" id="paperPath" name="paperPath" readonly>
                                </div>
	                        </div>
                            <div class="form-group">
	                        	<label class="control-label col-md-2"> 开户行</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountBank" name="accountBank" >
	                            </div>
	                            <label class="control-label col-md-2"> 开户名称</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountName" name="accountName" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 对公账户</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="accountNum" name="accountNum" >
	                            </div>
	                            <label class="control-label col-md-2"> 联系电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="telNo" name="telNo" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMail" name="eMail" >
	                            </div>
	                            <label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="address" name="address" >
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
	                                <input type="text" class="form-control" id="loginNameInp" name="loginNameInp" >
	                            </div>
	                            <label class="control-label col-md-2"> 登录名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="loginNameApp" name="loginNameApp" >
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
	                                <input type="text" class="form-control" id="userNameInp" name="userNameInp" >
	                            </div>
	                            <label class="control-label col-md-2"> 姓名</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="userNameApp" name="userNameApp" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 性别</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="sexInp" name="sexInp">
	                                	<option >请选择...</option>
	                                	<option >男</option>
	                                	<option >女</option>
	                                </select>
	                            </div>
	                            <label class="control-label col-md-2"> 性别</label>
	                            <div class="col-md-3">
	                                <select class="form-control" id="sexApp" name="sexApp">
	                                	<option >请选择...</option>
	                                	<option >男</option>
	                                	<option >女</option>
	                                </select>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="mobileNoInp" name="mobileNoInp" >
	                            </div>
	                            <label class="control-label col-md-2"> 电话</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="mobileNoApp" name="mobileNoApp" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMailInp" name="eMailInp" >
	                            </div>
	                            <label class="control-label col-md-2"> 邮箱</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="eMailApp" name="eMailApp" >
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="addressInp" name="addressInp" >
	                            </div>
	                            <label class="control-label col-md-2"> 地址</label>
	                            <div class="col-md-3">
	                                <input type="text" class="form-control" id="addressApp" name="addressApp" >
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
</div>
<!-- END LOGIN -->
<div class="copyright"> 2017 &copy; 招银云创. </div>
    <%@ include file="common/importJs.jsp"%>
	<script src="${ctx}/assets/users/js/login.min.js" type="text/javascript"></script>
</body>
</html>