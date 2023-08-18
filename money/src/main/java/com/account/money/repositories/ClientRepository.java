package com.account.money.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.money.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findAll();
	Client findById(long id);
	long countById(long id);
}
