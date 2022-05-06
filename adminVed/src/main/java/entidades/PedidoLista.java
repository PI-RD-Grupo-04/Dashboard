package entidades;

import java.util.Date;

public class PedidoLista {
	private Integer id;
	private Integer numero_pedido;
	private String nome_cliente;
	private String situacao;
	private Date data;
	private String frete;
	private String nome_produto;
	private Double preco_unitario;
	private Integer quantidade;
	private Double total;
	
	
	public PedidoLista(Integer numero_pedido, String nome_cliente, String situacao, Date data, String frete,
			String nome_produto, Double preco_unitario, Integer quantidade, Double total) {
		super();
		this.numero_pedido = numero_pedido;
		this.nome_cliente = nome_cliente;
		this.situacao = situacao;
		this.data = data;
		this.frete = frete;
		this.nome_produto = nome_produto;
		this.preco_unitario = preco_unitario;
		this.quantidade = quantidade;
		this.total = total;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumero_pedido() {
		return numero_pedido;
	}


	public void setNumero_pedido(Integer numero_pedido) {
		this.numero_pedido = numero_pedido;
	}


	public String getNome_cliente() {
		return nome_cliente;
	}


	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getFrete() {
		return frete;
	}


	public void setFrete(String frete) {
		this.frete = frete;
	}


	public String getNome_produto() {
		return nome_produto;
	}


	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}


	public Double getPreco_unitario() {
		return preco_unitario;
	}


	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}
}