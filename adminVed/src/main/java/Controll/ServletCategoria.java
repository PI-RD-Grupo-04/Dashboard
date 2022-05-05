package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import entidades.Categoria;


@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoriaDAO dao;
   
    public ServletCategoria() {
        super();
        dao = new CategoriaDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getListCategoria());
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
		request.setAttribute("lista", dao.getListCategoria());
		request.getRequestDispatcher("categoria.jsp").forward(request, response);			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroCategoria.jsp").forward(request, response);		
	}
	
	
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		Categoria Buscar=  dao.buscarCategoria(id1);
		request.setAttribute("categoria", Buscar);
		request.getRequestDispatcher("cadastroCategoria.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String descricao = request.getParameter("descricao");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				dao = new CategoriaDAO();
				Integer id1 = Integer.parseInt(id);
				Categoria Categoria1 = new Categoria(descricao);
				Categoria1.setId(id1);
				dao.updateCategoria(Categoria1);		
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new CategoriaDAO();
			dao.removeCategoria(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				 dao = new CategoriaDAO();
				 Categoria categoria = new Categoria(descricao);
				 dao.addCategoria(categoria); 
				 
			}
		}		
	}	
}
