package entidades;

public class Fornecedor {
	private Integer id;
	private String razao_social;
	private String cnpj;
	private String email;
	
	
	public Fornecedor(String razao_social, String cnpj, String email) {
		super();
		this.razao_social = razao_social;
		this.cnpj = cnpj;
		this.email = email;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRazao_social() {
		return razao_social;
	}


	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}