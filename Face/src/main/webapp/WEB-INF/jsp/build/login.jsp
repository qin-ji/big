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

<title>-阿胖登录页面-</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<!-- 	 <link rel="stylesheet" href="../../../../layui/css/layui.css"> -->
<style>
* {
	margin: 0;
	padding: 0;
}

html, body {
	height: 100%;
	width: 100%;
}

#area-render {
	position: fixed;
	width: 100%;
	height: 100%;
	right: -4px;
	bottom: 4px;
}

.loginDIV {
	position: fixed;
	top: 200px;;
	left: 550px;
	right: 0px;
	bottom: 0px;
	margin: auto;
}
.loginBG{
	 /*background-color:rgba(220,38,38,0.1);*/
}
</style>



</head>



<body class="body">

	<div id="area-render"></div>

	<div class="loginDIV">
		<div class="layui-col-md5 loginBG">
			<div class="layui-row grid-demo ">

				<div class="layui-col-md9 ">
					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 20px;">
						<legend>   登录页面    </legend>
					</fieldset>
				</div>
				<div class="layui-col-md12 ">
					<form class="layui-form" action="doLogin">


						<div class="layui-form-item">
							<div class="layui-inline">
								<label class="layui-form-label">用户名</label>
								<div class="layui-input-inline">
									<input type="text" value="qj" name="username"
										class="layui-input">
								</div>
							</div>
							<div class="layui-inline">
								<label class="layui-form-label">密码</label>
								<div class="layui-input-inline">
									<input type="password" value="qj" name="password"
										class="layui-input">
								</div>
							</div>
						</div>

						<div class="layui-form-item" style="margin-left: -20px;">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit="" lay-filter="demo1">登录</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
								<button data-method="notice" class="layui-btn layui-btn-warm"
										onclick="add()">注注注册</button>
							</div>
						</div>
					</form>
					<div class="site-demo-button" id="layerDemo"
						style="margin-bottom: 0;">
<%--						<button data-method="notice" class="layui-btn layui-btn-warm"--%>
<%--							onclick="add()">注注注册</button>--%>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div style="margin-left: 30px; display: inline; ">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-input-inline" style="width: 120px;">
					<input type="text" value="" placeholder="请选择颜色" class="layui-input"
						id="test-form-input">
				</div>
				<div class="layui-inline" style="left: -11px;">
					<div id="test-form"></div>
				</div>
			</div>
		</form>
	</div>
	<div style="margin-left: 30px; display: inline; ">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-input-inline" style="width: 120px;">
					<input type="text" value="" placeholder="请选择颜色" class="layui-input"
						id="test-form-input2">
				</div>
				<div class="layui-inline" style="left: -11px;">
					<div id="test-form2"></div>
				</div>
			</div>
		</form>
	</div>

	<div
		style=" height: 270px; display: none; padding: 50px; line-height: 52px; background-color: #393D49; color: #fff; font-weight: 300;"
		id="zhuc">
		<div class="layui-inline">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input type="text" id="username" name="username" class="layui-input">
			</div>
		</div>


		<div class="layui-inline">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" id="password" name="password"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">验证手机</label>
				<div class="layui-input-inline">
					<input type="tel" name="phone" id="phone"
						lay-verify="required|phone" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">验证邮箱</label>
				<div class="layui-input-inline">
					<input type="text" name="email" 
						id="email" lay-verify="email" autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>

	</div>



	<script src="../../../../js/build/login.js" charset="utf-8"></script>
	<script>	

	layui.use([ 'form','colorpicker'], function(){ 
  var form = layui.form
   var $ = layui.$,colorpicker = layui.colorpicker;
	var colorpicker = layui.colorpicker;

  
   //开启全功能
  colorpicker.render({
    elem: '#test-form'
    ,color: 'rgba(7, 155, 140, 1)'
    ,format: 'rgb'
    ,predefine: true
    ,alpha: true
    ,done: function(color){
     $('#test-form-input').val(color);
      color || this.change(color); //清空时执行 change
    }
    ,change: function(color){
    
     $('#test-form-input').val(color);
      //给当前页面头部和左侧设置主题色
      $('#area-render').css('background-color', color);
    }
  });
  
 		 var cn =new CanvasNest(document.getElementById('area-render'), {
		    color: '255,0,255',
		    count: 300,
		  });
  
    //开启全功能
  colorpicker.render({
    elem: '#test-form2'
    ,color: 'rgba(7, 155, 140, 1)'
    ,format: 'rgb'
    ,predefine: true
    ,alpha: true
    ,done: function(color){
     $('#test-form-input2').val(color);
      color || this.change(color); //清空时执行 change
    }
    ,change: function(color){
     $('#test-form-input2').val(color);
      //给当前页面头部和左侧设置主题色
    	 new CanvasNest(document.getElementById('area-render'), {
		    color: 'color',
		    count: 300,
     	 })
    }
  });
 
 
 });
	  

</script>


</body>
</html>
