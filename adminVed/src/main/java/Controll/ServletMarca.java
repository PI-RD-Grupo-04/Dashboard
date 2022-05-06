package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MarcaDAO;
import entidades.Marca;

@WebServlet("/ServletMarca")
public class ServletMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MarcaDAO dao;
   
    public ServletMarca() {
        super();
        dao = new MarcaDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getListMarca());
		
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
		request.setAttribute("lista", dao.getListMarca());
		request.getRequestDispatcher("marca.jsp").forward(request, response);
	}
	
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroMarca.jsp").forward(request, response);		
	}
	
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer id1 = Integer.parseInt(id);
		Marca Buscar=  dao.buscarMarca(id1);
		request.setAttribute("marca", Buscar);
		request.getRequestDispatcher("cadastroMarca.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String descricao = request.getParameter("descricao");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				dao = new MarcaDAO();
				Integer id1 = Integer.parseInt(id);
				Marca marca1 = new Marca(descricao);
				marca1.setId(id1);
				dao.updateMarca(marca1);	
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new MarcaDAO();
			dao.removeMarca(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				 dao = new MarcaDAO();
				 Marca marca = new Marca(descricao);
				 dao.addMarca(marca);
			}
		}	
	}
	
}