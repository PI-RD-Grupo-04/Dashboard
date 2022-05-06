package entidades;

public class Endereco {
	private Integer id;
	private String nome_cliente;
	private String cep;
	private String rua;
	private Integer numero;	
	private String municipio;
	private String cidade;
	private String uf;	
	private String complemento = "";
	
	public Endereco(String nome_cliente, String cep, String rua, Integer numero, String municipio, String cidade,
			String uf, String complemento) {
		super();
		this.nome_cliente = nome_cliente;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.municipio = municipio;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
	}



	public String getUf() {
		return uf;
	}



	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}



	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		if(complemento == null) {
			this.complemento = "nada";
		} else {
			this.complemento = complemento;
		}
		
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	@Override
	public String toString() {
		return "Endereco [id=" + id + ", nome_cliente=" + nome_cliente + ", cep=" + cep + ", rua=" + rua + ", numero="
				+ numero + ", complemento=" + complemento + ", municipio=" + municipio + ", cidade=" + cidade + "]";
	}

	
}