package entidades;

public class Uf {
	private Integer id;
	private String descricao;
	private boolean selecionado = false;
	
	
	
	
	public boolean isSelecionado() {
		return selecionado;
	}


	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}


	public Uf(String descricao) {
		super();
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}


	public Uf(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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
		return "Uf [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
}
