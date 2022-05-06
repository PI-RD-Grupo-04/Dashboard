package entidades;

public class Cartao {
	private Integer id;
	private String nome_cliente;
	private String numero_cartao;
	private String nome_titular;
	private String cpf_titular;
	private Integer dia_vencimento;
	private Integer ano_vencimento;
	private String bandeira;

	public Cartao(String nome_cliente, String numero_cartao, String nome_titular, String cpf_titular,
			Integer dia_vencimento, Integer ano_vencimento, String bandeira) {
		super();
		this.nome_cliente = nome_cliente;
		this.numero_cartao = numero_cartao;
		this.nome_titular = nome_titular;
		this.cpf_titular = cpf_titular;
		this.dia_vencimento = dia_vencimento;
		this.ano_vencimento = ano_vencimento;
		this.bandeira = bandeira;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getNumero_cartao() {
		return numero_cartao;
	}

	public void setNumero_cartao(String numero_cartao) {
		this.numero_cartao = numero_cartao;
	}

	public String getNome_titular() {
		return nome_titular;
	}

	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}

	public String getCpf_titular() {
		return cpf_titular;
	}

	public void setCpf_titular(String cpf_titular) {
		this.cpf_titular = cpf_titular;
	}

	public Integer getDia_vencimento() {
		return dia_vencimento;
	}

	public void setDia_vencimento(Integer dia_vencimento) {
		this.dia_vencimento = dia_vencimento;
	}

	public Integer getAno_vencimento() {
		return ano_vencimento;
	}

	public void setAno_vencimento(Integer ano_vencimento) {
		this.ano_vencimento = ano_vencimento;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", nome_cliente=" + nome_cliente + ", numero_cartao=" + numero_cartao
				+ ", nome_titular=" + nome_titular + ", cpf_titular=" + cpf_titular + ", dia_vencimento="
				+ dia_vencimento + ", ano_vencimento=" + ano_vencimento + ", bandeira=" + bandeira + "]";
	}


	
}
