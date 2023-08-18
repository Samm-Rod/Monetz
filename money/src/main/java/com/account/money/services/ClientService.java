package com.account.money.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.money.entities.Client;
import com.account.money.repositories.ClientRepository;

@Service
public class ClientService {
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	private Map<Client, Long> clients = new HashMap<>();
	
	public ResponseEntity<?> insert(Client obj) {
		if(obj.getName().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else if(obj.getCpf().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else if(obj.getEmail().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else if(obj.getContact().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(clientRepository.save(obj),HttpStatus.CREATED);  
		}
	}
	
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(clientRepository.findAll(),HttpStatus.OK);
	}
	
	public ResponseEntity<?> getById(long id){
		if(clientRepository.countById(id) == 0) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND); 
		}else {
			return new ResponseEntity<>(clientRepository.findById(id),HttpStatus.FOUND);
		}
	}
	
	public ResponseEntity<?> update(Client obj){
		if(obj.getId() <= 0) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}else if(obj.getName().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else if(obj.getCpf().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else if(obj.getEmail().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else if(obj.getContact().equals("")) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(clientRepository.save(obj),HttpStatus.CREATED);  
		}
	}
	
	public ResponseEntity<String> removeById(long id){
		if(clientRepository.countById(id) == 0) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND); 
		}else {
			Client client = clientRepository.findById(id);
			return new ResponseEntity<>("REMOVED !",HttpStatus.FOUND);
		}
	}

}
