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
import dto.ParticularDTO;


public class CrudClienteParticular extends HttpServlet {
private static final long serialVersionUID = 1L;


public CrudClienteParticular() {
}

protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
}

protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

String action = request.getParameter("action");

List<ParticularDTO> list = Administrador.getInstance().listarClientesParticular();
Gson gson = new Gson();
response.setContentType("application/json");

if (action != null) {
	if (action.equals("list")) {
	try {
		// 
		//list = Administrador.getInstance().listarClientesEmpresa();
		// Convert Java Object to Json
		JsonElement element = gson.toJsonTree(list,
				new TypeToken<List<ParticularDTO>>() {}.getType());
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
		ParticularDTO particular=new ParticularDTO();
		if (request.getParameter("idCliente") != null) {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		particular.setIdCliente(idCliente);;
		}

		if (request.getParameter("nombre") != null) {
			String nombre = request.getParameter("nombre");
			particular.setNombre(nombre);
		}
		if (request.getParameter("DNI") != null) {
			int DNI = Integer.parseInt(request.getParameter("DNI"));
			particular.setDNI(DNI);
		}
		if (request.getParameter("apellido") != null) {
			String apellido = request.getParameter("apellido");
			particular.setApellido(apellido);
		}
		
		try {
			if (action.equals("create")) {
				// Create new record
				Administrador.getInstance().altaClienteParticular(particular);
				// Convert Java Object to Json
				String json = gson.toJson(particular);
				// Return Json in the format required by jTable plugin
				String listData = "{\"Result\":\"OK\",\"Record\":"
						+ json + "}";
				response.getWriter().print(listData);
			} else if (action.equals("update")) {
				// Update existing record
				Administrador.getInstance().updateClienteParticular(particular);

				// Convert Java Object to Json
				String json = gson.toJson(particular);
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
				Administrador.getInstance().deleteClienteParticular(idCliente);
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