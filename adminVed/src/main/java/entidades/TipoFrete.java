package entidades;

public class TipoFrete {

	Integer id;
	String descricao_frete;

	public TipoFrete(String descricao_frete) {
		super();
		this.descricao_frete = descricao_frete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao_frete() {
		return descricao_frete;
	}

	public void setDescricao_frete(String descricao_frete) {
		this.descricao_frete = descricao_frete;
	}

}
