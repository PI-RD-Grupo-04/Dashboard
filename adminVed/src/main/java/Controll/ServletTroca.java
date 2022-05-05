package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletTroca")
public class ServletTroca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletTroca() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option"); 		
		switch(option) {
	
		case("categoriaSV"):
			request.getRequestDispatcher("ServletCategoria").forward(request, response);
			break;
		case("bandeiraSv"):
			request.getRequestDispatcher("ServletBandeira").forward(request, response);
			break;
		case("receitaSv"):
			request.getRequestDispatcher("ServletReceita").forward(request, response);
			break;
		case("marcaSV"):
			request.getRequestDispatcher("ServletMarca").forward(request, response);
			break;
		case("produtoSV"):
			request.getRequestDispatcher("ServletProduto").forward(request, response);
			break;
		case("statusProdutoSV"):
			request.getRequestDispatcher("ServletStatusProduto").forward(request, response);
			break;
		case("listaClienteSV"):
			request.getRequestDispatcher("ServletCliente").forward(request, response);
			break;
		case("listaPedidoSV"):
			request.getRequestDispatcher("ServletPedido").forward(request, response);
			break;
		case("fornecedorSV"):
			request.getRequestDispatcher("ServletFornecedor").forward(request, response);
			break;
		case("funcionarioSV"):
			request.getRequestDispatcher("ServletUsuario").forward(request, response);
			break;
		case("index"):
			request.getRequestDispatcher("ServletindexCarol").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	
	}

}

