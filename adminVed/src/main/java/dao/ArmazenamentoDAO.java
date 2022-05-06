package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Armazenamento;
import utilidades.Conexao;

public class ArmazenamentoDAO {
		
	public void AddArmazenamento(Armazenamento newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into armazenamento (descricao_armazenamento) values (?)");
			preStat.setString(1, newUser.getDescricao());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	
	}
	
	public ArrayList<Armazenamento> getlist(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Armazenamento> lista = new ArrayList<Armazenamento>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from armazenamento");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_armazenamento");
				String descricao_armazenamento = resultSet.getString("descricao_armazenamento");
				Armazenamento armazenamento = new Armazenamento(descricao_armazenamento);
				armazenamento.setId(id2);
				lista.add(armazenamento);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void removeArmazenamento(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from armazenamento where id_armazenamento = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMarca(Armazenamento updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update armazenamento set descricao_armazenamento = ? where id_armazenamento = ?");
			preStat.setString(1, updateUser.getDescricao());
			preStat.setInt(2, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	
	
	public Armazenamento buscarArmazenamento(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Armazenamento armazenamento = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from armazenamento where id_armazenamento = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_armazenamento");
				String descricao = resultSet.getString("descricao_armazenamento");
				armazenamento  = new Armazenamento(descricao);
				armazenamento.setId(ida);
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return armazenamento;
	}
}