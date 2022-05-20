package entidades;

public class Frete {

	Integer id ; 
	Double valor;
	Integer tipo_frete;
	Integer uf;
	String tipo_freteTxt;
	String ufTxt;
	
	
	


	public Frete(Double valor, String tipo_freteTxt, String ufTxt) {
		super();
		this.valor = valor;
		this.tipo_freteTxt = tipo_freteTxt;
		this.ufTxt = ufTxt;
	}

	public Frete(Double valor, Integer tipo_frete, Integer uf) {
		super();
		this.valor = valor;
		this.tipo_frete = tipo_frete;
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getTipo_frete() {
		return tipo_frete;
	}

	public void setTipo_frete(Integer tipo_frete) {
		this.tipo_frete = tipo_frete;
	}

	public Integer getUf() {
		return uf;
	}

	public void setUf(Integer uf) {
		this.uf = uf;
	}
	public String getTipo_freteTxt() {
		return tipo_freteTxt;
	}

	public void setTipo_freteTxt(String tipo_freteTxt) {
		this.tipo_freteTxt = tipo_freteTxt;
	}

	public String getUfTxt() {
		return ufTxt;
	}

	public void setUfTxt(String ufTxt) {
		this.ufTxt = ufTxt;
	}
	@Override
	public String toString() {
		return "Frete [id=" + id + ", valor=" + valor + ", tipo_frete=" + tipo_frete + ", uf=" + uf + "]";
	}
	
	
	
	
	
	
	
	
}
