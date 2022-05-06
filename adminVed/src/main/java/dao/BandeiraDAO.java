package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Bandeira;
import utilidades.Conexao;

public class BandeiraDAO {

	
	
	public void addBandeira(Bandeira newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into bandeira (nome_bandeira) values (?)");
			preStat.setString(1, newUser.getNome_bandeira());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	
	}
	
	public ArrayList<Bandeira> getlistBandeira(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Bandeira> lista = new ArrayList<Bandeira>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from bandeira");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_bandeira");
				String descricao = resultSet.getString("nome_bandeira");
				Bandeira bandeira = new Bandeira(descricao);
				bandeira.setId(id2);
				lista.add(bandeira);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void removeBandeira(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from bandeira where id_bandeira = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMarca(Bandeira updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update bandeira set nome_bandeira = ? where id_bandeira = ?");
			preStat.setString(1, updateUser.getNome_bandeira());
			preStat.setInt(2, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	
	
	public Bandeira buscarBandeira(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Bandeira bandeira = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from bandeira where id_bandeira = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_bandeira");
				String descricao = resultSet.getString("nome_bandeira");
				bandeira  = new Bandeira(descricao);
				bandeira.setId(ida);
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bandeira;
	}
}
