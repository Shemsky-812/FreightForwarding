$(document).ready(function () {          
	//初始化List
	initTable();  
}); 

function initTable(){
	
	$('#custAmtDg').bootstrapTable('destroy');  
	
	$('#custAmtDg').bootstrapTable({
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
	    url: ctx+"/custAmtController/custAmtList",//这个接口需要处理bootstrap table传递的固定参数
	    //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
	    //设置为limit可以获取limit, offset, search, sort, order  
	    queryParamsType : "undefined",  
        queryParams: function queryParams(params) {   //设置查询参数  
            var param = {    
                pageNumber: params.pageNumber,    
                pageSize: params.pageSize,
                amtCode : $("#amtCode").val(),
                tradNo : $("#tradNo").val(),
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
	        field: 'custAmtId',
	        title: '序号',
	        align: 'center',
	    },{
	        field: 'amtCode',
	        title: '资金编号',
	        align: 'center'
	    },{
	        field: 'amtValue',
	        title: '金额',
	        align: 'center'
	    }, {
	        field: 'tradType',
	        title: '交易类型',
	        align: 'center'
	    }, {
	        field: 'tradNo',
	        title: '交易编号',
	        align: 'center'
	    }, {
	        field: 'tradFromName',
	        title: '转出企业',
	        align: 'center'
	    }, {
	        field: 'tradToName',
	        title: '转入企业',
	        align: 'center'
	    }, {
	        field: 'custId',
	        title: '资金归属企业',
	        align: 'center'
	    }, {
	        field: 'status',
	        title: '交易状态',
	        align: 'center',
	        formatter : function(value) {
				var str = "";
				if (value == "0") {
					str = '<span class="label label-sm label-danger"> 已回收 </span>';
				}
				if (value == "1") {
					str = '<span class="label label-sm label-warning"> 可使用 </span>';
				}
				if (value == "2") {
					str = '<span class="label label-sm label-success"> 已使用 </span>';
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
