package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Armazenamento;
import utilidades.Conexao;

public class ArmazenamentoDAO {

	public ArrayList<Armazenamento> getlist(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Armazenamento> lista = new ArrayList<>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from armazenamento");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id_armazenamento");
				String descricao = resultSet.getString("descricao_armazenamento");
				Armazenamento armazenamento = new Armazenamento(descricao);
				armazenamento.setId(id);
				lista.add(armazenamento);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
