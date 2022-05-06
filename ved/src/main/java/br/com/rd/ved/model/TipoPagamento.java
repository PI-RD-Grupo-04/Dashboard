package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_pagamento")
	private Integer id;
	@Column(name = "descricao_pagamento")
	@Size(max = 50)

	@ManyToMany(mappedBy = "tipoPagamento", fetch = FetchType.LAZY)
	private List<Pedido> pedido;

	private String descricao;

	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "tipo_pagamento_boleto", joinColumns = {
			@JoinColumn(name = "id_tipo_pagamento") }, inverseJoinColumns = { @JoinColumn(name = "id_boleto") })
	private Boleto boleto;

	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "tipo_pagamento_pix", joinColumns = {
			@JoinColumn(name = "id_tipo_pagamento") }, inverseJoinColumns = { @JoinColumn(name = "id_pix") })
	private Pix pix;
	
	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "tipo_pagamento_cartao", joinColumns = {
			@JoinColumn(name = "id_tipo_pagamento") }, inverseJoinColumns = { @JoinColumn(name = "id_cartao") })
	private Cartao cartao;
	
	
	

	public TipoPagamento() {
		super();
	}

	public TipoPagamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public TipoPagamento(String descricao) {
		this.descricao = descricao;
	}

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
		return "TipoPagamento [id=" + id + ", descricao=" + descricao + "]";
	}

}
