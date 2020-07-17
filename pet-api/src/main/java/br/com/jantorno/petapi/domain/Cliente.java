package br.com.jantorno.petapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Size (max = 100, message = "O nome do cliente não pode ter mais que 100 caracteres.") 
	@NotEmpty (message = "Nome do cliente não pode ser vazio.")
	@NotNull
	private String nome;

	@NotEmpty (message = "CPF do cliente não pode ser vazio.")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@JsonInclude(Include.NON_NULL)
	@NotEmpty (message = "Email do cliente não pode ser vazio")
	@NotNull
	private String email;

	@Size (min = 9, message = "Telefone do cliente incompleto.")
	private String telefone;
	
	public Long getId() {
		return id;
	}

	@JsonInclude(Include.NON_NULL)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
	private List<Pet> pets;
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}