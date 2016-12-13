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
    // 2、初始化下拉框
    initCombo();
    
});
/**
 * 初始化下拉框
 */
function initCombo(){
	var store = Ext.create('Ext.data.Store', {
	    fields: ['codeValue', 'codeName'],
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
	// 2、创建一个ComboBox，可见的
	Ext.create('Ext.form.ComboBox', {
	    store: store,
	    displayField: 'codeName',
	    valueField: 'codeValue',
	    renderTo: 'opKindCombo',
	    listeners: {
	    	'select':function(){
	    		$("#opKind").val(this.getValue());
	    	},
	    	render: function(){
	    		store.load();
	    		this.setValue($("#opKind").val());
	    	}
	    }
	});
}

	
	
function upload(){
	$.ajaxFileUpload({
		url: rootPath + '/user/uploadFile',
		type:'post',
		//dataType : 'text',
		// 对应file标签的id
		fileElementId : "uploadFile",
		data:{
		},
		success :function(data){
			var str = $(data).find("body").text();
			alert(str);
			var json = $.parseJSON(str);
			alert(json);
		},
		error :function(data){
			alert(data.msg);
		}
	});
}


/*$.validator.setDefaults({
	submitHandler:function(form) {
		alert("表单提交");
		//$("#fbean").submit();
		var type = $("#type").val();
		//判断操作是添加还是更新
		if("add"==type){
			$("#fbean").attr("action",rootPath + "/user/addUser");
		}else{
			$("#fbean").attr("action",rootPath + "/user/modifyUser");
		}
		//提交表单
		$("#fbean").submit();
		
    }
});*/


$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#fbean").validate({
	  onfocusout:function(element){
		  $(element).valid();
	  },
      rules: {
    	 opName: { required: true},
    	 opCode:  {required: true},
    	 loginCode: {
          required: true,
          minlength: 2
        },
        loginPassword: {
        	required: true,
        	minlength: 2
        },
        mobileNo: {
        	 required: true,
             minlength: 5
        }
      },
      messages: {
    	  opName: { required:  "请输入操作员名称"},
    	  opCode: {required:  "请输入操作员编码"},
    	  loginCode: {
          required: "请输入用户名",
          minlength: "用户名最少由两个字母组成"
        },
        loginPassword: {
        	required: "请输入密码",
        	minlength: "密码最少由两个字母组成"
        },
        mobileNo: {required: "请输入联系电话"},
        }
  });
});

function save(){
	alert("save!!!")
	var type = $("#type").val();
	//判断操作是添加还是更新
	if("add"==type){
		$("#fbean").attr("action",rootPath + "/user/addUser");
	}else{
		$("#fbean").attr("action",rootPath + "/user/modifyUser");
	}
	//提交表单
	$("#fbean").submit();
}
function cancel(){
	
}