package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StatusProdutoDAO;
import entidades.StatusProduto;



@WebServlet("/ServletStatusProduto")
public class ServletStatusProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StatusProdutoDAO dao;
   
    public ServletStatusProduto() {
        super();
        dao = new StatusProdutoDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
			request.setAttribute("lista", dao.getListStatus());
		String option = request.getParameter("option");
		
		if(option.equals("insertfrm")) {
			request.getRequestDispatcher("cadastroStatusProduto.jsp").forward(request, response);		
		}else if (option.equals("updateForm")) {
			UpdateForm(request, response);
			
		} else if (option.equals("update")) {
			Update(request, response); 
			
		} else if (option.equals("delete")) {
			Delete(request, response);
		
		} else if (option.equals("insert")) {
		Insert(request, response);
		}
		request.setAttribute("lista", dao.getListStatus());
		request.getRequestDispatcher("statusProduto.jsp").forward(request, response);
	}

	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");	
		Integer id1 = Integer.parseInt(id);
		StatusProduto Buscar=  dao.buscarStatus(id1);
		request.setAttribute("statusProduto", Buscar);
		request.getRequestDispatcher("cadastroStatusProduto.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String descricao = request.getParameter("descricao");
	
		if ((descricao != null)) {
			if (!descricao.equals("")){
				dao = new StatusProdutoDAO();
				Integer id1 = Integer.parseInt(id);
				StatusProduto status1 = new StatusProduto(descricao);
				status1.setId(id1);
				dao.updateStatus(status1);		
			}
		} 		
	}

	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao.removeStatus(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				 StatusProduto status = new StatusProduto(descricao);
				 dao.addStatus(status);
			}
		}	
	}
	
}
