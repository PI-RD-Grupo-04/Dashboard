package Controll;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.PedidoRecenteDAO;
import dao.ProdutoDAO;
import dao.UfDAO;
import entidades.Uf;

/**
 * Servlet implementation class ServletindexCarol
 */
@WebServlet("/ServletindexCarol")
public class ServletindexCarol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO produto;
	private ClienteDAO cliente;
	private PedidoDAO pedido;
	private UfDAO uf;
	private PedidoRecenteDAO pedidoRecente;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletindexCarol() {
		super();
		this.produto = new ProdutoDAO();
		this.pedidoRecente = new PedidoRecenteDAO();

		cliente = new ClienteDAO();
		pedido = new PedidoDAO();
		uf = new UfDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ufescolhida = request.getParameter("uf");
		String btn = request.getParameter("a");
		List<Uf> lista = uf.getUf(); //Aqui eu trouxe todas as listas
		
		if (btn != null && btn.equals("atualizar")) {
			if (ufescolhida != null) {
				if (ufescolhida.equals("t")) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					lista =  uf.getUf().stream().map(f -> { //stream percorre toda a lista, o map vai permitir a modifica��o dos objetos da lista
						if (f.getId() == Integer.parseInt(ufescolhida)) {
							f.setSelecionado(true);
						} else {
							f.setSelecionado(false);
						}
						return f;
					}).collect(Collectors.toList());
					request.setAttribute("listauf",lista);

					request.setAttribute("totalUf", pedido.contarPedidoUF(Integer.parseInt(ufescolhida)));

				}
			}
		}

		listas(request, response);
		request.setAttribute("listauf",lista);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void listas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("totalCadastrado", produto.contarProduto());
		request.setAttribute("contUsuario", cliente.contarUsuario());
		request.setAttribute("contPedido", pedido.contarPedido());
		request.setAttribute("contVenda", produto.TotalDeVendas());
		request.setAttribute("listaPedidoRecente", pedidoRecente.exibirPedidosRecentes());

	}

}