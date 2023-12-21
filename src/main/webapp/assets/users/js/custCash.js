$(document).ready(function () {    
	//下拉框初始化
	combobox(); 
	//表单校验及提交
	confirmForm();
}); 

function combobox(){
	$.ajax({
        url : ctx+"/combobox/customer",
        type : "post",
        dataType : "json",
        success:function(data){
	        $.each(data, function (i, item) {
	        	$("#tradTo").append("<option value='" + item.custId + "'>" + item.custName + "</option>");
	        });
        }
    });
}

function CountRateAmt(){
	var tradAmt=document.getElementById("tradAmt").value;
	var chargeRate=document.getElementById("chargeRate").value;
	document.getElementById("rateAmt").value=parseFloat(tradAmt)*parseFloat(chargeRate);
}

function confirmForm() {
    $("#custCashForm").validate({
      submitHandler : function() {  //验证通过后的执行方法
          //当前的form通过ajax方式提交（用到jQuery.Form文件）
    	var tradToName = $("#tradTo").find("option:selected").text();
    	$("#tradToName").val(tradToName);
      	var param = $("#custCashForm").serialize();
          $.ajax({
              url : ctx+"/custAccountController/custCashConfirm",
              type : "post",
              dataType : "json",
              data: param,
              success:function(data){
                  if(data.isSuc){
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
    	  tradAmt : {  
	            required : true,   //验证非空
	            number : true,
	            max:$("#amtFree").val(),
        }
      },  
      messages : {  
    	  tradAmt : {  
	            required : "转出金额不能为空!",
	            number: "请输入正确的金额！" , //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
            	max:"不能超过可用余额"
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
