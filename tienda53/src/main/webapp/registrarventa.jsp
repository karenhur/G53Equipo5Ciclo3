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

<script>
    window.onload = function() {
        var req = new XMLHttpRequest();
        req.open('GET', 'http://localhost:8080/contadorventa', false);
        req.send(null);
        var cont = null;
        if (req.status == 200)
            cont = JSON.parse(req.responseText);
        console.log(cont.toString());
        
        document.getElementById("consecutivo").value=cont;
        
    };
</script>

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

	<div style="padding-left: 20px">
		<h1>
			<i class="fas fa-search"></i> Nueva venta
		</h1>
	</div>
	<br>
	<div class="ventas1">
		<div id="error" class="alert alert-danger visually-hidden"
			role="alert">Error al buscar el cliente, el cliente no existe</div>

		<div id="correcto" class="alert alert-success visually-hidden"
			role="alert">Cliente encontrado con exito</div>

        <div id="errorv" class="alert alert-danger visually-hidden"
			role="alert">Error al confirmar venta</div>

		<div id="correctov" class="alert alert-success visually-hidden"
			role="alert">Venta registrada con exito</div>
			
		<form id="form1">

			<div class="input-group mb-3">
				<div class="col-lg-1">
					<span class="input-group-text" id="basic-addon4">Cliente a
						buscar</span>
				</div>
				<div class="col-lg-1">
					<input type="text" class="form-control"
						placeholder="Inserte cedula aqui..."
						aria-describedby="basic-addon1" required id="cedulasearch">
				</div>
				<div class="col-lg-1">
					<button type="button" class="btn btn-primary" onclick="enviar()">
						<i class="fas fa-search"></i> Buscar
					</button>
				</div>

				<div class="col-lg-1">
					<span class="input-group-text" id="basic-addon2">Nombre
						completo</span>
				</div>
				<div class="col-lg-2">
					<input type="text" class="form-control"
						aria-describedby="basic-addon2" required id="nombre_cliente1"
						disabled="disabled">
				</div>
				<div class="col-lg-1">
					<span class="input-group-text ms-3" id="basic-addon4">Cedula
						Usuario</span>
				</div>
				<div class="col-lg-1">
					<input type="text" class="form-control"
						placeholder="Inserte cedula aqui..."
						aria-describedby="basic-addon1" required id="cedulausuario">
				</div>
				<div class="col-lg-1">
					<span class="input-group-text ms-3" id="basic-addon2">Consec</span>
				</div>
				<div class="col-lg-1">
					<input type="text" class="form-control"
						aria-describedby="basic-addon2" required id="consecutivo"
						disabled="disabled">
				</div>

			</div>
		</form>
	</div>
	<!-- ----------------------------------------------- ESPACIO 1 --------------------------------------------------------------------- -->
	<div class="ventas2">
	
	  <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
      <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
      <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
      </symbol>
      <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
      <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
      </symbol>
      </svg>
	
		<div id="error1" class="alert alert-danger d-flex align-items-center visually-hidden col-lg-1" 
		role="alert">
         <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" 
         aria-label="Danger:">
         <use xlink:href="#exclamation-triangle-fill"/></svg>
        </div>	

		<div id="correcto1" class="alert alert-success d-flex align-items-center visually-hidden col-lg-1"
			role="alert">
			<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
				aria-label="Success:">
				<use xlink:href="#check-circle-fill" /></svg>
		</div>		
		

	<div class="input-group mb-3">
		<div class="col-lg-1">
			<span class="input-group-text" id="basic-addon4">Código</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control" placeholder="Inserte código"
				aria-describedby="basic-addon1" required id="codigosearch1">
		</div>
		<div class="col-lg-1">
			<button type="button" class="btn btn-primary"
				onclick="enviarproducto1()">
				<i class="fas fa-search"></i> Buscar
			</button>
		</div>
		
			
		<div class="col-lg-1">
			<span class="input-group-text" id="basic-addon2">Producto</span>
		</div>
		<div class="col-lg-2">
			<input type="text" class="form-control"
				aria-describedby="basic-addon2" required id="producto1"
				disabled="disabled">
		</div>
		<div class="col-lg-1 ms-2">
			<span class="input-group-text" id="basic-addon4">Cantidad</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control"
				placeholder="Inserte cantidad" aria-describedby="basic-addon1"
				required id="cantidad1" oninput="calculate1()">
		</div>
		<div class="col-lg-1 ms-2">
			<span class="input-group-text" id="basic-addon2">Valor total</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control"
				aria-describedby="basic-addon2" required id="valor_total1"
				disabled="disabled">
		</div>

	</div>

	<!-- -------------------------------------------------ESPACIO 2 ------------------------------------------------------------------- -->
	<div class="input-group mb-3">
		<div class="col-lg-1">
			<span class="input-group-text" id="basic-addon4">Código</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control" placeholder="Inserte código"
				aria-describedby="basic-addon1" required id="codigosearch2">
		</div>
		<div class="col-lg-1">
			<button type="button" class="btn btn-primary"
				onclick="enviarproducto2()">
				<i class="fas fa-search"></i> Buscar
			</button>
		</div>
		<div class="col-lg-1">
			<span class="input-group-text" id="basic-addon2">Producto</span>
		</div>
		<div class="col-lg-2">
			<input type="text" class="form-control"
				aria-describedby="basic-addon2" required id="producto2"
				disabled="disabled">
		</div>
		<div class="col-lg-1 ms-2">
			<span class="input-group-text" id="basic-addon4">Cantidad</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control"
				placeholder="Inserte cantidad" aria-describedby="basic-addon1"
				required id="cantidad2" oninput="calculate2()">
		</div>
		<div class="col-lg-1 ms-2">
			<span class="input-group-text" id="basic-addon2">Valor total</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control"
				aria-describedby="basic-addon2" required id="valor_total2"
				disabled="disabled" >
		</div>

	</div>
	<!-- ---------------------------------------------------ESPACIO 3 ----------------------------------------------------------------- -->
	<div class="input-group mb-3">
		<div class="col-lg-1">
			<span class="input-group-text" id="basic-addon4">Código</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control" placeholder="Inserte código"
				aria-describedby="basic-addon1" required id="codigosearch3">
		</div>
		<div class="col-lg-1">
			<button type="button" class="btn btn-primary"
				onclick="enviarproducto3()">
				<i class="fas fa-search"></i> Buscar
			</button>
		</div>
		<div class="col-lg-1">
			<span class="input-group-text" id="basic-addon2">Producto</span>
		</div>
		<div class="col-lg-2">
			<input type="text" class="form-control"
				aria-describedby="basic-addon2" required id="producto3"
				disabled="disabled">
		</div>
		<div class="col-lg-1 ms-2">
			<span class="input-group-text" id="basic-addon4">Cantidad</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control"
				placeholder="Inserte cantidad" aria-describedby="basic-addon1"
				required id="cantidad3" oninput="calculate3()">
		</div>
		<div class="col-lg-1 ms-2">
			<span class="input-group-text" id="basic-addon2">Valor total</span>
		</div>
		<div class="col-lg-1">
			<input type="text" class="form-control"
				aria-describedby="basic-addon2" required id="valor_total3"
				disabled="disabled">
		</div>

	</div>
	</div>
	<!-- --------------------------------------------------- OPCIONES ----------------------------------------------------------------- -->
	<div class="opciones1">
		<div class="input-group mb-3" id="tv">
			<div class="col-lg-2">
				<span class="input-group-text" id="basic-addon2">Total venta</span>
			</div>
			<div class="col-lg-2">
				<input type="text" class="form-control"
					aria-describedby="basic-addon2" required id="totalventa"
					disabled="disabled">
			</div>

		</div>
	</div>

	<div class="opciones1">
		<div class="input-group mb-3">
			<div class="col-lg-2">
				<span class="input-group-text" id="basic-addon2">Total IVA</span>
			</div>
			<div class="col-lg-2">
				<input type="text" class="form-control"
					aria-describedby="basic-addon2" required id="valoriva"
					disabled="disabled">
			</div>

		</div>
	</div>
	<div class="opciones2">
		<div>
			<div class="input-group mb-3">

				<div class="col-lg-2">
					<span class="input-group-text ms-3" id="basic-addon2">Total
						con IVA</span>
				</div>
				<div class="col-lg-2">
					<input type="text" class="form-control"
						aria-describedby="basic-addon2" required id="valortotal"
						disabled="disabled">
				</div>

			</div>
		</div>
	</div>
	<div class="input-group mb-3">
	<div class="opciones1">
		<button type="button" class="btn btn-success"
			onclick="confirmarventa()">
			<i class="far fa-check-circle"></i> Confirmar Venta
		</button>
	</div>
	

	<div class="ms-5">
    <button type="button" class="btn btn-warning"
		onclick="window.location.reload();">
	<i class="fas fa-sync-alt"></i> Nueva venta
	</button>

   
        </div>




	<nav class="navbar fixed-bottom navbar-light">
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#"> Diseñado y programado
					por Equipo 5 Grupo 53 </a>
			</div>
		</div>
	</nav>
	<script>
		function enviar() {

			var req = new XMLHttpRequest();
			var coincidencia = false;
			var user = document.getElementById("cedulasearch").value;
			req.open('GET', 'http://localhost:8080/consultarcliente?cedula='
					+ user, false);
			req.send(null);
			var cliente = null;
			if (req.status == 200)
				cliente = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));

			var element = document.getElementById("error");
			element.classList.add("visually-hidden");
			var element2 = document.getElementById("correcto");
			element2.classList.remove("visually-hidden");

			console.log(cliente.toString());

			if (cliente.toString() != "") {

				document.getElementById("nombre_cliente1").value = cliente[0].nombre_cliente;

			} else {
				var element = document.getElementById("error");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correcto");
				element2.classList.add("visually-hidden");
				document.getElementById("nombre_cliente1").value = "";

			}
		}

		function enviarproducto1() {

			var req = new XMLHttpRequest();
			var coincidencia = false;
			var user = document.getElementById("codigosearch1").value;
			req.open('GET', 'http://localhost:8080/consultarproducto?code='
					+ user, false);
			req.send(null);
			var producto = null;
			if (req.status == 200)
				producto = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));

			var element = document.getElementById("error1");
			element.classList.add("visually-hidden");
			var element2 = document.getElementById("correcto1");
			element2.classList.remove("visually-hidden");

			console.log(producto.toString());

			if (producto.toString() != "") {

				document.getElementById("producto1").value = producto[0].nombre_producto;

			} else {
				var element = document.getElementById("error1");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correcto1");
				element2.classList.add("visually-hidden");
				document.getElementById("producto").value = "";

			}

		}

		function calculate1() {

			var req = new XMLHttpRequest();
			var coincidencia = false;
			var user = document.getElementById("codigosearch1").value;
			req.open('GET', 'http://localhost:8080/consultarproducto?code='
					+ user, false);
			req.send(null);
			var producto = null;
			if (req.status == 200)
				producto = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));
			var valorunitario = parseFloat(producto[0].precio_venta);

			var cantidad1 = parseFloat(document.getElementById("cantidad1").value);
			var total = valorunitario * cantidad1;
			console.log(total);
			document.getElementById("valor_total1").value = total;
			
			sumartotal();

		}

		function enviarproducto2() {

			var req = new XMLHttpRequest();
			var coincidencia = false;
			var user = document.getElementById("codigosearch2").value;
			req.open('GET', 'http://localhost:8080/consultarproducto?code='
					+ user, false);
			req.send(null);
			var producto = null;
			if (req.status == 200)
				producto = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));

			var element = document.getElementById("error1");
			element.classList.add("visually-hidden");
			var element2 = document.getElementById("correcto1");
			element2.classList.remove("visually-hidden");

			console.log(producto.toString());

			if (producto.toString() != "") {
				document.getElementById("producto2").value = producto[0].nombre_producto;
			} else {
				var element = document.getElementById("error1");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correcto1");
				element2.classList.add("visually-hidden");
				document.getElementById("producto").value = "";
			}
		}

		function calculate2() {

			var req = new XMLHttpRequest();
			var coincidencia = false;
			var user = document.getElementById("codigosearch2").value;
			req.open('GET', 'http://localhost:8080/consultarproducto?code='
					+ user, false);
			req.send(null);
			var producto = null;
			if (req.status == 200)
				producto = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));
			var valorunitario = parseFloat(producto[0].precio_venta);
			var cantidad2 = parseFloat(document.getElementById("cantidad2").value);
			var total = valorunitario * cantidad2;
			console.log(total);
			document.getElementById("valor_total2").value = total;
			
			sumartotal();

		}

		function enviarproducto3() {

			var req = new XMLHttpRequest();
			var coincidencia = false;
			var user = document.getElementById("codigosearch3").value;
			req.open('GET', 'http://localhost:8080/consultarproducto?code='
					+ user, false);
			req.send(null);
			var producto = null;
			if (req.status == 200)
				producto = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));

			var element = document.getElementById("error1");
			element.classList.add("visually-hidden");
			var element2 = document.getElementById("correcto1");
			element2.classList.remove("visually-hidden");

			console.log(producto.toString());

			if (producto.toString() != "") {
				document.getElementById("producto3").value = producto[0].nombre_producto;
			} else {
				var element = document.getElementById("error1");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correcto1");
				element2.classList.add("visually-hidden");
				document.getElementById("producto").value = "";
			}
		}

		function calculate3() {

			var req = new XMLHttpRequest();
			var coincidencia = false;
			var user = document.getElementById("codigosearch3").value;
			req.open('GET', 'http://localhost:8080/consultarproducto?code='
					+ user, false);
			req.send(null);
			var producto = null;
			if (req.status == 200)
				producto = JSON.parse(req.responseText);
			console.log(JSON.parse(req.responseText));
			var valorunitario = parseFloat(producto[0].precio_venta);
			var cantidad3 = parseFloat(document.getElementById("cantidad3").value);
			var total = valorunitario * cantidad3;
			console.log(total);
			document.getElementById("valor_total3").value = total;

			sumartotal();
		}

		function sumartotal() {
			
			var valor_total1 = document.getElementById("valor_total1").value;
			if (valor_total1 == "") {
				valor_total1=0.0;
			}
			var valor_total2 = document.getElementById("valor_total2").value;
			if (valor_total2 == "") {
				valor_total2=0.0;
			}
			
			var valor_total3 = document.getElementById("valor_total3").value;
			if (valor_total3 == "") {
				valor_total3=0.0;
			}
			
			
			valorglobal = parseFloat(valor_total1) +parseFloat(valor_total2) + parseFloat(valor_total3);
			console.log(valorglobal);
			document.getElementById("totalventa").value = valorglobal;

			var valoriva = valorglobal * 0.19;
			document.getElementById("valoriva").value = valoriva;
			var valortotal = valorglobal + valoriva;
			document.getElementById("valortotal").value = valortotal;
		}

		function confirmarventa() {
			
			try {

			var formData = new FormData();
			//formData.append("codigo_venta","null");
			formData.append("codigo_venta", document.getElementById("consecutivo").value);
			formData.append("cedula_cliente", document.getElementById("cedulasearch").value);
			formData.append("cedula_usuario", document.getElementById("cedulausuario").value);
			formData.append("ivaventa",document.getElementById("valoriva").value);
			formData.append("total_venta", document.getElementById("totalventa").value);
			formData.append("valor_venta", document.getElementById("valortotal").value);
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "http://localhost:8080/registrarventa");
			xhr.send(formData);
			
			setTimeout(
					
					function() {
						for (i = 1; i < 4; i++) {
							var actual = document.getElementById(("valor_total" + i.toString()).value);
							if (actual == 0) {
								continue;
							} else {
								var formData2 = new FormData();
								//formData2.append("codigo_detalle_venta", );
								formData2.append("cantidad", document.getElementById(("cantidad" +i.toString())).value);
								formData2.append("codigo_producto", document.getElementById("codigosearch" +i.toString()).value);
								formData2.append("codigo_venta",document.getElementById("consecutivo").value);
								formData2.append("valor_total", document.getElementById("valor_total" +i.toString()).value);
								formData2.append("valor_venta",document.getElementById("valortotal").value);
								formData2.append("valoriva",document.getElementById("valoriva").value);
								var xhr2 = new XMLHttpRequest();
								xhr2.open("POST","http://localhost:8080/registrardetalleventa");
								xhr2.send(formData2);
							}

						}
						var element = document.getElementById("errorv");
			            element.classList.add("visually-hidden");
			            var element2 = document.getElementById("correctov");
			            element2.classList.remove("visually-hidden");
					}, 1500);

			} catch (error) {
				var element = document.getElementById("error");
				element.classList.remove("visually-hidden");
				var element2 = document.getElementById("correcto");
				element2.classList.add("visually-hidden");
			}

		}

			/*document.getElementById("cedulasearch").value = "";
			document.getElementById("nombre_cliente1").value = "";
			document.getElementById("cedulausuario").value = "";
			document.getElementById("cantidad1").value = "";
			document.getElementById("codigosearch1").value = "";
			document.getElementById("cantidad2").value = "";
			document.getElementById("codigosearch2").value = "";
			document.getElementById("cantidad3").value = "";
			document.getElementById("codigosearch3").value = "";
			document.getElementById("producto1").value = "";
			document.getElementById("producto2").value = "";
			document.getElementById("producto3").value = "";
			document.getElementById("valor_total1").value = "";
			document.getElementById("valor_total2").value = "";
			document.getElementById("valor_total3").value = "";
			document.getElementById("valoriva").value = "";
			document.getElementById("totalventa").value = "";
			document.getElementById("valortotal").value = "";*/
			

	</script>

</body>
</html>