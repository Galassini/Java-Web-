<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" ></script>

</head>
<body>
<%@include file="menu.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container">
<h1>Lista de Eventos</h1>

<div>
<a href="novoevento" class="btn btn-primary">Novo Evento</a>

</div>

<table class="table table-striped">
<thead>
<tr>
<th>DESCRIÇÃO</th>
<th>RESPONSÁVEL</th>
<th>DATA</th>
<th>PREÇO</th>
<th></th>
</tr>
<thead>

<tbody>
<c:forEach var="evento" items="${listaEventos}">
<tr>
<td>${evento.descricao}</td>
<td>${evento.responsavel}</td>
<td><fmt:formatDate value="${evento.data}" pattern="dd/MM/yyyy"/></td>
<td><fmt:formatDate value="${evento.preco}" type="currency"/></td>
<td>
<a href ="alterarevento?idevento=${evento.id}">Alterar</a> 
<a href="excluirevento?idevento=${evento.id}">Excluir</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>

</body>
</html>