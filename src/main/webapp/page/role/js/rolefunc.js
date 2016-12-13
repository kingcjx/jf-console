Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux',rootPath+ '/res/extjs/ux/');
Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.util.*',
    'Ext.form.field.ComboBox',
    'Ext.form.FieldSet',
    'Ext.tip.QuickTipManager',
    'Ext.ux.data.PagingMemoryProxy'
    
]);


var data, store, columns, queryGrid,pager,treeObj;
Ext.onReady(function(){
    Ext.QuickTips.init();
    Ext.EventManager.onWindowResize(function(){ 
        queryGrid.getView().refresh() ;
    });
    initGrid();
    
});
//生成一个空树
window.onload=function(){
	$.ajax({
	    type: 'get',
	    dataType :'json',
	    async:false,
	    url: rootPath + '/user/getMenuChkByOpId',
	    data :{
	      roleId :0
	    },
	   success:function(data){
	 	  if(treeObj != null){
		           treeObj.destroy();
		         }
	 	  //初始化树，按配置进行渲染
	      $.fn.zTree.init($("#treeDemo"), setting, data);
	      //获取ztree对象
	      treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	      //获取到所有选择状态的节点
	      var nodes = treeObj.getCheckedNodes(true);
	      //alert(treeData.roleId);
	      //遍历所有节点，并展开，注意：只作用于父节点，因为子节点无法展开
	      for (var i = 0; i < nodes.length; i++) {
	        treeObj.expandNode(nodes[i], true, true, true);
	      }
	    },
	    error:function(data){
	 	   alert("初始化失败");
	    }
	});
}
function initGrid(){
    // create the data store
    store = Ext.create('Ext.data.Store', {
        fields: [
                 {name: 'roleId', type: 'auto'},
                 {name: 'roleName', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'opName', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'opId', type: 'auto', convert: null, defaultValue: undefined},
        ],  
        remoteSort: true,
        pageSize: 10,
        proxy: {
            type: 'ajax',
	        url : rootPath + '/role/selectSysOpRoleList',
	        /*data :{  },*/
	        actionMethods :{
	        	 read: "POST"
	        }, 
            reader: {
                 type: 'json',
                 root: 'list',
     	         totalProperty: 'total'
            }
        }
    });
 
    // width确定的宽度
    columns = [
            {
                text     : '角色名称',
                flex     : 1,
                sortable : false,
                dataIndex: 'roleName',
                renderer : qtips
            }
        ];
    //pager
    pager = Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            displayMsg : '显示第 {0} 条到 {1} 条记录,一共 {2} 条'
    });
    
    // create the Grid
    queryGrid = Ext.create('Ext.grid.Panel', {
        store: store,
        stateful: true,
        collapsible: false,
        multiSelect: true,
        stateId: 'stateGrid',
        columns: columns,
        autoHeight: true,
        autoWidth: true,
        renderTo: 'queryGrid',
        listeners: {
	    	'select':function(row,record,index){
	    		// 通过getValue获取数据值
	    		$("#roleId").val(record.data.roleId);
	    		/*4、ajax请求*/
	    		$.ajax({
	    		       type: 'get',
	    		       dataType :'json',
	    		       url: rootPath + '/user/getMenuChkByOpId',
	    		       data :{
	    		         roleId : $("#roleId").val()
	    		       },
	    		      success:function(data){
	    		    	  if(treeObj != null){
	    			           treeObj.destroy();
	    			         }
	    		    	  //初始化树，按配置进行渲染
	    		         $.fn.zTree.init($("#treeDemo"), setting, data);
	    		         //获取ztree对象
	    		         treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	    		         //获取到所有选择状态的节点
	    		         var nodes = treeObj.getCheckedNodes(true);
	    		         //alert(treeData.roleId);
	    		         //遍历所有节点，并展开，注意：只作用于父节点，因为子节点无法展开
	    		         for (var i = 0; i < nodes.length; i++) {
	    		           treeObj.expandNode(nodes[i], true, true, true);
	    		         }
	    		       },
	    		       error:function(data){
	    		    	   alert("初始化失败");
	    		       }
	    		 });
	    	},
        bbar: pager,
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true,
            deferRowRender : false,
            forceFit : true,
            emptyText : "<font class='emptyText'>没有符合条件的记录</font>",
            autoScroll:true,
            scrollOffset:-10
        	}
    	}
    });
    store.load();
}
/*
* 操作按钮
*/
/*
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}

var setting = {
	       check: {
	         enable: true,
	         chkboxType: { "Y": "p", "N": "s" }
	       },
	       data: {
	         key : {
	           name : "funcName"
	         },
	         simpleData: {
	           enable: true,
	           idKey:'funcId',
	           pIdKey:'supFuncId'
	         }
	       }
	    };
	
function query(){
	alert($("#roleName").val());
	store.proxy.extraParams = {
		roleName : $("#roleName").val()
	};
	store.load();
}

//批量保存
function save(){
	//重新获取tree中被选中的元素
	 var checkedNodes = treeObj.getCheckedNodes(true);
	 var ids = new Array();
	 for(var i=0; i < checkedNodes.length; i++){
		 ids.push(checkedNodes[i].funcId);
	 }
	 ids=ids.join(",");
	$.ajax({
	       type: 'post',
	       dataType :'text',
	       url: rootPath + '/role/saveRoleFunc',
	       async:false,
	       data :{
	    	 funcList:ids,
	         roleId : $("#roleId").val(),
	       },
	      success:function(data){
	    	  alert("保存成功");
	    	  //更新ztree
	    		treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	    	    var nodes = treeObj.getCheckedNodes(true);
	    	    for (var i = 0; i < nodes.length; i++) {
	    	     treeObj.updateNode(nodes[i]);
	    	    }
	       },
	       error:function(data){
	    	   alert("初始化失败");
	       }
	 });
}
//重置
function reset(){
	treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    //获取到所有选择状态的节点
    var nodes = treeObj.getCheckedNodes(true);
    //遍历节点将checked属性置为false
    for (var i = 0; i < nodes.length; i++) {
     nodes[i].checked=false;
     treeObj.updateNode(nodes[i]);
    }
  
	
/*	if(treeObj != null){
        treeObj.destroy();
      }*/
}



