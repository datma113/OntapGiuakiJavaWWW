<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<c:url var="savePerson" value="showFormAdd" />


	<a href="${savePerson }"> add person </a>

	<table class="table table-border col-6">
		<thead>
			<tr>
				<th>name</th>
				<th>email</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listPerson}" var="person">
				<c:url var="editPerson" value="edit">
				<c:url var ="deletePerson" value="delete">
					<c:param name="personID" value="${person.id }" />
				</c:url>
					<c:param name="personID" value="${person.id }" />
				</c:url>
				<tr>
					<th>${person.name }</th>
					<th>${person.email }</th>
					<th><a href="${editPerson}">edit person</a></th>
				<th><a href="${deletePerson}" class="text-danger">delete person</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>