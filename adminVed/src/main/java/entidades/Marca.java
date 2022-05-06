package entidades;

public class Marca {
	private Integer id;
	private String descricao;
	
	
	public Marca(String descricao) {
		super();
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
