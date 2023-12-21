function custTransfer(){
    $.ajax({
        url : ctx+"/custAccountController/isChargeRate",
        type : "post",
        dataType : "json",
        data:{rateType:"1"},
        success:function(data){
            if(data.isChargeRate){
                location.href=ctx+transfer
            }else{
                swal({title: '失败',
                    text: "未设置手续费，请联系管理员设置手续费",
                    type: 'error',
                    confirmButtonText: '确定',
                },function(){
                    location.reload();
                });
            }
        }
    });
}

function custCash(){
    $.ajax({
        url : ctx+"/custAccountController/isChargeRate",
        type : "post",
        dataType : "json",
        data:{rateType:"2"},
        success:function(data){
            if(data.isChargeRate){
                location.href=ctx+cash
            }else{
                swal({title: '失败',
                    text: "未设置手续费，请联系管理员设置手续费",
                    type: 'error',
                    confirmButtonText: '确定',
                },function(){
                    location.reload();
                });
            }
        }
    });
}