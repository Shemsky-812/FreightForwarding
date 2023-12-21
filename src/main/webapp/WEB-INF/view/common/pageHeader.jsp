<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BEGIN HEADER -->   
<div class="page-header navbar navbar-fixed-top">
    <!-- BEGIN HEADER INNER -->
    <div class="page-header-inner ">
        <!-- BEGIN LOGO -->
        <div class="page-logo">
        	<a href="${ctx}/login/welcome">
   				<img src="${ctx}/assets/users/img/logo-light.png" alt="logo" class="logo-default" /> 
   			</a>
            <div class="menu-toggler sidebar-toggler">
                <span></span>
            </div>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
            <span></span>
        </a>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->
        <div class="page-top">
	        <div class="top-menu">
	            <ul class="nav navbar-nav pull-right">
	                <!-- BEGIN USER LOGIN DROPDOWN -->
	                <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
	                <li class="dropdown dropdown-user dropdown-dark">
	                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
	                        <img alt="" class="img-circle" src="${ctx}${sessionScope.User.picPath}" />
	                        <span class="username username-hide-on-mobile">${sessionScope.User.userName}</span>
	                        <i class="fa fa-angle-down"></i>
	                    </a>
	                    <ul class="dropdown-menu dropdown-menu-default">
	                        <li>
                                <a href="#userinfo" data-toggle="modal">
                                    <i class="icon-user"></i> 个人中心 </a>
                            </li>
                            <li>
                                <a href="#userpic" data-toggle="modal">
                                    <i class="icon-picture"></i> 头像修改 </a>
                            </li>
                            <li>
                                <a href="#changepassword" data-toggle="modal">
                                    <i class="icon-key"></i> 密码修改 </a>
                            </li>
	                        <li class="divider"> </li>
	                        <li>
	                            <a href="${ctx}/login/close">
	                                <i class="font-red-flamingo icon-power"></i> 安全退出  </a>
	                        </li>
                            <!-- <li>
                                <a href="#uploadFile" data-toggle="modal">
                                    <i class="icon-key"></i> 附件上传 </a>
                            </li> -->
	                    </ul>
	                </li>
	                <!-- END USER LOGIN DROPDOWN -->
	            </ul>
	        </div>
        </div>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END HEADER INNER -->
</div>
<!-- END HEADER -->

<!--BEGIN USER INFO MODEL-->
<div id="userinfo" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <span>个人中心</span>
                </h4>
            </div>
            <div class="modal-body">
                <form id="userInfoForm" name="userInfoForm" novalidate="novalidate">
                	<div class="form-body">
                	<input type="hidden" class="form-control" id="userId" name="userId" value="${sessionScope.User.userId}">
                    <div class="form-group form-md-line-input form-md-floating-label">
                        <input type="text" class="form-control edited" value="${sessionScope.User.loginName}" id="HloginName" name="HloginName" maxlength="32" aria-required="true" readonly>
                        <label>用户名</label>
                    </div>
                    <div class="form-group form-md-line-input form-md-floating-label">
                        <input type="text" class="form-control edited" value="${sessionScope.User.userCode}" id="HuserCode" name="HuserCode" maxlength="32" aria-required="true">
                        <label>工号</label>
                    </div>
                    <div class="form-group form-md-line-input form-md-floating-label no-hint">
                        <input class="form-control edited" type="text" value="${sessionScope.User.userName}" id="HuserName" name="HuserName" maxlength="32" aria-required="true" aria-invalid="false">
                        <label>姓名</label>
                    </div>
                    <div class="form-group form-md-line-input form-md-floating-label no-hint">
                        <input class="form-control edited" type="text" value="${sessionScope.User.mobileNo}" id="HmobileNo" name="HmobileNo" maxlength="256" aria-required="true">
                        <label>手机号码</label>
                    </div>
                    <div class="form-group form-md-line-input form-md-floating-label no-hint">
                        <input class="form-control edited" type="text" value="${sessionScope.User.address}" id="Haddress" name="Haddress" maxlength="256" aria-required="true">
                        <label>联系地址</label>
                    </div>
                    <div class="form-group form-md-line-input form-md-floating-label no-hint">
                        <input class="form-control edited" type="email" value="${sessionScope.User.EMail}" id="HeMail" name="HeMail" maxlength="256" aria-required="true">
                        <label>邮箱地址</label>
                    </div>
                    </div>
                    <div class="form-actions">
                    	<button type="button" class="btn default" data-dismiss="modal">取消</button>
                    	<button type="submit" class="btn green" >保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--END USER INFO MODEL-->
