<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/icsdc/resources/style.css">
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		<a href="../">головна</a>
		<br>
		<br>
		<a href="add">додати шафку</a>
   		<table id="stands" border="1" >
   			<tr>
   				<td>номер шафки</td><td>альтернативний номер шафки</td><td></td><td></td>
   			</tr>
   			<c:forEach items="${stands}" var="stand">
				<form:form action="${stand.id}" method="delete" modelAttribute="stand">
					<tr>
						<td>${stand.number}</td><td>${stand.alternativeNumber}</td><td><input type="submit" value="видалити"></td><td><a href="${stand.id}/update">змінити</a></td>
					</tr>
				</form:form>
			</c:forEach>
		</table>	
	</div>
</body>
</html>