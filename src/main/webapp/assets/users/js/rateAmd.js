$(document).ready(function () {      
	//下拉框初始化
	combobox();
	//表单校验及提交
	confirmForm();
}); 

function combobox(){
	$.ajax({
        url : ctx+"/combobox/role",
        type : "post",
        dataType : "json",
        success:function(data){
	        $.each(data, function (i, item) {
	        	if(item.roleId == roleId){
	        		$("#roleId").append("<option value='" + item.roleId + "' selected>" + item.roleName + "</option>");
	        	}else{
	        		$("#roleId").append("<option value='" + item.roleId + "'>" + item.roleName + "</option>");
	        	}
	        });
        }
    });
	$.ajax({
        url : ctx+"/combobox/customer",
        type : "post",
        dataType : "json",
        success:function(data){
	        $.each(data, function (i, item) {
	        	if(item.custId == toCustId){
	        		$("#toCustId").append("<option value='" + item.custId + "' selected>" + item.custName + "</option>");
	        	}else{
	        		$("#toCustId").append("<option value='" + item.custId + "'>" + item.custName + "</option>");
	        	}
	        });
        }
    });
}

function confirmForm() {
    $("#rateAmdForm").validate({
      submitHandler : function() {  //验证通过后的执行方法
          //当前的form通过ajax方式提交（用到jQuery.Form文件）
      	var param = $("#rateAmdForm").serialize();
          $.ajax({
              url : ctx+"/rateController/rateAmdConfirm",
              type : "post",
              dataType : "json",
              data: param,
              success:function(data){
                  if(data.isSuc){
                	  document.getElementById("rateAmdForm").reset(); 
                      swal({title: '成功',
                		  text: data.errMsg,
                		  type: 'success',
                		  confirmButtonText: '确定',
                      },function(){
                    	  history.go(-1);
                      }); 
                  }else{
                  	swal("失败", data.errMsg, "error"); 
                  }
                }
              });
      },
      focusInvalid : true,   //验证提示时，鼠标光标指向提示的input
      rules : {
          rateName : {
	            required : true,   //验证非空
        },
          roleId : {
              required : true,
              remote: {          //远程ajax验证
                  url: ctx+"/rateController/checkChargeRate", //检查是否存在账号，存在则返回true
                  type: "GET",
                  dataType: "json",
                  data: {
                      rateType: function () {
                          return $("#rateType").val(); //这个是取要验证的用户名
                      },
                      roleId: function () {
                          return $("#roleId").val(); //这个是取要验证的用户名
                      },
                  },
                  dataFilter: function (data) {  //判断控制器返回的内容
                      var rateTypeTmp = $("#rateType").val();
                      var roleIdTmp = $("#roleId").val();
                      var notice = eval("("+ data +")");
                      if( notice && ((rateTypeTmp != rateType) || (roleIdTmp != roleId))){
                          return false;
                      }else{
                          return true;
                      }
                  }
              }
          }
      },  
      messages : {
          rateName : {
	            required : "名称不能为空!",
//	            remote: "用户名已存在！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
        },
          roleId : {
              required : "角色不能为空!",
              remote: "该角色手续费已存在！"
          }
      },  
      errorElement : "small",
      errorClass : "font-red",
      highlight : function(element, errorClass,validClass) {
        $(element).closest('.form-control').addClass('border-red');
      },
      success : function(element) {
        $(element).siblings('.form-control').removeClass('border-red');
        $(element).remove();
      }
    });
  }