package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import at.favre.lib.crypto.bcrypt.BCrypt;
import entidades.Usuario;
import utilidades.Conexao;


public class UsuarioDAO {

	public UsuarioDAO() {

	}
	
	public String codificarSenha(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        
    }
	

	 public void cadastroUsuario (Usuario novousuario) {
			Conexao conexao = Conexao.getInstance();
			Connection connection = conexao.getConnection();
		  
			try {
				PreparedStatement preStat = connection.prepareStatement("insert into usuario (nome, email, senha) values (?,?,?)");
				preStat.setString(1, novousuario.getNome());
				preStat.setString(2, novousuario.getEmail());
				preStat.setString(3, codificarSenha(novousuario.getSenha())); 
				
				System.out.println(preStat);
				preStat.executeUpdate();
				System.out.println("Comando executado");
				preStat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public ArrayList<Usuario> getListUsuario() {
			Conexao conexao = Conexao.getInstance();
			Connection connection = conexao.getConnection();
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			try {
				PreparedStatement preStat = connection.prepareStatement("select * from usuario");
				ResultSet resultSet = preStat.executeQuery();

				while (resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String email = resultSet.getString("email");
					String senha = resultSet.getString("senha"); 
					
					Usuario user = new Usuario(nome, email, senha);
					user.setId(id);
					lista.add(user);
				}
				resultSet.close();
				preStat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lista;
		}

		public void removeUsuario(Integer id) {
			Conexao conexao = Conexao.getInstance();
			Connection connection = conexao.getConnection();

			try {
				PreparedStatement preStat = connection.prepareStatement("delete from usuario where id = ?");
				preStat.setInt(1, id);
				System.out.println(preStat);
				preStat.executeUpdate();
				System.out.println("Comando executado");
				preStat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void updateUsuario(Usuario updateUser) {
			Conexao conexao = Conexao.getInstance();
			Connection connection = conexao.getConnection();

			try {
				PreparedStatement preStat = connection.prepareStatement("update usuario set nome = ?, email = ?, senha = ? where id = ?");
				preStat.setString(1, updateUser.getNome());
				preStat.setString(2, updateUser.getEmail());
				preStat.setString(3, updateUser.getSenha());
				preStat.setInt(4, updateUser.getId());
				
				System.out.println(preStat);
				preStat.executeUpdate();
				System.out.println("Comando executado");
				preStat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public Usuario buscarUsuario(Integer id) {
			Conexao conexao = Conexao.getInstance();
			Connection connection = conexao.getConnection();
			Usuario user = null;
			try {
				PreparedStatement preStat = connection.prepareStatement("select * from usuario where id = ?");
				preStat.setInt(1, id);
				ResultSet resultSet = preStat.executeQuery();
				while (resultSet.next()) {

					Integer ida = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String email = resultSet.getString("email");
					String senha = resultSet.getString("senha");
					user = new Usuario (nome, email, senha);
					user.setId(ida);

				}
				resultSet.close();
				preStat.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return user;  }


		
		public boolean validarSenha(String senha, String senhaCrypto) {
	        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), senhaCrypto);
	        return response.verified;
	    }
		
		public Usuario conferencia(String email, String senha) {
			Conexao conexao = Conexao.getInstance();
			Connection connection = conexao.getConnection();
			
			Usuario user = null;
			try {
				PreparedStatement preStat = connection.prepareStatement("select * from usuario where email = ? ");
				preStat.setString(1, email);
				ResultSet resultSet = preStat.executeQuery();
				while(resultSet.next()) {
					String nome1 = resultSet.getString("nome");
					String email1 = resultSet.getString("email");
					String senha1 = resultSet.getString("senha");
					Integer id1 = resultSet.getInt("id");
					if (email.equals(email1) && this.validarSenha(senha, senha1)) {
						user = new Usuario(nome1, email1, senha1);
						user.setId(id1);
						return user;
					} else{
						System.out.println("email ou senha invalidos!");}
					}
				}catch (SQLException e) {

					e.printStackTrace();
				}
			return user;
			
			}
}