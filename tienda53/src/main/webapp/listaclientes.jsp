<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<!-- paquete de caracteres -->
<meta charset="utf-8">
<!-- TamaÃ±o de la pantalla -->
<meta name="viewport" content="width=device-width">
<!-- titulo de la pestaÃ±a -->
<title>Lista de clientes</title>
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


<script>
	var geturl = window.location;
	var baseurl = geturl.protocol + "//" + geturl.host + "/" + geturl.pathname.split('/')[1];
	function loadclientes() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", baseurl+"/listarclientes", true);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
				var clientes = JSON.parse(xmlhttp.responseText);
				var tbltop = "<table class='table table-dark table-striped'><tr><th>Cedula</th><th>Nombre</th><th>Dirección</th><th>Telefono</th><th>Email</th></tr>";
				var main = "";
				for (i = 0; i < clientes.length; i++) {
					main += "<tr><td>" + clientes[i].cedula_cliente
							+ "</td><td>" + clientes[i].nombre_cliente
							+ "</td><td>" + clientes[i].direccion_cliente
							+ "</td><td>" + clientes[i].telefono_cliente
							+ "</td><td>" + clientes[i].email_cliente;
				}
				var tblbottom = "</table>";
				var tbl = tbltop + main + tblbottom;
				document.getElementById("clientesinfo").innerHTML = tbl;
			}
		};
		xmlhttp.send();
	}
	window.onload = function() {
		loadclientes();
	}
</script>

</head>


<body>
	<!-- Navbar-->
	<nav class="navbar navbar-light" style="background-color: #cad46e;">
		<div class="container-fluid">
			<a class="navbar-brand link" href="login.jsp" ><i
				class="fas fa-shopping-cart"></i> Tienda Generica</a>
		</div>
	</nav>

	<!-- Navbar modulos-->
	<nav class="navbar navbar-dark" style="background-color: #feb935;">
		<div class="container">
			<a class="navbar-brand links" href="listausuarios.jsp">
			<i class="fas fa-users"></i> Usuarios</a> 
			<a class="navbar-brand links" href="listaclientes.jsp">
			<i class="fas fa-address-book"></i> Clientes</a>
			<a class="navbar-brand links" href="listaproveedores.jsp">
			<i class="fas fa-truck"></i> Proveedores</a>
			<a class="navbar-brand links" href="insertarproducto.jsp">
			<i class="fas fa-apple-alt"></i> Productos</a>
			<a class="navbar-brand links" href="registrarventa.jsp">
			<i class="fas fa-money-check-alt"></i> Ventas</a>
			<a class="navbar-brand links" href="listausuarios.jsp">
			<i class="fas fa-clipboard-list"></i> Reportes</a>
		</div>
	</nav>
	
	
	<!-- contenido  -->
	
	<div style="padding-left: 5px;">
	
		<h1><i class="fas fa-list-ol"></i> Tabla de clientes</h1>
			<div class="container">
				<div class="row">
					<!--  Aqui es donde se autogenera la tabla basado en el script -->
					<div class="col align-self-center" id="clientesinfo">
					
					</div>
	
				</div>
			</div>
	
		<h1><i class="fas fa-cogs"></i> Operaciones</h1>
			<div class="container">
				
					<button type="button" class="btn btn-success"
						onclick="window.location.href='<%=request.getContextPath()%>/insertarclientes.jsp'">
						<i class="fas fa-plus-circle"></i> Agregar cliente
					</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='<%=request.getContextPath()%>/eliminarcliente.jsp'">
						<i class="fas fa-trash"></i> Eliminar cliente
					</button>
					<button type="button" class="btn btn-warning"
						onclick="window.location.href='<%=request.getContextPath()%>/actualizarcliente.jsp'">
						<i class="fas fa-pen-alt"></i> Actualizar cliente
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/buscarcliente.jsp'">
						<i class="fas fa-search"></i> Buscar un cliente
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/listaclientes.jsp'">
						<i class="fas fa-search"></i> Listar todos los clientes
					</button>

				</div>
			</div>
	</div>


<nav class="navbar fixed-bottom navbar-light" >
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#">
					Diseñado y programado por Equipo 5 Grupo 53 </a>
			</div>
		</div>
	</nav>


</body>
</html>