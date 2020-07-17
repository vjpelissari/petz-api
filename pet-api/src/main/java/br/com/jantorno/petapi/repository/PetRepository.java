package br.com.jantorno.petapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jantorno.petapi.domain.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
	public Pet findByNome(String nome);
	
}