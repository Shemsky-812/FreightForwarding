$(document).ready(function () {      
	//表单校验及提交
	confirmCheckForm();
}); 

function confirmCheckForm() {
	
    $("#checkForm").validate({
      submitHandler : function() {  //验证通过后的执行方法
          //当前的form通过ajax方式提交（用到jQuery.Form文件）
    	console.log( "checkStatus"+$("#checkStatus").val());
      	var param = $("#checkForm").serialize();
      	console.log("txCheck");
    	$.ajax({
            url : ctx+"/checkController/checkConfirm",
            type : "post",
            dataType : "json",
            data: param,
            success:function(data){
            	$("#checkModal").modal('hide');
            	document.getElementById("checkForm").reset();
            	if(data.isSuc){
                    swal({title: '成功',
              		  text: data.errMsg,
              		  type: 'success',
              		  confirmButtonText: '确定',
                    },function(){
                    	window.location.href = ctx+data.returnUrl;
                    }); 
                }else{
                	swal("失败", data.errMsg, "error"); 
                }
            }
        });
      },
      focusInvalid : true,   //验证提示时，鼠标光标指向提示的input
      rules : {
    	  checkMsg : {  
	            required : true,   //验证非空
        }
      },  
      messages : {  
    	  checkMsg : {  
	            required : "信息不能为空!",
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