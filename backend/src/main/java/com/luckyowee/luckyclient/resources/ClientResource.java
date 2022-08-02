package com.luckyowee.luckyclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckyowee.luckyclient.entities.Client;
import com.luckyowee.luckyclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	//dependencia para o ClientService
	@Autowired
	private ClientService service;
	
	//chamada do metodo findAll do ClientService
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
