package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.StatusProduto;
import utilidades.Conexao;



public class StatusProdutoDAO {
	
	
	public StatusProdutoDAO() {
		
	}
	
	public void addStatus(StatusProduto newStatus) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into status_produto (descricao_produto_status) values (?)");
			preStat.setString(1, newStatus.getDescricao());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public ArrayList<StatusProduto> getListStatus(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<StatusProduto> lista = new ArrayList<StatusProduto>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from status_produto");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_status_produto");
				String descricao = resultSet.getString("descricao_produto_status");
				StatusProduto status = new StatusProduto(descricao);
				status.setId(id2);
				lista.add(status);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void removeStatus(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from status_produto where id_status_produto = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStatus(StatusProduto updateStatus) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update status_produto set descricao_produto_status = ? where id_status_produto = ?");
			preStat.setString(1, updateStatus.getDescricao());
			preStat.setInt(2, updateStatus.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public StatusProduto buscarStatus(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		StatusProduto status = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from status_produto where id_status_produto = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_status_produto");
				String descricao = resultSet.getString("descricao_produto_status");
				status = new StatusProduto(descricao);
				status.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
	}
	
}
