<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String errorMsg = (String) session.getAttribute("errorMsg");
	session.removeAttribute("errorMsg");
 %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>ERROR-400</title>

<script type="text/javascript">
	
</script>
</head>

<body>
	<img alt="" style="height: 350px;width: 500px;" src="images/error_404.jpg"/>
</body>
</html>
