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
<style type="text/css">
.borda {
	max-width: 400px;
	margin: auto;
}
</style>

</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container"></div>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container">
		<div class="borda">
			<h2 class="text-danger">Cadastro de Convidados</h2>
			<form action="novoconvidado" method="post">

				<div class="mb-3">
					<span class="form-label">Selecione o Evento:</span>
						<select class="form-select" name="cmEvento">
						<c:catch var="evento" items="${eventos}">
						<option value="${evento.id}">${evento}</option>
						</c:catch>
						
						</select>
				</div>
				<div class="mb-3">
					<span class="form-label">Nome:</span> 
						<input class="form-control" type="text" name="tctNome" />
				</div>

				<div class="mb-3">
					<span class="form-label">Idade:</span> <input class="form-control"
						type="number" name="txtIdade" />
				</div>


				<div class="mb-3">
					<span class="form-label">Email:</span> <input class="form-control"
						type="email" name=txtEmail />
				</div>

				<input class="btn btn-danger" type="submit" value="Incluir Convidado" />
				<a href="convidado" class="btn btn-default">Voltar</a>

			</form>
		</div>
	</div>
</body>
</html>