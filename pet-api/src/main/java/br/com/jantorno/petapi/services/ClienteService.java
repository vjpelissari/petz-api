package br.com.jantorno.petapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.jantorno.petapi.domain.Cliente;
import br.com.jantorno.petapi.domain.Pet;
import br.com.jantorno.petapi.repository.ClienteRepository;
import br.com.jantorno.petapi.repository.PetRepository;
import br.com.jantorno.petapi.services.exceptions.ClienteNaoEncontradoException;
import br.com.jantorno.petapi.services.exceptions.CpfClienteExistenteException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscar(Long id) {
		Cliente cliente = this.clienteRepository.findById(id).orElse(null);
		
		if(cliente == null) {
			throw new ClienteNaoEncontradoException("O cliente não foi encontrado.");
		}
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		
		Cliente cliente_pesquisado = clienteRepository.findByCpf(cliente.getCpf());
		
		if (cliente_pesquisado != null) {
			throw new CpfClienteExistenteException("O cpf do cliente já encontra-se cadastrado.");
		}
		cliente.setId(null);
		return clienteRepository.save(cliente);
	}
	

	
	public void deletar(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException("O cliente não foi encontrado.");
		}
	}
	
	public void atualizar(Cliente cliente) {
		
		// O cliente tem que existir para ser atualizado
        this.verificarExistencia(cliente);
				
		// Valida se o nome ja esta cadastrado para ou cliente
		this.validarNomeUpdate(cliente);

		clienteRepository.save(cliente);
	}
	
	private void verificarExistencia(Cliente cliente) {
		buscar(cliente.getId());
	}
	
	private void validarNomeUpdate(Cliente cliente) {
        
		Cliente clientePesquisa = clienteRepository.findByNome(cliente.getNome());

		if ((clientePesquisa != null) && (clientePesquisa.getId() != cliente.getId())) {
			throw new CpfClienteExistenteException("O nome do cliente já encontra-se cadastrado.");
		}
	}
	
	public Pet salvarPet(Long clienteId, Pet pet) {
		Cliente cliente = buscar(clienteId);
		pet.setCliente(cliente);
		return petRepository.save(pet);
	}
}