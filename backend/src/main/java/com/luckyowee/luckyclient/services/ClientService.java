package com.luckyowee.luckyclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luckyowee.luckyclient.dto.ClientDTO;
import com.luckyowee.luckyclient.entities.Client;
import com.luckyowee.luckyclient.repositories.ClientRepository;
import com.luckyowee.luckyclient.services.exceptions.DatabaseException;
import com.luckyowee.luckyclient.services.exceptions.ResourceNotFoundException;

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

	@Transactional(readOnly = true)
	public ClientDTO findByid(Long id) {
		Optional<Client> obj = repository.findById(id);
		//chamo a exceção personalizada (services.exceptions) caso não encontre o id do client e informo a camada de controle (resources.exceptions)
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
		entity = repository.save(entity);//salva os dados recebidos pelo DTO
		
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);//metodo getOne esta deprecated...devew ser substituido por getReferenceById
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			
			entity = repository.save(entity); //salva os dados recebidos pelo DTO
			
			return new ClientDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	//delete não recebe annotation
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
