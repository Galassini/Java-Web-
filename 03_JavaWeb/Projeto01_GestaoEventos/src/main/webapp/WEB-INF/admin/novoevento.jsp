<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

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
			<form action="novoevento" method="post">

				<div class="mb-3">
					<span class="form-label">Descrição:</span> 
					<input	class="form-control" type="text" name="txtDescricao" />
				</div>
				<div class="mb-3">
					<span class="form-label">Responsavel:</span> 
						 <input class="form-control" type="text" name="txtResponsavel" />
				</div>
				
				<div class="mb-3">
					<span class="form-label">Data:</span>
						<input class="form-control" type="date" name="txtData" />
				</div>
				

				<div class="mb-3">
					<span class="form-label">Preço:</span> 
						<input class="form-control" type="text" name=txtPreco />
				</div>

				<input class="btn btn-danger" type="submit" value="Incluir Evento" />
				<a href="eventos" class="btn btn-default">Voltar</a>

			</form>
		</div>
</div>
</body>
</html>