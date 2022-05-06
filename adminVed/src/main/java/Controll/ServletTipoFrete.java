package Controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoFreteDAO;
import entidades.TipoFrete;

@WebServlet("/ServletTipoFrete")
public class ServletTipoFrete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipoFreteDAO dao;
 
    public ServletTipoFrete() {
        super();
        dao = new TipoFreteDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		request.setAttribute("lista", dao.getlistTipoFrete());
		
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
		request.setAttribute("lista", dao.getlistTipoFrete());
		request.getRequestDispatcher("tipoFrete.jsp").forward(request, response);
	}
	
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroTipoFrete.jsp").forward(request, response);		
	}
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer id1 = Integer.parseInt(id);
		TipoFrete Buscar =  dao.buscarTipoFrete(id1);
		request.setAttribute("tipoFrete", Buscar);
		request.getRequestDispatcher("cadastroTipoFrete.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String descricao = request.getParameter("descricao_frete");
		if ((descricao != null)) {
			if (!descricao.equals("")){
				dao = new TipoFreteDAO();
				Integer id1 = Integer.parseInt(id);
				TipoFrete tipofrete = new TipoFrete(descricao);
				tipofrete.setId(id1);
				dao.updateTipoFrete(tipofrete);	
			}
		} 		
	}
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new TipoFreteDAO();
			dao.removeTipoFrete(id1);
		}		
	}
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao_frete = request.getParameter("descricao_frete");
		if ((descricao_frete != null)) {
			if (!descricao_frete.equals("")){
				 dao = new TipoFreteDAO();
				 TipoFrete tipoFrete = new TipoFrete(descricao_frete);
				 dao.AddTipoFrete(tipoFrete);
			}
		}	
	}
}
