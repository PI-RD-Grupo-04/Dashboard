package Controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArmazenamentoDAO;
import entidades.Armazenamento;



@WebServlet("/ServletArmazenamento")
public class ServletArmazenamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private ArmazenamentoDAO dao;

    public ServletArmazenamento() {
        super();
        dao = new ArmazenamentoDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getlist());
		
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
		request.setAttribute("lista", dao.getlist());
		request.getRequestDispatcher("armazenamento.jsp").forward(request, response);
	}
	
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroArmazenamento.jsp").forward(request, response);		
	}
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer id1 = Integer.parseInt(id);
		Armazenamento Buscar =  dao.buscarArmazenamento(id1);
		request.setAttribute("armazenamento", Buscar);
		request.getRequestDispatcher("cadastroArmazenamento.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String descricao = request.getParameter("descricao_armazenamento");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				dao = new ArmazenamentoDAO();
				Integer id1 = Integer.parseInt(id);
				Armazenamento armazenamento = new Armazenamento(descricao);
				armazenamento.setId(id1);
				dao.updateMarca(armazenamento);	
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new ArmazenamentoDAO();
			dao.removeArmazenamento(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao_armazenamento = request.getParameter("descricao_armazenamento");
		if ((descricao_armazenamento != null)) {
			if (!descricao_armazenamento.equals("")){
				 dao = new ArmazenamentoDAO();
				 Armazenamento armazenamento = new Armazenamento(descricao_armazenamento);
				 dao.AddArmazenamento(armazenamento);
			}
		}	
	}
	
}
