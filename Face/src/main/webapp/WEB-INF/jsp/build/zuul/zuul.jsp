<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@include file="../../../../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../../../js/build/zuul/zuul.js" charset="utf-8"></script>
<!-- 	 <link rel="stylesheet" href="../../../../layui/css/layui.css"> -->
<style>
.layui-form-item {
	margin-top: 13px;
	margin-left: -40px;
}

.layui-input {
	width: 150px;
}

.layui-inline {
	line-height: 15px
}

.huakuai {
	margin: 20px 20px;
}

.layui-form-label {
	color: #EE7942;
}

#imgg {
	position: relative;
	top: -180px;
	left: 110px;
}

#demo {
	text-align: cneter;
}
/* #test10{ */
/* 	width:300px; */
/* 	height:150px; */
/* 	border:2px solid red ; */
/* } */
#selectBox {
	position: absolute;
	top: 40px;
	width: 300px;
	height: 300px;
	background-color: #F0F8FF;
	z-index: 99999;
	overflow-y: auto;
	/* 	opacity: 0.6; */
}

#ul_qj {
	list-style: none;
}

li {
	padding-bottom: 2px;
	margin-top: 1px;
	margin-bottom: 1px;
	color: #000;
}
</style>
</head>



<body class="body">
	<fieldset class="layui-elem-field site-demo-button">
		<legend style="color: #EE7942;">用户管理</legend>
		</br>
		<div id="button_ID">
			<!-- 			<button class="layui-btn layui-btn-radius" data-url="/role/queryRole">查询角色</button> -->

			<!-- 			<button class="layui-btn layui-btn-normal layui-btn-radius">新增用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-warm layui-btn-radius">修改用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-danger layui-btn-radius">删除用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-radius layui-btn-primary">权限管理</button> -->
		</div>
		<div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">角色ID</label>
					<div class="layui-input-inline">
						<input type="text" name="roleID" id="roleID" class="layui-input">
					</div>
					<label class="layui-form-label" style="margin-left:-85px">角色名</label>
					<div class="layui-input-inline" style="margin-left:-12px">
						<input type="text" name="roleName" id="roleName"
							class="layui-input">
					</div>
				</div>


			</div>

		</div>

		<div id="sliderDemo" class="huakuai"></div>

	</fieldset>

	<!-- 修改信息 -->
	<div
		style=" height: 280px; display: none; padding: 50px; line-height: 52px; background-color: #AEEEEE; color: #EE7942; font-weight: 300;"
		id="updateAndAddInfo">

		<form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">ID</label>
					<div class="layui-input-inline">
						<input type="text" id="id_S" name="id_S" class="layui-input"
							style="width:250px">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">ServiceId</label>
					<div class="layui-input-inline">
						<input type="text" id="ServiceId" name="ServiceId"
							class="layui-input" style="width:250px">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">Path</label>
					<div class="layui-input-inline">
						<input type="text" id="Path" name="Path" class="layui-input"
							style="width:250px">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">URL</label>
					<div class="layui-input-inline">
						<input type="text" id="URL" name="URL" class="layui-input"
							style="width:250px">
					</div>
				</div>

			</div>



		</form>
	</div>




	<!-- /修改信息 -->
	<!-- start :表格数据 -->
	<table class="layui-hide" id="demo" lay-filter="test"></table>
	<script>
	
	
	
		layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'form' ], function() {
			var laydate = layui.laydate, //日期
				laypage = layui.laypage, //分页
				layer = layui.layer, //弹层
				table = layui.table, //表格
				carousel = layui.carousel, //轮播
				upload = layui.upload, //上传
				element = layui.element, //元素操作
				slider = layui.slider, //滑块
				$ = layui.$,
				form = layui.form;
	
			var click_qj;
			// 			layui.selMeltiple(layui.$);
	
	
	
			//执行一个 table 实例
			var tableIns = table.render({
				elem : '#demo',
				method : 'get',
				height : 600,
				url : '/zuul/queryZuul', //数据接口
				title : '路由表',
				page : true, //开启分页
				toolbar : 'default', //开验证启工具栏，此处显示默认图标，可以自定义模板，详见文档
				loading : true,
				toolbar : true,
				limit : 10,
				limits : [ 10, 30, 50 ],
				even : true,
				request : {
					pageName : 'indexPage', //页码的参数名称，默认：page
					limitName : 'pageSize' //每页数据量的参数名，默认：limit
				},
				response : {
					statusName : 'status', //规定数据状态的字段名称，默认：code
					statusCode : 200, //规定成功的状态码，默认：0
					msgName : 'msg', //规定状态信息的字段名称，默认：msg
					countName : 'total', //规定数据总数的字段名称，默认：count
					dataName : 'data' //规定数据列表的字段名称，默认：data
				},
				cols : [
					[ {
						type : 'checkbox',
						fixed : 'left'
					}
						, {
							field : 'id',
							title : 'ID',
							align : 'center',
							width : 140,
							sort : true,
							fixed : 'left'
						}
						, {
							field : 'serviceId',
							title : 'ServiceId',
							align : 'center',
							width : 300
						}
						, {
							field : 'path',
							title : 'Path',
							align : 'center',
							width : 260
						}, {
							field : 'url',
							title : 'URL',
							align : 'center',
							width : 900
						}
					]
				],
				done : function(res, curr, count) {
					var size = $(".layui-laypage-limits").find("option:selected").val();
					if (size == '' || size == null) {
						size = 10;
					}
	
					var end = 1;
					if (count % size == 0) {
						end = count / size;
					} else {
						end = count / size + 1;
					}
					slider.render({
						elem : '#sliderDemo',
						theme : '#5FB878',
						step : 1, //步长
						max : end,
						disabled : true,
						value : curr,
						min : 1,
						showstep : true, //开启间隔点
						change : function(value) {
							// 							if (value != curr && value != NaN) {
							// 								queryRole("/role/queryRole", value);
							// 							}
						}
					});
	
				}
			});
	
	
			$(".layui-btn-radius").click(function() {
	
				var checkStatus = table.checkStatus('demo'),
					data = checkStatus.data;
	
				var url = $(this).attr("data-url");
	
				if (url.indexOf('query') > 0) {
					// 					queryZuul(url, 1); //查询
				} else if (url.indexOf('add') > 0) {
					addZuul(url);
				} else if (url.indexOf('update') > 0) {
					if (data.length == 0) {
						layer.msg('请选择一行数据修改');
					} else if (data.length > 1) {
						layer.msg('只能修改一行数据');
					} else if (data.length == 1) {
	
						updateAddInfo(data);
						updateZuul(url);
	
					}
				} else if (url.indexOf('delete') > 0) {
					if (data.length == 0) {
						layer.msg('请选择一行数据删除');
					} else if (data.length > 0) {
						layer.confirm('真的删除选中的：' + data.length + '行数据么？', function(index) {
							var ids = "";
							var roleIDs = "";
							for (var i = 0; i < data.length; i++) {
								if (ids == "") {
									ids = data[i].id;
								} else {
									ids += "," + data[i].id;
								}
	
								if (roleIDs == "") {
									roleIDs = data[i].roleId;
								} else {
									roleIDs += "," + data[i].roleId;
								}
							}
	
							$.ajax({
								type : "post",
								data : {
									"ids" : ids,
								},
								url : url,
								dataType : "json",
								success : function(result) {
									if (result.success) {
										successMsg(result.success);
										tableIns.reload();
									}
									if (result.error) {
										errorMsg(result.error)
									}
									layer.close(index); //如果设定了yes回调，需进行手工关闭
								},
								error : function(result) {
									errorMsg(result.error)
									layer.close(index); //如果设定了yes回调，需进行手工关闭
								}
							});
							// 							queryZuul('/role/queryRole'); //查询
	
						});
					}
	
				}
	
			})
	
	
			function updateAddInfo(data) {
				$("#ServiceId").val(data[0].serviceId);
				$("#Path").val(data[0].path);
				$("#URL").val(data[0].url);
				$("#id_S").val(data[0].id);
				$("#id_S").attr("readonly", "true")
			}
	
			function close_updateAddInfo() {
				$("#ServiceId").val("");
				$("#Path").val("");
				$("#URL").val("");
				$("#id_S").val("");
			}
	
			function updateZuul(url) {
				layer.open({
					type : 1,
					title : '路由信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '430px' ],
					shade : 0.3,
					anim : 1,
					scrollbar : false,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '修改', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
						var ServiceId = $("#ServiceId").val();
						var Path = $("#Path").val();
						var URL = $("#URL").val();
						var id = $("#id_S").val();
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"ServiceId" : ServiceId,
								"Path" : Path,
								"URL" : URL,
								"id" : id
							},
							url : url,
							success : function(result) {
								if (result.success) {
									successMsg(result.success);
									close_updateAddInfo();
									tableIns.reload();
									layer.close(index); //如果设定了yes回调，需进行手工关闭
								}
	
							},
							error : function(result) {
								errorMsg(result.error)
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							}
						});
	
	
					},
					end : function() {
						close_updateAddInfo();
					}
				});
			}
	
	
			function addZuul(url) {
				close_updateAddInfo();
				layer.open({
					type : 1,
					title : '路由信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '430px' ],
					shade : 0.3,
					anim : 1,
					scrollbar : false,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '新增', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
	
						var ServiceId = $("#ServiceId").val();
						var Path = $("#Path").val();
						var URL = $("#URL").val();
						var id = $("#id_S").val();
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"ServiceId" : ServiceId,
								"Path" : Path,
								"URL" : URL,
								"id" : id
							},
							url : url,
							success : function(result) {
								if (result.success) {
									successMsg(result.success)
									tableIns.reload();
								}
								close_updateAddInfo();
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							},
							error : function(result) {
								errorMsg(result.error)
								close_updateAddInfo();
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							// 								errorMsg(result.msg)
							}
						});
	
	
					},
					end : function() {
						close_updateAddInfo();
					}
				});
			}
	
	
		})
	</script>

</body>
</html>