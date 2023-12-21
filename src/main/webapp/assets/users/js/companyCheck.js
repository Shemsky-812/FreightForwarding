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
	        	$("#roleIdInp").append("<option value='" + item.roleId + "'>" + item.roleName + "</option>");
	        	$("#roleIdApp").append("<option value='" + item.roleId + "'>" + item.roleName + "</option>");
	        });
        }
    });
}

function confirmForm() {
    $("#companyCheckForm").validate({
      submitHandler : function() {  //验证通过后的执行方法
          //当前的form通过ajax方式提交（用到jQuery.Form文件）
      	var param = $("#companyCheckForm").serialize();
          $.ajax({
              url : ctx+"/companyController/companyCheckConfirm",
              type : "post",
              dataType : "json",
              data: param,
              success:function(data){
                  if(data.isSuc){
                	  document.getElementById("companyCheckForm").reset(); 
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
//      rules : {
//    	  factorAmt : {  
//	            required : true,   //验证非空
//	            number : true,
//        },rate : {  
//            required : true,   //验证非空
//            number : true,
//        } 
//      },  
//      messages : {  
//    	  factorAmt : {  
//	            required : "用户名不能为空!",
//	            number: "请输入正确的金额！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
//        },rate : {  
//            required : "用户名不能为空!",
//            number: "请输入正确的金额！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
//        }
//      },  
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