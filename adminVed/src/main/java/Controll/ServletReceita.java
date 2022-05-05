package Controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReceitaDAO;
import entidades.Receita;


@WebServlet("/ServletReceita")
public class ServletReceita extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReceitaDAO dao;

    public ServletReceita() {
        super();
        dao = new ReceitaDAO(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getListReceita());
		String option = request.getParameter("option");
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
			
		}else if (option.equals("UpdateForm")) {
			UpdateForm(request, response);
			
		} else if (option.equals("update")) {
			Update(request, response); }
		
			else if (option.equals("delete")) {
			Delete(request, response);
		
		} else if (option.equals("insert")) {
			Insert(request, response);
			
		}				
		
		request.setAttribute("lista", dao.getListReceita());
		request.getRequestDispatcher("receita.jsp").forward(request, response);		
			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroReceita.jsp").forward(request, response);		
	}
	

	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		Receita Buscar=  dao.buscarReceita(id1);
		request.setAttribute("receita", Buscar);
		request.getRequestDispatcher("cadastroReceita.jsp").forward(request, response);		
	}
	
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_receita = request.getParameter("id");
		String ingredientes = request.getParameter("ingredientes");
		String preparo = request.getParameter("preparo");
		String titulo = request.getParameter("titulo");
		
		if (ingredientes!= null)  {
			if (!ingredientes.equals("")){
				dao = new ReceitaDAO();
				Integer id1 = Integer.parseInt(id_receita);
				Receita receita = new Receita(ingredientes, preparo, titulo);
				receita.setId_receita(id1);
				dao.updateReceita(receita);		
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new ReceitaDAO();
			dao.removeReceita(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ingredientes = request.getParameter("ingredientes");
		String preparo = request.getParameter("preparo");
		String titulo = request.getParameter("titulo");
	

		
		if ((ingredientes!= null) && (preparo != null) && (titulo != null)) {
			if (!ingredientes.equals("")){
				 dao = new ReceitaDAO();
				 Receita receita = new Receita(ingredientes, preparo, titulo);
				 dao.addReceita(receita);
			}
		}	
	}
	
}
