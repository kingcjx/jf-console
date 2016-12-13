Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux', rootPath + '/res/extjs/ux/');
Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.util.*',
    'Ext.form.field.ComboBox',
    'Ext.form.FieldSet',
    'Ext.tip.QuickTipManager',
    'Ext.ux.data.PagingMemoryProxy'
    
]);


var data, store, columns, queryGrid,pager;
Ext.onReady(function(){
	// tips 悬浮框
	Ext.QuickTips.init();
	// 自适应宽高
    Ext.EventManager.onWindowResize(function(){ 
        queryGrid.getView().refresh() ;
    });
    // 1、初始化列表
    initGrid();
    
    // 2、初始化下拉框
    initCombo();
    
});

/*init combo */
function initCombo(){
	var store = Ext.create('Ext.data.Store', {
        fields: ['codeValue','codeName'],
        proxy: {
	         type: 'ajax',
	         url: rootPath + '/common/getCodeValue' ,
	         reader: {
	             type: 'json'
	         },
	         extraParams:{
	        	 codeType : '1003'
	         }
	     },
	});        
	
	Ext.create('Ext.form.ComboBox', {
	    //2.2、对应上面的仓库
	    store: store,
	    //2.3、显示字段名
	    displayField: 'codeName',
	    //2.4、值的字段名
	    valueField: 'codeValue',
	    // 渲染到哪个元素，div的id为comboId
	    renderTo: 'simpleCombo',
	    listeners: {
	    	'select':function(){
	    		// 通过getValue获取数据值
	    		alert(this.getValue());
	    		$("#opKind").val(this.getValue());
	    	}
	    }
	});
}

function initGrid(){
    // create the data store
    store = Ext.create('Ext.data.Store', {
        fields: [
                 {name: 'opId', type: 'auto'},
                 {name: 'opName', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'opCode', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'opKind', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'opPic', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'mobileNo', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'emailAdress', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'loginCode', type: 'auto', convert: null, defaultValue: undefined},
                 {name: 'lockFlag', type: 'auto', convert: null, defaultValue: undefined}
                 ], 
        remoteSort: true,
        pageSize: 10,
        proxy: {
	        type: 'ajax',
	        url : rootPath + '/user/selectSysOpList',
	        actionMethods :{
	        	 read: "POST"
	        }, 
	        reader: {
	        	// json格式
	            type: 'json',
	            root: 'list',
	            totalProperty: 'total'
	        }
        }
    });
 // width确定的宽度
    columns = [
               {
                   text : '操作员名称',
                   flex : 1,
                   sortable : false,
                   dataIndex: 'opName',
                   renderer : qtips
               },
               {
                   text : '编码',
                   width : 110,
                   sortable : true,
                   dataIndex: 'opCode'
               },
               {
                   text : '操作员类别',
                   width : 110,
                   sortable : true,
                   // 操作员类别：0-超级管理员 1-管理员 2-普通用户'
                   dataIndex: 'opKind',
                   renderer : function(value){
                	   var kind = value;
                	   if(kind == '0'){
                		   return '超级管理员';
                	   }else if(kind == '1'){
                		   return '管理员';
                	   }else{
                		   return '普通用户';
                	   }
                   }
               },
               {
                   text : '头像',
                   width : 110,
                   sortable : true,
                   dataIndex: 'opPic'
               },
               {
                   text : '手机号',
                   width : 120,
                   sortable : true,
                   dataIndex: 'mobileNo',
                   // 对齐
                   align : 'center'
               },
               {
                   text : '电子邮件地址',
                   width : 110,
                   sortable : true,
                   dataIndex: 'emailAdress'
               },
               {
                   text : '登陆名',
                   width : 110,
                   sortable : true,
                   dataIndex: 'loginCode'
               },
               {
                   text : '是否锁定',
                   width : 85,
                   sortable : true,
                   dataIndex: 'lockFlag',
                   renderer : function(value){
                	   var lockFlag = value;
                	   if(lockFlag == null || lockFlag == '1'){
                		   return '未锁定';
                	   }else{
                		   return '已锁定';
                	   }
                   }
               },
               {
                   text: '操作',
                   menuDisabled: true,
                   sortable: false,
                   width: 75,
                   renderer: buttonRender,
                   align : 'center'
               }
        ];
    // 操作区域
    var dockedItems = [/*{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            layout: {
                pack: 'center'
            }
        }, */{
            xtype: 'toolbar',
            items: [{
                text:'',
                tooltip:'新建',
                minWidth: 30,
                minHeight:30,
                iconCls:'new-ico',
				listeners : {
					click : {
						element : 'el',
						fn : function() {
							window.location.href =rootPath+"/user/toAddPage?type=add";
						}
					}
				}
            }]
        }];
    // 多选
    var selModel = Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function(sm, selections) {
            }
        }
    });
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
        selModel: selModel,
        dockedItems: dockedItems,
        autoHeight: true,
        autoWidth: true,
        renderTo: 'queryGrid',
        /*resizable: {
          handles: 's',
          minHeight: 100
        },*/
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
    });
    store.load();
}

/*
* 操作按钮
*/
function buttonRender(value, meta, record, rowIndex, colIndex, store) {
    var returnValue = "";
    var opId = record.data.opId;
    returnValue += '<em class="modify-ico" title="修改" onclick="toModifyPage('+opId+')"></em>'+
                    '<em class="del-ico" title="删除" onclick="deleteUser('+opId+')"></em>';
    
    return returnValue;
}

/*
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}
function toModifyPage(opId){
	window.location.href =rootPath+"/user/toAddPage?type=modify&opId="+opId;
}

function query(){
	store.proxy.extraParams = {
		opName : $("#opName").val(),
		opKind :$("#opKind").val()
		
	};
	
	
}
function deleteUser(opId){
	window.location.href = rootPath+"/user/deleteUser?opId="+opId;
}