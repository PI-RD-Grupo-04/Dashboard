package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDAO;




@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoDAO dao;
        
 
    public ServletPedido() {
        super();
        dao = new PedidoDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
	
		if(option.equals("insertForm")) {
			InsertForm(request, response);
		}  else if(option.equals("informacao")) {
			Informacao(request, response);					
		} 
		
		request.setAttribute("lista", dao.getListPedido());
		request.getRequestDispatcher("listaPedido.jsp").forward(request, response);
		
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lista", dao.getListPedido());
		request.getRequestDispatcher("listaPedido.jsp").forward(request, response);	
	}

	protected void Informacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pedido = Integer.parseInt( request.getParameter("id"));
		request.setAttribute("Pedido", dao.relacaoPedido(pedido));
		request.setAttribute("ListaProduto", dao.Lista(pedido));
		request.getRequestDispatcher("relacaopedido.jsp").forward(request, response);	
	
	}
	
}
