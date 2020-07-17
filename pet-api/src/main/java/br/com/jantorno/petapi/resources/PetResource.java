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

import br.com.jantorno.petapi.domain.Pet;
import br.com.jantorno.petapi.services.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pets")
@Api(value = "API Rest Pets")
@CrossOrigin(origins="*")
public class PetResource {

	@Autowired
	private PetService petServices;
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Retorna a lista de todos os pets cadastrados.")
	public ResponseEntity<List<Pet>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(petServices.listar());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna a busca um pet.")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Pet pet = petServices.buscar(id);
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(pet);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Salva um pet.")
	public ResponseEntity<Void> salvar(@Valid @RequestBody Pet pet) {
		pet = petServices.salvar(pet);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pet.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="Remove um pet.")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		petServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value="Atualiza um pet.")
	public ResponseEntity<Void> atualizar(@RequestBody Pet pet, 
			@PathVariable("id") Long id) {
		pet.setId(id);
		petServices.atualizar(pet);
		return ResponseEntity.noContent().build();
	}
}