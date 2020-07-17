package br.com.jantorno.petapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jantorno.petapi.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Cliente findByNome(String nome);
	public Cliente findByCpf(String cpf);
}