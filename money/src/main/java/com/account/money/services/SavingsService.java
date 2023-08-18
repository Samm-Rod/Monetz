package com.account.money.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.account.money.entities.Savings;
import com.account.money.repositories.SavingsRepository;

@Service
public class SavingsService {
	
	@Autowired
	private SavingsRepository savingsRepository;
	private List<Savings> list = new ArrayList<>();
	private Map<Savings, String> map = new HashMap<>();
	
	private Integer generatedNum() {
		Random aleat = new Random();
		return aleat.nextInt(100000 + 900000);
	}
	
	public ResponseEntity<?> openAccount(Savings obj){
		String num = String.valueOf(generatedNum());
		if(obj.getNumAcc().equals("")) {
			return new ResponseEntity<>("UNDEFINED NUMBER ACCOUNT !",HttpStatus.BAD_REQUEST);
		}
		obj.setNumAcc(num);
		return new ResponseEntity<>(savingsRepository.save(obj),HttpStatus.CREATED);
	}
}
