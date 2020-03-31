<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="../../../../common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BB.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <div>
	<textarea rows="3" cols="20" id="content"></textarea>
	<br>
    <input type="submit" value="Start" onclick="start()" />
  </div>
  <div id="messages"></div>
  <script type="text/javascript">
    var webSocket = 
      new WebSocket('ws://localhost:8888/websocket');

    webSocket.onerror = function(event) {
      onError(event)
    };

    webSocket.onopen = function(event) {
      onOpen(event)
    };

    webSocket.onmessage = function(event) {
      onMessage(event)
    };
	
	webSocket.onclose = function(event) {
      onClose(event)
    };
	

    function onMessage(event) {
      document.getElementById('messages').innerHTML 
        += '<br />' + event.data;
    }

    function onOpen(event) {
      document.getElementById('messages').innerHTML 
        = 'Connection established';
    }

    function onError(event) {
      alert(event.toString);
    }
	
	function onClose(event) {
      alert(event);
    }

    function start() {
	  var text = document.getElementById('content').value;
      webSocket.send(text);
    }
  </script>
  </body>
</html>
