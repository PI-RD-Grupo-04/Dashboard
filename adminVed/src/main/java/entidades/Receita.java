package entidades;

public class Receita {

	private Integer id_receita;
	private String ingredientes;
	private String preparo;
	private String titulo;

	public Receita(String ingredientes, String preparo, String titulo) {
		super();
		this.ingredientes = ingredientes;
		this.preparo = preparo;
		this.titulo = titulo;

	}

	public Integer getId_receita() {
		return id_receita;
	}

	public void setId_receita(Integer id_receita) {
		this.id_receita = id_receita;
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
