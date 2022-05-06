package entidades;

<<<<<<< HEAD

public class Armazenamento{
=======
public class Armazenamento {
>>>>>>> 0a520af20fb5aff9538e0d08a157782c68ca5499

	private Integer id;
	private String descricao;

	public Armazenamento(String descricao) {
		this.descricao = descricao;
	}
<<<<<<< HEAD
	
=======

>>>>>>> 0a520af20fb5aff9538e0d08a157782c68ca5499
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
		return descricao;
	}
}
