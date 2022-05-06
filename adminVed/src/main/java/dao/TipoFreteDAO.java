package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.TipoFrete;
import utilidades.Conexao;

public class TipoFreteDAO {

	public void AddTipoFrete(TipoFrete newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection
					.prepareStatement("insert into tipo_frete (descricao_frete) values (?)");
			preStat.setString(1, newUser.getDescricao_frete());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TipoFrete> getlistTipoFrete() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<TipoFrete> lista = new ArrayList<TipoFrete>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from tipo_frete");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_tipo_frete");
				String descricao_frete = resultSet.getString("descricao_frete");
				TipoFrete tipoFrete = new TipoFrete(descricao_frete);
				tipoFrete.setId(id2);
				lista.add(tipoFrete);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void removeTipoFrete(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection.prepareStatement("delete from tipo_frete where id_tipo_frete = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTipoFrete(TipoFrete updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection
					.prepareStatement("update tipo_frete set descricao_frete = ? where id_tipo_frete = ?");
			preStat.setString(1, updateUser.getDescricao_frete());
			preStat.setInt(2, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TipoFrete buscarTipoFrete(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		TipoFrete tipofrete = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from tipo_frete where id_tipo_frete = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();
			while (resultSet.next()) {

				Integer ida = resultSet.getInt("id_tipo_frete");
				String descricao = resultSet.getString("descricao_frete");
				tipofrete = new TipoFrete(descricao);
				tipofrete.setId(ida);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return tipofrete;
	}
}
