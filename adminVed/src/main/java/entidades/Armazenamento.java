package entidades;

import java.util.List;



public class Armazenamento {

	private Integer id; 
	private String descricao; 
	
	public Armazenamento(String descricao) {
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

	@Override
	public String toString() {
		return descricao ;
	}
	
	
}
