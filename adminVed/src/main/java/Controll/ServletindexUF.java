package Controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.PedidoDAO;


/**
 * Servlet implementation class ServletindexCarol
 */
@WebServlet("/ServletindexUF")
public class ServletindexUF extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PedidoDAO pedido;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletindexUF() {
        super();
       
        
       pedido = new PedidoDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String b = request.getParameter("uf"); 			
		request.setAttribute("totalUf",pedido.contarPedidoUF(Integer.parseInt(b)));
			
	
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}
	

}
