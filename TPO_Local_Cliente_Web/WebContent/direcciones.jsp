<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Direcciones | TPO AD </title>
<link href="./css/styles.css" rel="stylesheet" type="text/css" />
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet"
	type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#DireccionesTableContainer').jtable({
			title : 'Lista de Direcciones',
			actions : {
				listAction : 'CrudProveedor?action=list',
				createAction : 'CrudProveedor?action=create',
				updateAction : 'CrudProveedor?action=update',
				deleteAction : 'CrudProveedor?action=delete'
			},
			fields : {
				idProveedor : {
					title : 'id',
					width : '1%',
					key : true,
					list : true,
					edit : false,
					create : false
				},
				calle : {
					title : 'Calle',
					width : '5%',
					edit : true
				},
				numero : {
					title : 'Nro',
					width : '5%',
					edit : true
				},
				piso : {
					title : 'Piso',
					width : '5%',
					edit : true
				},
				depto : {
					title : 'Dto',
					width : '5%',
					edit : true
				},
				cp : {
					title : 'Cp',
					width : '5%',
					edit : true
				}				
			}
		});
		$('#DireccionesTableContainer').jtable('load');
	});
</script>

</head>
<body>
<div id="wrapper">

		<div id="header">
			<div class="col-full">
				<h1>TPO AD</h1>
			</div>
		</div>

		<div id="content-wrap">
			<div id="navigation" class="col-full">
				<ul id="main-nav" class="nav fl">
					<li><a href="index.jsp">Inicio</a></li>
					<li><a href="precioVehiculos.jsp">Precio de Vehículos</a></li>
					<li><a href="direcciones.jsp">Direcciones</a></li>
					<li><a href="proveedores.jsp">Proveedores</a></li>
					<li><a href="empresas.jsp">Empresas</a></li>
					<li><a href="particulares.jsp">Particulares</a></li>
					<li><a href="planesDeMantenimiento.jsp">Planes De Mantenimiento</a></li>
					<li><a href="vehiculos.jsp">Vehículos</a></li>
					<li><a href="cargas.jsp">Cargas</a></li>
					<li><a href="sucursales.jsp">Sucursales</a></li>
					<li><a href="rutas.jsp">Rutas</a></li>
					<li><a href="trayectos.jsp">Trayectos</a></li>
					<li><a href="./pedidos.jsp">Pedidos</a></li>
					<li><a href="viajes.jsp">Viajes</a></li>
					<li><a href="envios.jsp">Envíos</a></li>
					<li><a href="facturas.jsp">Facturas</a></li>
					<li><a href="remitos.jsp">Remitos</a></li>
					<li><a href="viajes.jsp">Viajes</a></li>
				</ul>
			</div>

			<div class="featured col-full feat-blog">
				<div class="feat-post">
					<div class="feat-content">
	
						<div class="entry">

							<div style="width: 100%; margin-right: 5%; margin-left: 5%;">
								<!-- <h4>AJAX based CRUD operations using jTable in Servlet and JSP</h4> -->
								<div id="DireccionesTableContainer"></div>
							</div>
							
	
	
						</div>

						<div class="fix"></div>
					</div>
				</div>
			</div>

			<div class="fix"></div>
		</div>
</div>
</body>
</html>