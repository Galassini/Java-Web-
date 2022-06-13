
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
.borda {
	max-width: 400px;
	margin: auto;
	padding: 20px;
	background-color: #DCDCDC;
}

.margem-supeiror {
	margin-top: 50px;
}
</style>
</head>
<body>

	<div class="container margem-superior">
		<div class="borda">
			<h2 class="text-danger">Informe suas credenciais</h2>
			<form action="login" method="post">

				<div class="mb-3">
					<span class="form-label">Usuário:</span> <input
						class="form-control" type="text" name="txtNome" />
				</div>

				<div class="mb-3">
					<span class="form-label">Senha:</span> <input class="form-control"
						type="password" name="txtSenha" />
				</div>

				<input class="btn btn-danger" type="submit" value="Iniciar Sessão" />

			</form>
		</div>
	</div>

</body>
</html>