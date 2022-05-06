package br.com.rd.ved.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id;
	
	@Column(name = "nome", nullable = false)
	@Size(max = 50)
	private String nome;

	@Column(name = "sobrenome", nullable = false)
	@Size(max = 50)
	private String sobrenome;

	@Column(name = "nome_social")
	@Size(max = 30)
	private String nomeSocial;

	@Column(name = "cpf", nullable = false)
	@Size(max = 16)
	private String cpf;

	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	@NotBlank
	@Column(name = "email", nullable = false)
	@Size(max = 30)
	private String email;

	@Column(name = "telefone", nullable = false)
	@Size(max = 16)
	private String telefone;

	@Column(name = "senha", nullable = false)
	private String senha;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	@JsonIgnore
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cliente_cartao", joinColumns = { @JoinColumn(name = "id_cliente") }, inverseJoinColumns = {
			@JoinColumn(name = "id_cartao") })
	private List<Cartao> cartoes;
	
	
	
	@JsonIgnore
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cliente_endereco", joinColumns = { @JoinColumn(name = "id_cliente") }, inverseJoinColumns = {
			@JoinColumn(name = "id_endereco") })
	private List<Endereco> enderecos;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String sobreNome, String nomeSocial, String cpf, Date dataNascimento, String email,
			String telefone, String senha) {
		this.nome = nome;
		this.sobrenome = sobreNome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobrenome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobrenome = sobreNome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nome Social=" + nomeSocial
				+ ", cpf=" + cpf + ", data de Nascimento=" + dataNascimento + ", email=" + email + ", telefone="
				+ telefone + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}