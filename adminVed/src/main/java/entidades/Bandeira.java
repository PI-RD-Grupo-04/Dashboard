package entidades;

public class Bandeira {

	private Integer id;
	private String nome_bandeira;

	public Bandeira(String nome_bandeira) {
		super();
		this.nome_bandeira = nome_bandeira;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_bandeira() {
		return nome_bandeira;
	}

	public void setNome_bandeira(String nome_bandeira) {
		this.nome_bandeira = nome_bandeira;
	}

}
