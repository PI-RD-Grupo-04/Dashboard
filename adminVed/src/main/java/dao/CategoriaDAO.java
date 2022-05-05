package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Categoria;
import utilidades.Conexao;



public class CategoriaDAO {
	
	
	public CategoriaDAO() {
		
	}
	
	public void addCategoria(Categoria newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into categoria (descricao_categoria) values (?)");
			preStat.setString(1, newUser.getDescricao());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public ArrayList<Categoria> getListCategoria(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from categoria");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_categoria");
				String descricao = resultSet.getString("descricao_categoria");
				Categoria categoria = new Categoria(descricao);
				categoria.setId(id2);
				lista.add(categoria);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void removeCategoria(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from categoria where id_categoria = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCategoria(Categoria updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update categoria set descricao_categoria = ? where id_categoria = ?");
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
	
	public Categoria buscarCategoria(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Categoria categoria = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from categoria where id_categoria = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_categoria");
				String descricao = resultSet.getString("descricao_categoria");
				categoria = new Categoria(descricao);
				categoria.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return categoria;
	}
	
}
