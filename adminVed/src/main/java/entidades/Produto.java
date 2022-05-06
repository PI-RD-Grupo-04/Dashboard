package entidades;
import java.math.BigDecimal;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class Produto {

	private Integer id;
	private String nome;
	private BigDecimal preco;
	private String url;
	private String descricao;
	private Double peso;
	private Integer quantidade;
	private Integer categoria; 
	private String categoriaTxt; 
	private Integer marca;
	private String marcaTxt;
	private Integer statusProduto;
	private String statusProdutoTxt;
	private Integer armazenamento;
	private Integer fornecedor;
	private Integer receita;

	public Produto(String nomeProduto, BigDecimal preco, String url, String descricao, Double peso, Integer quantidade,
			Integer categoria, Integer marca, Integer statusProduto, Integer armazenamento, Integer fornecedor,
			Integer receita) {
		this.nome = nomeProduto;
		this.preco = preco;
		this.url = url;
		this.descricao = descricao;
		this.peso = peso;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.marca = marca;
		this.statusProduto = statusProduto;
		this.armazenamento = armazenamento;
		this.fornecedor = fornecedor;
		this.receita = receita;
	}

	public Produto(String nome, BigDecimal preco, Integer quantidade, String categoria, String marca, String status
			) {
		this.nome = nome; 
		this.preco = preco; 
		this.quantidade = quantidade; 
		this.categoriaTxt = categoria; 
		this.marcaTxt = marca; 
		this.statusProdutoTxt = status;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public String getCategoriaTxt() {
		return categoriaTxt;
	}

	public String getMarcaTxt() {
		return marcaTxt;
	}

	public String getStatusProdutoTxt() {
		return statusProdutoTxt;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public Integer getStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(Integer statusProduto) {
		this.statusProduto = statusProduto;
	}

	public Integer getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(Integer armazenamento) {
		this.armazenamento = armazenamento;
	}

	public Integer getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Integer fornecedor) {
		this.fornecedor = fornecedor;
	} 
	

	public Integer getReceita() {
		return receita;
	}

	public void setReceita(Integer receita) {
		this.receita = receita;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeProduto=" + nome + ", preco=" + preco + ", url=" + url
				+ ", descricao=" + descricao + ", peso=" + peso + ", quantidade=" + quantidade + ", categoria="
				+ categoria + ", marca=" + marca + ", statusProduto=" + statusProduto + ", armazenamento="
				+ armazenamento + "]";
	}

}