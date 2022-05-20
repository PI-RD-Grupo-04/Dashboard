package Controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreteDAO;
import dao.TipoFreteDAO;
import dao.UfDAO;
import entidades.Frete;

@WebServlet("/ServletFrete")
public class ServletFrete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FreteDAO fretedao;
	private TipoFreteDAO tipofretedao;
	private UfDAO ufdao;

	public ServletFrete() {
		super();
		fretedao = new FreteDAO();
		tipofretedao = new TipoFreteDAO();
		ufdao = new UfDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("option");

		if (option.equals("insertForm")) {
			InsertForm(request, response);

		} else if (option.equals("updateForm")) {
			 UpdateForm(request, response);
		} else if (option.equals("update")) {
			Update(request, response);

		} else if (option.equals("delete")) {
			Delete(request, response);

		} else if (option.equals("insert")) {
			Insert(request, response);

		}

		request.setAttribute("lista", fretedao.ListFrete());
		request.getRequestDispatcher("frete.jsp").forward(request, response);
	}

	protected void InsertForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listaStatus", fretedao.ListFrete());
		request.setAttribute("ListaTipoFrete", tipofretedao.getlistTipoFrete());
		request.setAttribute("ListaUf", ufdao.getUf());

		request.getRequestDispatcher("cadastroFrete.jsp").forward(request, response);
	}

	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer id1 = Integer.parseInt(id);
		
	
		request.setAttribute("listaStatus", fretedao.ListFrete());
		request.setAttribute("ListaTipoFrete", tipofretedao.getlistTipoFrete());
		request.setAttribute("ListaUf", ufdao.getUf());
		request.getRequestDispatcher("cadastroFrete.jsp").forward(request, response);
	}
	
	
	

	protected void Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String valor = request.getParameter("valor");
		String tipo_frete = request.getParameter("tipo_frete");
		String uf = request.getParameter("uf");

		if ((valor != null) && (uf != null) && (tipo_frete != null)) {
			if (!valor.equals("")) {
				fretedao = new FreteDAO();
				Integer id1 = Integer.parseInt(id);
				Frete frete = new Frete(Double.parseDouble(valor), Integer.parseInt(tipo_frete), Integer.parseInt(uf));
				frete.setId(id1);
				fretedao.updateFrete(frete);
			}
		}
	}

	protected void Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			fretedao = new FreteDAO();
			fretedao.removeFrete(id1);

		}
	}

	protected void Insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String valor = request.getParameter("valor");
		String tipo_frete = request.getParameter("tipo_frete");
		String uf = request.getParameter("uf");

		if ((valor != null) && (tipo_frete != null) && (uf != null)) {
			if (!valor.equals("")) {
				Double valor1 = Double.parseDouble(valor);
				Integer tipofrete1 = Integer.parseInt(tipo_frete);
				Integer uf1 = Integer.parseInt(uf);

				Frete frete = new Frete(valor1, tipofrete1, uf1);
				fretedao.AddFrete(frete);
			}
		}
	}

}
