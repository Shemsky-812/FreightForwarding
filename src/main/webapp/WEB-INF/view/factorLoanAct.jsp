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
                    <div class="caption">保理合同-质押放款</div>
                </div>
                <div class="portlet-body">
                	<form class="form-horizontal " id="userAmdForm" name="userAmdForm" >
	                   <div class="form-body">
	                  	<input type="hidden" class="form-control" id="factorId1" name="factorId1" value="${factorId1}">
	                  	<input type="hidden" class="form-control" id="loanId2" name="loanId2" value="${loanId2}">
	                       <br>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 保理合同编号 </label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="factorCode1" name="factorCode1" value="${factorCode1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 贷款合同编号 </label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="loanCode2" name="loanCode2" value="${loanCode2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 卖方</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="custSellName1" name="custSellName1" value="${custSellName1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 债务人</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="custDebtorName2" name="custDebtorName2" value="${custDebtorName2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 保理商</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="custfactorName1" name="custfactorName1" value="${custfactorName1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 债权人</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="custCreditorName2" name="custCreditorName2" value="${custCreditorName2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 保理金额</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="factorAmt1" name="factorAmt1" value="${factorAmt1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 贷款金额</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="loanAmt2" name="loanAmt2" value="${loanAmt2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 还款方式</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="payment1" name="payment1" value="${payment1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 还款方式</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="payment2" name="payment2" value="${payment2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 保理利率</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="rate1" name="rate1" value="${rate1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 贷款利率</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="rate2" name="rate2" value="${rate2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 保理利息</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="interest1" name="interest1" value="${interest1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 贷款利息</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="interest2" name="interest2" value="${interest2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 保理期限</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="tenor1" name="tenor1" value="${tenor1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 贷款期限</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="tenor2" name="tenor2" value="${tenor2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 开始日期</label>
	                           <div class="col-md-3">
	                               <input type="date" class="form-control" id="startDate1" name="startDate1" value="${startDate1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 开始日期</label>
	                           <div class="col-md-3">
	                               <input type="date" class="form-control" id="startDate2" name="startDate2" value="${startDate2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 到期日期</label>
	                           <div class="col-md-3">
	                               <input type="date" class="form-control" id="endDate1" name="endDate1" value="${endDate1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 到期日期</label>
	                           <div class="col-md-3">
	                               <input type="date" class="form-control" id="endDate2" name="endDate2" value="${endDate2}" readonly>
	                           </div>
	                       </div>
	                       <div class="form-group">
	                              <label class="control-label col-md-2">保理合同附件</label>
	                              <div class="col-md-3">
	                              	<a href="${ctx}${filePath1}" class="btn green"> 查看保理合同 </a>
	                              </div>
	                              <label class="control-label col-md-2">贷款合同附件</label>
	                              <div class="col-md-3">
                                  	<a href="${ctx}${filePath2}" class="btn green"> 查看贷款合同 </a>
                                  </div>
	                          </div>
	                       <div class="form-group">
	                           <label class="control-label col-md-2"> 备注</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="remark1" name="remark1" value="${remark1}" readonly>
	                           </div>
	                           <label class="control-label col-md-2"> 备注</label>
	                           <div class="col-md-3">
	                               <input type="text" class="form-control" id="remark2" name="remark2" value="${remark2}" readonly>
	                           </div>
	                       </div>
	                   </div>
	                   <div class="form-actions">
	                        <div class="row">
	                            <div class="col-md-offset-3 col-md-9">
	                                <a class="btn default" onclick="history.go(-1)">返回</a>&nbsp;
									<a class="btn btn-success" href="#checkModal" data-toggle="modal">复核</a>
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
                    <span>放款确认</span>
                </h4>
            </div>
            <div class="modal-body">
                <form id="checkForm" name="checkForm" novalidate="novalidate">
                	<div class="form-body">
                		<input type="hidden" class="form-control" id="txType" name="txType" value="loanAct">
                		<input type="hidden" class="form-control" id="txId" name="txId" value="${factorId1}">
                		<input type="hidden" class="form-control" id="txStatus" name="txStatus" value="${status1}">
	                    <div class="form-group ">
	                        <label>复核信息</label>
	                        <textarea class="form-control" rows="3" id="checkMsg" name="checkMsg" required="required"></textarea>
	                    </div>
	                    <input type="hidden" class="form-control" id="checkStatus" name="checkStatus">
                		<input type="hidden" class="form-control" id="checkId" name="checkId" value="${checkId1}">
                		<input type="hidden" class="form-control" id="checkFilePath" name="checkFilePath" value="null">
                    </div>
					<div class="form-actions">
						<button type="button" class="btn default close-button" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-success" onclick="$('#checkStatus').val('agree')">通过</button>
					</div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>