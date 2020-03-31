$(function() {

	getMenButton();
	
	
	setInterval(getColor, 1000 * 0.5);
})

function getColor(){
	
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/GColor",
		success : function(result) {
			if (result.msg) {
				$("#updateAndAddInfo").css("background-color", result.color);
//				$(".body").css("background-color", result.color);
			}
		}
	})
}



function getMenButton() {
	$("#button_ID").html('')
	$("#barDemo").html('')
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/men/getMenButton",
		success : function(result) {
			if (result.msg) {
				var queryB ='';
				var addB ='';
				var updateB ='';
				var deleteB ='';
				
				$.each(result.menButtonList, function(i, item) {
					if(item.menName.indexOf("查询")!=-1){
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							queryB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							queryB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
					}
					if(item.menName.indexOf("新增")!=-1){
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							addB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							addB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
					}
					if(item.menName.indexOf("修改")!=-1){
						$("#barDemo").append('<a class="layui-btn layui-btn-xs" lay-event="edit">保存编辑</a>');
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							updateB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							updateB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
						
					}
					if(item.menName.indexOf("删除")!=-1){
						$("#barDemo").append('<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除信息</a>');
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							deleteB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							deleteB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
					}
					
				});
				if(queryB!=''){
					$("#button_ID").append(queryB);
				}
				if(addB!=''){
					$("#button_ID").append(addB);
				}
				if(updateB!=''){
					$("#button_ID").append(updateB);
				}
				if(deleteB!=''){
					$("#button_ID").append(deleteB);
				}
				
			}

		},
		error : function(result) {
		}
	});
}

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