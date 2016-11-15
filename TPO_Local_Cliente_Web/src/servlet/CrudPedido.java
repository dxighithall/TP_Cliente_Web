package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import Negocio.Administrador;
import dto.ClienteDTO;
import dto.DireccionDTO;
import dto.EmpresaDTO;
import dto.PedidoDTO;


public class CrudPedido extends HttpServlet {
private static final long serialVersionUID = 1L;


public CrudPedido() {
}

protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
}

protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

String action = request.getParameter("action");

List<PedidoDTO> list = Administrador.getInstance().obtenerPedidos();
Gson gson = new Gson();
response.setContentType("application/json");

if (action != null) {
	if (action.equals("list")) {
	try {
		// 
		//list = Administrador.getInstance().listarClientesEmpresa();
		// Convert Java Object to Json
		
		JsonElement element = gson.toJsonTree(list,
				new TypeToken<List<PedidoDTO>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		String listData = jsonArray.toString();

		// Return Json in the format required by jTable plugin
		listData = "{\"Result\":\"OK\",\"Records\":" 
		+ listData + "}";
		response.getWriter().print(listData);
		} catch (Exception e) {
			String error = "{\"Result\":\"ERROR\",\"Message\":"
					+ "Exception on listing records }";
			response.getWriter().print(error);
			System.err.println(e.getMessage());
		}
	} else if (action.equals("create") || action.equals("update")) {
		//Student student = new Student();
		PedidoDTO pedido=new PedidoDTO();
		if (request.getParameter("idPedido") != null) {
			int idPedido = Integer.parseInt(request.getParameter("idPedido"));
			pedido.setIdPedido(idPedido);
			}
		
		if (request.getParameter("idCliente") != null) {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		ClienteDTO c=new ClienteDTO();
		c.setIdCliente(idCliente); 
		pedido.setCliente(c);
		}

		if (request.getParameter("idDireccionCarga") != null) {
			int idDireccion =  Integer.parseInt(request.getParameter("idDireccionCarga"));
			DireccionDTO dC=new DireccionDTO();
			dC.setIdDireccion(idDireccion);
			pedido.setDireccionCarga(dC);
		}
		if (request.getParameter("idDireccionDestino") != null) {
			int idDireccionD =  Integer.parseInt(request.getParameter("idDireccionDestino"));
			DireccionDTO dD=new DireccionDTO();
			dD.setIdDireccion(idDireccionD);
			pedido.setDireccionCarga(dD);
		}
		if (request.getParameter("fechaCarga") != null) {
			String[] fechaC= request.getParameterValues("fechaCarga");
			//pedido.setFechaCarga(fechaC);
		}
		if (request.getParameter("horaInicio") != null) {
			int horaInicio = Integer.valueOf(request.getParameter("horaInicio"));
			pedido.setHoraInicio(horaInicio);
		}
		if (request.getParameter("horaFin") != null) {
			int horaFin = Integer.valueOf(request.getParameter("horaFin"));
			pedido.setHoraFin(horaFin);
		}
		if (request.getParameter("fechaMaxima") != null) {
			String fechaMaxima = request.getParameter("fechaMaxima");
			//pedido.setFechaCarga(fechaMaxima);
		}
		if (request.getParameter("precio") != null) {
			float precio = Float.parseFloat(request.getParameter("precio"));
			pedido.setPrecio(precio);
		}
		if (request.getParameter("sucursalOrigen") != null) {
			String sucO = request.getParameter("sucursalOrigen");
			pedido.setSucursalOrigen(sucO);
		}
		if (request.getParameter("sucursalDestino") != null) {
			String sucursalDestino = request.getParameter("sucursalDestino");
			pedido.setSucursalDestino(sucursalDestino);
		}
		if (request.getParameter("solicitaTransporteDirecto") != null) {
			//boolean solicitaTransporteDirecto = ("solicitaTransporteDirecto");
			//pedido.setSolicitaTransporteDirecto(solicitaTransporteDirecto);
		}
		if (request.getParameter("solicitaAvionetaParticular") != null) {
			//boolean solicitaAvionetaParticular = request.getParameter("solicitaAvionetaParticular");
			//pedido.setSolicitaAvionetaParticular(solicitaAvionetaParticular);
		}
		
		try {
			if (action.equals("create")) {
				// Create new record
				//Administrador.getInstance()
				// Convert Java Object to Json
				String json = gson.toJson(pedido);
				// Return Json in the format required by jTable plugin
				String listData = "{\"Result\":\"OK\",\"Record\":"
						+ json + "}";
				response.getWriter().print(listData);
			} else if (action.equals("update")) {
				// Update existing record
				//Administrador.getInstance().updatePedido(pedido);

				// Convert Java Object to Json
				String json = gson.toJson(pedido);
				String listData = "{\"Result\":\"OK\",\"Record\":"
						+ json + "}";
				response.getWriter().print(listData);
			}
		} catch (Exception e) {
			String error = "{\"Result\":\"ERROR\",\"Message\":"
					+ "Exception in creating records }";
			response.getWriter().print(error);
			System.err.println(e.getMessage());
		}

	} else if (action.equals("delete")) {
		try {
			// Delete record
			if (request.getParameter("idPedido") != null) {
				int idPedido = Integer.parseInt(request
						.getParameter("idPedido"));
				//Administrador.getInstance().deletePedido(pedido);
				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			}
		} catch (Exception e) {
			String error = "{\"Result\":\"ERROR\",\"Message\":"
					+" Exception in deleting records }";
			response.getWriter().print(error);
			System.err.println(e.getMessage());
		}
	}else if (action.equals("obtener")) {
		/*try {
			// 
			//list = Administrador.getInstance().listarClientesEmpresa();
			// Convert Java Object to Json
			List<ClienteDTO> listC=Administrador.getInstance().listarClientes();
			JsonElement element = gson.toJsonTree(listC,	new TypeToken<List<ClienteDTO>>() {}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			String listData = jsonArray.toString();

			// Return Json in the format required by jTable plugin
			listData = "{\"Result\":\"OK\",\"Records\":" 
			+ listData + "}";
			response.getWriter().print(listData);
			} catch (Exception e) {
				String error = "{\"Result\":\"ERROR\",\"Message\":"
						+ "Exception on listing records }";
				response.getWriter().print(error);
				System.err.println(e.getMessage());
			}*/
		/*try {
			 System.out.println("I came to action getClassID");
		        List<String> lstClassID = new ArrayList<String>();
		    //Here i am able to get the List containing classID
		        //lstClassID = GetClassList();
		        JsonElement element = gson.toJsonTree(lstClassID , new TypeToken<List<String>>() {
		        }.getType());
		        JsonArray jsonArray = element.getAsJsonArray();
		        String listData = jsonArray.toString();
		        // Return Json in the format required by jTable plugin
		        listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
		        response.getWriter().print(listData );
		        //return jsonArray;
		} catch (Exception e) {
			String error = "{\"Result\":\"ERROR\",\"Message\":"
					+" Exception in deleting records }";
			response.getWriter().print(error);
			System.err.println(e.getMessage());
		}*/
		/*try {

	        // Your java method fetch Status_id and Status_Value 
	        // (I've used collections map for mapping name with ID)
	        List<ClienteDTO> status = Administrador.getInstance().obtenerClientes();// Your_Part_Here (Maybe dao.fetchStatus() like this)

	        // Convert Java Object to Json
	        String json = gson.toJson(status);
	        response.getWriter().print(json);

	    } catch (Exception e) {
	        String error = "{\"Result\":\"ERROR\",\"Message\":" + e.getMessage() + "}";
	        response.getWriter().print(error);
	    }*/
	}
}
}
}