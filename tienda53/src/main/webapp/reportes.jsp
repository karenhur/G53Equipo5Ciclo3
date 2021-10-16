<!DOCTYPE html>
<html>

<head>


<!-- paquete de caracteres -->
<meta charset="utf-8">
<!-- Tamaño de la pantalla -->
<meta name="viewport" content="width=device-width">
<!-- titulo de la pestaña -->
<title>Ventas</title>
<!-- bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">

<!-- Cargando mi hoja de estilo -->
<link href="style.css" rel="stylesheet" type="text/css" />


</head>


<body>
	<!-- Navbar-->
	<nav class="navbar navbar-light" style="background-color: #cad46e;">
		<div class="container-fluid">
			<a class="navbar-brand link" href="login.jsp"><i
				class="fas fa-shopping-cart"></i> Tienda Generica</a>
		</div>
	</nav>

	<!-- Navbar modulos-->
	<nav class="navbar navbar-dark" style="background-color: #feb935;">
		<div class="container">
			<a class="navbar-brand links" href="listausuarios.jsp"> <i
				class="fas fa-users"></i> Usuarios
			</a> <a class="navbar-brand links" href="listaclientes.jsp"> <i
				class="fas fa-address-book"></i> Clientes
			</a> <a class="navbar-brand links" href="listaproveedores.jsp"> <i
				class="fas fa-truck"></i> Proveedores
			</a> <a class="navbar-brand links" href="insertarproducto.jsp"> <i
				class="fas fa-apple-alt"></i> Productos
			</a> <a class="navbar-brand links" href="listaventas.jsp"> <i
				class="fas fa-money-check-alt"></i> Ventas
			</a> <a class="navbar-brand links" href="listausuarios.jsp"> <i
				class="fas fa-clipboard-list"></i> Reportes
			</a>
		</div>
	</nav>
	
	<div style="padding: 150px 100px ">
	<div class="btn-group-vertical btn-group-lg">
	<button type="button" class="btn btn-secondary btn-lg"
						onclick="window.location.href='/reporteusuario.jsp'">
						<i class="fas fa-plus-circle"></i> Listado de Usuarios
					</button>
					<br>
					</br>
	<button type="button" class="btn btn-secondary" 
						onclick="window.location.href='/reporteclientes.jsp'">
						<i class="fas fa-plus-circle"></i> Listado de Clientes
					</button>
					<br>
					</br>
	<button type="button" class="btn btn-secondary"
						onclick="window.location.href='/insertarclientes.jsp'">
						<i class="fas fa-plus-circle"></i> Ventas por Cliente
					</button>
	</div>
	</div>
	<nav class="navbar fixed-bottom navbar-light">
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#"> Diseñado y programado
					por Equipo 5 Grupo 53 </a>
			</div>
		</div>
	</nav>

</body>
</html>