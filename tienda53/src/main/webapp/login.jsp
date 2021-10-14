<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width">
	<title>Login_tienda generica</title>
	<link href="style.css" rel="stylesheet" type="text/css" />
	
	<!-- bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	

	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	 crossorigin="anonymous">
</head>

<body>

	<nav class="navbar navbar-light" style="background-color: #cad46e;">
		<div class="container-fluid">
      <a class="navbar-brand" id="titulonavbar">
        <i class="fas fa-shopping-cart" item-width="30" item-height="24"></i>
        Tienda genérica 
    </a>
       
  </div>
</nav>

    <div class="login-box">
      <img class="avatar" src="cereza.jpg" alt="Logo Tienda Generica">
      <h1>Iniciar sesión <i class="fas fa-shopping-cart"></i></h1><br>
      
 	  <form>
        <!-- USERNAME -->
        <label for="inputuser"><i class="far fa-user"></i> Usuario</label> 
        <input type="text" id="inputuser"
        placeholder= "Ingresar Usuario">
		
         <!-- PASWORD -->
        <label for="pasword"><i class="fas fa-key"></i> Contraseña</label>
        <input type="password" id="inputpass" placeholder="Ingresar Contraseña">    

	<div style="margin: auto; text-align: center;">
	<button type="button" class="btn btn-primary" onclick="comparar()">
	<i class="fas fa-sign-in-alt"></i> Iniciar Sesión
	</button>
	<button type="button" class="btn btn-success" onclick="registrar()">
	<i class="fas fa-clipboard-list"></i> Registrarse
	</button>
	<div id="error" class="alert alert-secondary visually-hidden"
	role="alert">Usuario o contraseña incorrecta!</div>
	
	</div>


		
      </form>  	
      </div>
    
	<script>
		function comparar() {
			//trayendo texto de input de username
			
			var x = document.getElementById("inputuser").value;
			//trayendo texto de input de password
			
			var y = document.getElementById("inputpass").value;
			//url de la api 
			
			var baseurl = "http://localhost:8080/listarusuarios";
			//creando un objeto de manipulacion de solicitudes
			var xmlhttp = new XMLHttpRequest();
			//abriendo la api
			xmlhttp.open("GET", baseurl, true);
			//funcion interna que compara la información
			
			xmlhttp.onreadystatechange = function() {
				//si se obtiene un 200 (Conexion correcta)
				
				if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
					//convirtiendo JSON en variable javascrip
					var usuarios = JSON.parse(xmlhttp.responseText);
					
					//verificando uno por uno si existe ese usuario
					for (i = 0; i < usuarios.length; i++) {
						
						//imprimiendo en la consola del navegador pata verificar
						console.log(usuarios);
						console.log(x);
						console.log(usuarios[i].usuario);
						console.log(y);
						console.log(usuarios[i].password);
						
						//si el nombre coincide
						if (usuarios[i].usuario == x) {
							//si la clave coincide
							if (usuarios[i].password == y) {
								console.log("si");
								var element = document.getElementById("error");
								element.classList.add("visually-hidden");
								document.getElementById("inputuser").value = "";
								document.getElementById("inputpass").value = "";
								window.location.href = "listausuarios.jsp";
								return;
							} else {
								//si la clave NO coincide
								console.log("error clave");
								var element = document.getElementById("error");
								element.classList.add("visually-hidden");
								document.getElementById("inputuser").value = "";
								document.getElementById("inputpass").value = "";
								return;
							}
						}
					}
					//Si no existe el usuario
					console.log("no encontrado");
					
					//quitando la capacidad de ocultacion del error para mostrarlo
					var element = document.getElementById("error");
					element.classList.remove("visually-hidden");
					document.getElementById("inputuser").value = "";
					document.getElementById("inputpass").value = "";
					return;
				}
				
			};
			
			
			//ejecutando
			xmlhttp.send();
		}
		function registrar(){
			window.location.href = "insertarusuario.jsp";
			return;	
		}
		
	</script>
  </body>
</html>