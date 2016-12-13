Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux', rootPath+'/res/extjs/ux/');
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

window.onload=function(){
	$.ajax({
	    type: 'get',
	    dataType :'json',
	    async:false,
	    url: rootPath + '/item/getAllIcItem',
	    data :{   },
	   success:function(data){
		   alert(data);
	    },
	    error:function(data){
	 	   alert("初始化数据失败");
	    }
	});
};

Ext.onReady(function(){
    Ext.QuickTips.init();
    Ext.EventManager.onWindowResize(function(){ 
        queryGrid.getView().refresh();
    });
    /*自定义table的滚动条*/
    //jscrollBar(".scroll","2");
});
/*init combo */
function initCombo(){
	var store = Ext.create('Ext.data.Store', {
        fields: ['codeValue','codeName'],
        proxy: {
	         type: 'ajax',
	         url: rootPath + '/item/getIcItemByItemType' ,
	         data:{
	        	itemType: ("#itemType")
	         },
	         reader: {
	             type: 'json'
	         },
	     },
	});   
	
	Ext.create('Ext.form.ComboBox', {
	    //2.2、对应上面的仓库
	    store: store,
	    //2.3、显示字段名
	    displayField: 'typeName',
	    //2.4、值的字段名
	    valueField: 'typeValue',
	    // 渲染到哪个元素，div的id为comboId
	    renderTo: 'typeCombo',
	    listeners: {
	    	'select':function(){
	    		// 通过getValue获取数据值
	    		$("#itemType").val(this.getValue());
	    	}
	    }
	});
}
/*
* 操作按钮
*/
function buttonRender(value, meta, record, rowIndex, colIndex, store) {
    var returnValue = "";
    var state = record.data.state;
    returnValue += '<em class="modify-ico" title="修改" onclick=""></em>'+
                    '<em class="del-ico" title="删除" onclick=""></em>';
    
    return returnValue;
}
/*
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}

