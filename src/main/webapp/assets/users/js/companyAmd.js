$(document).ready(function () {   
	//表单校验及提交
	confirmForm();
}); 

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
			$("#paperPath").val(data.filePath);
		}
	});
}

function confirmForm() {
    $("#companyAmdForm").validate({
      submitHandler : function() {  //验证通过后的执行方法
          //当前的form通过ajax方式提交（用到jQuery.Form文件）
      	var param = $("#companyAmdForm").serialize();
          $.ajax({
              url : ctx+"/companyController/companyAmdConfirm",
              type : "post",
              dataType : "json",
              data: param,
              success:function(data){
                  if(data.isSuc){
                	  document.getElementById("companyAmdForm").reset(); 
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
          paperNo : {
	            required : true,   //验证非空
	           remote: {          //远程ajax验证
	               url: ctx+"/companyController/checkPaperNo", //检查是否存在账号，存在则返回true
	               type: "GET",
	               dataType: "json",
	               data: {
                       paperNo: function () {
	                       return $("#paperNo").val(); //这个是取要验证的用户名
	                   }
	               },
	               dataFilter: function (data) {  //判断控制器返回的内容
	                   var paperNoTmp = $("#paperNo").val();
	                   var notice = eval("("+ data +")");
	                   if( notice && (paperNoTmp != paperNo)){
	                       return false;
	                   }else{
	                       return true;
	                   }
	               }
	           }
        },
          loginNameInp : {
              required : true,   //验证非空
              remote: {          //远程ajax验证
                  url: ctx+"/sysUserController/checkLoginName", //检查是否存在账号，存在则返回true
                  type: "GET",
                  dataType: "json",
                  data: {
                      loginName: function () {
                          return $("#loginNameInp").val(); //这个是取要验证的用户名
                      }
                  },
                  dataFilter: function (data) {  //判断控制器返回的内容
                      var loginNameInpTmp = $("#loginNameInp").val();
                      var notice = eval("("+ data +")");
                      if( notice && (loginNameInpTmp != loginNameInp)){
                          return false;
                      }else{
                          return true;
                      }
                  }
              }
          },
          loginNameApp : {
              required : true,   //验证非空
              remote: {          //远程ajax验证
                  url: ctx+"/sysUserController/checkLoginName", //检查是否存在账号，存在则返回true
                  type: "GET",
                  dataType: "json",
                  data: {
                      loginName: function () {
                          return $("#loginNameApp").val(); //这个是取要验证的用户名
                      }
                  },
                  dataFilter: function (data) {  //判断控制器返回的内容
                      var loginNameAppTmp = $("#loginNameApp").val();
                      var notice = eval("("+ data +")");
                      if( notice && (loginNameAppTmp != loginNameApp)){
                          return false;
                      }else{
                          return true;
                      }
                  }
              }
          },
      },  
      messages : {
          paperNo : {
              required : "营业执照编号不能为空!",
              remote: "营业执照编号已存在！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
        },
          loginNameInp : {
              required : "登录名不能为空!",
              remote: "登录名已存在！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
          },
          loginNameApp : {
              required : "登录名不能为空!",
              remote: "登录名已存在！"  //这个地方如果不写的话，是自带的提示内容，加上就是这个内容。
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