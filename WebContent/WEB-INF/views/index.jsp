<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/style.css"> 
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">

<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript" src="resources/organizationDao.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body >

	<div id="content" class="form-group" >
		Організація
	<select id="organizations" class="form-control">
	</select>
	
	<br>
	<br>
	<br>
	
	Співробітник
	<select id="employees" class="form-control">
	</select>
	
	<br>
	<br>
	<br>
	
	Доступ дозволено до
	<table id="stands" border="1">
	</table>
	
	<br>
	<br>
	<br>
	
	</div>
	

	<div id="footer">
		<a href="admin">admin console</a>
	</div>


</body>
</html>