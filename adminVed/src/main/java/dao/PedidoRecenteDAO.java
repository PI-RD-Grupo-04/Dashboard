package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.PedidoRecente;
import utilidades.Conexao;

public class PedidoRecenteDAO{
	
	
    public PedidoRecenteDAO() {
		super();
	}

    
    
    public ArrayList<PedidoRecente> exibirPedidosRecentes(){
    	Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<PedidoRecente> listaPedidosRecentes = new ArrayList<PedidoRecente>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select pedido.data_pedido, p.nome_produto, u.descricao_uf from pedido \r\n"
					+ "inner join item_pedido i on i.id_pedido = pedido.id_pedido \r\n"
					+ "inner join produto p on p.id_produto = i.id_produto\r\n"
					+ "inner join frete f on f.id_frete = pedido.id_frete\r\n"
					+ "inner join uf u on u.id_uf = f.id_uf\r\n"
					+ "order by data_pedido desc");
					
					ResultSet resultSet = preStat.executeQuery();		
			
					int i = 0;
					while (resultSet.next() && i<= 2  ){
				String nome = resultSet.getString("nome_produto");
				String descricao_uf = resultSet.getString("descricao_uf");
				Date data = (Date) resultSet.getDate("data_pedido");
				
				PedidoRecente pedido = new PedidoRecente ( nome, descricao_uf, data);
				//pedido.setCod_pedido(id);
				listaPedidosRecentes.add(pedido); 
				i++;
			}
					resultSet.close();
					preStat.close();
					connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPedidosRecentes;
	}


	
	
	
	
}