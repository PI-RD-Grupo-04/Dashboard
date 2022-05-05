package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Produto;
import utilidades.Conexao;



public class ProdutoDAO {
	
	
	public ProdutoDAO() {
		
	}
	
	public void addProduto(Produto newProduto) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into produto (nome_produto, preco, imagem_url, id_categoria, id_marca, descricao_produto, id_status_produto, peso_kilo) values (?, ?, ?, ?, ?, ?, ?, ?)");
			preStat.setString(1, newProduto.getNome());
			preStat.setDouble(2, newProduto.getPreco());
			preStat.setString(3, newProduto.getImagem());
			preStat.setInt(4, newProduto.getCategoria());
			preStat.setInt(5, newProduto.getMarca());
			preStat.setString(6, newProduto.getDescricao());
			preStat.setInt(7, newProduto.getStatus());
			preStat.setDouble(8, newProduto.getPeso());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	
	public ArrayList<Produto> getListProduto(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from produto");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_produto");
				String nome = resultSet.getString("nome_produto");
				String preco = resultSet.getString("preco");
				String imagem = resultSet.getString("imagem_url");
				String categoria = resultSet.getString("id_categoria");
				String marca = resultSet.getString("id_marca");
				String descricao = resultSet.getString("descricao_produto_status");
				String status = resultSet.getString("id_status_produto");
				String peso = resultSet.getString("peso_kilo");
				Produto produto = new Produto(nome, Double.parseDouble(preco), imagem, Integer.parseInt(categoria), Integer.parseInt(marca), descricao, Integer.parseInt(status), Double.parseDouble(peso));
				produto.setId(id2);
				listaProduto.add(produto);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto;
	}
	
	public <T> ArrayList<Produto> ListProduto(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Produto> listaProduto2 = new ArrayList<Produto>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select produto.id_produto,produto.nome_produto, produto.preco, produto.imagem_url, categoria.descricao_categoria , marca.descricao_marca ,produto.descricao_produto , status_produto.descricao_produto_status , produto.peso_kilo "
					+ "from produto "
					+ "inner join categoria on produto.id_categoria = categoria.id_categoria "
					+ "inner join marca on produto.id_marca = marca.id_marca "
					+ "inner join status_produto on produto.id_status_produto = status_produto.id_status_produto "
					+ "order by produto.id_produto");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_produto");
				String nome = resultSet.getString("nome_produto");
				String preco = resultSet.getString("preco");
				String imagem = resultSet.getString("imagem_url");
				String categoria = resultSet.getString("descricao_categoria");
				String marca = resultSet.getString("descricao_marca");
				String status = resultSet.getString("descricao_produto_status");
				String peso = resultSet.getString("peso_kilo");
				Produto produto2 = new Produto(nome, Double.parseDouble(preco), imagem, categoria, marca, status, Double.parseDouble(peso));
				produto2.setId(id2);
				listaProduto2.add(produto2);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProduto2;
	}
		
	public void removeProduto(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from produto where id_produto = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduto(Produto updateProduto) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update produto set nome_produto = ?, preco = ?, imagem_url = ?, id_categoria = ?, id_marca = ?, descricao_produto = ?, id_status_produto = ?, peso_kilo = ?   where id_produto = ?");
			preStat.setString(1, updateProduto.getNome());
			preStat.setDouble(2, updateProduto.getPreco());
			preStat.setString(3, updateProduto.getImagem());
			preStat.setInt(4, updateProduto.getCategoria());
			preStat.setInt(5, updateProduto.getMarca());
			preStat.setString(6, updateProduto.getDescricao());
			preStat.setInt(7, updateProduto.getStatus());
			preStat.setDouble(8, updateProduto.getPeso());
			preStat.setInt(9, updateProduto.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public Produto buscarProduto(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Produto produto = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from produto where id_produto = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_produto");
				String nome = resultSet.getString("nome_produto");
				String preco = resultSet.getString("preco");
				String imagem = resultSet.getString("imagem_url");
				String categoria = resultSet.getString("id_categoria");
				String marca = resultSet.getString("id_marca");
				String descricao = resultSet.getString("descricao_produto");
				String status = resultSet.getString("id_status_produto");
				String peso = resultSet.getString("peso_kilo");
				produto = new Produto(nome, Double.parseDouble(preco), imagem, Integer.parseInt(categoria), Integer.parseInt(marca), descricao, Integer.parseInt(status), Double.parseDouble(peso));
				produto.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return produto;
	}
	
	
	public  ArrayList<Produto> ListProdutoLike(String produto){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Produto> listaLike = new ArrayList<Produto>();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("select produto.id_produto,produto.nome_produto, produto.preco, produto.imagem_url, categoria.descricao_categoria , marca.descricao_marca ,produto.descricao_produto , status_produto.descricao_produto_status , produto.peso_kilo "
					+ "from produto "
					+ "inner join categoria on produto.id_categoria = categoria.id_categoria "
					+ "inner join marca on produto.id_marca = marca.id_marca "
					+ "inner join status_produto on produto.id_status_produto = status_produto.id_status_produto  "
					+ "where produto.nome_produto LIKE ?"
					+ "order by produto.id_produto ");
			preStat.setString(1, produto+"%");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_produto");
				String nome = resultSet.getString("nome_produto");
				String preco = resultSet.getString("preco");
				String imagem = resultSet.getString("imagem_url");
				String categoria = resultSet.getString("descricao_categoria");
				String marca = resultSet.getString("descricao_marca");
				String status = resultSet.getString("descricao_produto_status");
				String peso = resultSet.getString("peso_kilo");
				Produto produto1 = new Produto(nome, Double.parseDouble(preco), imagem, categoria, marca, status, Double.parseDouble(peso));
				produto1.setId(id2);
				listaLike.add(produto1);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaLike;
	}
	
	
	//Contagem de Produto 
	public Integer contarProduto() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			Integer cont = null;
			PreparedStatement preStat = connection.prepareStatement("select count(*) as NumeroDeProduto from produto");
			ResultSet resultSet = preStat.executeQuery();			
			resultSet.next();

			cont = resultSet.getInt("NumeroDeProduto");
			
			 resultSet.close();
			 preStat.close();
			 return cont;
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Valor total de Vendas no pa�s
	public Integer TotalDeVendas() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			Integer cont = null;
			PreparedStatement preStat = connection.prepareStatement("select ifnull( sum(b.quantidade_total*c.preco),0) total from  pedido as a inner join item_pedido as b on a.id_pedido=b.id_pedido inner join produto as c on b.id_produto=c.id_produto;");
			ResultSet resultSet = preStat.executeQuery();			
			resultSet.next();

			cont = resultSet.getInt("total");
			
			 resultSet.close();
			 preStat.close();
			 return cont;
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}