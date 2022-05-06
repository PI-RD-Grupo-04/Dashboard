package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Fornecedor;
import utilidades.Conexao;



public class FornecedorDAO {
	
	
	public FornecedorDAO() {
		
	}
	
	public void addFornecedor(Fornecedor newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into fornecedor (razao_social, CNPJ, email) values (?, ?, ?)");
			preStat.setString(1, newUser.getRazao_social());
			preStat.setString(2, newUser.getCnpj());
			preStat.setString(3, newUser.getEmail());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public ArrayList<Fornecedor> getListFornecedor(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from fornecedor");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_fornecedor");
				String razao_social = resultSet.getString("razao_social");
				String cnpj = resultSet.getString("CNPJ");
				String email = resultSet.getString("email");
				Fornecedor fornecedor = new Fornecedor(razao_social, cnpj, email);
				fornecedor.setId(id2);
				lista.add(fornecedor);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void removeFornecedor(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from fornecedor where id_fornecedor = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFornecedor(Fornecedor updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update fornecedor set razao_social = ?, CNPJ = ?, email = ?  where id_fornecedor = ?");
			preStat.setString(1, updateUser.getRazao_social());
			preStat.setString(2, updateUser.getCnpj());
			preStat.setString(3, updateUser.getEmail());
			preStat.setInt(4, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public Fornecedor buscarFornecedor(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Fornecedor fornecedor = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from fornecedor where id_fornecedor = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_fornecedor");
				String razao_social = resultSet.getString("razao_social");
				String cnpj = resultSet.getString("CNPJ");
				String email = resultSet.getString("email");
				fornecedor = new Fornecedor(razao_social, cnpj, email);
				fornecedor.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return fornecedor;
	}
	
}
