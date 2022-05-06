package br.com.rd.ved.formdto;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

public class AtualizarClienteForm {

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String nomeSocial;

	@NotBlank
	private String telefone;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Cliente atualizar(Integer id, ClienteRepository cr) {
		Optional<Cliente> cliente = cr.findById(id);
		cliente.get().setNome(nome);
		cliente.get().setSobreNome(sobrenome);
		cliente.get().setNomeSocial(nomeSocial);
		cliente.get().setTelefone(telefone); 
		
		return cliente.get();
		
	}
	
	
}
