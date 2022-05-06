package entidades;

import java.util.Date;

public class RelacaoPedido {
	
	 private String stPedido;
	 private Date data;
	 private String tpEntrega;                 
	 private Double  total;
	 private Integer quantidade;
	 private Double  valor;
	 private String cep;
	 public String rua;
	 private Integer numero;
	 private String municipio;
	 private Integer idpedido;
	 private String pamento;
	 private String nome;
	 private String sobrenome;
	 private String cpf;
	 private String telefone;
	 private String email;
	 private String uf;
	 
	 
	 
	 
	 
	 
	 
	 
	@Override
	public String toString() {
		return "RelacaoPedido [stPedido=" + stPedido + ", data=" + data + ", tpEntrega=" + tpEntrega + ", total="
				+ total + ", quantidade=" + quantidade + ", valor=" + valor + ", cep=" + cep + ", rua=" + rua
				+ ", numero=" + numero + ", municipio=" + municipio + ", idpedido=" + idpedido + ", pamento=" + pamento
				+ ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", telefone=" + telefone + ", email="
				+ email + ", uf=" + uf + "]";
	}
	
	
	
	
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 public Integer getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}
	public String getStPedido() {
		return stPedido;
	}
	public void setStPedido(String stPedido) {
		this.stPedido = stPedido;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTpEntrega() {
		return tpEntrega;
	}
	public void setTpEntrega(String tpEntrega) {
		this.tpEntrega = tpEntrega;
	}
	public String getPamento() {
		return pamento;
	}
	public void setPamento(String pamento) {
		this.pamento = pamento;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public RelacaoPedido(String stPedido, Date data, String tpEntrega, Double total, Integer quantidade, Double valor,
			String cep, String rua, Integer numero, String municipio, String pamento, String nome, String sobrenome,
			String cpf, String telefone, String email, String uf) {
		super();
		this.stPedido = stPedido;
		this.data = data;
		this.tpEntrega = tpEntrega;
		this.total = total;
		this.quantidade = quantidade;
		this.valor = valor;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.municipio = municipio;
		this.pamento = pamento;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.uf = uf;
	}
	
	
	

	 

	
	
	
	
	
}
