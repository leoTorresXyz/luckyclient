package com.luckyowee.luckyclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckyowee.luckyclient.entities.Client;
import com.luckyowee.luckyclient.repositories.ClientRepository;

@Service
public class ClientService {
	
	//dependencia do ClientRepository
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
}
