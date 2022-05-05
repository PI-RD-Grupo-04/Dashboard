package dao;

import java.math.BigDecimal;
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
			PreparedStatement preStat = connection.prepareStatement(
					"INSERT INTO produto" + "(descricao_produto,nome_produto,peso_kilo,preco,quantidade,imagem_url,"
							+ "id_armazenamento,id_categoria,id_fornecedor,id_marca,id_receita,id_status_produto)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			preStat.setString(1, newProduto.getDescricao());
			preStat.setString(2, newProduto.getNomeProduto());
			preStat.setDouble(3, newProduto.getPeso());
			preStat.setBigDecimal(4, newProduto.getPreco());
			preStat.setInt(5, newProduto.getQuantidade());
			preStat.setString(6, newProduto.getUrl());
			preStat.setInt(7, newProduto.getArmazenamento());
			preStat.setInt(8, newProduto.getCategoria());
			preStat.setInt(9, newProduto.getFornecedor());
			preStat.setInt(10, newProduto.getMarca());
			preStat.setInt(11, newProduto.getReceita());
			preStat.setInt(12, newProduto.getStatusProduto());

			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Produto> getListProduto() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from produto");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_produto");
				String descricao = resultSet.getString("descricao_produto_status");
				String nome = resultSet.getString("nome_produto");
				String peso = resultSet.getString("peso_kilo");
				String preco = resultSet.getString("preco");
				String quantidade = resultSet.getString("quantidade");
				String imagem = resultSet.getString("imagem_url");
				String armazenamento = resultSet.getString("id_armazenamento");
				String categoria = resultSet.getString("id_categoria");
				String fornecedor = resultSet.getString("id_fornecedor");
				String marca = resultSet.getString("id_marca");
				String receita = resultSet.getString("id_receita");
				String status = resultSet.getString("id_status_produto");

				Produto produto = new Produto(nome, new BigDecimal(preco), imagem, descricao, Double.parseDouble(peso),
						Integer.parseInt(quantidade), Integer.parseInt(categoria), Integer.parseInt(marca),
						Integer.parseInt(status), Integer.parseInt(armazenamento), Integer.parseInt(fornecedor),
						Integer.parseInt(receita));
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

	public <T> ArrayList<Produto> ListProduto() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Produto> listaProduto2 = new ArrayList<Produto>();
		try {
			PreparedStatement preStat = connection.prepareStatement(
					"select p.id_produto,p.nome_produto, p.preco, p.quantidade,p.descricao_produto,\n"
					+ "	c.descricao_categoria , m.descricao_marca , sp.descricao_status \n"
					+ "	from produto p\n"
					+ "		inner join categoria c  on p.id_categoria = c.id_categoria \n"
					+ "		inner join marca  m on p.id_marca = m.id_marca \n"
					+ "		inner join status_produto sp  on p.id_status_produto = sp.id_status_produto  \n"
					+ "        inner join fornecedor f on f.id_fornecedor = p.id_fornecedor \n"
					+ "			order by p.id_produto;\n"
					+ "");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_produto");
				String nome = resultSet.getString("nome_produto");
				String preco = resultSet.getString("preco");
				String quant = resultSet.getString("quantidade");
				String categoria = resultSet.getString("descricao_categoria");
				String marca = resultSet.getString("descricao_marca");
				String status = resultSet.getString("descricao_produto_status");
				String peso = resultSet.getString("peso_kilo"); 
				
				Produto produto2 = new Produto(nome, new BigDecimal(preco), Integer.parseInt(quant), Integer.parseInt(categoria), Integer.parseInt(marca), Integer.parseInt(status),
						Double.parseDouble(peso));
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
			PreparedStatement preStat = connection.prepareStatement(
					"UPDATE produto SET id_produto =? :,descricao_produto =? ,nome_produto =? ,peso_kilo =?,preco =?,quantidade =?,imagem_url =?,\n"
					+ "id_armazenamento =? ,id_categoria =? ,id_fornecedor =? ,id_marca =?,id_receita =?,id_status_produto =?WHERE id_produto =?;\n"
					+ "");
			preStat.setString(1, updateProduto.getDescricao());
			preStat.setString(2, updateProduto.getNomeProduto());
			preStat.setDouble(3, updateProduto.getPeso());
			preStat.setBigDecimal(4, updateProduto.getPreco());
			preStat.setInt(5, updateProduto.getQuantidade());
			preStat.setString(6, updateProduto.getUrl());
			preStat.setInt(7, updateProduto.getArmazenamento());
			preStat.setInt(8, updateProduto.getCategoria());
			preStat.setInt(9, updateProduto.getFornecedor());
			preStat.setInt(10, updateProduto.getMarca());
			preStat.setInt(11, updateProduto.getReceita());
			preStat.setInt(12, updateProduto.getStatusProduto());
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
			while (resultSet.next()) {

				Integer id2 = resultSet.getInt("id_produto");
				String nome = resultSet.getString("nome_produto");
				String preco = resultSet.getString("preco");
				String quant = resultSet.getString("quantidade");
				String categoria = resultSet.getString("descricao_categoria");
				String marca = resultSet.getString("descricao_marca");
				String status = resultSet.getString("descricao_produto_status");
				String peso = resultSet.getString("peso_kilo"); 
	
				
				
				produto = new  Produto(nome, new BigDecimal(preco), Integer.parseInt(quant), Integer.parseInt(categoria), Integer.parseInt(marca), Integer.parseInt(status),
						Double.parseDouble(peso));
				produto.setId(id2);

			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return produto;
	}

	public ArrayList<Produto> ListProdutoLike(String produto) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Produto> listaLike = new ArrayList<Produto>();

		try {
			PreparedStatement preStat = connection.prepareStatement(
					"select p.id_produto,p.nome_produto, p.preco, p.quantidade,p.descricao_produto,\n"
					+ "	c.descricao_categoria , m.descricao_marca , sp.descricao_status \n"
					+ "	from produto p\n"
					+ "		inner join categoria c  on p.id_categoria = c.id_categoria \n"
					+ "		inner join marca  m on p.id_marca = m.id_marca \n"
					+ "		inner join status_produto sp  on p.id_status_produto = sp.id_status_produto  \n"
					+ "        inner join fornecedor f on f.id_fornecedor = p.id_fornecedor \n"
					+ "        where p.nome_produto like ?\n"
					+ "			order by p.id_produto; ");
			preStat.setString(1, produto + "%");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_produto");
				String nome = resultSet.getString("nome_produto");
				String preco = resultSet.getString("preco");
				String quant = resultSet.getString("quantidade");
				String categoria = resultSet.getString("descricao_categoria");
				String marca = resultSet.getString("descricao_marca");
				String status = resultSet.getString("descricao_produto_status");
				String peso = resultSet.getString("peso_kilo"); 
				Produto produto1 = new Produto(nome, new BigDecimal(preco), Integer.parseInt(quant), Integer.parseInt(categoria), Integer.parseInt(marca), Integer.parseInt(status),
						Double.parseDouble(peso));
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

	// Contagem de Produto
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
			PreparedStatement preStat = connection.prepareStatement(
					"select ifnull( sum(b.quantidade_total*c.preco),0) total from  pedido as a inner join item_pedido as b on a.id_pedido=b.id_pedido inner join produto as c on b.id_produto=c.id_produto;");
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