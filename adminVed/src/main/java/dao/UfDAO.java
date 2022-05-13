package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Uf;
import utilidades.Conexao;

public class UfDAO {

	public UfDAO() {

	}
	

	public ArrayList<Uf> getUf() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Uf> lista = new ArrayList<Uf>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select id_uf,descricao_uf from uf");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_uf");
				String descricao = resultSet.getString("descricao_uf");
				Uf uf = new Uf(id2, descricao); 
				
				lista.add(uf);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
