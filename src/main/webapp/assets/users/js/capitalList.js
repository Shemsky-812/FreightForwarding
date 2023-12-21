$(document).ready(function () {          
	//初始化List
	initTable();  
}); 

function initTable(){
	
	$('#capitalDg').bootstrapTable('destroy');  
	
	$('#capitalDg').bootstrapTable({
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
	    url: ctx+"/capitalController/capitalList",//这个接口需要处理bootstrap table传递的固定参数
	    //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
	    //设置为limit可以获取limit, offset, search, sort, order  
	    queryParamsType : "undefined",  
        queryParams: function queryParams(params) {   //设置查询参数  
            var param = {    
                pageNumber: params.pageNumber,    
                pageSize: params.pageSize,
                roleName : $("#roleName").val()
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
	        field: 'tradId',
	        title: '序号',
	        align: 'center',
	        formatter:function(value,row,index){ 
	        	if(cash!="" && cash!=null && row.tradType == "提现" && row.status === 1){
	        		var e = '<a class="btn btn-xs btn-warning" onclick="Cash(\''+ row.capitalId +'\')">提现确认</a>'; 
	        	}else{
	        		var e = ''; 
	        	}
	        	if(received!="" && received!=null && row.tradType == "保理" && row.status === 1){
	        		var d = '<a class="btn btn-xs btn-danger"  onclick="FactorReceived(\''+ row.capitalId +'\')">收款确认</a>';
	        	}else{
	        		var d = ''; 
	        	}
	        	if(payment!="" && payment!=null && row.tradType == "贷款" && row.status === 1){
	        		var r = '<a class="btn btn-xs btn-danger"  onclick="LoanPayment(\''+ row.capitalId +'\')">偿还确认</a>';
	        	}else{
	        		var r = ''; 
	        	}
                return e+d+r;
             }
	    },{
	        field: 'tradType',
	        title: '交易类型',
	        align: 'center'
	    },{
	        field: 'tradNo',
	        title: '交易编号',
	        align: 'center'
	    }, {
	        field: 'tradFromName',
	        title: '出账企业',
	        align: 'center'
	    }, {
	        field: 'tradToName',
	        title: '入账企业',
	        align: 'center'
	    }, {
	        field: 'capitalAmt',
	        title: '交易金额',
	        align: 'center'
	    }, {
	        field: 'status',
	        title: '交易状态',
	        align: 'center',
	        formatter : function(value) {
				var str = "";
				if (value == "1") {
					str = '<span class="label label-sm label-warning"> 待确认 </span>';
				}
				if (value == "2") {
					str = '<span class="label label-sm label-success"> 已完成 </span>';
				}
				return str;
			}
	    },{
	        field: 'modOptr',
	        title: '操作人',
	        align: 'center'
	    },{
	        field: 'modTime',
	        title: '操作时间',
	        align: 'center'
	    }]
	});
}

function Cash(capitalId){
	window.location.href = ctx+cash+"?capitalId="+capitalId;
}


function FactorReceived(capitalId){
	window.location.href = ctx+received+"?capitalId="+capitalId;
}


function LoanPayment(capitalId){
	window.location.href = ctx+payment+"?capitalId="+capitalId;
}

