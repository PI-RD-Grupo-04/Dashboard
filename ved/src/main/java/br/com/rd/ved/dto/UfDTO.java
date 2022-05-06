package br.com.rd.ved.dto;

import br.com.rd.ved.model.Uf;

public class UfDTO {

	private Integer id;
	private String nomeUf;
	

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nomeUf;
	}

	public UfDTO(Integer id, String nome) {

		this.id = id;
		this.nomeUf = nome;
	}

	public UfDTO(Uf uf) {
		this.id = uf.getId();

	}

}