<!--BEGIN CHANGE USERPIC MODEL-->
<div id="userpic" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <span>修改头像</span>
                </h4>
            </div>
            <div class="modal-body">
				    <div class="row">
				      <div class="col-md-6">
				        <!-- <h3 class="page-header">Demo:</h3> -->
				        <div class="img-container">
				          <img id="image" src="${sessionScope.User.picPath}" alt="Picture">
				        </div>
				      </div>
				      <div class="col-md-6">
				        <!-- <h3 class="page-header">Preview:</h3> -->
				        <div class="docs-preview clearfix ">
				          <div class="img-preview preview-md img-circle"></div>
				        </div>
				      </div>
				    </div>
				    <div class="row">
				      <div class="col-md-6 docs-buttons">
				        <!-- <h3 class="page-header">Toolbar:</h3> -->
				
				        <div class="btn-group">
				          <label class="btn btn-default btn-upload" for="inputImage" title="Upload image file">
				            <input type="file" class="sr-only" id="inputImage" name="file" accept="image/*">
				            <span class="docs-tooltip" data-toggle="tooltip" title="Import image with Blob URLs">
				            	 请选择图片(JPG、JPEG、PNG)
				            </span>
				          </label>
				        </div>
				        
				        <!-- Show the cropped image in modal -->
				        <div class="modal fade docs-cropped" id="getCroppedCanvasModal" aria-hidden="true" aria-labelledby="getCroppedCanvasTitle" role="dialog" tabindex="-1">
				          <div class="modal-dialog">
				            <div class="modal-content">
				              <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                <h4 class="modal-title" id="getCroppedCanvasTitle">Cropped</h4>
				              </div>
				              <div class="modal-body"></div>
				              <div class="modal-footer">
				                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				              </div>
				            </div>
				          </div>
				        </div><!-- /.modal -->
				
				      </div><!-- /.docs-buttons -->
				    </div>
	  		</div>
		    <div class="modal-footer">
		    	<div class="saveUserPic">
			        <button type="button" class="btn default close-button" data-dismiss="modal">取消</button>
			        <button type="button" class="btn green" data-method="getCroppedCanvas">
			           <span class="docs-tooltip" data-toggle="tooltip" title="$().cropper(&quot;getCroppedCanvas&quot;)">保存</span>
			         </button>
		    	</div>
		    </div>
        </div>
    </div>
</div>
<!--END USER USERPIC MODEL-->
<!--BEGIN CHANGE PASSWORD MODEL-->
<div id="changepassword" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">
                    <span>修改密码</span>
                </h4>
            </div>
            <div class="modal-body">
                <form id="ChangePasswordModalForm" name="ChangePasswordModalForm" novalidate="novalidate">
                	<div class="form-body">
                		<input type="hidden" class="form-control" id="userId" name="userId" value="${sessionScope.User.userId}">
	                    <div class="form-group form-md-line-input form-md-floating-label">
	                        <input type="password" id="CurrentPassword" name="CurrentPassword" class="form-control" aria-required="true">
	                        <label>当前密码</label>
	                    </div>
	                    <div class="form-group form-md-line-input form-md-floating-label no-hint">
	                        <input type="password" id="NewPassword" name="NewPassword" class="form-control" aria-required="true">
	                        <label>新密码</label>
	                    </div>
	                    <div class="form-group form-md-line-input form-md-floating-label no-hint">
	                        <input type="password" id="NewPasswordRepeat" name="NewPasswordRepeat" class="form-control" aria-required="true">
	                        <label>新密码 (核对)</label>
	                    </div>
                    </div>
                    <div class="form-actions">
                    	<button type="button" class="btn default close-button" data-dismiss="modal">取消</button>
		                <button type="submit" class="btn green "><span>保存</span></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--END CHANGE PASSWORD MODEL-->