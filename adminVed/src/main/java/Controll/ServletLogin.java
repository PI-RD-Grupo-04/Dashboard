package Controll;

import java.io.IOException;

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
import dao.UsuarioDAO;
import entidades.Usuario;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO DAO;
    private ProdutoDAO produto;
    private ClienteDAO cliente;
    private PedidoDAO pedido;
    private UfDAO uf;
    private PedidoRecenteDAO pedidoRecente;

    public ServletLogin() {
        super();
        DAO = new UsuarioDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String opcao = request.getParameter("opcao");
		
	switch(opcao) {
	case ("Entrar"): 
		conferencia(request, response);
		break;
	case ("insert"): 
		Insert(request, response);
		break;
	case ("sair"): 
		request.getRequestDispatcher("index.jsp").forward(request, response);
		break;
	case ("frmLogin"): 
		request.getRequestDispatcher("produto.jsp").forward(request, response);
		break;
		default:			
	}

	
	}
	
	protected void conferencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(DAO.conferencia(email, senha) != null) {
			Usuario user = DAO.conferencia(email, senha); 
			request.getServletContext().setAttribute("nome", user.getNome()); 
			
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			request.getRequestDispatcher("ServletindexCarol").forward(request, response);
			
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if ((nome != null && !nome.equals("") ) && (email!= null  && !email.equals("")) && (senha!= null  && !senha.equals(""))) {
				Usuario user = new Usuario(email, senha, nome);
				DAO.cadastroUsuario(user);
			
		}	
	}	
	
	
	
}