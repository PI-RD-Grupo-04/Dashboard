package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Receita;
import utilidades.Conexao;

public class ReceitaDAO {

	
	public void addReceita (Receita newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into receita (ingredientes, preparo, titulo) values (?, ?, ?)");
			preStat.setString(1, newUser.getIngredientes());
			preStat.setString(2, newUser.getPreparo());
			preStat.setString(3, newUser.getTitulo());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public ArrayList<Receita> getListReceita(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Receita> lista = new ArrayList<Receita>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from receita");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_receita");
				String ingredientes = resultSet.getString("ingredientes");
				String preparo = resultSet.getString("preparo");
				String titulo = resultSet.getString("titulo");
				Receita receita = new Receita(ingredientes, preparo, titulo);
				receita.setId_receita(id2);
				lista.add(receita);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void removeReceita(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from receita where id_receita = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateReceita(Receita updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update receita set ingredientes = ?, preparo = ?, titulo = ?  where id_receita = ?");
			preStat.setString(1, updateUser.getIngredientes());
			preStat.setString(2, updateUser.getPreparo());
			preStat.setString(3, updateUser.getTitulo());
			preStat.setInt(4, updateUser.getId_receita());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public Receita buscarReceita(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Receita receita = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from receita where id_receita = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer id_receita = resultSet.getInt("id_receita");
				String ingredientes = resultSet.getString("ingredientes");
				String preparo = resultSet.getString("preparo");
				String titulo = resultSet.getString("titulo");
				receita = new Receita(ingredientes, preparo, titulo);
				receita.setId_receita(id_receita);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return receita;
	}
	
	
}
