
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>定时任务-手动调用</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.11.4.css" />
<script type="text/javascript" src="js/jquery-ui/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui-1.11.4.js"></script>
<script type="text/javascript" src="js/jquery.mypagination.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

</head>

<body>
	
	<div>
		<!--/sidebar-->
		<div class="main-wrap" id="topDiv">

			<div class="result-wrap">
				<div class="result-content">
						<table class="result-tab" width="100%" style="table-layout:fixed;" id="tb">
							<tr>
								<th width="350px">定时任务</th>
								<th style="width:300px">标题</th>
								<th style="width:100px">参数个数</th>
								<th>操作</th>
								<th>备注</th>
								
							</tr>
							<c:forEach items="${tasks}" var="task" >
							<tr>
								<td>${task.taskName}</td>	
								<td>${task.title }</td>
								<td>${task.paramsCount }</td>
								<td>
									<button onclick="execute('${task.taskName}')" >直接执行</button>
									<c:if test="${task.paramsCount != 0 }">
										<button onclick="openParamDialog('${task.taskName}','${task.title}' , ${task.paramsCount })" >执行</button>
									</c:if>
									
								</td>
								<td>${task.remark}</td>	
								
							</tr>
							</c:forEach> 
						</table>
				</div>
			</div>
		</div>
	</div>
	
	<div id="dialog" title="参数填写" style="display: none">
		<div id="divParams">
			<ul id="ulParams">
				<li id="param1">参数一：<input type="text" name="param1"></li>
				<li id="param2">参数二：<input type="text" name="param2"></li>
				<li id="param3">参数三：<input type="text" name="param3"></li>
			</ul>
		</div>
	</div>
	
</body>
<script type="text/javascript">

	function openParamDialog(taskName,title,paramsCount){
		$("#ulParams li").hide();
		console.log(paramsCount);
		if(paramsCount == 1){
			$("#param1").show();
		}else if(paramsCount == 2){
			$("#param1").show();
			$("#param2").show();
		}else{
			$("#param1").show();
			$("#param2").show();
			$("#param3").show();
		}
		$( "#dialog" ).dialog({
			  title:"任务 " +title , 
			  maxHeight: 300 ,
			  buttons : [
				{
					text:"执行",
					click:function(){
						var param1 = $("[name=param1]").val() ;
						var param2 = $("[name=param2]").val() ;
						var param3 = $("[name=param3]").val() ;
						execute(taskName,param1,param2,param3);
					}
				}
			  ]
		});
		
	}

	function execute(taskName,param1,param2,param3,$btn){
		$.post('task/execute',{taskName:taskName,param1:param1,param2:param2,param3:param3},function(data){
			alert(data.codeMsg);
			$( "#dialog" ).dialog('close');
		})
	}

</script>
</html>
