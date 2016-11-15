package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import dto.EmpresaDTO;


public class CrudClienteEmpresa extends HttpServlet {
private static final long serialVersionUID = 1L;


public CrudClienteEmpresa() {
}

protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
}

protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

String action = request.getParameter("action");

List<EmpresaDTO> list = Administrador.getInstance().listarClientesEmpresa();
Gson gson = new Gson();
response.setContentType("application/json");

if (action != null) {
	if (action.equals("list")) {
	try {
		// 
		//list = Administrador.getInstance().listarClientesEmpresa();
		// Convert Java Object to Json
		JsonElement element = gson.toJsonTree(list,
				new TypeToken<List<EmpresaDTO>>() {}.getType());
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
		EmpresaDTO empresa=new EmpresaDTO();
		if (request.getParameter("idCliente") != null) {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		empresa.setIdCliente(idCliente);;
		}

		if (request.getParameter("nombre") != null) {
			String nombre = request.getParameter("nombre");
			empresa.setNombre(nombre);
		}
		if (request.getParameter("CUIT") != null) {
			int CUIT = Integer.parseInt(request.getParameter("CUIT"));
			empresa.setCUIT(CUIT);
		}
		if (request.getParameter("tipo") != null) {
			String tipo = request.getParameter("tipo");
			empresa.setTipo(tipo);
		}
		if (request.getParameter("detallePoliticas") != null) {
			String detallePoliticas = request.getParameter("detallePoliticas");
			empresa.setDetallePoliticas(detallePoliticas);
		}
		if (request.getParameter("saldoCuentaCorriente") != null) {
			float saldoCuentaCorriente = Float.parseFloat(request.getParameter("saldoCuentaCorriente"));
			empresa.setSaldoCuentaCorriente(saldoCuentaCorriente);
		}
		try {
			if (action.equals("create")) {
				// Create new record
				Administrador.getInstance().altaClienteEmpresa(empresa);
				// Convert Java Object to Json
				String json = gson.toJson(empresa);
				// Return Json in the format required by jTable plugin
				String listData = "{\"Result\":\"OK\",\"Record\":"
						+ json + "}";
				response.getWriter().print(listData);
			} else if (action.equals("update")) {
				// Update existing record
				Administrador.getInstance().updateClienteEmpresa(empresa);

				// Convert Java Object to Json
				String json = gson.toJson(empresa);
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
			if (request.getParameter("idCliente") != null) {
				int idCliente = Integer.parseInt(request
						.getParameter("idCliente"));
				Administrador.getInstance().deleteClienteEmpresa(idCliente);
				String listData = "{\"Result\":\"OK\"}";
				response.getWriter().print(listData);
			}
		} catch (Exception e) {
			String error = "{\"Result\":\"ERROR\",\"Message\":"
					+" Exception in deleting records }";
			response.getWriter().print(error);
			System.err.println(e.getMessage());
		}
	}
}
}
}