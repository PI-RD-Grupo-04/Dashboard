package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import entidades.Usuario;




@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO dao;
   
    public ServletUsuario() {
        super();
        dao = new UsuarioDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("usuario.jsp").forward(request, response);		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getListUsuario());
		String option = request.getParameter("option");
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
			
		}else if (option.equals("updateForm")) {
			UpdateForm(request, response);
			
		} else if (option.equals("update")) {
			Update(request, response); 
			
		} else if (option.equals("delete")) {
			Delete(request, response);
		
		} else if (option.equals("insert")) {
			Insert(request, response);
			
		}				
		
		request.setAttribute("lista", dao.getListUsuario());
		request.getRequestDispatcher("usuario.jsp").forward(request, response);		
			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);		
	}
	

	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		Usuario Buscar=  dao.buscarUsuario(id1);
		request.setAttribute("usuario", Buscar);
		request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);		
	}
	
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		//Boolean adm = Boolean.parseBoolean(request.getParameter("adm"));
	
		if ((nome!= null) && (email != null) && (senha != null)) {
			if (!nome.equals("")){
				dao = new UsuarioDAO();
				Integer id1 = Integer.parseInt(id);
				Usuario usuario1 = new Usuario(nome, email, senha);
				usuario1.setId(id1);
				dao.updateUsuario(usuario1);		
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new UsuarioDAO();
			dao.removeUsuario(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		//Boolean adm = Boolean.parseBoolean(request.getParameter("adm"));
		
		if ((nome!= null) && (email != null) && (senha != null)) {
			if (!nome.equals("")){
				 dao = new UsuarioDAO();
				 Usuario usuario = new Usuario(nome, email, senha);
				 dao.cadastroUsuario(usuario);
			}
		}	
	}
	
}
