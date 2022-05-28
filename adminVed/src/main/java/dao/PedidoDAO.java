package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.ListaProdutos;
import entidades.Pedido;
import entidades.RelacaoPedido;
import utilidades.Conexao;


public class PedidoDAO {

	public PedidoDAO() {
		super();
	}

	public ArrayList<Pedido> getListPedido() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		try {
<<<<<<< HEAD
			PreparedStatement preStat = connection.prepareStatement("select pedido.id_pedido, cliente.nome, pedido_status.descricao_status, pedido.data_pedido "
					+ "from pedido "
					+ "inner join cliente on pedido.id_cliente = cliente.id_cliente "
					+ "inner join pedido_status on pedido.id_pedido_status = pedido_status.id_pedido_status "
					);
			ResultSet resultSet = preStat.executeQuery();			
			
=======
			PreparedStatement preStat = connection
					.prepareStatement("select p.id_pedido, c.nome, ps.descricao_status, p.data_pedido "
							+ "from pedido p " + "inner join cliente c on p.id_cliente = c.id_cliente "
							+ "inner join pedido_status ps on p.id_pedido_status = ps.id_pedido_status ");
			ResultSet resultSet = preStat.executeQuery();

>>>>>>> c8d66d2648b935c8747a7cf6eb6c2b5fb479aadc
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_pedido");
				String cliente = resultSet.getString("nome");
				String descricao_status = resultSet.getString("descricao_status");
				Date data = resultSet.getDate("data_pedido");
				Double quantidade = this.Quantidade(id2);
				Double valorTotal = this.TotalValor(id2);
				Pedido pedido = new Pedido(cliente, descricao_status, data, quantidade, valorTotal);
				pedido.setId(id2);
				lista.add(pedido);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Double TotalValor(Integer id2) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Double totalValor = 0.0;
		try {
			PreparedStatement preStat = connection
					.prepareStatement("select  sum(produto.preco *  item_pedido.quantidade_total) as preco_total "
							+ "from item_pedido " + "inner join produto on produto.id_produto = item_pedido.id_produto "
							+ "inner join pedido on pedido.id_pedido = item_pedido.id_pedido "
							+ "inner join pedido_status on pedido_status.id_pedido_status = pedido.id_pedido_status "
							+ "inner join cliente on cliente.id_cliente = pedido.id_cliente "
							+ "inner join frete on frete.id_frete = pedido.id_frete "
							+ "inner join tipo_frete on tipo_frete.id_tipo_frete = frete.id_tipo_frete "
							+ "where pedido.id_pedido =  ?");
			preStat.setDouble(1, id2);
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Double valor_total = resultSet.getDouble("preco_total");
				totalValor = valor_total;

			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalValor;
	}

	public Double Quantidade(Integer id2) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Double totalValor = 0.0;
		try {
			PreparedStatement preStat = connection
					.prepareStatement("select sum(item_pedido.quantidade_total) as quantidade  from item_pedido "
							+ "							inner join pedido on pedido.id_pedido = item_pedido.id_pedido "
							+ "							inner join produto on produto.id_produto = item_pedido.id_produto "
							+ "							inner join cliente on cliente.id_cliente = pedido.id_cliente "
							+ "							where pedido.id_pedido = ?");
			preStat.setDouble(1, id2);
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Double valor_total = resultSet.getDouble("quantidade");
				totalValor = valor_total;

			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return totalValor;
	}

<<<<<<< HEAD

	public RelacaoPedido relacaoPedido(Integer id){
=======
	public RelacaoPedido relacaoPedido(Integer id) {
>>>>>>> c8d66d2648b935c8747a7cf6eb6c2b5fb479aadc
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		RelacaoPedido pedido = null;
		try {
<<<<<<< HEAD
			PreparedStatement preStat = connection.prepareStatement("select   endereco.cep as cep ,endereco.rua as rua, endereco.numero , "
					+ "												endereco.municipio , pedido.data_pedido ,  tipo_frete.descricao_frete  "
					+ "												,pedido.id_pedido  ,  uf.descricao , pedido_status.descricao , "
					+ "												bandeira.nome_bandeira ,  cartao.CPF_Titular , cartao.numeracao_Cartao , "
					+ "												item_pedido.quantidade_total , produto.nome_produto , produto.preco , "
					+ "												cliente.id_cliente , cliente.nome, cliente.sobrenome , cliente.CPF , "
					+ "												cliente.telefone , cliente.email , pedido.id_pedido  ,tipo_pagamento.descricao "
					+ "							from pedido "
					+ "                         inner join endereco on pedido.id_endereco = endereco.id_endereco "
					+ "							inner join cliente_endereco on endereco.id_endereco = cliente_endereco.id_endereco "
					+ "							inner join cliente on cliente.id_cliente = cliente_endereco.id_cliente "
					+ "							inner join cliente_cartao on cliente_cartao.id_cliente = cliente.id_cliente "
					+ "							inner join cartao on cliente_cartao.id_cartao  = cartao.id_cartao "
					+ "							inner join uf on  endereco.id_uf = uf.id_uf "
					+ "							inner join bandeira on cartao.id_bandeira = bandeira.id_bandeira "
					+ "							inner join item_pedido on pedido.id_pedido = item_pedido.id_pedido "
					+ "							inner join produto on produto.id_produto = item_pedido.id_produto "
					+ "							inner join pedido_status on pedido_status.id_pedido_status = pedido.id_pedido_status "
					+ "							inner join frete on frete.id_frete = pedido.id_frete "
					+ "							inner join tipo_frete on tipo_frete.id_tipo_frete = frete.id_tipo_frete "
					+ "                            inner join pagamento on pedido.id_pedido = pagamento.id_pedido "
					+ "                            inner join tipo_pagamento on pagamento.id_tipo_pagamento = tipo_pagamento.id_tipo_pagamento "
					+ "                            where (cliente.id_cliente = pedido.id_cliente and pedido.id_pedido = ?) ");
=======
			PreparedStatement preStat = connection.prepareStatement(
					"	select   endereco.cep as cep ,endereco.rua as rua, endereco.numero , endereco.municipio , "
					+ "							pedido.data_pedido ,  tipo_frete.descricao_frete  ,pedido.id_pedido  ,  uf.descricao_uf ,  "
					+ "							pedido_status.descricao_status ,pedido.tipo_pagamento   , bandeira.nome_bandeira ,  cartao.cpf_Titular , "
					+ "						    cartao.numeracao_cartao , item_pedido.quantidade_total , produto.nome_produto ,  "
					+ "							produto.preco , cliente.id_cliente , cliente.nome, cliente.sobrenome, "
					+ "							cliente.cpf , cliente.telefone , cliente.email , pedido.id_pedido  	 "
					+ "							 from pedido  "
					+ "							 inner join endereco on pedido.id_endereco = endereco.id_endereco  "
					+ "							 	inner join cliente_endereco on endereco.id_endereco = cliente_endereco.id_endereco  "
					+ "							 	inner join cliente on cliente.id_cliente = cliente_endereco.id_cliente  "
					+ "							 	inner join cliente_cartao on cliente_cartao.id_cliente = cliente.id_cliente  "
					+ "							 	inner join cartao on cliente_cartao.id_cartao  = cartao.id_cartao  "
					+ "							 	inner join uf on  endereco.id_uf = uf.id_uf  "
					+ "							 	inner join bandeira on cartao.id_bandeira = bandeira.id_bandeira  "
					+ "							 	inner join item_pedido on pedido.id_pedido = item_pedido.id_pedido  "
					+ "							 	inner join produto on produto.id_produto = item_pedido.id_produto   "
					+ "							 	inner join pedido_status on pedido_status.id_pedido_status = pedido.id_pedido_status   "
					+ "							 	inner join frete on frete.id_frete = pedido.id_frete   "
					+ "							 	inner join tipo_frete on tipo_frete.id_tipo_frete = frete.id_tipo_frete   "
					+ "							  where (cliente.id_cliente = pedido.id_cliente and pedido.id_pedido = ?)");
>>>>>>> c8d66d2648b935c8747a7cf6eb6c2b5fb479aadc
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer numero_pedido = resultSet.getInt("id_pedido");
				String status = resultSet.getString("descricao");
				Date data = resultSet.getDate("data_pedido");
				String frete = resultSet.getString("descricao");
				Double total = this.TotalValor(numero_pedido);
				Integer quantidade = resultSet.getInt("quantidade_total");
				Double preco = resultSet.getDouble("preco");
				String cep = resultSet.getString("cep");
				String rua = resultSet.getString("rua");
				Integer numero = resultSet.getInt("numero");
				String municipio = resultSet.getString("municipio");
<<<<<<< HEAD
				String uf = resultSet.getString("descricao");
				String pamento = resultSet.getString("descricao");
				String nome = resultSet.getString("nome");
				String sobrenome = resultSet.getString("sobrenome");
				String cpf = resultSet.getString("CPF");
=======
				String uf = resultSet.getString("descricao_uf");
				String nome = resultSet.getString("nome");
				String sobrenome = resultSet.getString("sobrenome");
				String cpf = resultSet.getString("cpf");
>>>>>>> c8d66d2648b935c8747a7cf6eb6c2b5fb479aadc
				String telefone = resultSet.getString("telefone");
				String email = resultSet.getString("email"); 
				String pamento =  resultSet.getString("tipo_pagamento"); 
				pedido = new RelacaoPedido(status, data, frete, total, quantidade, preco, cep, rua, numero, municipio,
						pamento, nome, sobrenome, cpf, telefone, email, uf);
				pedido.setIdpedido(numero_pedido);
				System.out.println(pedido);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido;
	}

	public ArrayList<ListaProdutos> Lista(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<ListaProdutos> lista = new ArrayList<ListaProdutos>();
		try {
			PreparedStatement preStat = connection.prepareStatement(
					"select  produto.nome_produto , item_pedido.quantidade_total  ,   produto.preco ,  ( produto.preco  *  item_pedido.quantidade_total) as final "
							+ "from pedido " + "inner join item_pedido on pedido.id_pedido = item_pedido.id_pedido "
							+ "	inner join produto on produto.id_produto = item_pedido.id_produto  "
							+ "inner join cliente on cliente.id_cliente = cliente.id_cliente "
							+ "	where (cliente.id_cliente = pedido.id_cliente and pedido.id_pedido = ? )");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
			
				String nome_produto = resultSet.getString("nome_produto");
				Integer quantidade_total = resultSet.getInt("quantidade_total");
				Double preco = resultSet.getDouble("preco");
				Double precoTI = resultSet.getDouble("final");
				System.out.println(precoTI);
				ListaProdutos Produto = new ListaProdutos(nome_produto, quantidade_total, preco, precoTI);
				lista.add(Produto);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Integer contarPedidoUF(Integer id_uf) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			Integer cont = null;
			PreparedStatement preStat = connection
					.prepareStatement("select ifnull( sum(b.quantidade_total*c.preco) ,0) totalUf "
							+ "from  pedido as a inner join item_pedido as b on a.id_pedido=b.id_pedido "
							+ "inner join produto as c on b.id_produto=c.id_produto inner join frete as d on d.id_frete=a.id_frete "
							+ "where d.id_uf=" + id_uf);

			ResultSet resultSet = preStat.executeQuery();
			resultSet.next();
			cont = resultSet.getInt("totalUf");

			resultSet.close();
			preStat.close();
			return cont;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	public Integer contarPedido() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			Integer cont = null;
			PreparedStatement preStat = connection.prepareStatement("select count(*) total from pedido");
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