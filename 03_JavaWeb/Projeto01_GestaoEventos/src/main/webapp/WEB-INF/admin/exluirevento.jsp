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
<h1 class="txt-danger">Tem certeza que deseja exluir este evento?</h1>
<h2 class="text-danger">${evento.descricao}</h2>

<form action="excluirevento" method="post">
 <input type="hidden" value="${evento.id}" name="txtId"/>
 <input type="submit" class="btn btn-danger" value="Sim, exluir" />
 <a href="eventos">Não, Voltar para a lista</a>
 
</form>

</body>
</html>