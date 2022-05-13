package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Frete;
import utilidades.Conexao;

public class FreteDAO {

	public FreteDAO() {

	}

	public void AddFrete(Frete newfrete) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection
					.prepareStatement("insert into frete (valor, id_tipo_frete, id_uf) values (?, ?, ?)");
			preStat.setDouble(1, newfrete.getValor());
			preStat.setInt(2, newfrete.getTipo_frete());
			preStat.setInt(3, newfrete.getUf());

			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Frete> getListFrete() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Frete> listaFrete = new ArrayList<Frete>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from frete");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id_frete = resultSet.getInt("id_frete");
				String valor = resultSet.getString("valor");
				String id_tipo_frete = resultSet.getString("id_tipo_frete");
				String id_uf = resultSet.getString("id_uf");

				Frete frete = new Frete(Double.parseDouble(valor), Integer.parseInt(id_tipo_frete),
						Integer.parseInt(id_uf));
				frete.setId(id_frete);
				listaFrete.add(frete);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFrete;
	}

	public void removeFrete(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection.prepareStatement("delete from frete where id_frete = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFrete(Frete updateFrete) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection.prepareStatement(
					"UPDATE produto SET id_frete =? :,valor =? ,id_tipo_frete =? , id_uf =?  WHERE id_frete =? ");
			preStat.setDouble(1, updateFrete.getValor());
			preStat.setInt(2, updateFrete.getTipo_frete());
			preStat.setInt(3, updateFrete.getUf());
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Frete> ListFrete() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Frete> listaFrete2 = new ArrayList<Frete>();
		try {
			PreparedStatement preStat = connection.prepareStatement(
					"select  frete.id_frete , frete.valor , tipo_frete.descricao_frete , uf.descricao_uf "
							+ "from frete "
							+ "inner join tipo_frete on frete.id_tipo_frete = tipo_frete.id_tipo_frete "
							+ "inner join uf on frete.id_uf = uf.id_uf " 
							+ " order by frete.id_frete ");

			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id_frete = resultSet.getInt("id_frete");
				String valor = resultSet.getString("valor");
				String id_tipo_frete = resultSet.getString("descricao_frete");
				String id_uf = resultSet.getString("descricao_uf");

				Frete Frete2 = new Frete(Double.parseDouble(valor), id_tipo_frete , id_uf );
				Frete2.setId(id_frete);
				listaFrete2.add(Frete2);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFrete2;
	}
}
