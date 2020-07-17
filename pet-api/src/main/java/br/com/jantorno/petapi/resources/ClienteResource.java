package br.com.jantorno.petapi.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jantorno.petapi.domain.Cliente;
import br.com.jantorno.petapi.domain.Pet;
import br.com.jantorno.petapi.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clientes")
@Api(value = "API Rest Clientes")
@CrossOrigin(origins="*")
public class ClienteResource {

		@Autowired
		private ClienteService clienteServices;
		
		@RequestMapping(method=RequestMethod.GET)
		@ApiOperation(value="Retorna a lista de todos os clientes cadastrados.")
		public ResponseEntity<List<Cliente>> listar() {
			return ResponseEntity.status(HttpStatus.OK).body(clienteServices.listar());
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		@ApiOperation(value="Retorna a busca um cliente.")
		public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
			Cliente cliente = clienteServices.buscar(id);
			CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(cliente);
		}
		
		@RequestMapping(method = RequestMethod.POST)
		@ApiOperation(value="Salva um cliente.")
		public ResponseEntity<Void> salvar(@Valid @RequestBody Cliente cliente) {
			cliente = clienteServices.salvar(cliente);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(cliente.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		@ApiOperation(value="Remove um cliente.")
		public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
			clienteServices.deletar(id);
			return ResponseEntity.noContent().build();
		}
			
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		@ApiOperation(value="Atualiza um cliente.")
		public ResponseEntity<Void> atualizar(@RequestBody Cliente cliente, 
				@PathVariable("id") Long id) {
			cliente.setId(id);
			clienteServices.atualizar(cliente);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value = "/{id}/pets", method = RequestMethod.POST)
		@ApiOperation(value="Inclui um pet de um cliente.")
		public ResponseEntity<Void> adicionarPet(@PathVariable("id") Long clienteId, @RequestBody Pet pet) {
			clienteServices.salvarPet(clienteId, pet);
			URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
			return ResponseEntity.created(uri).build();
		}
	}