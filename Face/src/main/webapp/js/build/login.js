$(function(){
	
	
})

//注册
function add(){
	layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '500px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['注册', '返回']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content:  $('#zhuc')
        ,yes: function(index, layero){
        	var username = $("#username").val();
        	var password = $("#password").val();
        	var phone = $("#phone").val();
        	var email = $("#email").val();
        	$.ajax({
        		type : "post",
        		dataType : "json",
        		data : {
        			"username" : username,
        			"password":password,
        			"email":email,
        			"phone":phone
        		},
        		url :  "http://localhost:8888/register",
        		success : function(result) {
        			if (result.error) {
        				errorMsg(result.error)
        			}
        			if (result.success) {
        				successMsg(result.success)
        			}
        			layer.close(index); //如果设定了yes回调，需进行手工关闭
        		},
        		error : function(result) {
        			layer.close(index); //如果设定了yes回调，需进行手工关闭
        			errorMsg(result.error)
        		}
        	});
        	
          
         }
        
	});		
}

//function colorInput(){
////	test-form-input
//	alert(1)
//}
//
//function colorInput2(){
////	test-form-input2
//}

//报错提示
function errorMsg(errMsg) {
	layer.msg(errMsg, {
		icon : 2,
		skin : 'layui-layer-molv',
		time : 2000,
	})
}
//成功提示
function successMsg(sucMsg) {
	layer.msg(sucMsg, {
		icon : 1,
		skin : 'layui-layer-molv',
		time : 2000,
	})
}