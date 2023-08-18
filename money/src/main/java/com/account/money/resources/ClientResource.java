package com.account.money.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.money.entities.Client;
import com.account.money.services.ClientService;

@ResponseBody
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	private ClientService clientService;
	
	@PostMapping("/")
	public ResponseEntity<?> insertClient(@RequestBody Client client){
		return clientService.insert(client);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		return clientService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id){
		return clientService.getById(id);
	} 
	
	@PutMapping("/")
	public ResponseEntity<?> editClient(@RequestBody Client obj){
		return clientService.update(obj);
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeById(@PathVariable("id") Long id){
		return clientService.removeById(id);
	} 
	
}
