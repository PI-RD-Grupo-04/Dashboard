package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FornecedorDAO;
import entidades.Fornecedor;


@WebServlet("/ServletFornecedor")
public class ServletFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FornecedorDAO dao;
   
    public ServletFornecedor() {
        super();
        dao = new FornecedorDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getListFornecedor());
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
		
		request.setAttribute("lista", dao.getListFornecedor());
		request.getRequestDispatcher("fornecedor.jsp").forward(request, response);		
			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroFornecedor.jsp").forward(request, response);		
	}
	

	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		Fornecedor Buscar=  dao.buscarFornecedor(id1);
		request.setAttribute("fornecedor", Buscar);
		request.getRequestDispatcher("cadastroFornecedor.jsp").forward(request, response);		
	}
	
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String razao_social = request.getParameter("razao_social");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
	
		if ((razao_social!= null) && (cnpj != null) && (email != null)) {
			if (!razao_social.equals("")){
				dao = new FornecedorDAO();
				Integer id1 = Integer.parseInt(id);
				Fornecedor fornecedor1 = new Fornecedor(razao_social, cnpj, email);
				fornecedor1.setId(id1);
				dao.updateFornecedor(fornecedor1);		
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new FornecedorDAO();
			dao.removeFornecedor(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String razao_social = request.getParameter("razao_social");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");

		
		if ((razao_social!= null) && (cnpj != null) && (email != null)) {
			if (!razao_social.equals("")){
				 dao = new FornecedorDAO();
				 Fornecedor fornecedor = new Fornecedor(razao_social, cnpj, email);
				 dao.addFornecedor(fornecedor);
			}
		}	
	}
	
}
