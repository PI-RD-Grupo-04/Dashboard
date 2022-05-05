package utilidades;


import java.text.NumberFormat;

import dao.ProdutoDAO;
import entidades.Produto;

public class App {

	public static void main(String[] args) {
	ProdutoDAO dao = new ProdutoDAO();
	Produto p = dao.buscarProduto(14); 
	//BigDecimal preco = new BigDecimal(p.getPreco());
	NumberFormat z = NumberFormat.getCurrencyInstance();
System.out.println(NumberFormat.getCurrencyInstance().format(p.getPreco())); 
	

	
	
	}
}
