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


<!-- 	 <link rel="stylesheet" href="../../../../layui/css/layui.css"> -->
<style>
.layui-form-item {
	margin-top: 13px;
	margin-left: -40px;
}

.layui-input {
	width: 150px;
}

.layui-form-label {
	color: #EE7942;
}

.huakuai {
	margin: 20px 20px;
}

.site-doc-icon li {
	height: 145px;
	width: 130px;
	float: left;
	text-align: center;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 10px;
	padding-right: 10px;
}

.layui-icon-qj {
	font-size: 65px;
}
</style>
</head>



<body class="body">
	<fieldset class="layui-elem-field site-demo-button">
		<legend style="color: #EE7942;">页面管理</legend>
		</br>
		<div id="button_ID">
			<!-- 			<button class="layui-btn layui-btn-radius" data-url="/men/queryMen">查询</button> -->

			<!-- 			<button class="layui-btn layui-btn-normal layui-btn-radius">新增用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-warm layui-btn-radius">修改用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-danger layui-btn-radius">删除用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-radius layui-btn-primary">权限管理</button> -->
		</div>
		<div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">名称</label>
					<div class="layui-input-inline">
						<input type="text" name="menName" id="menName" class="layui-input">
					</div>
					<label class="layui-form-label" style="margin-left:-85px">PranetID</label>
					<div class="layui-input-inline" style="margin-left:-12px">
						<input type="text" name="pId" id="pId" class="layui-input">
					</div>
				</div>

			</div>
		</div>
		<div id="sliderDemo" class="huakuai"></div>
	</fieldset>

	<!-- 修改信息 -->
	<div
		style="height:550px; display: none; padding: 50px; line-height: 52px; background-color: #393D49; color:  #EE7942; font-weight: 300;"
		id="updateAndAddInfo">

		<form class="layui-form" lay-filter="formTests" action="">

			<input type="hidden" id="id_S" /> <input type="hidden"
				id="menId_Update" />

			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">名称</label>
					<div class="layui-input-inline">
						<input type="text" id="menOrButName" name="menOrButName"
							class="layui-input" style="width:250px">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">类型</label>
					<div class="layui-input-block">
						<input type="radio" name="type" lay-filter="erweima" value="men"
							title="菜单"> <input type="radio" name="type"
							lay-filter="erweima" value="button" title="按钮">
					</div>
				</div>
				<div class="layui-inline" style="display:none;" id="cd">
					<label class="layui-form-label">菜单图标</label>
					<div class="layui-input-inline" style="padding-top:-25px">
						<input type="text" name="menImage" id="menImage"
							class="layui-input" style="width:250px" readonly="readonly ">
					</div>
				</div>
				<div class="layui-inline" style="display:none;" id="an">
					<label class="layui-form-label">按钮样式</label>
					<div class="layui-input-inline" style="padding-top:-25px">
						<input type="text" name="buttonStyle" id="buttonStyle"
							class="layui-input" style="width:250px" readonly="readonly ">
					</div>
				</div>
				<div class="layui-inline" style="display:none;" id="anImg">
					<label class="layui-form-label">按钮图标</label>
					<div class="layui-input-inline" style="padding-top:-25px">
						<input type="text" name="buttonImg" id="buttonImg"
							class="layui-input" style="width:250px" readonly="readonly ">
					</div>
				</div>
				<div class="layui-inline" style="display:none;" id="men_URL">
					<label class="layui-form-label">页面路径</label>
					<div class="layui-input-inline">
						<input type="text" id="pageURL" name="pageURL" class="layui-input"
							style="width:250px">
					</div>
				</div>
				<div class="layui-inline" style="display:none;" id="but_URL">
					<label class="layui-form-label">按钮路径</label>
					<div class="layui-input-inline">
						<input type="text" name="buttonURL" id="buttonURL"
							class="layui-input" style="width:250px">
					</div>
				</div>


				<div class="layui-inline">
					<label class="layui-form-label">PranetID</label>
					<div class="layui-input-inline" style="width:200px">
						<select name="pranetIdSelect" id="pranetId" lay-verify="required"
							lay-search="">

						</select>
					</div>
				</div>





			</div>
		</form>
	</div>

	<!-- /修改信息 -->

	<!-- start :表格数据 -->
	<table class="layui-hide" id="demo" lay-filter="test"></table>

	<div id="menORbutton" style="display:none;"></div>

	<script src="../../../../js/build/men/men.js" charset="utf-8"></script>
	<script type="text/html" id="barDemo"></script>
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
			var indexMenOrBut;
	
	
			//执行一个 table 实例
			var tableIns = table.render({
				elem : '#demo',
				method : 'get',
				height : 600,
				url : '/men/queryMen', //数据接口
				title : '页面表',
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
							width : 100,
							sort : true,
							fixed : 'left',
						}, {
							field : 'menId',
							title : '页面/按钮	ID',
							align : 'center',
							width : 120,
						}, {
							field : 'parentId',
							title : 'ParentID',
							align : 'center',
							width : 120,
							edit : 'text',
							sort : true,
						}, {
							field : 'menName',
							title : '菜单/按钮  名',
							align : 'center',
							width : 150,
							edit : 'text'
						}, {
							field : 'menImage',
							title : '菜单图标',
							align : 'center',
							width : 110,
						}
	
						, {
							field : 'menUrl',
							title : '菜单路径',
							align : 'center',
							width : 180,
							edit : 'text'
						}
						, {
							field : 'menButtonImage',
							title : '按钮图标',
							align : 'center',
							width : 110,
						}, {
							field : 'menButtonUrl',
							title : '按钮路径',
							align : 'center',
							width : 180,
							edit : 'text'
						}, {
							field : 'menButtonStyle',
							title : '按钮样式',
							align : 'center',
							edit : 'text',
							width : 180,
						}
						, {
							field : 'menType',
							title : '类型',
							align : 'center',
							width : 180,
							edit : 'text',
						}
						, {
							title : '操作',
							align : 'center',
							fixed : 'right',
							width : 240,
							align : 'center',
							toolbar : '#barDemo'
						}
					]
				],
				done : function(res, curr, count) {
					btnMode();
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
						disabled: true,
						value : curr,
						min : 1,
						showstep : true, //开启间隔点
						change : function(value) {
// 							if (value != curr && value != NaN) {
// 								successMsg(value)
// 								queryMen("/men/queryMen", value);
// 							}
						}
					});
	
				}
			});
	
			function btnMode() {
				$(".layui-btn-radius").click(function() {
	
					var checkStatus = table.checkStatus('demo'),
						data = checkStatus.data;
	
					var url = $(this).attr("data-url");
	
					if (url.indexOf('query') > 0) {
						queryMen(url, 1); //查询
					} else if (url.indexOf('add') > 0) {
						addMen(url);
					} else if (url.indexOf('update') > 0) {
						if (data.length == 0) {
							layer.msg('请选择一行数据修改');
						} else if (data.length > 1) {
							layer.msg('只能修改一行数据');
						} else if (data.length == 1) {
							updateAddInfo(data);
							updateMen(url);
						}
					} else if (url.indexOf('delete') > 0) {
						if (data.length == 0) {
							layer.msg('请选择一行数据删除');
						} else if (data.length > 0) {
							layer.confirm('真的删除选中的：' + data.length + '行数据么？', function(index) {
								var ids = "";
								for (var i = 0; i < data.length; i++) {
	
									if (ids == "") {
										ids = data[i].id;
									} else {
										ids += "," + data[i].id;
									}
								}
	
								$.ajax({
									type : "post",
									data : {
										"ids" : ids
									},
									url : $(".layui-btn-danger").attr("data-url"),
									dataType : "json"
								});
								tableIns.reload();
								layer.close(index);
							});
						}
	
					}
	
	
				})
			}
			function updateAddInfo(data) {
				$("#id_S").val(data[0].id);
				$("#menOrButName").val(data[0].menName);
				$("#buttonImg").val(data[0].menButtonImage);
				$("#menOrButName").val(data[0].menName);
				$("#menImage").val(data[0].menImage);
				$("#buttonStyle").val(data[0].menButtonStyle);
				$("#buttonURL").val(data[0].menButtonUrl);
				$("#pageURL").val(data[0].menUrl);
				$("#menId_Update").val(data[0].menId);
				var type = data[0].menType;
	
				if (type == 'button') {
					butOrMen("men", data[0].parentId)
					$("#an").show();
					$("#anImg").show();
					$("#but_URL").show();
					$("#cd").hide();
					$("#men_URL").hide();
					form.val("formTests", {
						"type" : "button", // "name": "value"
					})
	
	
					getButAll();
				} else {
					butOrMen("menu bar", data[0].parentId);
					$("#an").hide();
					$("#anImg").hide();
					$("#but_URL").hide();
					$("#cd").show();
					$("#men_URL").show();
					form.val("formTests", {
						"type" : "men", // "name": "value"
					})
	
					getImgAll();
				}
	
			}
	
			function close_updateAddInfo() {
				$("#id_S").val("");
				$("#menOrButName").val("");
				$("#menImage").val("");
				$("#buttonStyle").val("");
				$("#pageURL").val("");
				$("#buttonURL").val("");
				$("#buttonImg").val("");
				$("#pranetId").val("");
				$("#menId_Update").val("");
				 $("input[name='type']:checked").prop('checked', false);
				form.render('radio', 'formTests');
	
			}
	
			function updateMen(url) {
				layer.open({
					type : 1,
					title : '页面信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '650px' ],
					shade : 0.3,
					anim : 1,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '修改', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
						var id = $("#id_S").val();
						var type = $("input[name='type']:checked").val(); //类型   men 页面  button 按钮
						var menName = $("#menOrButName").val(); //名称
						var butImage = $("#buttonImg").val();
						var menImage = $("#menImage").val(); //菜单图标
						var buttonStyle = 'layui-btn ' + $("#buttonStyle").val(); //按钮样式
						var pageURL = $("#pageURL").val(); //页面路径
						var buttonURL = $("#buttonURL").val(); //按钮路径
						var menButtonImage = $("#buttonImg").val(); //按钮图标
						var pranetId = $("#pranetId").val();
						var menId = $("#menId_Update").val();
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"id" : id,
								"menName" : menName,
								"menImage" : menImage,
								"buttonStyle" : buttonStyle,
								"butImage" : butImage,
								"pageURL" : pageURL,
								"buttonURL" : buttonURL,
								"pranetId" : pranetId,
								"type" : type,
								"menButtonImage" : menButtonImage,
								"menId" : menId
							},
							url : url,
							success : function(result) {
								if (result.error) {
									errorMsg(result.error)
								}
								if (result.success) {
									successMsg(result.success)
								}
								layer.close(index); //如果设定了yes回调，需进行手工关闭
								layer.close(indexMenOrBut);
								indexMenOrBut = '';
								tableIns.reload();
								close_updateAddInfo();
// 								getMenButton(); //如果当前页按钮改变 ，当即刷新
								btnMode();
							},
							error : function(result) {
								layer.close(index); //如果设定了yes回调，需进行手工关闭
								layer.close(indexMenOrBut);
								indexMenOrBut = '';
								errorMsg(result.error)
								close_updateAddInfo();
							}
						});
	
	
					},
					btn2 : function(index, layero) {
						layer.close(index); //如果设定了yes回调，需进行手工关闭
						layer.close(indexMenOrBut);
						indexMenOrBut = '';
						close_updateAddInfo();
	
					}
				});
	
				if (indexMenOrBut == '' || indexMenOrBut == null) {
					indexMenOrBut = layer.open({
						type : 1,
						offset : 'r',
						title : '请选择图标或者按钮~',
						closeBtn : false,
						area : [ '490px', '650px' ],
						shade : 0,
						anim : 1,
						id : 'LAY_menORbutton', //设定一个id，防止重复弹出
						moveType : 1, //拖拽模式，0或者1
						content : $('#menORbutton')
					});
				}
			}
	
	
			function addMen(url) {
				layer.open({
					type : 1,
					title : '页面信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '650px' ],
					shade : 0.3,
					anim : 1,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '新增', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
						var type = $("input[name='type']:checked").val(); //类型   men 页面  button 按钮
						var menName = $("#menOrButName").val(); //名称
						var butImage = $("#buttonImg").val();
						var menImage = $("#menImage").val(); //菜单图标
						var buttonStyle = 'layui-btn ' + $("#buttonStyle").val(); //按钮样式
						var pageURL = $("#pageURL").val(); //页面路径
						var buttonURL = $("#buttonURL").val(); //按钮路径
						var pranetId = $("#pranetId").val();
						var menButtonImage = $("#buttonImg").val(); //按钮图标
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"menName" : menName,
								"menImage" : menImage,
								"buttonStyle" : buttonStyle,
								"butImage" : butImage,
								"pageURL" : pageURL,
								"buttonURL" : buttonURL,
								"pranetId" : pranetId,
								"type" : type,
								"menButtonImage" : menButtonImage
							},
							url : url,
							success : function(result) {
								if (result.error) {
									errorMsg(result.error)
								}
								if (result.success) {
									successMsg(result.success)
								}
								layer.close(index); //如果设定了yes回调，需进行手工关闭
								layer.close(indexMenOrBut);
								indexMenOrBut = '';
								tableIns.reload();
								close_updateAddInfo();
							},
							error : function(result) {
								layer.close(index); //如果设定了yes回调，需进行手工关闭
								layer.close(indexMenOrBut);
								indexMenOrBut = '';
								errorMsg(result.error)
								close_updateAddInfo();
// 								getMenButton(); //如果当前页按钮改变 ，当即刷新
							}
						});
	
	
					},
					btn2 : function(index, layero) {
						layer.close(index); //如果设定了yes回调，需进行手工关闭
						layer.close(indexMenOrBut);
						indexMenOrBut = '';
						close_updateAddInfo();
					}
				});
			}
	
	
	
			function queryMen(url, index) {
				var menName = $("#menName").val();
				var pId = $("#pId").val();
				var size = $(".layui-laypage-limits").find("option:selected").val();
				if (size == '' || size == null) {
					size = 10;
				}
	
	
				//执行一个 table 实例
				table.render({
					elem : '#demo',
					method : 'get',
					height : 600,
					url : url,
					where : {
						menName : menName,
						pId : pId
					// 						indexPage : index
					},
					title : '用户表',
					page : true, //开启分页
					toolbar : 'default', //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
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
								width : 100,
								sort : true,
								fixed : 'left',
							}, {
								field : 'menId',
								title : '页面/按钮	ID',
								align : 'center',
								width : 120,
							}, {
								field : 'parentId',
								title : 'ParentID',
								align : 'center',
								width : 120,
								edit : 'text',
								sort : true,
							}, {
								field : 'menName',
								title : '菜单/按钮  名',
								align : 'center',
								width : 150,
								edit : 'text'
							}, {
								field : 'menImage',
								title : '菜单图标',
								align : 'center',
								width : 110,
							}
	
							, {
								field : 'menUrl',
								title : '菜单路径',
								align : 'center',
								width : 180,
								edit : 'text'
							}
							, {
								field : 'menButtonImage',
								title : '按钮图标',
								align : 'center',
								width : 110,
							}, {
								field : 'menButtonUrl',
								title : '按钮路径',
								align : 'center',
								width : 180,
								edit : 'text'
							}, {
								field : 'menButtonStyle',
								title : '按钮样式',
								align : 'center',
								edit : 'text',
								width : 180,
							}
							, {
								field : 'menType',
								title : '类型',
								align : 'center',
								width : 180,
								edit : 'text',
							}
							, {
								title : '操作',
								align : 'center',
								fixed : 'right',
								width : 240,
								align : 'center',
								toolbar : '#barDemo'
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
							disabled: true,
							value : curr,
							min : 1,
							showstep : true, //开启间隔点
							change : function(value) {
// 								if (value != curr && value != NaN) {
// 									queryMen("/men/queryMen", value);
// 								}
							}
						});
	
					}
				});
	
			}
	
	
			//监听行工具事件
			table.on('tool(test)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
				var data = obj.data, //获得当前行数据
					layEvent = obj.event; //获得 lay-event 对应的值
				if (layEvent === 'del') {
					layer.confirm('真的删除么', function(index) {
						obj.del(); //删除对应行（tr）的DOM结构
						$.ajax({
							type : "post",
							data : {
								"ids" : data.id
							},
							url : $(".layui-btn-danger").attr("data-url"),
							dataType : "json",
							success : function(result) {
								successMsg(result.msg)
							},
							error : function(result) {
								errorMsg(result.msg)
							}
						});
						layer.close(index);
					});
				} else if (layEvent === 'edit') {
					var datas = {};
					datas.id = data.id;
					datas.type = data.menType;
					datas.menName = data.menName;
					datas.butImage = data.menButtonImage;
					datas.menImage = data.menImage;
					datas.buttonStyle = data.menButtonStyle;
					datas.pageURL = data.menUrl;
					datas.buttonURL = data.menButtonUrl;
					datas.menButtonImage = data.menButtonImage;
					datas.pranetId = data.parentId;
	
					$.ajax({
						type : "post",
						data : datas,
						url : $(".layui-btn-warm").attr("data-url"),
						dataType : "json",
						success : function(result) {
							successMsg(result.success)
						},
						error : function(result) {
							errorMsg(result.error)
						}
					});
	
				}
			});
	
			var but_style;
			form.on('radio(erweima)', function(data) {
				$('#menORbutton').html("");
	
				if (indexMenOrBut == '' || indexMenOrBut == null) {
					indexMenOrBut = layer.open({
						type : 1,
						offset : 'r',
						title : '请选择图标或者按钮~',
						closeBtn : false,
						area : [ '490px', '650px' ],
						shade : 0,
						anim : 1,
						id : 'LAY_menORbutton', //设定一个id，防止重复弹出
						moveType : 1, //拖拽模式，0或者1
						content : $('#menORbutton')
					});
				}
	
	
				if (data.value == 'men') {
	
					butOrMen("menu bar", -1)
					$("#cd").show();
					$("#men_URL").show();
					$("#an").hide();
					$("#anImg").hide();
					$("#but_URL").hide();
	
					getImgAll();
	
	
				} else if (data.value == 'button') {
	
					butOrMen("men", -1)
					$("#an").show();
					$("#anImg").show();
					$("#but_URL").show();
					$("#cd").hide();
					$("#men_URL").hide();
	
					getButAll();
	
				}
	
	
			});
	
			//根据传递进来的类型判断是按钮还是 页面，然后查询出不同的下拉框信息
			function butOrMen(type, selected) {
				$.ajax({
					type : "post",
					data : {
						"type" : type
					},
					url : "/men/getMenOrButton",
					dataType : "json",
					success : function(result) {
						$("#pranetId").html("")
						if (result.msg) {
							var htmlStr = "<option value=''>直接选择或搜索选择</option>";
							$.each(result.menOrButtonList, function(i, item) {
								if (type == 'menu bar') {
									if (item.parentId == null || item.parentId == '') {
										if (selected == item.menId) {
											htmlStr += "<option value=" + item.menId + " selected>" + item.menName + "</option>";
										} else {
											htmlStr += "<option value=" + item.menId + " >" + item.menName + "</option>";
										}
	
									}
								} else {
									if (item.parentId == null || item.parentId == '') {
										htmlStr += "<optgroup label=" + item.menName + ">";
										$.each(result.menOrButtonList, function(i, items) {
											if (item.menId == items.parentId) {
												if (selected == items.menId) {
													htmlStr += "<option value=" + items.menId + " selected>" + items.menName + "</option>";
												} else {
													htmlStr += "<option value=" + items.menId + ">" + items.menName + "</option>";
												}
	
	
											}
										})
									}
								}
							})
							$("#pranetId").append(htmlStr)
						}
						form.render("select");
					},
					error : function(result) {
						errorMsg("获取下拉框信息失败")
					}
				});
	
			}
	
			function getImgAll() {
				$("#menORbutton").html("")
				$.ajax({
					type : "post",
					dataType : "json",
					url : '/image/getAllImage',
					success : function(result) {
	
						if (result.msg) {
							var htmlImg = '';
							$.each(result.imageList, function(i, item) {
								htmlImg += '<li><i class="layui-icon layui-icon-qj ' + item.imgUrl + '"></i>';
								htmlImg += '<div class="doc-icon-name">' + item.imgName + '</div>';
								htmlImg += '<div class="doc-icon-fontclass">' + item.imgUrl + '</div></li>';
							})
							htmlImg = '<ul class="site-doc-icon">"' + htmlImg + '</ul>';
							$("#menORbutton").append(htmlImg);
	
							$(".site-doc-icon li").hover(function() {
								$(this).css("background-color", "#99FFFF");
							}, function() {
								$(this).css("background-color", "#fff");
							});
	
							$(".site-doc-icon li").click(function() {
								$("#menImage").val($(this).find(".doc-icon-fontclass").text())
							})
						}
					},
					error : function(result) {}
				});
			}
			function getButAll() {
				$("#menORbutton").html("")
	
				$.ajax({
					type : "post",
					dataType : "json",
					url : '/button/getAllButton',
					success : function(result) {
						if (result.msg) {
							$.each(result.buttonList, function(i, item) {
								if (item.butPId == null) {
									var htmlButton = '';
									htmlButton += '<legend><a id="' + item.butClass + '">' + item.butTitle + '</legend> ';
									htmlButton += '<div class="site-text"><p>';
									$.each(result.buttonList, function(i, items) {
										if (items.butPId == item.id) {
											if (items.butTitle == 4) {
												htmlButton += '<button type="button"  style="float:left;margin-left:3px;margin-top:2px;"   class="bt_qj layui-btn" data-title="' + items.butTitle + '" data-url="' + items.butContext + '">' + items.butContext + '</button>';
											} else {
												htmlButton += '<button type="button"   style="float:left;margin-left:5px;margin-top:4px;" class="bt_qj layui-btn ' + items.butClass + '" data-title="' + items.butTitle + '" data-url="' + items.butClass + '">' + items.butContext + '</button>';
											}
										}
									})
									htmlButton += '</p></div>';
									if (item.id == 16) {
										htmlButton = '	<div class="site-title"><fieldset style="height:140px">' + htmlButton + '</fieldset></div>';
									} else {
										htmlButton = '	<div class="site-title"><fieldset style="height:100px">' + htmlButton + '</fieldset></div>';
									}
	
	
									$("#menORbutton").append(htmlButton);
								}
							})
							var htmlButton = '';
							htmlButton += '<legend><a>按扭预览</legend> ';
							htmlButton += '<div class="site-text"><p>';
							htmlButton += '<button type="button" id="buttt_b" class="layui-btn"></button>';
							htmlButton += '</p></div>';
							htmlButton = '	<div class="site-title"><fieldset style="height:60px">' + htmlButton + '</fieldset></div>';
							$("#menORbutton").append(htmlButton);
	
							var col = '';
							var size = '';
							var radius = '';
							$(".bt_qj").click(function() {
								var title = $(this).attr("data-title");
								var url = $(this).attr("data-url");
								if (title == 1) {
									col = url;
									if (url == "layui-btn-primary") {
										$("#color").text("请选择按钮颜色：原始颜色")
									} else if (url == "") {
										col = ""
										$("#color").text("请选择按钮颜色：默认颜色")
									} else if (url == "layui-btn-normal") {
										$("#color").text("请选择按钮颜色：百搭颜色")
									} else if (url == "layui-btn-warm") {
										$("#color").text("请选择按钮颜色：暖色")
									} else if (url == "layui-btn-danger") {
										$("#color").text("请选择按钮颜色：警告颜色")
									}
								}
	
								if (title == 2) {
									size = url;
									if (url == "layui-btn-lg") {
										$("#size").text("请选择按钮尺寸：大型按钮")
									} else if (url == "") {
										size = ""
										$("#size").text("请选择按钮尺寸：默认大小")
									} else if (url == "layui-btn-sm") {
										$("#size").text("请选择按钮尺寸：小型按钮")
									} else if (url == "layui-btn-xs") {
										$("#size").text("请选择按钮尺寸：迷你按钮")
									}
								}
	
								if (title == 3) {
									radius = url;
									if (url == "layui-btn-radius") {
										$("#type").text("请选择按钮是否圆角：圆角")
									} else if (url == "") {
										radius = ""
										$("#type").text("请选择是否圆角：非圆角")
									}
								}
	
								if (title == 4) {
									$("#butImg").html("请选择按钮图标：" + url)
									$("#buttonImg").val(url);
								}
								if (col != '' || size != '' || radius != '') {
									$("#buttonStyle").val(col + ' ' + size + ' ' + radius);
								} else {
									if (title != 4) {
										$("#buttonStyle").val('');
									}
								}
	
	
								$("#buttt_b").removeClass(but_style);
								$("#buttt_b").html("")
								$("#buttt_b").addClass('layui-btn ' + $("#buttonStyle").val());
								but_style = 'layui-btn ' + $("#buttonStyle").val();
								$("#buttt_b").html($("#buttonImg").val() + $("#menOrButName").val());
	
							})
	
						}
						$("#buttt_b").addClass($("#buttonStyle").val());
						but_style = $("#buttonStyle").val();
						$("#buttt_b").html($("#buttonImg").val() + $("#menOrButName").val());
					},
					error : function(result) {}
				});
			}
		})
	
	
	
		function createTime(v) {
			var date = new Date(v);
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			m = m < 10 ? '0' + m : m;
			var d = date.getDate();
			d = d < 10 ? ("0" + d) : d;
			var h = date.getHours();
			h = h < 10 ? ("0" + h) : h;
			var M = date.getMinutes();
			M = M < 10 ? ("0" + M) : M;
			var str = y + "-" + m + "-" + d + " " + h + ":" + M;
			return str;
		}
	</script>

</body>
</html>