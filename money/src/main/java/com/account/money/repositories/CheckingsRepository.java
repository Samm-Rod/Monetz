package com.account.money.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.money.entities.Checking;

public interface CheckingsRepository extends JpaRepository<Checking, Long>{

}
