
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<title>修改用户密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="修改用户密码">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.9.1.min.js"></script>


</head>

<body>

	<div>
		<div class="main-wrap">
			<div class="result-wrap">
				<div class="result-content">
						<table class="insert-tab" width="100%">
							<caption>修改操作员&nbsp;【${sessionScope.loginUser.userName}】&nbsp;密码</caption>
							<tr>
								<th>原密码：</th>
								<td><input type="password" name="oldPsd"  id="oldPsd" /><span name="msg" ><font color="red" id="oldPsdMsg"></font></span>
								</td>
							</tr>
							<tr>
								<th>新密码：</th>
								<td><input type="password" name="newPsd"  id="newPsd" /><span name="msg" ><font color="red" id="newPsdMsg"></font></span>
								</td>
							</tr>
							<tr>
								<th>新密码确认：</th>
								<td><input type="password" name="newPsdConfirm"  id="newPsdConfirm" /><span name="msg" ><font color="red" id="newPsdConfirmMsg"></font></span>
								</td>
							</tr>
							<tr>
								<th>操作：</th>
								<td>
										<div>
											<button id="btnOK"  >提交</button>
											<button onclick="history.go(-1)">返回</button>
										</div>
								</td>
							</tr>
						</table>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$("#btnOK").click(function(){
				$("[name=msg]").hide();
				var oldPsd = $("#oldPsd").val();
				var newPsd = $("#newPsd").val() ;
				var newPsdConfirm = $("#newPsdConfirm").val() ;
				
				
				if( newPsd != newPsdConfirm ){
					alert("确认密码不一致");
					return ;
				}
				$.post("./changePsd",{adminName:'${sessionScope.loginUser.userName}' ,oldPsd:oldPsd , newPsd:newPsd},function(data){
					if( data.code == '0' ){
						//$(":input").val("");
						alert("修改密码"+data.codeMsg);
						window.history.go(-1) ;
					}
					
				},"json") ;
				
			});
			
		}) 
		
		function clearMsg(){
			
		}
	</script>
	
	
</body>
</html>
