<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/icsdc/resources/style.css">
<title>Insert title here</title>
</head>
<body>

	<div id="content">
   		<table id="stands" border="1" >
   			<c:forEach items="${organizations}" var="organization">
				<tr>
					<td>${organization.name}</td><td><a href="${organization.id}/update">видалити</a></td><td><a href="">змінити</a></td>
				</tr>
			</c:forEach>
		</table>	
	</div>
	
</body>
</html>