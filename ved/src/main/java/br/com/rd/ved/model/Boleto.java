package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="boleto")
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_boleto")
	private Integer id;
	@Column(name="codigo_barra", nullable = false)
	@Size(max = 25)
	private String codigoBarras;
	
	@OneToMany(mappedBy="boleto",fetch = FetchType.LAZY)
	private List <TipoPagamento> tipoPagamento; 
	
	
	
	
	public Boleto() {
		super();
	}

	public Boleto(Integer id, String codigoBarras) {
		this.id = id;
		this.codigoBarras = codigoBarras;
	}

	public Boleto(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	@Override
	public String toString() {
		return "Boleto [id=" + id + ", codigoBarras=" + codigoBarras + "]";
	}
	
	
	
}
