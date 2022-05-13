package entidades;

import java.util.Date;

public class PedidoRecente {
	
	private String nome_produto;
	private String descricao_uf;
	private Date data;

	
	
	public PedidoRecente(String nome_produto, String descricao_uf, Date data) {
		super();
		this.nome_produto = nome_produto;
		this.descricao_uf = descricao_uf;
		this.data = data;
		
	}



	public String getNome_produto() {
		return nome_produto;
	}



	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}



	public String getDescricao_uf() {
		return descricao_uf;
	}



	public void setDescricao_uf(String descricao_uf) {
		this.descricao_uf = descricao_uf;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	@Override
	public String toString() {
		return "PedidoRecente [nome_produto=" + nome_produto + ", descricao_uf=" + descricao_uf + ", data=" + data
				+ "]";
	}



}
