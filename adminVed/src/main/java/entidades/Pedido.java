package entidades;

import java.util.Date;

public class Pedido {
	private Integer id;
	private String cliente;
	private String descricao_status;
	private Date data;
	private Double quantidade;
	private Double valor_total;
	private String frete;
	
	public Pedido(String cliente, String descricao_status, Date data, Double quantidade, Double valor_total) {
		super();
		this.cliente = cliente;
		this.descricao_status = descricao_status;
		this.data = data;
		this.quantidade = quantidade;
		this.valor_total = valor_total;
	}


	public String getFrete() {
		return frete;
	}


	public void setFrete(String frete) {
		this.frete = frete;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getDescricao_status() {
		return descricao_status;
	}


	public void setDescricao_status(String descricao_status) {
		this.descricao_status = descricao_status;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Double getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValor_total() {
		return valor_total;
	}


	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", descricao_status=" + descricao_status + ", data=" + data
				+ ", quantidade=" + quantidade + ", valor_total=" + valor_total + ", frete=" + frete + "]";
	}


	

}
