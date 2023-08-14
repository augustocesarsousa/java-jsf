package com.acsousa.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Size(min = 4, max = 50, message = "Nome precisa ter entre 4 e 50 dígitos")
	private String nome;
	
	@NotNull(message = "Informe o sobrenome")
	@NotEmpty(message = "Informe o sobrenome")
	private String sobrenome;
	
	@Email(message = "Email inválido")
	private String email;
	private String telefone;
	
	@Temporal(TemporalType.DATE)
	@Past(message = "Data inválida")
	private Date dataNascimento;
	
	private Character sexo;
	private String[] linguagens;
	private String[] bancosDados;
	private Boolean ativo;
	
	@Size(min = 4, max = 12, message = "A senha deve ter entre 4 e 12 dígitos")
	private String senha;
	private String perfil;

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String[] getLinguagens() {
		return linguagens;
	}

	public void setLinguagens(String[] tecnologis) {
		this.linguagens = tecnologis;
	}
	
	public String[] getBancosDados() {
		return bancosDados;
	}

	public void setBancosDados(String[] bancosDados) {
		this.bancosDados = bancosDados;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", telefone="
				+ telefone + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", tecnologis="
				+ Arrays.toString(linguagens) + ", ativo=" + ativo + ", perfil=" + perfil + "]";
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
