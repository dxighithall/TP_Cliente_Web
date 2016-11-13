<%@ page import="dto.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Items Solicitud Cotizacion | TPO AD</title>
	<link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="wrapper">

		<div class="featured col-full feat-blog">
			<div class="feat-post">
				<div class="feat-content">

					<div class="entry">

						<h2>Lista de Cargas</h2>

						<h3>Cargas</h3>
						<table border="1">
							<tbody>
								<tr>
									<th>idCarga</th>
									<th>Alto</th>
									<th>Ancho</th>
									<th>Profundidad</th>
									<th>Volumen</th>
									<th>Apilable</th>
									<th>Condiciones</th>
									<th>Fragilidad</th>
									<th>Peso</th>
									<th>Tipo de Mercaderia</th>
									<th>Tratamiento</th>
								</tr>
								<%
	   	List <PedidoDTO> pedidos = (List <PedidoDTO>) request.getSession().getAttribute("pedidos");
 		Iterator <PedidoDTO> it = pedidos.iterator();
 		boolean encontrado = false;
 		PedidoDTO pedido = null;
 		while (it.hasNext() && !encontrado) {
 			pedido = it.next();
 			if (String.valueOf(pedido.getIdPedido()).equals(request.getParameter("idPedido")))
 				encontrado = true;
		}
 		
 		for (CargaDTO c : pedido.getCargas()) {
        	%>
								<tr>
									<td><%= c.getIdCarga() %></td>
									<td><%= c.getAncho() %></td>
									<td><%= c.getAlto() %></td>
									<td><%= c.getProfundidad() %></td>
									<td><%= c.getVolumen() %></td>
									<td><%= c.getApilable() %></td>
									<td><%= c.getCondiciones() %></td>
									<td><%= c.getFragilidad() %></td>
									<td><%= c.getPeso() %></td>
									<td><%= c.getTipoMercaderia() %></td>
									<td><%= c.getTratamiento() %></td>
									
								</tr>
								<% } %>
							</tbody>
						</table>
					</div>
					<div class="fix"></div>
				</div>
			</div>
		</div>

		<div class="fix"></div>
	</div>

</body>
</html>