<%@page import="com.qj.face.entity.MenEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String name = (String) request.getAttribute("username");
		String userimage = (String) request.getAttribute("userimage");
%>
<%@include file="../../../../common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>-阿胖首页-</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="styles.css">
<style>
#topDiv {
	width: 100%;
	height: 80px;
	background-color: rgba(0, 0, 0, 0.9);
	position: fixed;
	z-index: 999997;
	top: 0px;
	border-top: 1px solid red
}

#leftDome {
	float: left;
	height: 92%;
	position: fixed;
	z-index: 999996;
	top: 8%
}

.titleCla {
	float: left;
	height: 10%;
	width: 14%;
	font-size: 45px;
	color: white;
	font-style: oblique;
	text-align: center;
	position: fixed;
	z-index: 999999;
	border-top: 1px solid red
}

.titleUserName {
	margin-left: 78%;
	
	height: 20%;
	width: 19%;
	font-size: 25px;
	color: white;
	font-style: oblique;
	text-align: center;
	position: fixed;
	z-index: 999998;
}

#contentDiv {
	float: right;
	width: 85.5%;
	height: 20%;
	position: fixed;
	top: 80px;
	left: 225px;
	color: #EE7942;
}

.layui-col-md9 {
	position: relative;
	top: -300px;
	left: 605px;
}

.layui-col-md12 {
	position: relative;
	top: -270px;
	left: 5px;
}

.rightmenu {
	border: 2px dashed rgba(0, 0, 0, 0.3);
}

.closethis {
	border-bottom: 2px dashed rgba(0, 0, 0, 0.3);
}

.rightmenu_BG {
	background-color: rgba(0, 0, 0, 0.3);
}

.iframe_CSS {
	margin: 0px;
	width: 1660px;
	height: 820px;
	border: 0px;
}

.body {
	background-color: #99FFFF
}

.layui-col-xs3 {
	width: 91px;
	height: 100px;
	margin: 10px;
	padding-top: 30px;
	padding-left: 15px
}

.layui-col-space10 {
	width: 450px;
	height: 200px;
	padding-top: 10px;
	padding-left: 25px;
}
</style>

</head>

