package Controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BandeiraDAO;
import entidades.Bandeira;


@WebServlet("/ServletBandeira")
public class ServletBandeira extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BandeiraDAO dao;

    public ServletBandeira() {
        super();
        dao = new BandeiraDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getlistBandeira());
		
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
		request.setAttribute("lista", dao.getlistBandeira());
		request.getRequestDispatcher("bandeira.jsp").forward(request, response);
	}
	
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroBandeira.jsp").forward(request, response);		
	}
	
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer id1 = Integer.parseInt(id);
		Bandeira Buscar =  dao.buscarBandeira(id1);
		request.setAttribute("bandeira", Buscar);
		request.getRequestDispatcher("cadastroBandeira.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String descricao = request.getParameter("nome_bandeira");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				dao = new BandeiraDAO();
				Integer id1 = Integer.parseInt(id);
				Bandeira bandeira = new Bandeira(descricao);
				bandeira.setId(id1);
				dao.updateMarca(bandeira);	
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new BandeiraDAO();
			dao.removeBandeira(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome_bandeira = request.getParameter("nome_bandeira");
		if ((nome_bandeira != null)) {
			if (!nome_bandeira.equals("")){
				 dao = new BandeiraDAO();
				 Bandeira bandeira = new Bandeira(nome_bandeira);
				 dao.addBandeira(bandeira);
			}
		}	
	}
	
}