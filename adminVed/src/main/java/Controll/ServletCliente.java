package Controll;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;



@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO dao;
       

    public ServletCliente() {
        super();
        dao = new ClienteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lista", dao.getListCliente());
		String option = request.getParameter("option");
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
		} else if(option.equals("informacao")) {
			Informacao(request, response);					
		}else {
		request.setAttribute("lista", dao.getListCliente());
		request.getRequestDispatcher("listaCliente.jsp").forward(request, response); 
		}
	}
	
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lista", dao.getListCliente());
		request.getRequestDispatcher("listaCliente.jsp").forward(request, response);	
	}
	
	protected void Informacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");		
		Integer id1 = Integer.parseInt(id);
		request.setAttribute("listaCartao", dao.Cartao(id1));
		request.setAttribute("listaEndereco", dao.Endereco(id1));
		request.setAttribute("listaPedido1", dao.getPedidoCliente(id1));
		request.setAttribute("listaCliente", dao.Cliente(id1)); 
//		request.setAttribute(id, id1);
		request.getRequestDispatcher("relacaoCliente.jsp").forward(request, response);	
	}
}