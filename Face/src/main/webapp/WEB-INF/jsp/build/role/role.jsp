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

<script src="../../../../js/build/role/role.js" charset="utf-8"></script>
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
.requiredLevelOption button,.childRequiredTypeOption button,.childRequiredTypexOption button,.projectIdOption button{
	letter-spacing: 2px;
	margin-bottom:5px;
    border: 0px;
    min-width:80px;
        padding: 0px 10px;
    max-width:160px;
    height: 30px;
    word-break: keep-all;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.requiredLevelOption .btn-default,.childRequiredTypeOption .btn-default,.childRequiredTypexOption .btn-default,.projectIdOption .btn-default{
	background-color: #dcd9d9;
}
.btn-info{
	background-color: #02c874;
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
		style=" height: 380px; display: none; padding: 50px; line-height: 52px; background-color: #AEEEEE; color: #EE7942; font-weight: 300;"
		id="updateAndAddInfo">

		<form class="layui-form" action="">
			<input type="hidden" id="id_S" /> <input type="hidden" id="role_id" />
			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">角色名</label>
					<div class="layui-input-inline">
						<input type="text" id="roleName_S" name="roleName_S"
							class="layui-input" style="width:250px">
					</div>
				</div>

				<div class="layui-inline" style="width:300px">
					<label class="layui-form-label">PranetID</label>
					<div class="layui-input-block">
						<span id="qj_c"> <select name="pranetIdSelect"
							id="pranetId" lay-filter="pranetId" style="width:300px"
							lay-verify="required" lay-search="">
								<option>请选择权限</option>
						</select>
						</span>
						<div id="selectBox">
							<ul id="ul_qj">

							</ul>
						</div>

					</div>

				</div>
			</div>
		</form>
	</div>

<div
		style=" height:680px;width:600px; display: none; padding: 50px; line-height: 52px;  color: #EE7942; font-weight: 600;"
		id="updateAndAddInfos">

		<form class="layui-form" action="">
			<table class="layui-table">
						<colgroup>
							<col width="50">
							<col width="200">
						</colgroup>
						<thead>
							<tr>
								<th>属性名</th>
								<th>值</th>
							</tr>
						</thead>
						<tbody id="m-body">
							<tr>
								<td><label for="requiredPriorityLevel">紧急度</label></td>
								<td class="requiredLevelOption">
									<button type="button" onclick="choosePriorityLevel(this);"
										value="0" class="btn-info">特紧急</button>
									<button type="button" onclick="choosePriorityLevel(this);"
										value="1" class="btn-default">紧急</button>
									<button type="button" onclick="choosePriorityLevel(this);"
										value="2" class="btn-default">一般</button> <input
									name="required.priorityLevel" id="priorityLevel" value="0"
									type="hidden" />
								</td>
							</tr>
							<tr>
								<td>上传图片</td>
								<td>
									<div class="layui-upload-drag" id="uploadImgs">
										<i class="layui-icon"></i>
										<p>点击上传，或将文件拖拽到此处</p>
									</div>
								</td>
							</tr>
							<tr>
								<td>图片信息</td>
								<td>
									<table class="layui-table">
										<thead>
											<tr>
												<th>文件名</th>
												<th>大小</th>
												<th>预览</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="imgReview1"></tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<div style="text-align:center;width:70%;margin:0 auto"
						class="form-group">
						<div>
							<button type="button" id="saveImg" class="btn btn-default">保存</button>
						</div>
					</div>
		</form>
	</div>


	<!-- /修改信息 -->
	<!-- start :表格数据 -->
	<table class="layui-hide" id="demo" lay-filter="test"></table>


	<!-- /-->
	<div style="display: none;">
		<div id="d-dialog">
			<div class="form-div">
				<form class="form-horizontal" id="changeData" role="form">
					<table class="layui-table">
						<colgroup>
							<col width="50">
							<col width="200">
						</colgroup>
						<thead>
							<tr>
								<th>属性名</th>
								<th>值</th>
							</tr>
						</thead>
						<tbody id="m-body">
							<tr>
								<td><label for="requiredPriorityLevel">紧急度</label></td>
								<td class="requiredLevelOption">
									<button type="button" onclick="choosePriorityLevel(this);"
										value="0" class="btn-info">特紧急</button>
									<button type="button" onclick="choosePriorityLevel(this);"
										value="1" class="btn-default">紧急</button>
									<button type="button" onclick="choosePriorityLevel(this);"
										value="2" class="btn-default">一般</button> <input
									name="required.priorityLevel" id="priorityLevel" value="0"
									type="hidden" />
								</td>
							</tr>
							<tr>
								<td>上传图片</td>
								<td>
									<div class="layui-upload-drag" id="uploadImgs">
										<i class="layui-icon"></i>
										<p>点击上传，或将文件拖拽到此处</p>
									</div>
								</td>
							</tr>
							<tr>
								<td>图片信息</td>
								<td>
									<table class="layui-table">
										<thead>
											<tr>
												<th>文件名</th>
												<th>大小</th>
												<th>预览</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="imgReview1"></tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<div style="text-align:center;width:70%;margin:0 auto"
						class="form-group">
						<div>
							<button type="button" id="saveImg" class="btn btn-default">保存</button>
							<button type="button" onclick=""
								class="btn btn-default">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


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
	
			upload.render({
				elem : '#test10',
				accept : 'images',
				url : '/user/upload/img',
				done : function(res) {
					$("#imgg").show();
					$("#imgg").attr("src", "../../../../Uploads/" + res.data.src)
				}
			});
	
	
	
		var tbody  = $("#imgReview1");
		var imgPath ="";
		var picUpload = upload.render({
			  elem: "#uploadImgs"
			  ,url:  "/user/upload/imgss"
			  ,accept: 'images'
		      ,multiple: true
		      ,auto: false
		      ,acceptMime:'image/*'
		      ,number:4
	          , choose: function (obj) {
	        	  var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
	              //读取本地文件
	              obj.preview(function(index, file, result){
	                var tr = $(['<tr id="upload-'+ index +'">'
	                  ,'<td>'+ file.name +'</td>'
	                  ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
	                  ,'<td><img src="'+result+'"/></td>'
	                  ,'<td>'
	                    ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button> '
	                    ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
	                  ,'</td>'
	                ,'</tr>'].join(''));
	                
	                //单个重传
	                tr.find('.demo-reload').on('click', function(){
	                  obj.upload(index, file);
	                });
	                
	                //删除
	                tr.find('.demo-delete').on('click', function(){
	                  delete files[index]; //删除对应的文件
	                  tr.remove();
	                  picUpload.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
	                });
	                
	                tbody.append(tr);
	              });
			  }
			  ,done: function(res, index, upload){
			  	alert( res.data.src)
				  if(res.path){
					  imgPath+=res.path+";";  
				  }
			  }
			  ,allDone: function(obj){
				  var data = {};
				  data = $("#"+formId).serialize();
				  data+="&childRequired.imgPath="+imgPath;
				  ajaxRequired(data,url);
			  },error: function(e){
				  console.log(e)
			  }
			  
			}); 	
	
			$("#saveImg").on("click",function(){
				if(picUpload.config.files){
					picUpload.upload();
				}
				if(!picUpload.config.files){
					data = $("#"+formId).serialize();
					ajaxRequired(data,url);
				}
		})
	
			//执行一个 table 实例
			var tableIns = table.render({
				elem : '#demo',
				method : 'get',
				height : 600,
				url : '/role/queryRole', //数据接口
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
							field : 'roleId',
							title : '角色ID',
							align : 'center',
							width : 140,
						}
						, {
							field : 'roleName',
							title : '角色名',
							align : 'center',
							width : 260,
						}, {
							field : 'roleMen',
							title : '所拥有的权限	 MenID:MenName',
							align : 'center',
							width : 1066,
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
					queryRole(url, 1); //查询
				} else if (url.indexOf('add') > 0) {
					addRole(url);
				} else if (url.indexOf('update') > 0) {
					if (data.length == 0) {
						layer.msg('请选择一行数据修改');
					} else if (data.length > 1) {
						layer.msg('只能修改一行数据');
					} else if (data.length == 1) {
	
						updateAddInfo(data);
						updateRole(url);
	
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
									"roleIDs" : roleIDs
								},
								url : url,
								dataType : "json",
							});
							queryRole('/role/queryRole'); //查询
							layer.close(index);
						});
					}
	
				} else if (url.indexOf('cheshi') > 0) {
					opendd();
				}
	
			})
	
	
			function opendd() {
				layer.open({
					type : 1,
					title : '信息', //不显示标题栏
					closeBtn : false,
					area : [ '750px', '600px' ],
					shade : 0.3,
					anim : 1,
					scrollbar : false,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '修改', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfos'),
					yes : function(index, layero) {},
					end : function() {}
				});
			}
	
		function choosePriorityLevel(thiss){
			alert(thiss)
		}
		
			function updateAddInfo(data) {
				$("#roleName_S").val(data[0].roleName);
				$("#role_id").val(data[0].roleId);
	
			}
	
			function close_updateAddInfo() {
				$("#roleName_S").val("");
				$("#role_id").val("");
				$("#ul_qj").html("");
			}
	
			function updateRole(url) {
				butOrMen();
				layer.open({
					type : 1,
					title : '角色信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '600px' ],
					shade : 0.3,
					anim : 1,
					scrollbar : false,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '修改', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
						var arr = []; //定义一个数组用来接收多选框的值
						var roleName = $("#roleName_S").val();
						$('input[name="checkbox_qj"]:checked').each(function() { //遍历每一个名字为interest的复选框，其中选中的执行函数    
							arr.push($(this).val())   ;
						});
	
						var menId_str = arr.join(',');
						var role_id = $("#role_id").val();
	
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"roleName" : roleName,
								"menIds" : menId_str,
								"roleId" : role_id
							},
							url : url,
							success : function(result) {
								if (result.success) {
									successMsg(result.success)
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
	
	
			function addRole(url) {
				butOrMen();
	
				layer.open({
					type : 1,
					title : '角色信息', //不显示标题栏
					closeBtn : false,
					area : [ '550px', '600px' ],
					shade : 0.3,
					anim : 1,
					scrollbar : false,
					id : 'LAY_layuipro', //设定一个id，防止重复弹出
					btn : [ '新增', '返回' ],
					btnAlign : 'c',
					moveType : 1, //拖拽模式，0或者1
					content : $('#updateAndAddInfo'),
					yes : function(index, layero) {
	
						var arr = []; //定义一个数组用来接收多选框的值
						var roleName = $("#roleName_S").val();
						$('input[name="checkbox_qj"]:checked').each(function() { //遍历每一个名字为interest的复选框，其中选中的执行函数    
							arr.push($(this).val())   ;
						});
	
						var menIds_str = arr.join(',');
	
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"roleName" : roleName,
								"menIds" : menIds_str
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
			
			//这个函数用于获取指定值在数组中的索引
			function getIndex(arr, value) {
				for (var i = 0; i < arr.length; i++) {
					if (arr[i] == value) {
						return i
					}
				}
			}
	
			function queryRole(url, index) {
				var roleID = $("#roleID").val();
				var roleName = $("#roleName").val();
	
	
				//执行一个 table 实例
				table.render({
					elem : '#demo',
					method : 'get',
					url : url,
					where : {
						roleID : roleID,
						roleName : roleName,
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
						[ //表头
							{
								type : 'checkbox',
								fixed : 'left'
							}
							, {
								field : 'id',
								title : 'ID',
								width : 140,
								align : 'center',
								sort : true,
								fixed : 'left',
							}
							, {
								field : 'roleId',
								title : '角色ID',
								align : 'center',
								width : 140,
							}
							, {
								field : 'roleName',
								title : '角色名',
								align : 'center',
								width : 260,
							}, {
								field : 'roleMen',
								title : '所拥有的权限',
								align : 'center',
								width : 1066,
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
							disabled : true,
							max : end,
							min : 1,
							showstep : true, //开启间隔点
							change : function(value) {
								// 								if (value != curr && value != NaN) {
								// 									queryRole("/role/queryRole", value);
								// 								}
							}
						});
	
					}
				});
	
			}
	
	
			//根据传递进来的类型判断是按钮还是 页面，然后查询出不同的下拉框信息
			function butOrMen() {
				$('#qj_c').unbind('click', click_qj);
				//初始化让下拉列表不显示
				$('#selectBox').hide();
				//单击下拉列表时显示/隐藏下拉列表
				$("#qj_c").click(click_qj = function() {
					$('#selectBox').toggle();
				})
	
	
				$.ajax({
					type : "post",
					data : {
						"type" : "men"
					},
					url : "/men/getMenOrButton",
					dataType : "json",
					success : function(result) {
						$("#ul_qj").html("")
						if (result.msg) {
							var htmlStr = "";
							$.each(result.menOrButtonList, function(i, item) {
								if (item.parentId == null || item.parentId == 0) {
									htmlStr += "<li>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='checkbox_qj' data-id='" + item.menId + "' data-title='-99'   value='" + item.menId + "'>->" + item.menName + "(主菜单)</li>"
									$.each(result.menOrButtonList, function(i, items) {
										if (items.parentId == item.menId) {
											htmlStr += "<li>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='checkbox_qj'  data-id='" + items.menId + "' data-title='" + items.parentId + "'  value='" + items.menId + "'>->->" + items.menName + "(子菜单)</li>"
											$.each(result.menOrButtonList, function(i, itemss) {
												if (itemss.parentId == items.menId) {
													htmlStr += "<li>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='checkbox_qj'  data-id='-99'  data-title='" + itemss.parentId + "'  value='" + itemss.menId + "'>->->->" + itemss.menName + "(按钮)</li>"
												}
											})
										}
									})
	
								}
							})
							$("#ul_qj").append(htmlStr)
						}
						form.render("checkbox");
						$("li").click(function() {
	
							var isTrue_qj = $(this).find("input[type='checkbox']").is(":checked");
							if (!isTrue_qj) {
								$(this).find("input[type='checkbox']").prop("checked", true);
								$(this).css("background-color", "#00CD66");
							} else {
								$(this).find("input[type='checkbox']").prop("checked", false);
								$(this).css("background-color", "#F0F8FF");
							}
	
							var data_id = $(this).find("input[type='checkbox']").attr("data-id");
							var data_title = $(this).find("input[type='checkbox']").attr("data-title");
							if (data_id != -99) {
								$('input[name="checkbox_qj"]').each(function() { //遍历每一个名字为interest的复选框，其中选中的执行函数    
									var che = $(this);
									if ($(this).attr("data-title") != -99) {
										if ($(this).attr("data-title") == data_id) {
											$(this).prop("checked", !isTrue_qj);
											if (!isTrue_qj) {
												$(this).parent().css("background-color", "#00CD66");
											} else {
												$(this).parent().css("background-color", "#F0F8FF");
											}
											$('input[name="checkbox_qj"]').each(function() { //遍历每一个名字为interest的复选框，其中选中的执行函数   
												if ($(this).attr("data-title") != -99) {
													if ($(this).attr("data-title") == che.attr("data-id")) {
														$(this).prop("checked", !isTrue_qj);
														if (!isTrue_qj) {
															$(this).parent().css("background-color", "#00CD66");
														} else {
															$(this).parent().css("background-color", "#F0F8FF");
														}
													}
												}
											})
										}
									}
								});
							}
	
							form.render("checkbox");
	
						})
	
	
					},
					error : function(result) {
						errorMsg("获取下拉框信息失败")
					}
				});
	
	
			}
	
		})
	</script>

</body>
</html>