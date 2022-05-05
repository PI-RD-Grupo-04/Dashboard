package utilidades;

import dao.ArmazenamentoDAO;
import dao.FornecedorDAO;

public class App {

	public static void main(String[] args) {
	//ProdutoDAO dao = new ProdutoDAO();
	//Produto p = dao.buscarProduto(14); 
	//BigDecimal preco = new BigDecimal(p.getPreco());
	//NumberFormat z = NumberFormat.getCurrencyInstance();
	//System.out.println(NumberFormat.getCurrencyInstance().format(p.getPreco())); 
	 
	
		ArmazenamentoDAO d = new ArmazenamentoDAO(); 
		FornecedorDAO dd = new FornecedorDAO();
		System.out.println(dd.getListFornecedor());

	
	
	}
}
