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

<script src="../../../../js/build/user/user.js" charset="utf-8"></script>
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
/* #test10{ */
/* 	width:300px; */
/* 	height:150px; */
/* 	border:2px solid red ; */
/* } */
</style>
</head>



<body class="body">
	<fieldset class="layui-elem-field site-demo-button">
		<legend style="color: #EE7942;">用户管理</legend>
		</br>
		<div id="button_ID">
			<!-- 			<button class="layui-btn layui-btn-radius" data-url="/user/queryUser">查询用户</button> -->

			<!-- 			<button class="layui-btn layui-btn-normal layui-btn-radius">新增用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-warm layui-btn-radius">修改用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-danger layui-btn-radius">删除用户</button> -->
			<!-- 			<button class="layui-btn layui-btn-radius layui-btn-primary">权限管理</button> -->
		</div>
		<div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline">
						<input type="text" name="username" id="username"
							class="layui-input">
					</div>
					<label class="layui-form-label" style="margin-left:-85px">电话</label>
					<div class="layui-input-inline" style="margin-left:-12px">
						<input type="text" name="phone" id="phone" class="layui-input">
					</div>
					<label class="layui-form-label" style="margin-left:-75px">创建时间</label>
					<div class="layui-input-inline" style="margin-left:-10px">
						<input type="text" class="layui-input" id="date_D"
							placeholder=" - ">
					</div>
				</div>

			</div>

		</div>

		<div id="sliderDemo" class="huakuai"></div>

	</fieldset>

	<!-- 修改信息 -->
	<div
		style=" height: 490px; display: none; padding: 50px; line-height: 52px; background-color: #AEEEEE; color: #EE7942; font-weight: 300;"
		id="updateAndAddInfo">

		<form class="layui-form" action="">
			<input type="hidden" id="id_S" />
			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline">
						<input type="text" id="username_S" name="username"
							class="layui-input" style="width:250px">
					</div>
				</div>


				<div class="layui-inline">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-inline">
						<input type="text" id="password_S" name="password"
							class="layui-input" style="width:250px">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">手机</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" id="phone_S"
							lay-verify="required|phone" autocomplete="off"
							class="layui-input" style="width:250px">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline">
						<input type="text" name="email" id="email_S" lay-verify="email"
							autocomplete="off" class="layui-input" style="width:250px">
					</div>
				</div>

				<div class="layui-form-item" style="margin-left:3px">
					<label class="layui-form-label">角色</label>
					<div class="layui-input-block" id="roleName"></div>
				</div>

				<div class="layui-form-item" style="margin-left:3px">
					<label class="layui-form-label">上传帅照：</label>
					<div class="layui-upload-drag" id="test10">
						<i class="layui-icon"></i>
						<p class="qj_upload">点击上传，或将文件拖拽到此处</p>

					</div>
					<img src="" id="imgg" height="180px" width="258.5px" />
				</div>

			</div>
		</form>
	</div>




	<!-- /修改信息 -->

	<!-- start :表格数据 -->
	<table class="layui-hide" id="demo" lay-filter="test"></table>
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
	
			upload.render({
				elem : '#test10',
				accept : 'images',
				url : '/user/upload/img',
				done : function(res) {
					$("#imgg").show();
					$("#imgg").attr("src", "../../../../Uploads/" + res.data.src)
				}
			});
	
			//日期范围
			laydate.render({
				elem : '#date_D',
				range : true
			});
	
			//执行一个 table 实例
			var tableIns = table.render({
				elem : '#demo',
				method : 'get',
				height : 600,
				url : '/user/queryUser', //数据接口
				title : '用户表',
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
							fixed : 'left',
						}
						, {
							field : 'username',
							title : '用户名',
							align : 'center',
							width : 140,
							edit : 'text'
						}
						, {
							field : 'roleName',
							title : '角色',
							align : 'center',
							width : 260,
						}
						, {
							field : 'phone',
							title : '电话',
							align : 'center',
							width : 180,
							edit : 'text'
						}
						, {
							field : 'email',
							title : '邮箱',
							align : 'center',
							width : 180,
							edit : 'text'
						}, {
							field : 'img_url',
							title : '用户头像',
							align : 'center',
							width : 180,
						}
						, {
							field : 'created',
							title : '创建时间',
							align : 'center',
							width : 180,
							sort : true,
							templet : function(data) {
								return createTime(data.created);
							}
						}
						, {
							field : 'updated',
							title : '最后修改时间',
							align : 'center',
							width : 180,
							templet : function(data) {
								return createTime(data.updated);
							}
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
					getRole();
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
						value : curr,
						min : 1,
						disabled: true,
						showstep : true, //开启间隔点
						change : function(value) {
// 							if (value != curr && value != NaN) {
// 								queryUser("/user/queryUser", value);
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
					queryUser(url, 1); //查询
				} else if (url.indexOf('add') > 0) {
					addUser(url);
				} else if (url.indexOf('update') > 0) {
					if (data.length == 0) {
						layer.msg('请选择一行数据修改');
					} else if (data.length > 1) {
						layer.msg('只能修改一行数据');
					} else if (data.length == 1) {
	
						updateAddInfo(data);
						updateUser(url);
	
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
							queryUser('/user/queryUser'); //查询
	
							layer.close(index);
						});
					}
	
				} else if (url.indexOf('power') > 0) {
					if (data.length == 0) {
						layer.msg('请选择一行数据赋权');
					} else if (data.length > 0) {
						layer.msg('权限操作');
					}
				}
	
	
			})
	
			function updateAddInfo(data) {
				$("#id_S").val(data[0].id);
				$("#username_S").val(data[0].username);
	
				$("#phone_S").val(data[0].phone);
				$("#email_S").val(data[0].email);
	
				if (data[0].roleName != null) {
					var rolename = [];
					if (data[0].roleName.indexOf(",") != -1) {
						rolename = data[0].roleName.split(",");
					} else {
						rolename[0] = data[0].roleName;
					}
	
					var roleCheckbox = $("input[name='roleChecks']");
	
					for (var j = 0; j < rolename.length; j++) {
						for (var i = 0; i < roleCheckbox.length; i++) {
							if (roleCheckbox[i].title == rolename[j]) {
								roleCheckbox[i].checked = true;
							}
						}
	
					}
	
					form.render('checkbox');
					$("#imgg").attr("src", "../../../../Uploads/" + data[0].img_url);
				}
			}
	
			function close_updateAddInfo() {
				$("#id_S").val("");
				$("#username_S").val("");
				$("#password_S").val("");
				$("#phone_S").val("");
				$("#email_S").val("");
				$("#imgg").attr("src", "");
	
				var roleCheckbox = $("input[name='roleChecks']");
				for (var i = 0; i < roleCheckbox.length; i++) {
					roleCheckbox[i].checked = false;
				}
	
			}
	
			function updateUser(url) {
				if ($("#imgg").attr("src").substr($("#imgg").attr("src").lastIndexOf("/") + 1) == undefined) {
					$("#imgg").css("display", "none")
				}
				layer.open({
					type : 1,
					title : '用户信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '700px' ],
					shade : 0.3,
					anim : 1,
					scrollbar : false,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '修改', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
						var id = $("#id_S").val();
						var username = $("#username_S").val();
						var password = $("#password_S").val();
						var phone = $("#phone_S").val();
						var email = $("#email_S").val();
						var roleName = "";
						var img_url = $("#imgg").attr("src").substring($("#imgg").attr("src").lastIndexOf("/") + 1);
	
						var roleCheckbox = $("input[name='roleChecks']");
						for (var i = 0; i < roleCheckbox.length; i++) {
							if (roleCheckbox[i].checked == true) {
								if (roleName == "") {
									roleName = roleCheckbox[i].title;
								} else {
									roleName += "," + roleCheckbox[i].title;
								}
							}
						}
	
	
	
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"id" : id,
								"username" : username,
								"password" : password,
								"email" : email,
								"phone" : phone,
								"roleName" : roleName,
								"img_url" : img_url
							},
							url : url,
							success : function(result) {
								if (result.msg) {
									successMsg(result.msg)
									tableIns.reload();
								}
	
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							},
							error : function(result) {
	
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							// errorMsg(result.msg)
							}
						});
	
	
					},
					end : function() {
						close_updateAddInfo();
					}
				});
			}
	
	
			function addUser(url) {
				if ($("#imgg").attr("src").substr($("#imgg").attr("src").lastIndexOf("/") + 1) == undefined
					|| $("#imgg").attr("src").substr($("#imgg").attr("src").lastIndexOf("/") + 1) == '') {
	
					$("#imgg").css("display", "none")
				}
				layer.open({
					type : 1,
					title : '用户信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '700px' ],
					shade : 0.3,
					anim : 1,
					scrollbar : false,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '新增', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
						var id = $("#id_S").val();
						var username = $("#username_S").val();
						var password = $("#password_S").val();
						var phone = $("#phone_S").val();
						var email = $("#email_S").val();
						var roleName = "";
						var roleCheckbox = $("input[name='roleChecks']");
						var img_url = $("#imgg").attr("src").substring($("#imgg").attr("src").lastIndexOf("/") + 1);
						for (var i = 0; i < roleCheckbox.length; i++) {
							if (roleCheckbox[i].checked == true) {
								if (roleName == "") {
									roleName = roleCheckbox[i].title;
								} else {
									roleName += "," + roleCheckbox[i].title;
								}
							}
						}
	
	
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"id" : id,
								"username" : username,
								"password" : password,
								"email" : email,
								"phone" : phone,
								"roleName" : roleName,
								"img_url" : img_url
							},
							url : url,
							success : function(result) {
								if (result.msg) {
									successMsg(result.msg)
									tableIns.reload();
								}
	
								layer.close(index); //如果设定了yes回调，需进行手工关闭
							},
							error : function(result) {
	
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
	
	
	
			function queryUser(url, index) {
				var username = $("#username").val();
				var phone = $("#phone").val();
				var date_D = $("#date_D").val();
				var size = $(".layui-laypage-limits").find("option:selected").val();
				if (size == '' || size == null) {
					size = 10;
				}
	
				//执行一个 table 实例
				table.render({
					elem : '#demo',
					method : 'get',
					url : url,
					where : {
						userName : username,
						phone : phone,
						date_D : date_D,
					// 						indexPage : index
					},
					height : 600,
					title : '用户表',
					page : {
						curr : index
					},
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
								width : 140,
								sort : true,
								fixed : 'left',
							}
							, {
								field : 'username',
								title : '用户名',
								align : 'center',
								width : 140,
								edit : 'text'
							}
							, {
								field : 'roleName',
								title : '角色',
								align : 'center',
								width : 260,
							}
							, {
								field : 'phone',
								title : '电话',
								align : 'center',
								width : 180,
								edit : 'text'
							}
							, {
								field : 'email',
								title : '邮箱',
								align : 'center',
								width : 180,
								edit : 'text'
							}, {
								field : 'img_url',
								title : '用户头像',
								align : 'center',
								width : 180,
							}
							, {
								field : 'created',
								title : '创建时间',
								align : 'center',
								width : 180,
								sort : true,
								templet : function(data) {
									return createTime(data.created);
								}
							}
							, {
								field : 'updated',
								title : '最后修改时间',
								align : 'center',
								width : 180,
								templet : function(data) {
									return createTime(data.updated);
								}
							}
							, {
								title : '操作',
								algin : 'center',
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
							value : curr,
							disabled: true,
							max : end,
							min : 1,
							showstep : true, //开启间隔点
							change : function(value) {
// 								if (value != curr && value != NaN) {
// 									queryUser("/user/queryUser", value);
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
								tableIns.reload();
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
					datas.username = data.username;
					datas.phone = data.phone;
					datas.email = data.email;
					datas.roleName = data.roleName;
					datas.img_url = data.img_url;
					$.ajax({
						type : "post",
						data : datas,
						url : $(".layui-btn-warm").attr("data-url"),
						dataType : "json",
						success : function(result) {
							successMsg(result.msg)
							tableIns.reload();
						},
						error : function(result) {
							errorMsg(result.msg)
						}
					});
	
				}
			});
	
			function getRole() {
				$("#roleName").html("");
				$.ajax({
					type : "post",
					dataType : "json",
					url : "/user/getRole",
					success : function(result) {
						if (result.msg) {
							$.each(result.roleList, function(i, item) {
								$("#roleName").append('<input type="checkbox" name="roleChecks"  value="' + item.roleId + '" title="' + item.roleName + '"/>');
							});
							form.render('checkbox');
						}
					},
					error : function(result) {}
				});
			}
	
	
			$("#imgg").hover(function() {
				$(this).hide();
				$("#test10").hover(function() {
					$("#imgg").hide();
				}, function() {
					$("#imgg").show();
				})
	
			})
	
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