
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="home">Gestão de Eventos</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link " href="home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="eventos">Eventos</a></li>
        		<li class="nav-item"><a class="nav-link " href="convidados">Convidados</a>
				</li>
			</ul>
            
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item"><a class="nav-link " href="home">${session_usuario.usuario}</a></li>
            <li class="nav-item"><a class="nav-link " href="usuario">Registro</a></li>
            <li class="nav-item"><a class="nav-link " href="logoff">Logoff</a></li>
            </ul>
		</div>
	</div>
</nav>