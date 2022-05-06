package entidades;

public class Receita {

	private Integer id;
	private String ingredientes;
	private String preparo;
	private String titulo;

	public Receita(String ingredientes, String preparo, String titulo) {
		this.ingredientes = ingredientes;
		this.preparo = preparo;
		this.titulo = titulo;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparo() {
		return preparo;
	}

	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
