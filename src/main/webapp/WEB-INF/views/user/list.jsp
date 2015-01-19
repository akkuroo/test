<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	유저 목록
</h1>

<table border=1>
	<tr>
		<th>idx</th>
		<th>name</th>
		<th>action</th>
	</tr>
	
	<c:forEach var="row" items="${list}">
	<tr>
		<td>${row.idx}</td>
		<td>${row.name}</td>
		<td><a href="./delete?name=${row.name}">delete</a></td>
	</tr>
	</c:forEach>
	
</table>
<a href="./create">add</a>
</body>
</html>
