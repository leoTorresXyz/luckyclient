package com.luckyowee.luckyclient.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luckyowee.luckyclient.dto.ClientDTO;
import com.luckyowee.luckyclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	//cria a dependencia para o ClientService
	@Autowired
	private ClientService service;
	
	/*
	 * Camada de Controle(Resources) recebe as requisições do Front end e passa pro Services usando DTO.
	 * DTO repassa a requisição e o Services devolve após fazer as chamadas no BD
	 */
	
	//chamada do metodo findAll do ClientService
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//chamada do metodo findById do ClientService
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		ClientDTO dto = service.findByid(id);
		return ResponseEntity.ok().body(dto);
	}
	
	//chamada do metodo insert do ClientService
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
