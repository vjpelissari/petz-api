package br.com.jantorno.petapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jantorno.petapi.domain.Pet;
import br.com.jantorno.petapi.repository.PetRepository;
import br.com.jantorno.petapi.services.exceptions.PetNaoEncontradoException;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	public List<Pet> listar() {
		return petRepository.findAll();
	}
	
	public Pet buscar(Long id) {
		Pet pet = this.petRepository.findById(id).orElse(null);
		
		if(pet == null) {
			throw new PetNaoEncontradoException("O Pet não foi encontrado.");
		}
		return pet;
	}
	
	public Pet salvar(Pet pet) {
		
		pet.setId(null);
		return petRepository.save(pet);
	}

	
	public void deletar(Long id) {
		try {
			petRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new PetNaoEncontradoException("O pet não foi encontrado.");
		}
	}
	
	public void atualizar(Pet pet) {
		
        this.verificarExistencia(pet);
		petRepository.save(pet);
	}
	
	private void verificarExistencia(Pet pet) {
		buscar(pet.getId());
	}
}