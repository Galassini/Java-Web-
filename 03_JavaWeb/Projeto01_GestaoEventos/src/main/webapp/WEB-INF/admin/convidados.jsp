<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container"></div>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1>Lista de Convidados</h1>
	
	<form action="convidados" method="get">
			<select class="form-select" name="codevento">
				<c:forEach var="evento" items="${eventos}">
					<c:choose>
						<c:when test="${codigo eq evento.id}">
							<option value="${evento.id}" selected>${evento.descricao}</option>
						</c:when>
						<c:otherwise>
							<option value="${evento.id}">${evento.descricao}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select> <br>
			<button type="submit" class="btn btn-primary">Listar</button> |
			<a href="novoconvidado" class="tbn btn-suces">Novo Convidado</a>
		</form>
		
		<table class="table table-hover">
		<thead>
		<tr>
		   <th>ID</th>
		   <th>NOME</th>
		   <th>IDADE</th>
		   <th>EMAIL</th>
		
		</tr>
		</thead>
		<tbody>
		<c:forEach var="guest" items="${convidaos}">
		<tr>
		<td>${guest.id}</td>
		<td>${guest.nome}</td>
		<td>${guest.idade}</td>
		<td>${guest.email}</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>

</body>
</html>