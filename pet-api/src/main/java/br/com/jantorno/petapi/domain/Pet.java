package br.com.jantorno.petapi.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Size (max = 100, message = "O nome do Pet não pode ter mais que 100 caracteres.") 
	@NotEmpty (message = "Nome do Pet não pode ser vazio.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty (message = "Idade do Pet não pode ser vazia.")
	private String idade;
	
	@JsonInclude(Include.NON_NULL)
	private String raca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cliente_ID")
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}