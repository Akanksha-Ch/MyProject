<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="order" method="post" action="purchase/submitItems">    
	<table>
		<c:forEach items="${order.itemlist}" var="item" varStatus="loop">
			<tr>
				<td>
					<c:out value="${item.name}"> </c:out>
				</td>
				<td>
					<c:out value="$${item.price}"> </c:out>
				</td>
				<td>
					<form:input path="items[${loop.index}].quantity" />
				</td>
			</tr>
		</c:forEach>  
			<tr>
				<td colspan="2">
					<input type="submit" value="Purchase">
				</td>  
			</tr>
	</table>
</form:form>
</body>
</html>