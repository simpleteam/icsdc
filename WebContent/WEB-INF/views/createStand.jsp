<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/style.css">
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		<form:form action="/icsdc/stand/" method="POST" modelAttribute="stand">
			Інвентарний номер шафки:
			<form:input path="number" /><br>
			Альтeрнатив номер шафки:
			<form:input path="alternativeNumber" />
			<input type="submit" value="зберегти" />
			<input type="reset" value="очистити" />
		</form:form>
	</div>
</body>
</html>