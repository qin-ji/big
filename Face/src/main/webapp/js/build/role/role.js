$(function() {

	getRoleButton();
	setInterval(getColor, 1000 * 0.5);
	
})





function getColor() {
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





function getRoleButton() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/role/getRoleButton",
		success : function(result) {
			if (result.error) {
				errorMsg(result.error)
			}
			if (result.success) {
				var queryB ='';
				var addB ='';
				var updateB ='';
				var deleteB ='';
				var qitaB ='';
				$.each(result.roleButtonList, function(i, item) {
					var isTrue = true;
					if(item.menName.indexOf("查询")!=-1){
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							queryB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							queryB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
						isTrue = false;
					}
					if(item.menName.indexOf("新增")!=-1){
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							addB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							addB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
						isTrue = false;
					}
					if(item.menName.indexOf("修改")!=-1){
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							updateB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							updateB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
						isTrue = false;
					}
					if(item.menName.indexOf("删除")!=-1){
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							deleteB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							deleteB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
						}
						isTrue = false;
					}
					if(isTrue){
						if(item.menButtonImage!=undefined && item.menButtonImage!=''){
							qitaB ='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menButtonImage+item.menName+'</button>';
						}else{
							qitaB='<button class="'+item.menButtonStyle+'" data-url="'+item.menButtonUrl+'">'+item.menName+'</button>';
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
				if(qitaB!=''){
					$("#button_ID").append(qitaB);
				}
				
			}

		},
		error : function(result) {
			errorMsg(result.error)
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
/**
 * 添加需求紧急度标签点击事件
 */
function choosePriorityLevel(data){
	var levelClass=$(data).attr("class");
	if(levelClass!="btn-info"){
		$(".requiredLevelOption button").attr("class","btn-default");
		$(data).attr("class","btn-info");
		//修改值
		$("#priorityLevel").val(data.value);
	}
}