<body class="body">
	<!--start : 头部内容  -->
	<div id="topDiv">
		<span class="titleCla"> FACE </span> <span class="titleUserName">
			<ul class="layui-nav">
				<li class="layui-nav-item"><a href="">消息中心<span
						class="layui-badge">9</span></a></li>
				<li class="layui-nav-item"><a href=""><img
						src="../../../../Uploads/<%=userimage%>" class="layui-nav-img"><%=name%></a>
					<dl class="layui-nav-child">
						<dd>
							<a href="http://localhost:8888/tuile">退了</a>
						</dd>
					</dl></li>
			</ul>
		</span>

		<div style="margin-left: 30px; float: right;">
			<input type="hidden" name="color" value="" id="test-all-input">
			<div id="test-all"></div>
		</div>
	</div>
	<!-- end : 头部内容  -->


	<!-- start :左侧菜单 -->
	<ul class="layui-nav layui-nav-tree layui-inline" id="leftDome"
		lay-filter="demo" style="margin-right: 10px;">
	</ul>
	<!-- end : 左侧菜单 -->


	<!-- start : tab选项卡  -->
	<div class="layui-tab" lay-filter="test" lay-allowclose="true"
		id="contentDiv">
		<ul class="layui-tab-title">

		</ul>

		<ul class="rightmenu" style="display: none;position: absolute;">
			<li class="closethis" data-type="closethis">&nbsp;关 闭 当 前&nbsp;</li>
			<li class="closeall" data-type="closeall">&nbsp;关 闭 所 有&nbsp;</li>
		</ul>

		<div class="layui-tab-content"></div>


		<div class="layui-row layui-col-space5">
			<div class="layui-col-md5">
				<div class="layui-row grid-demo">
					<div class="layui-col-md5">
						<div class="layui-card" style="width: 570px;height:300px;">
							<div class="layui-card-header">快捷方式</div>
							<div class="layui-card-body">
								<ul class="layui-row layui-col-space10 layui-this">
									<li class="layui-col-xs3" data-url="/user/user" data-title="用户管理" data-id="3">
										<a lay-href=""> 
					 						<i	class='layui-icon layui-icon-username'	style='font-size: 65px; color: #000;' ></i> <cite>用户管理</cite>
									</a></li>
									<li class="layui-col-xs3" data-url="/men/men" data-title="页面管理" data-id="7">
										<a lay-href=""> <i class='layui-icon layui-icon-layer'
											style='font-size: 65px; color: #000;'></i> <cite>页面管理</cite>
									</a>
									</li>
									<li class="layui-col-xs3" data-url="/face/face" data-title="Face管理页面" data-id="4"><a
										lay-href=""> <i class='layui-icon layui-icon-picture'
											style='font-size: 65px; color: #000;'></i> <cite>FACE管理</cite>
									</a></li>
									<li class="layui-col-xs3" data-url="/role/role" data-title="角色管理" data-id="11"><a
										lay-href=""> <i class='layui-icon layui-icon-friends'
											style='font-size: 65px; color: #000;'></i> <cite>
												&nbsp;&nbsp;角色管理</cite>
									</a></li>
									<li class="layui-col-xs3" data-url="" data-title="" data-id=""><a
										lay-href=""> <i class='layui-icon layui-icon-star'
											style='font-size: 65px; color: #000;'></i> <cite>按钮管理</cite>
									</a></li>
									<li class="layui-col-xs3" data-url="" data-title="" data-id=""><a
										lay-href=""> <i
											class='layui-icon layui-icon-face-smile-fine'
											style='font-size: 65px; color: #000;'></i> <cite>图标管理</cite>
									</a></li>
									<li class="layui-col-xs3" data-url="" data-title="" data-id=""><a
										lay-href=""> <i class='layui-icon layui-icon-release'
											style='font-size: 65px; color: #000;'></i> <cite>飞机管理</cite>
									</a></li>
									<li class="layui-col-xs3" data-url="" data-title="" data-id=""><a
										lay-href=""> <i class='layui-icon layui-icon-reply-fill'
											style='font-size: 65px; color: #000;'></i> <cite>消息管理</cite>
									</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="layui-col-md9">
						<div class="layui-card" style="width: 830px;height:300px;">
							<div class="layui-card-header">实时监控</div>
							<div class="layui-card-body">
								<fieldset class="layui-elem-field layui-field-title"
									style="margin-top: 50px;">
									<legend>CPU</legend>
								</fieldset>
								<div class="layui-progress layui-progress-big"
									lay-showpercent="true" lay-filter="demo">
									<div class="layui-progress-bar" lay-percent="0%"></div>
								</div>

								<fieldset class="layui-elem-field layui-field-title"
									style="margin-top: 50px;">
									<legend>内存占用率</legend>
								</fieldset>
								<div class="layui-progress layui-progress-big"
									lay-showpercent="true" lay-filter="demo2">
									<div class="layui-progress-bar layui-bg-cyan" lay-percent="0%"></div>
								</div>

							</div>
						</div>
					</div>
					<div class="layui-col-md12">
						<div id="main" style="width: 1500px;height:400px;"></div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="../../../../js/build/index.js" charset="utf-8"></script>
	<script>
	
		layui.use([ 'laydate', 'colorpicker', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider' ], function() {
			var laydate = layui.laydate, //日期
				laypage = layui.laypage, //分页
				layer = layui.layer, //弹层
				table = layui.table, //表格
				carousel = layui.carousel, //轮播
				upload = layui.upload, //上传
				element = layui.element, //元素操作
				slider = layui.slider, //滑块
				$ = layui.$,
				colorpicker = layui.colorpicker;
	
			//开启全功能
			colorpicker.render({
				elem : '#test-all',
				color : 'rgba(7, 155, 140, 1)',
				format : 'rgb',
				predefine : true,
				alpha : true,
				done : function(color) {
					color || this.change(color); //清空时执行 change
				},
				change : function(color) {
					//给当前页面头部和左侧设置主题色
					$('#topDiv').css('background-color', color);
					$('.layui-nav').css('background-color', color);
					$(".rightmenu").css('border', '2px dashed ' + color);
					$(".closethis").css('border-bottom', '2px dashed ' + color);
					$(".rightmenu_BG").css('background-color', color);
	
					$.ajax({
						type : "post",
						dataType : "json",
						data : {
							"color" : color,
						},
						url : "/SColor",
					});
	
				}
			});
	
	
			//Hash地址的定位
			var layid = location.hash.replace(/^#test=/, '');
			element.tabChange('test', layid);
	
			element.on('tab(test)', function(elem) {
				location.hash = 'test=' + $(this).attr('lay-id');
			});
	
	
			//触发事件
			var active = {
				tabAdd : function(url, id, title) {
					//新增一个Tab项
					element.tabAdd('test', {
						title : title, //用于演示
						content : '<div><iframe src="http://192.168.1.117:8888' + url + '" class="iframe_CSS" ></iframe></div>',
						id : id //实际使用一般是规定好的id，这里以时间戳模拟下
					})
					CustomRightClick(id); //给tab绑定右击事件
				// 					FrameWH(); //计算ifram层的大小
				},
				tabChange : function(id) {
					//切换到指定Tab项
					element.tabChange('test', id); //根据传入的id传入到指定的tab项
				},
				tabDelete : function(id) {
					element.tabDelete("test", id); //删除
				},
				tabDeleteAll : function(ids) { //删除所有
					$.each(ids, function(i, item) {
						element.tabDelete("test", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
					})
				}
			};
	
	
	
			//当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
			$('.site-demo-active').on('click', function() {
				var dataid = $(this);
	
				//这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
				if ($(".layui-tab-title li[lay-id]").length <= 0) {
					//如果比零小，则直接打开新的tab项
					active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
				} else {
					//否则判断该tab项是否以及存在
	
					var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
					$.each($(".layui-tab-title li[lay-id]"), function() {
						//如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
						if ($(this).attr("lay-id") == dataid.attr("data-id")) {
							isData = true;
						}
					})
					if (isData == false) {
						//标志为false 新增一个tab项
						active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
					}
				}
				//最后不管是否新增tab，最后都转到要打开的选项页面上
				active.tabChange(dataid.attr("data-id"));
			});
	
	
			function CustomRightClick(id) {
				//取消右键  rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
				$('.layui-tab-title li').on('contextmenu', function() {
					return false;
				})
				$('.layui-tab-title,.layui-tab-title li').click(function() {
					$('.rightmenu').hide();
				});
				//桌面点击右击 
				$('.layui-tab-title li').on('contextmenu', function(e) {
				
					var popupmenu = $(".rightmenu");
					popupmenu.find("li").attr("data-id", id); //在右键菜单中的标签绑定id属性
					
	
					//判断右侧菜单的位置 
					l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
					t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
					
					l = l - 220;
					t = 30;
					popupmenu.css({
						left : l,
						top : t
					}).show(); //进行绝对定位
					//alert("右键菜单")
					return false;
				});
			}
	
			$(".rightmenu li").click(function() {
	
				//右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
				if ($(this).attr("data-type") == "closethis") {
					//如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
					active.tabDelete($(this).attr("data-id"))
				} else if ($(this).attr("data-type") == "closeall") {
					var tabtitle = $(".layui-tab-title li");
					var ids = new Array();
					$.each(tabtitle, function(i) {
						ids[i] = $(this).attr("lay-id");
					})
					//如果关闭所有 ，即将所有的lay-id放进数组，执行tabDeleteAll
					active.tabDeleteAll(ids);
				}
	
				$('.rightmenu').hide(); //最后再隐藏右键菜单
			})
			$('.rightmenu li').hover(function() {
				$(this).addClass('rightmenu_BG');
			}, function() {
				$(this).removeClass('rightmenu_BG');
			});
	
			function FrameWH() {
				var h = $(window).height() - 41 - 10 - 60 - 10 - 44 - 10;
				$("iframe").css("height", h + "px");
			}
	
			$(window).resize(function() {
				FrameWH();
			})
			getIndexJDTInfo();
			setInterval(getIndexJDTInfo, 1000 * 2);
			function getIndexJDTInfo() {
				$.ajax({
					type : "post",
					dataType : "json",
					url : "/getIndexJDTInfo",
					success : function(result) {
						element.progress('demo', result.CPU)
						element.progress('demo2', result.C)
					}
				})
	
			}
	
			$(".layui-col-xs3").hover(function() {
				$(this).css("background-color", "#99FFFF");
			}, function() {
				$(this).css("background-color", "#fff");
			});
	
			$(".layui-col-xs3").click(function() {
	
				element.tabAdd('test', {
					title : $(this).attr("data-title"), //用于演示
					content : '<div><iframe src="http://127.0.0.1:8888' + $(this).attr("data-url") + '" class="iframe_CSS" ></iframe></div>',
					id : $(this).attr("data-id") //实际使用一般是规定好的id，这里以时间戳模拟下
				})
				element.tabChange("test", $(this).attr("data-id")); 
				
	
			})
	
	
		});
	
		getMen();
	
	
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		getIndexInfo();
		setInterval(getIndexInfo, 1000 * 2);
		function getIndexInfo() {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "/getIndexInfo",
				success : function(result) {
					option = {
						title : {
							text : '			 	计算机：' + result.computerName + " : " + result.ip + ' 数据信息',
							left : 'center'
						},
						tooltip : {
							trigger : 'item',
							formatter : '{a} <br/>{b} : {c}'
						},
						legend : {
							left : 'left',
							data : result.title
						},
						xAxis : {
							type : 'category',
							name : 'x',
							splitLine : {
								show : false
							},
							data : result.time
						},
						grid : {
							left : '3%',
							right : '4%',
							bottom : '3%',
							containLabel : true
						},
						yAxis : {
							type : 'log',
							name : 'y'
						},
						series : [
							{
								name : result.title[0],
								type : 'line',
								data : result.oneCPU
							},
							{
								name : result.title[1],
								type : 'line',
								data : result.towCPU
							},
							{
								name : result.title[2],
								type : 'line',
								data : result.theeCPU
							},
							{
								name : result.title[3],
								type : 'line',
								data : result.foCPU
							}
						]
					};
	
					// 使用刚指定的配置项和数据显示图表。
					myChart.setOption(option);
				}
			})
		}
	</script>
</body>
</html>
