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
	
		<a href="add">додати співробітника</a>
   		<table id="stands" border="1" >
   			<c:forEach items="${employees}" var="employee">
				<form:form action="${employee.id}" method="delete" modelAttribute="employee">
					<tr>
						<td>${employee.name}</td><td>${employee.middleName}</td><td>${employee.surname}</td><td><input type="submit" value="видалити"></td><td><a href="${employee.id}/update">змінити</a></td>
					</tr>
				</form:form>
			</c:forEach>
		</table>	
	</div>
	
</body>
</html>