$(document).ready(function () {    
	//初始化List
	initTable();  
}); 

function initTable(){
	
	$('#factorDg').bootstrapTable('destroy');  
	
	$('#factorDg').bootstrapTable({
	    method: 'get',
	    //toolbar: '#phoneTb',    //工具按钮用哪个容器
	    striped: true,           //是否显示行间隔色
	    cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	    pagination: true,        //是否显示分页（*）
	    sortable: false,         //是否启用排序
	    sortOrder: "asc",        //排序方式
	    pageNumber:1,            //初始化加载第一页，默认第一页
	    pageSize: 10,            //每页的记录行数（*）
	    pageList: [10, 20],      //可供选择的每页的行数（*）
	    url: ctx+"/factorController/factorList",//这个接口需要处理bootstrap table传递的固定参数
	    //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
	    //设置为limit可以获取limit, offset, search, sort, order  
	    queryParamsType : "undefined",  
        queryParams: function queryParams(params) {   //设置查询参数  
            var param = {    
                pageNumber: params.pageNumber,    
                pageSize: params.pageSize,
                factorCode : $("#factorCode").val()
            };    
            return param;                   
          }, 
	    sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
	    //search: true,           //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	    //strictSearch: true,
	    //showColumns: true,      //是否显示所有的列
	    //showRefresh: true,      //是否显示刷新按钮
	    minimumCountColumns: 2,   //最少允许的列数
	    clickToSelect: false,     //是否启用点击选中行
	    searchOnEnterKey: true,
	    columns: [{
	        field: 'userId',
	        title: '序号',
	        align: 'center',
	        formatter:function(value,row,index){  
	        	if(updateBtn!="" && updateBtn!=null && row.status === 1){
	        		var e = '<a class="btn btn-xs btn-warning" onclick="updateFactor(\''+ row.factorId +'\')">修改</a>'; 
	        	}else{
	        		var e = ''; 
	        	}
	        	if(deleteBtn!="" && deleteBtn!=null && row.status === 1){
	        		var d = '<a class="btn btn-xs btn-danger"  onclick="deleteFactor(\''+ row.factorId +'\',\''+ row.factorCode +'\')">删除</a>';
	        	}else{
	        		var d = ''; 
	        	}
	        	if(addCheck!="" && addCheck!=null && row.status === 2){
	        		var e1 = '<a class="btn btn-xs btn-success" onclick="AddCheckFactor(\''+ row.factorId +'\')">录入复核</a>'; 
	        	}else{
	        		var e1 = ''; 
	        	}
	        	if(factorLoan!="" && factorLoan!=null && row.status === 3){
	        		var e2 = '<a class="btn btn-xs btn-success" onclick="loanFactor(\''+ row.factorId +'\')">质押</a>'; 
	        	}else{
	        		var e2 = ''; 
	        	}
	        	if(loanCheck!="" && loanCheck!=null && row.status === 4){
	        		var e3 = '<a class="btn btn-xs btn-success" onclick="checkLoan(\''+ row.factorId +'\')">质押复核</a>'; 
	        	}else{
	        		var e3 = ''; 
	        	}
	        	if(loanAction!="" && loanAction!=null && row.status === 5){
	        		var e4 = '<a class="btn btn-xs btn-success" onclick="actionLoan(\''+ row.factorId +'\')">质押放款</a>'; 
	        	}else{
	        		var e4 = ''; 
	        	}
	        	if(factorAction!="" && factorAction!=null && row.status === 6){
	        		var e5 = '<a class="btn btn-xs btn-success" onclick="actionFactor(\''+ row.factorId +'\')">保理执行</a>'; 
	        	}else{
	        		var e5 = ''; 
	        	}
                return e+d+e1+e2+e3+e4+e5;
             }
	    },{
	        field: 'factorCode',
	        title: '合同编号',
	        align: 'center'
	    },{
	        field: 'custSellName',
	        title: '卖方',
	        align: 'center'
	    },{
	        field: 'custfactorName',
	        title: '保理商',
	        align: 'center'
	    },{
	        field: 'factorAmt',
	        title: '金额',
	        align: 'center'
	    }, {
	        field: 'startDate',
	        title: '合同时间',
	        align: 'center'
	    },{
	        field: 'status',
	        title: '合同状态',
	        align: 'center',
	        formatter : function(value) {
				var str = "";
				if (value == "1") {
					str = '<span class="label label-sm label-danger"> 审批失败 </span>';
				}
				if (value == "2") {
					str = '<span class="label label-sm label-success"> 已录入 </span>';
				}
				if (value == "3") {
					str = '<span class="label label-sm label-success"> 复核通过 </span>';
				}
				if (value == "4") {
					str = '<span class="label label-sm label-success"> 已质押 </span>';
				}
				if (value == "5") {
					str = '<span class="label label-sm label-success"> 质押已复核 </span>';
				}
				if (value == "6") {
					str = '<span class="label label-sm label-success"> 质押已放款 </span>';
				}
				if (value == "7") {
					str = '<span class="label label-sm label-success"> 保理已执行 </span>';
				}
				return str;
			}
	    },{
	        field: 'modOptr',
	        title: '操作人',
	        align: 'center'
	    }, {
	        field: 'modTime',
	        title: '操作时间',
	        align: 'center'
	    }]
	});
}

function updateFactor(factorId){
	window.location.href = ctx+updateBtn+"?factorId="+factorId;
}

function deleteFactor(factorId,factorCode){
	swal({title: '您确认要删除吗？',
		  text: "您确认要删除 保理合同["+factorCode+"]？",
		  type: 'warning',
		  showCancelButton: true,
		  closeOnConfirm: false,
		  cancelButtonText:"取消",
		  confirmButtonText: '确认删除',
		  confirmButtonColor:"#ec6c62"
		  },function (){
				$.ajax({
			        url : ctx+deleteBtn+"?factorId="+factorId,
			        type : "post",
			        dataType : "json"
					}).done(function (data){
						swal({title: '成功',
	                		  text: data.errMsg,
	                		  type: 'success',
	                		  confirmButtonText: '确定',
	                      },function(){
	                    	  location.reload();
	                      }); 
					}).error(function (data){
						swal({title: '失败',
	                		  text: data.errMsg,
	                		  type: 'error',
	                		  confirmButtonText: '确定',
	                      },function(){
	                    	  location.reload();
	                      }); 
			    });
		  })
}

function AddCheckFactor(factorId){
	window.location.href = ctx+addCheck+"?factorId="+factorId;
}

function loanFactor(factorId){
	window.location.href = ctx+factorLoan+"?factorId="+factorId;
}

function checkLoan(factorId){
	window.location.href = ctx+loanCheck+"?factorId="+factorId;
}

function actionLoan(factorId){
	window.location.href = ctx+loanAction+"?factorId="+factorId;
}

function actionFactor(factorId){
	window.location.href = ctx+factorAction+"?factorId="+factorId;
}