Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux', rootPath + '/res/extjs/ux/');
// 动态模块的引入
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
	 /* Ext.EventManager.onWindowResize(function(){ 
	        queryGrid.getView().refresh() ;
	    });*/
    // 1、初始化列表
    initGrid();
    
    // 2、初始化下拉框
   
    initCombo();
    
});

/*init combo */
function initCombo(){
  var store = Ext.create('Ext.data.Store', {
      autoDestroy: true,
      fields: ['codeValue', 'codeName'],
      proxy:{
          type: 'ajax',
          url : rootPath+'/common/getCodeValue?codeType=1001',
          reader:{
          	type:'json'
          }
      },
  });
  var simpleCombo = Ext.create('Ext.form.field.ComboBox', {
      renderTo: 'table1',
      displayField: 'codeName',
      valueField: 'codeValue',
      width: 220,
      labelWidth: 130,
      store: store,
      //queryMode: 'local',
      typeAhead: true,
      listeners: {
	    	'select':function(){
	    		// 通过getValue获取数据值
	    		$("#evaluationStatus").val(this.getValue());
	    	}
	    }
  });
}

function initGrid(){
	// create the data store
  var  store = Ext.create('Ext.data.Store', {
        fields: [
                {name: 'evaluationId', type: 'auto'},
       	      {name: 'evaluateAcount', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'commodityName', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'commodityPic', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'evaluationGrade', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'evaluationContent', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'evaluationPic', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'evaluationStore', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'evaluationTime', type: 'auto', convert: null, defaultValue: undefined},
       	      {name: 'mcthName', type: 'auto', convert: null, defaultValue: undefined}

               ],  
        remoteSort: true,
        pageSize: 5,
        proxy: {
	    	// 内存读取，本地读取
	        //type: 'memory',
	        type: 'ajax',
	        url : rootPath+"/item/itemEvaluationMgnt",
	        // 如果修改读请求为POSt，通过actionMethods
	        actionMethods :{
	        	 read: "POST"
	        }, 
	        reader: {
	        	// json格式
	            type: 'json',
	            // 指定数据的根节点，这个节点下面，应该是json格式的数组数据
	            root: 'list',
	            // 后台返回的数据中，一定是有一个属性代表着总条数
	            totalProperty: 'total'
	        }
	    }
    });
    // width确定的宽度
    columns = [
               {
            	   text : '评论账号',
            	   width : 110,
            	   sortable : true,
            	   dataIndex: 'evaluateAcount'
               },
               {
                   text : '商品名称',
                   width : 110,
                   sortable : true,
                   dataIndex: 'commodityName'
               },
               {
                   text : '商品图片',
                   width : 110,
                   hight : 50,
                   sortable : true,
                  // dataIndex: 'commodityPic',
                   renderer:function(value, meta, record, rowIndex, colIndex, store){
                	   var commodityPic = record.data.commodityPic;
                	   return "<img src="+rootPath+commodityPic+"></img>";
                   }
               },
               {
                   text : '评论分值',
                   width : 120,
                   sortable : true,
                   dataIndex: 'evaluationGrade',
                   // 对齐
                   align : 'center'
               },
               {
                   text : '评论内容',
                   width : 110,
                   sortable : true,
                   dataIndex: 'evaluationContent'
               },
               {
                   text : '评论图片',
                   width : 110,
                   sortable : true,
                   dataIndex: 'evaluationPic'
               },
               {
            	   text : '评论店铺',
            	   width : 110,
            	   sortable : true,
            	   dataIndex: 'evaluationStore'
               },
               {
            	   text : '评论时间',
            	   width : 110,
            	   sortable : true,
            	   dataIndex: 'evaluationTime'
               },
               {
                   text: '操作',
                   menuDisabled: true,
                   sortable: false,
                   width: 75,
                   renderer: butt,
                   align : 'center'
               }
        ];
    // 操作区域buttonRender,
    /*var dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            ui: 'footer',
            layout: {
                pack: 'center'
            }
        }, {
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
							window.location.href = rootPath+"/user/toAddAndUpdateUser?type=add";
						}
					}
				}
            }]
        }];*/
    // 多选
   /* var selModel = Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function(sm, selections) {
            }
        }
    });*/
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
       // selModel: selModel,
       // dockedItems: dockedItems,
        autoHeight: true,
        autoWidth: true,
        renderTo: 'table',
       /* resizable: {
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
function butt(value, meta, record, rowIndex, colIndex, store) {
    var returnValue = "";
    var evaluateAcount = record.data.evaluateAcount;
    var mcthName = record.data.mcthName;
    var evaluationStore = record.data.evaluationStore;
    returnValue += '<a  title="详情" href="'+rootPath+'/item/info?evaluateAcount='+evaluateAcount+'&mcthName='+mcthName+'&evaluationStore='+evaluationStore+'">详情</a><br><br><br>'+
                    '<a  title="屏蔽" href="'+rootPath+'/item/shield?evaluationId='+evaluateAcount+'&mcthName='+mcthName+'&evaluationStore='+evaluationStore+'">屏蔽</a>';
    
    return returnValue;
}

//'+rootPath+'/item/info?evaluationId='+evaluationId+'
function info(evaluationId){
	window.location.href = rootPath+"/item/info?evaluationId="+evaluationId;
}

function shield(evaluationId){
	window.location.href = rootPath+"/item/shield?evaluationId="+evaluationId;
}




/*
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}

function query(){
	store.proxy.extraParams = {
			evaluateAcount : $("#evaluateAcount").val(),
			evaluationStatus : $("#evaluationStatus").val()
	};
	
	store.load();
}


