package com.luckyowee.luckyclient.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luckyowee.luckyclient.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	//Response entity encapsula uma resposta http no modelo/entidade Client
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		return null;
	}
}
