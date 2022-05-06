package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.CupomDesconto;
import utilidades.Conexao;

public class CupomDescontoDAO {

	
	public void addCupomDesconto (CupomDesconto newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into cupom_desconto (descricao_desconto, porcentagem_desconto) values (?, ?)");
			preStat.setString(1, newUser.getDescricao_desconto());
			preStat.setInt(2, newUser.getPorcentagem_desconto());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<CupomDesconto> getListCupomDesconto(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<CupomDesconto> lista = new ArrayList<CupomDesconto>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from cupom_desconto");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_cupom_desconto");
				String descricao_desconto = resultSet.getString("descricao_desconto");
				Integer porcentagem_desconto = resultSet.getInt("porcentagem_desconto");
				CupomDesconto cupomDesconto = new CupomDesconto(descricao_desconto, porcentagem_desconto);
				cupomDesconto.setId_cupom_desconto(id2);
				lista.add(cupomDesconto);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void removeCupomDesconto(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from cupom_desconto where id_cupom_desconto = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCupomDesconto(CupomDesconto updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update cupom_desconto set descricao_desconto = ?, porcentagem_desconto = ?  where id_cupom_desconto = ?");
			preStat.setString(1, updateUser.getDescricao_desconto());
			preStat.setInt(2, updateUser.getPorcentagem_desconto());
			preStat.setInt(3, updateUser.getId_cupom_desconto());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public CupomDesconto buscarCupomDesconto(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		CupomDesconto cupomDesconto = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from cupom_desconto where id_cupom_desconto = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer id_cupom_desconto = resultSet.getInt("id_cupom_desconto");
				String descricao_desconto = resultSet.getString("descricao_desconto");
				Integer porcentagem_desconto = resultSet.getInt("porcentagem_desconto");
				
				cupomDesconto = new CupomDesconto(descricao_desconto, porcentagem_desconto);
				cupomDesconto.setId_cupom_desconto(id_cupom_desconto);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cupomDesconto;
	}
	
	
	
	
	
	
	
}
