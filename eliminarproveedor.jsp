<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<!-- paquete de caracteres -->
<meta charset="utf-8">
<!-- Tama�o de la pantalla -->
<meta name="viewport" content="width=device-width">
<!-- titulo de la pesta�a -->
<title>Eliminar Proveedor</title>
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

	<div style="padding-left: 5px">
		<h1>
			<i class="fas fa-skull-crossbones"></i> Datos del proveedor a eliminar
		</h1>
		<div class="container">


			<div id="error" class="alert alert-danger visually-hidden"
				role="alert">Error al eliminar el proveedor, verifique que 
				exista un proveedor con el nit dado</div>

			<div id="correcto" class="alert alert-success visually-hidden"
				role="alert">Proveedor eliminado con exito</div>

			<form id="form1">
			
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Nit</span> <input
						type="text" class="form-control"
						placeholder="Inserte nit aqui..."
						aria-describedby="basic-addon1" required id="nit_proveedor">
				</div>

			</form>

			<button type="button" class="btn btn-danger" onclick="eliminar()">
				<i class="fas fa-skull-crossbones"></i> Eliminar proveedor
			</button>
			
			<br>
			<br>
			<br>
			<h1>
				<i class="fas fa-cogs"></i> Operaciones
			</h1>
			<div class="container">
				
					<button type="button" class="btn btn-success"
						onclick="window.location.href='<%=request.getContextPath()%>/insertarproveedor.jsp'">
						<i class="fas fa-plus-circle"></i> Agregar Proveedor
					</button>
					<button type="button" class="btn btn-danger"
						onclick="window.location.href='<%=request.getContextPath()%>/eliminarproveedor.jsp'">
						<i class="fas fa-trash"></i> Eliminar Proveedor
					</button>
					<button type="button" class="btn btn-warning"
						onclick="window.location.href='<%=request.getContextPath()%>/actualizarproveedor.jsp'">
						<i class="fas fa-pen-alt"></i> Actualizar Proveedor
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/buscarproveedor.jsp'">
						<i class="fas fa-search"></i> Buscar un Proveedor
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='<%=request.getContextPath()%>/listaproveedores.jsp'">
						<i class="fas fa-search"></i> Listar todos los Proveedores
					</button>
				</div>
			</div>
		</div>

	</div>
	<nav class="navbar fixed-bottom navbar-light" >
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#">
					Dise�ado y programado por Equipo 5 Grupo 53 </a>
			</div>
		</div>
	</nav>
	<script>
	var geturl = window.location;
	var baseurl = geturl.protocol + "//" + geturl.host + "/" + geturl.pathname.split('/')[1];
		function eliminar() {
			var y = document.getElementById("nit_proveedor").value;
			var req = new XMLHttpRequest();
			var coincidencia = false;
			req.open('GET', baseurl+'/listarproveedores',false);
			req.send(null);
			var proveedores = null;
			if (req.status == 200)
				proveedores = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));

			for (i = 0; i < proveedores.length; i++) {
				
				console.log(proveedores[i].nit_proveedor);
				if (proveedores[i].nit_proveedor == y) {
					console.log(proveedores[i].nit_proveedor + " " + y);
					coincidencia = true;
					break;
				}
			}
			console.log(coincidencia);

			if (coincidencia != false) {
				var nit=document.getElementById("nit_proveedor").value;
				
				var xhr = new XMLHttpRequest();
				xhr.open("DELETE", baseurl+"/eliminarproveedor?nit="+nit);
				
				var element = document.getElementById("error");
				element.classList.add("visually-hidden");
				
				var element2 = document.getElementById("correcto");
				element2.classList.remove("visually-hidden");

				document.getElementById("nit_proveedor").value = "";
				xhr.send();

			} else {
				var element = document.getElementById("error");
				element.classList.remove("visually-hidden");
				
				var element2 = document.getElementById("correcto");
				element2.classList.add("visually-hidden");
				
				document.getElementById("nit_proveedor").value = "";;
			}
		}
	</script>

</body>
</html>