<%@ page import="dto.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="Negocio.Administrador"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Pedidos | TPO AD </title>
<link href="./css/styles.css" rel="stylesheet" type="text/css" />
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#PedidoTableContainer').jtable({
			title : 'Lista de Pedidos',
			actions : {
				listAction : 'CrudPedido?action=list',
				createAction : 'CrudPedido?action=create',
				updateAction : 'CrudPedido?action=update',
				deleteAction : 'CrudPedido?action=delete'
			},
			fields : {
				idPedido : {
					title : 'idPedido',
					width : '1%',
					key : true,
					list : true,
					edit : false,
					create : false
				},
				idCliente : {
					title : 'idCliente',
					width : '11%',
					edit : true,
					create: true,
					list: false
					//options: ['1','2','3','4']
					//options: 'CrudPedido?action=obtener'
					//options: '@Url.Action("obtener")'
					/* list:false,
					options: function (data) {
				        if (data.source == 'list') {
				            //Return url of all cities for optimization. 
				            return 'Demo/GetCityOptions?countryId=0';
				        }
				        //This code runs when user opens edit/create form or changes country combobox on an edit/create form.
				        return 'CrudPedido?action=obtener' + data.dependedValues.CountryId;
				    } */
				},
				idDireccionCarga : {
					title : 'idDireccionCarga',
					width : '1%',
					edit : true
				},
				idDireccionDestino : {
					title : 'idDireccionDestino',
					width : '1%',
					edit : true
				},
				fechaCarga : {
					title : 'Fecha de Carga',
					width : '4%',
					type: 'date',
					displayFormat: 'dd-mm-yy',
					edit : true
				},
				horaInicio : {
					title : 'Hora Inicio',
					width : '2%',
					edit : true
				},
				horaFin : {
					title : 'Hora Fin',
					width : '2%',
					edit : true
				},
				fechaMaxima : {
					title : 'Fecha Máxima',
					width : '5%',
					type: 'date',
					displayFormat: 'dd-mm-yy',
					edit : true
				},
				sucursalOrigen : {
					title : 'sucursalOrigen',
					width : '5%',
					edit : true
				},
				sucursalDestino : {
					title : 'sucursalDestino',
					width : '5%',
					edit : true
				},
				solicitaTransporteDirecto : {
					title : 'solicitaTransporteDirecto',
					width : '5%',
					edit : true
				},
				solicitaAvionetaParticular : {
					title : 'solicitaAvionetaParticular',
					width : '5%',
					edit : true
				}
			}
		});
		$('#PedidoTableContainer').jtable('load');
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
					<li><a href="Pedido.jsp">Pedidos</a></li>
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
								<div id="PedidoTableContainer"></div>
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