Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux', '../../res/extjs/ux/');
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
    initGrid();
    onfocus();
    initDateTime();
    initCombo("simpleCombo");
    initCombo("simpleCombo2");
    initCombo("simpleCombo3");
    initCombo("simpleCombo4");
    initCombo("simpleCombo5");
});
function initDateTime() {
	// 开始时间
	$("#startDateBox").live("click", function() {
		WdatePicker({
					el : "startDate",
					dateFmt : "yyyy-MM-dd HH:mm:ss"
				});
	});
	// 结束时间
	$("#endDateBox").live("click", function() {
		WdatePicker({
					el : "endDate",
					dateFmt : "yyyy-MM-dd HH:mm:ss"
				});
	});
}
/*init combo */
function initCombo(obj){
    var states = [
                    {"abbr":"AL","name":"Alabama","slogan":"The Heart of Dixie"},
                    {"abbr":"AK","name":"Alaska","slogan":"The Land of the Midnight Sun"},
                    {"abbr":"AZ","name":"Arizona","slogan":"The Grand Canyon State"}];
    var store = Ext.create('Ext.data.Store', {
        autoDestroy: true,
        fields: [
            {type: 'string', name: 'abbr'},
            {type: 'string', name: 'name'},
            {type: 'string', name: 'slogan'}
        ],
        data: states
    });
    var simpleCombo = Ext.create('Ext.form.field.ComboBox', {
        renderTo: obj,
        displayField: 'name',
        width: 280,
        labelWidth: 130,
        store: store,
        queryMode: 'local',
        typeAhead: true
    });
}
function initGrid(){
    data = [
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx'],
        ['供应商1','电信', '100:1',  10.03,'日结','线下','xxxxx', '151xxxxxxx']
        
    ];

    // create the data store
    store = Ext.create('Ext.data.Store', {
        fields: [
           {name: 'name'},
           {name: 'type',  type: 'float', convert: null,     defaultValue: undefined},
           {name: 'changeRatio', type: 'float', convert: null,     defaultValue: undefined},
           {name: 'price',  type: 'float', convert: null,     defaultValue: undefined},
           {name: 'settlementPeriod', type: 'float', convert: null,   defaultValue: undefined},
           {name: 'settlement', type: 'float', convert: null,  defaultValue: undefined},
           {name: 'contact', type: 'float', convert: null,  defaultValue: undefined},
           {name: 'contactTel', type: 'float', convert: null,  defaultValue: undefined}
        ],  
        remoteSort: true,
        pageSize: 10,
        proxy: {
            //type: 'ajax',
            type: 'pagingmemory',
            // url: '',
            data: data,
            reader: {
                // type: 'json'
                type: 'array'
            }
        }
    });
    // width确定的宽度
    columns = [
            {
                text     : '供应商名称',
                flex     : 1,
                sortable : false,
                dataIndex: 'name',
                renderer : qtips
            },
            {
                text     : '供应商类型',
                width    : 110,
                sortable : true,
                dataIndex: 'type'
            },
            {
                text     : '兑换比率',
                width    : 110,
                sortable : true,
                dataIndex: 'changeRatio',
                align    : 'right'
            },
            {
                text     : '兑换费',
                width    : 110,
                sortable : true,
                dataIndex: 'price',
                align    : 'right'
            },
            {
                text     : '结算周期',
                width    : 120,
                sortable : true,
                dataIndex: 'settlementPeriod',
                align    : 'center'
            },
            {
                text     : '结算方式',
                width    : 110,
                sortable : true,
                dataIndex: 'settlement'
            },
            {
                text     : '联系人',
                width    : 110,
                sortable : true,
                dataIndex: 'contact'
            },
            {
                text     : '联系电话',
                width    : 85,
                sortable : true,
                dataIndex: 'contactTel'
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
        columns: columns,
        height: 350,
        autoWidth: true,
        renderTo: 'otherGrid',
        /*resizable: {
          handles: 's',
          minHeight: 100
        },*/
        //bbar: pager,
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
* 提示文字
*/
function qtips(value, cellmeta, record, rowIndex, colIndex, store){
    return '<span  title="'+ value +'">' + value + '</span>';    
}
/* upload */
function uploadImage(obj){
    $(this).prev("input").val("11111");
    var $this = $(obj),
        type = $this.val().split(".")[1];
    if(type.match(/gif$|jpeg$|png$|jpg$/i)){
        getImage(obj);
        $("#uploadTips").append('<b class="upload-rgt"><i class="r"></i>上传成功！</b>');
        $("#dft-tips").show();
        $(".error-tip2").remove();
        $(".upload-err").remove();
    }
    else{
        $("#wrapImg").remove();
        $(".error-tip2").remove();
        $("#uploadTips").append('<b class="error-tip2 error-spe"><i class="e"></i>上传的图片格式不正确！</b>');
        $(".preview-tips").append('<span class="upload-err"><i class="upload-err-tip"></i>上传失败！</span>');
        $("#dft-tips").hide();
        $("#imghead").remove();
    }
}
function getImage(obj){
    $("#wrapImg").remove();
    var wrapImg = '<div id="wrapImg"></div>';
    $("#preview").append(wrapImg);
    var imgHtml = '<img width="260" height="180" border="0" class="img-placeholder"  src="" id="imghead">';
    $("#wrapImg").append(imgHtml);
    var img = $("#imghead");
    if (obj.files && obj.files[0])
      {
        var reader = new FileReader;
        reader.onload = function(evt){img.attr("src", evt.target.result);}
        reader.readAsDataURL(obj.files[0]);
       }
       else //兼容IE
       {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            obj.select();
            var src = document.selection.createRange().text;
            //var img = document.getElementById('imghead');
           // img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            $("#wrapImg").append("<div class='ieImg' style='width:260px;height:180px;"+sFilter+src+"'></div>");
        }

    $(".ieImg,.img-placeholder").live("mouseover",function(){
        $("#wrapImg").append('<b class="btn-remove"></b>');
        removeObj(".btn-remove","#wrapImg");//IE的情况下都删除
    });
    $("#preview").live("mouseleave",function(){
        $(".btn-remove").remove();
    });
}
/*=======================*/
function onfocus(){
    $("input[type='text']").focus(function(){
        $(this).addClass("blur");
    })
     $("input[type='text']").blur(function(){
        $(this).removeClass("blur");
    })
}