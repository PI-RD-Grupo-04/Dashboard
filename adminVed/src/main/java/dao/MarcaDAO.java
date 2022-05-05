package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Marca;
import utilidades.Conexao;



public class MarcaDAO {
	
	
	public MarcaDAO() {
		
	}
	
	public void addMarca(Marca newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into marca (descricao_marca) values (?)");
			preStat.setString(1, newUser.getDescricao());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public ArrayList<Marca> getListMarca(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Marca> lista = new ArrayList<Marca>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from marca");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_marca");
				String descricao = resultSet.getString("descricao_marca");
				Marca marca = new Marca(descricao);
				marca.setId(id2);
				lista.add(marca);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void removeMarca(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from marca where id_marca = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMarca(Marca updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update marca set descricao_marca = ? where id_marca = ?");
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
	
	public Marca buscarMarca(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Marca marca = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from marca where id_marca = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_marca");
				String descricao = resultSet.getString("descricao_marca");
				marca = new Marca(descricao);
				marca.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return marca;
	}
	
}