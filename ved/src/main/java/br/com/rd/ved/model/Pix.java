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

@Entity
@Table(name="pix")
public class Pix {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pix")
	private Integer id;
	@Column(name="codigo_pix")
	private String codigoPix;
	
	
	@OneToMany(mappedBy="pix",fetch = FetchType.LAZY)
	private List <TipoPagamento> tipoPagamento; 
	
	public Pix() {
		super();
	}

	public Pix(Integer id, String codigoPix) {
		this.id = id;
		this.codigoPix = codigoPix;
	}

	public Pix(String codigoPix) {
		this.codigoPix = codigoPix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoPix() {
		return codigoPix;
	}

	public void setCodigoPix(String codigoPix) {
		this.codigoPix = codigoPix;
	}

	@Override
	public String toString() {
		return "Pix [id=" + id + ", codigoPix=" + codigoPix + "]";
	}
	
	
	
}
