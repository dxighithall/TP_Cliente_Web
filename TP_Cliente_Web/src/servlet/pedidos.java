package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.Administrador;
import dto.CargaDTO;
import dto.PedidoDTO;

/**
 * Servlet implementation class verCotizaciones
 */
public class pedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pedidos() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <PedidoDTO> pedidos = Administrador.getInstance().obtenerPedidos();
		request.getSession().setAttribute("pedidos", pedidos);
		
 		for (PedidoDTO pedido : pedidos) {
 			System.out.println(pedido.getIdPedido());
 			System.out.println(pedido.getCliente().getIdCliente());
 			System.out.println(pedido.getDireccionCarga().getIdDireccion());
 			System.out.println(pedido.getDireccionDestino().getIdDireccion());
 			System.out.println(pedido.getFechaCarga());
 			System.out.println(pedido.getHoraInicio());
 			System.out.println(pedido.getHoraFin());
 			System.out.println(pedido.getFechaMaxima());
 			System.out.println(pedido.getPrecio());
 			System.out.println(pedido.getSucursalOrigen());
 			System.out.println(pedido.getSucursalDestino());
 			System.out.println(pedido.isSolicitaTransporteDirecto());
 			System.out.println(pedido.isSolicitaAvionetaParticular());
 			for (CargaDTO carga: pedido.getCargas()){
 				System.out.println(carga.getIdCarga());
 				System.out.println(carga.getAlto());
 				System.out.println(carga.getAncho());
 				System.out.println(carga.getProfundidad());
 				System.out.println(carga.getVolumen());
 				System.out.println(carga.getApilable());
 				System.out.println(carga.getCondiciones());
 				System.out.println(carga.getFragilidad());
 				System.out.println(carga.getPeso());
 				System.out.println(carga.getTipoMercaderia());
 				System.out.println(carga.getTratamiento());
 			}		
 		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("pedidos.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
