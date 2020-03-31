<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.addHeader("Cache-control", "No-cache");
	response.addDateHeader("Expires", 0);
		request.setAttribute("ctx", request.getContextPath());
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if lt IE 9]>
    　 <script src="https://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
       <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.js"></script>
    <![endif]-->

<link style="text/css" rel="stylesheet" href="../layer/mobile/need/layer.css">
<link style="text/css" rel="stylesheet" href="../layui/css/layui.css">

<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../layer/layer.js"></script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>

<script type="text/javascript" color="255,0,0" pointColor="255,0,0" opacity='0.7' zIndex="-2" count="100" src="../js/canvas-nest.js"></script>
<script type="text/javascript" src="../js/canvas-nest.umd.js"></script>
<body>

</body>
</html>
