package Controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CupomDescontoDAO;
import dao.ReceitaDAO;
import entidades.CupomDesconto;
import entidades.Receita;

@WebServlet("/ServletCupomDesconto")
public class ServletCupomDesconto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private CupomDescontoDAO dao;

    public ServletCupomDesconto() {
        super();
        dao = new CupomDescontoDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getListCupomDesconto());
		String option = request.getParameter("option");
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
			
		}else if (option.equals("UpdateForm")) {
			UpdateForm(request, response);
			
		} else if (option.equals("update")) {
			Update(request, response); 
			
		} else if (option.equals("delete")) {
			Delete(request, response);
		
		} else if (option.equals("insert")) {
			Insert(request, response);
			
		}				
		
		request.setAttribute("lista", dao.getListCupomDesconto());
		request.getRequestDispatcher("cupomDesconto.jsp").forward(request, response);		
			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroCupomDesconto.jsp").forward(request, response);		
	}
	

	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		CupomDesconto Buscar=  dao.buscarCupomDesconto(id1);
		request.setAttribute("cupomDesconto", Buscar);
		request.getRequestDispatcher("cadastroCupomDesconto.jsp").forward(request, response);		
	}
	
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_cupom_desconto = request.getParameter("id");
		String descricao_desconto = request.getParameter("descricao_desconto");
		String porcentagem_desconto = request.getParameter("porcentagem_desconto");
		
		if (descricao_desconto!= null)  {
			if (!descricao_desconto.equals("")){
				dao = new CupomDescontoDAO();
				Integer id1 = Integer.parseInt(id_cupom_desconto);
				
				Integer porcentagem_desconto1 = Integer.parseInt(porcentagem_desconto);
				CupomDesconto cupomDesconto = new CupomDesconto(descricao_desconto, porcentagem_desconto1);
				cupomDesconto.setId_cupom_desconto(id1);
				dao.updateCupomDesconto(cupomDesconto);		
			}
		} 		
	}
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new CupomDescontoDAO();
			dao.removeCupomDesconto(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao_desconto = request.getParameter("descricao_desconto");
		String porcentagem_desconto = request.getParameter("porcentagem_desconto");
	
		Integer porcentagem_desconto1 =  Integer.parseInt(porcentagem_desconto);
		
		if ((descricao_desconto!= null) && (porcentagem_desconto != null) ) {
			if (!descricao_desconto.equals("")){
				 dao = new CupomDescontoDAO();
				 CupomDesconto cupomDesconto = new CupomDesconto(descricao_desconto, porcentagem_desconto1);
				 dao.addCupomDesconto(cupomDesconto);
			}
		}	
	}
}

    
    
    
    

	