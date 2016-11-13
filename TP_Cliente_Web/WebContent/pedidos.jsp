<%@ page import="dto.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>

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

						<h2>Lista de Pedidos</h2>

							<h3>Pedidos</h3>
							<div class="fix"></div>
								<form action="./GenerarOC" method="post">
									<div class="form-actions">
										<input type="submit" value="Nuevo Pedido" />
									</div>
								</form>
							
							</div>
							<table border="1">
								<tbody>
									<tr>
										<th>idPedido</th>
										<th>idCliente</th>
										<th>idDireccionCarga</th>
										<th>idDireccionDestino</th>
										<th>fechaCarga</th>
										<th>horaInicio</th>
										<th>horaFin</th>
										<th>fechaMaxima</th>
										<th>precio</th>
										<th>sucursalOrigen</th>
										<th>sucursalDestino</th>
										<th>solicitaTransporteDirecto</th>
										<th>solicitaAvionetaParticular</th>
										<th></th>
									</tr>
									<%
									List <PedidoDTO> pedidos = (List <PedidoDTO>) request.getSession().getAttribute("pedidos");
							 		for (PedidoDTO pedido : pedidos) {
							 		
							 			
							        %>
									<tr>
										<td><%= pedido.getIdPedido() %></td>
										<td><%= pedido.getCliente().getIdCliente() %></td>
										<td><%= pedido.getDireccionCarga().getIdDireccion() %></td>
										<td><%= pedido.getDireccionDestino().getIdDireccion() %></td>
										<td><%= pedido.getFechaCarga() %></td>
										<td><%= pedido.getHoraInicio() %></td>
										<td><%= pedido.getHoraFin() %></td>
										<td><%= pedido.getFechaMaxima() %></td>
										<td><%= pedido.getPrecio() %></td>
										<td><%= pedido.getSucursalOrigen() %></td>
										<td><%= pedido.getSucursalDestino() %></td>
										<td><%= pedido.isSolicitaTransporteDirecto() %></td>
										<td><%= pedido.isSolicitaAvionetaParticular() %></td>
										<td><a
											href="verCargas.jsp?idPedido=<%=pedido.getIdPedido() %>"
											onClick="return popup(this, 'cargas')">Ver Cargas</a>
										</td>
										
										
									</tr>
									<% } %>
								</tbody>
							</table>
						</div>
	
	
						</div>

						<div class="fix"></div>
					</div>
				</div>
			</div>

			<div class="fix"></div>
		</div>
</body>
</html>