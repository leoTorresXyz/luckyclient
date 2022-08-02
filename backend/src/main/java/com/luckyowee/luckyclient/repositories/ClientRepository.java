package com.luckyowee.luckyclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckyowee.luckyclient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
