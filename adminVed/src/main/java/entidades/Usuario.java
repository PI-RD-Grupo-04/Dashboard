package entidades;


public class Usuario {
	private Integer id;
	private String nome;
	private String email;
	private String senha; 
	//private Boolean adm;
	

	public Usuario(String nome, String email, String senha ) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha; 
		//this.adm = adm;
	}


	//public Boolean getAdm() {
	//	return adm;
	//}


//	public void setAdm(Boolean adm) {
//		this.adm = adm;
//	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}	
}