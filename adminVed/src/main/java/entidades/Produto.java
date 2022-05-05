package entidades;

public class Produto {
	private Integer id;
	private String nome;
	private Double preco;
	private String imagem;
	private Integer categoria;
	private String categoria2;
	private Integer marca;
	private String marca2;
	private String descricao;
	private Integer status;
	private String status2;
	private Double peso;
	
	
	public Produto(String nome, Double preco, String imagem, Integer categoria, Integer marca, String descricao,
			Integer status, Double peso) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;
		this.categoria = categoria;
		this.marca = marca;
		this.descricao = descricao;
		this.status = status;
		this.peso = peso;
	}

	

	public Produto(String nome, Double preco, String imagem, String categoria2, String marca2,
			String status2, Double peso) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;
		this.categoria2 = categoria2;
		this.marca2 = marca2;
		this.status2 = status2;
		this.peso = peso;
	}



	public Integer getId() {
		return id;
	}


	public String getCategoria2() {
		return categoria2;
	}



	public void setCategoria2(String categoria2) {
		this.categoria2 = categoria2;
	}



	public String getMarca2() {
		return marca2;
	}



	public void setMarca2(String marca2) {
		this.marca2 = marca2;
	}



	public String getStatus2() {
		return status2;
	}



	public void setStatus2(String status2) {
		this.status2 = status2;
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


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}

}