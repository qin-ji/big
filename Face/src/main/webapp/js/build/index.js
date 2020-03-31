$(function() {
	setInterval(getColor, 1000 * 0.5);
	
	
})


function getColor(){
	
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/GColor",
		success : function(result) {
			if (result.msg) {
//				$(".body").css("background-color", result.color);
//				$('#leftDome').css('background-color', result.color);
				$('#topDiv').css('background-color',result.color);
				$('.layui-nav').css('background-color', result.color);
			}
		}
	})
}



function tuile(){
	$.ajax({
		type : "post",
		url : "/tuile",
	});
}



function getMen() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/getMen",
		success : function(result) {
			if (result.error) {
				errorMsg(result.error)
			}
			if (result.success) {
				getLeftMen(result.menList)
			}

		},
		error : function(result) {
			errorMsg(result.error)
		}
	});
	
	
	
}

function getLeftMen(data) {
	var resultStr="" ;
	var liStr="";
	$.each(data, function(i, item) {
		if (item.parentId == 0) {
			liStr="<li class='layui-nav-item' > <a href='javascript:;'  style='line-height:65px;text-alight:center;padding-bottom:13px'><i class='layui-icon "+item.menImage+"' style='font-size: 25px; color: #F5F5F5;'></i>&nbsp;"+item.menName+"</a><dl class='layui-nav-child'>";
			$.each(data, function(i, items) {
				if(items.parentId ==  item.id && items.menType=='men'){
					liStr+="<dd data-url='"+items.menUrl+"' data-title='"+items.menName+"' data-id='"+items.menId+"'" +
							" class='site-demo-active' data-type='tabAdd'  style='padding-left:13px; '>"+
							"<a href='javascript:(0);' style='line-height:50px;'><i class='layui-icon "+items.menImage+"' style='font-size: 25px; color: #F5F5F5;'></i>"+items.menName+"</a></dd>";
				}
			});
			liStr+="</dl></li>";
			resultStr+=liStr;
		}

	});
	$("#leftDome").append(resultStr);
	
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
