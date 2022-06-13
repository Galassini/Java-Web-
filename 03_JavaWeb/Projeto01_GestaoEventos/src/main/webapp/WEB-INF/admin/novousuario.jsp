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

.margem-supeiror {
	margin-top: 50px;
}
</style>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
		<div class="borda">
			<h2 class="text-danger">Cadastro de eventos</h2>
			<form action="usuarios" method="post">

				<div class="mb-3">
					<span class="form-label">Username:</span> <input
						class="form-control" type="text" name="txtUsername" />
				</div>
				<div class="mb-3">
					<span class="form-label">Password:</span> <input
						class="form-control" type="text" name="txtConfirma" />
				</div>
				<div class="mb-3">
					<span class="form-label">Confirme Password:</span> <input
						class="form-control" type="text" name="txtDescricao" />
				</div>
				<div class="mb-3">
					<span class="form-label">Nivel:</span> 
					<select class="form-select" name="cmbNivel">
					<option value="1">Administrador</option>
					<option value="2">Convidado</option>
					<option value="3">Atendente</option>
					
					</select>
				</div>
				<input class="btn btn-primary" type="submit" value="incluir Usuario" />
			</form>
		</div>

	</div>


</body>
</html>