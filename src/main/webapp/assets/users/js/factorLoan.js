$(document).ready(function () {      
	//获取企业信息;
	getcustomer();
	//表单校验及提交
	confirmForm();
}); 

function getcustomer(){
	$.ajax({
        url : ctx+"/custAccountController/getcustomer",
        type : "post",
        dataType : "json",
        success:function(data){
        	$("#custDebtor2").val(data.custId );
        	$("#custDebtorName2").val(data.custName);
        }
    });
}

function fileUploadBtn (file){
	
	var files = $("#"+file).val();
	var strFileName=files.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");  //正则表达式获取文件名，不带后缀
	var FileExt=files.replace(/.+\./,"");   //正则表达式获取后缀
	var fileName = strFileName+"."+FileExt;
	
	$.ajaxFileUpload({
		url : ctx+"/upload/file",
		secureuri : false,
		fileElementId : file,
		type : 'post',
		dataType : 'json',
		data:{
			"filename":fileName,
		},
		success : function(data){
			console.log("filePath1"+data.filePath);
			$("#filePath2").val(data.filePath);
		}
	});
}

function confirmForm() {
    $("#factorLoanForm").validate({
      submitHandler : function() {  //验证通过后的执行方法
          //当前的form通过ajax方式提交（用到jQuery.Form文件）
      	var param = $("#factorLoanForm").serialize();
          $.ajax({
              url : ctx+"/factorController/factorLoanConfirm",
              type : "post",
              dataType : "json",
              data: param,
              success:function(data){
                  if(data.isSuc){
                	  document.getElementById("factorLoanForm").reset(); 
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
    	  loanAmt2 : {  
	            required : true,   //验证非空
	            number : true,
        },rate2 : {  
            required : true,   //验证非空
            number : true,
        } 
      },  
      messages : {  
    	  loanAmt2 : {  
	            required : "不能为空!",
	            number: "请输入正确的金额！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
        },rate2 : {  
            required : "不能为空!",
            number: "请输入正确的金额！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
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