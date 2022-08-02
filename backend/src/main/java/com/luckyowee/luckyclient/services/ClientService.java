package com.luckyowee.luckyclient.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luckyowee.luckyclient.dto.ClientDTO;
import com.luckyowee.luckyclient.entities.Client;
import com.luckyowee.luckyclient.repositories.ClientRepository;

@Service
public class ClientService {
	
	//dependencia do ClientRepository
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();
		
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());

	}
}
