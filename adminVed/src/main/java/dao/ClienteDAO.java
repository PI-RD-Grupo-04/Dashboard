package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.Cartao;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Pedido;
import utilidades.Conexao;

public class ClienteDAO {
	
	
    public ClienteDAO() {
		
	}

    public ArrayList<Cliente> Cliente(Integer id){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from cliente "
					+ "where cliente.id_cliente = ? "
					+ ";");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_cliente");
				String nome = resultSet.getString("nome");
				String sobrenome = resultSet.getString("sobrenome");
				String cpf = resultSet.getString("cpf");
				Date nascimento = resultSet.getDate("data_nascimento");
				String email = resultSet.getString("email");
				String telefone = resultSet.getString("telefone");
				Cliente cliente = new Cliente(nome, sobrenome, cpf, nascimento, email, telefone);
				cliente.setId(id2);
				lista.add(cliente);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
    
	public ArrayList<Cliente> getListCliente(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from cliente");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_cliente");
				String nome = resultSet.getString("nome");
				String sobrenome = resultSet.getString("sobrenome");
				String cpf = resultSet.getString("cpf");
				Date nascimento = resultSet.getDate("data_nascimento");
				String email = resultSet.getString("email");
				String telefone = resultSet.getString("telefone");
				Cliente cliente = new Cliente(nome, sobrenome, cpf, nascimento, email, telefone);
				cliente.setId(id2);
				lista.add(cliente);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
			
	
	public ArrayList<Cartao> Cartao(Integer id){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Cartao> lista = new ArrayList<Cartao>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select cliente_cartao.id_cliente, cliente.nome_cliente,  cartao.numeracao_Cartao, cartao.nome_Titular, cartao.CPF_Titular, cartao.dia_vencimento, "
					+ "cartao.ano_vencimento, bandeira.nome_bandeira "
					+ "from cliente_cartao "
					+ "inner join cliente on cliente.id_cliente =  cliente_cartao.id_cliente "
					+ "inner join cartao on cartao.id_cartao = cliente_cartao.id_cartao "
					+ "inner join bandeira on bandeira.id_bandeira = cartao.id_bandeira "
					+ "where cliente.id_cliente = ? ");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id1 = resultSet.getInt("id_cliente");
				String nome_cliente = resultSet.getString("nome_cliente");
				String numero_cartao = resultSet.getString("numeracao_Cartao");
				String nome_titular = resultSet.getString("nome_Titular");
				String cpf_titular = resultSet.getString("CPF_Titular");
				String dia_vencimento = resultSet.getString("dia_vencimento");
				String ano_vencimento = resultSet.getString("ano_vencimento");
				String bandeira = resultSet.getString("nome_bandeira");
				Cartao cartao = new Cartao(nome_cliente, numero_cartao, nome_titular, cpf_titular, Integer.parseInt(dia_vencimento), Integer.parseInt(ano_vencimento), bandeira);
				cartao.setId(id1);
				lista.add(cartao);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public ArrayList<Endereco> Endereco(Integer id){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Endereco> lista = new ArrayList<Endereco>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select cliente_endereco.id_cliente, cliente.nome_cliente , endereco.cep, endereco.rua, endereco.numero, endereco.municipio, "
					+ "endereco.cidade,uf.descricao_uf, endereco.complemento "
					+ "from cliente_endereco "
					+ "inner join cliente on cliente.id_cliente =  cliente_endereco.id_cliente "
					+ "inner join endereco on endereco.id_endereco = cliente_endereco.id_endereco "
					+ "inner join uf on endereco.id_endereco = uf.id_uf "
					+ "where cliente.id_cliente = ? order by id_cliente");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id1 = resultSet.getInt("id_cliente");
				String nome_cliente = resultSet.getString("nome_cliente");
				String cep = resultSet.getString("cep");
				String rua = resultSet.getString("rua");
				String numero = resultSet.getString("numero");
				String municipio = resultSet.getString("municipio");
				String cidade = resultSet.getString("cidade");
				String uf = resultSet.getString("descricao_uf");				
				String complemento = resultSet.getString("complemento");				
				Endereco endereco = new Endereco(nome_cliente, cep, rua, Integer.parseInt(numero), municipio, cidade, uf, complemento);
				endereco.setId(id1);
				lista.add(endereco);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
	
	
	
	
	
	
	public ArrayList<Pedido> getPedidoCliente(Integer id){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select pedido.id_pedido, cliente.nome_cliente, pedido_status.descricao_status, pedido.data_pedido, tipo_frete.descricao_frete"
					+ "					from pedido "
					+ "					inner join cliente on pedido.id_cliente = cliente.id_cliente "
					+ "					inner join pedido_status on pedido.id_pedido_status = pedido_status.id_pedido_status  "
					+ "                    inner join frete on frete.id_frete = pedido.id_frete"
					+ "                    inner join tipo_frete on tipo_frete.id_tipo_frete = frete.id_tipo_frete"
					+ "                    where cliente.id_cliente = ?"
					); 
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_pedido");
				String cliente = resultSet.getString("nome_cliente");
				String descricao_status = resultSet.getString("descricao_status");
				Date data = resultSet.getDate("data_pedido");
				Double quantidade = this.Quantidade(id2);
				Double valorTotal = this.TotalValor(id2);
				String frete = resultSet.getString("descricao_frete");
				Pedido pedido = new Pedido(cliente, descricao_status, data, quantidade, valorTotal);
				pedido.setId(id2); 
				pedido.setFrete(frete);
				lista.add(pedido);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Double TotalValor(Integer id2){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Double totalValor = 0.0;
		try {
			PreparedStatement preStat = connection.prepareStatement("select  sum(produto.preco *  item_pedido.quantidade_total) as preco_total "
					+ "from item_pedido "
					+ "inner join produto on produto.id_produto = item_pedido.id_produto "
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
	
	public Double Quantidade(Integer id2){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Double totalValor = 0.0;
		try {
			PreparedStatement preStat = connection.prepareStatement("select sum(item_pedido.quantidade_total) as quantidade "
					+ "from item_pedido "
					+ "inner join pedido on pedido.id_pedido = item_pedido.id_pedido "
					+ "inner join produto on produto.id_produto = item_pedido.id_produto "
					+ "inner join cliente on cliente.id_cliente = pedido.id_cliente "
					+ "where cliente.id_cliente = ?");
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

	
	public Integer contarUsuario() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			Integer cont = null;
			PreparedStatement preStat = connection.prepareStatement("select count(id_cliente) from cliente");
			ResultSet resultSet = preStat.executeQuery();			
			resultSet.next();
			cont = resultSet.getInt("count(id_cliente)");
			
			 resultSet.close();
			 preStat.close();
			 return cont;
			 
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}
}
