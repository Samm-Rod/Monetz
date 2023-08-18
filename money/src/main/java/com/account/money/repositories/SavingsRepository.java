package com.account.money.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.money.entities.Savings;

public interface SavingsRepository extends JpaRepository<Savings, Long>{
	
}
