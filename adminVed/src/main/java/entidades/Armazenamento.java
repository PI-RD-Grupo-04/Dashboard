package entidades;

public class Armazenamento {


	Integer id;
	String descricao_armazenamento;
	
	
	public Armazenamento(String descricao_armazenamento) {
		super();
		this.descricao_armazenamento = descricao_armazenamento;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao_armazenamento() {
		return descricao_armazenamento;
	}
	public void setDescricao_armazenamento(String descricao_armazenamento) {
		this.descricao_armazenamento = descricao_armazenamento;
	}
	

	
	
}
