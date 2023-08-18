package com.account.money.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_checkings")
public class Checking implements Serializable{
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numAcc;
	private Double balance;
	private Double limits;
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client clients;
	
	public Checking() {
		
	}

	public Checking(Long id, String numAcc, Double balance, Double limits, Client clients) {
		this.id = id;
		this.numAcc = numAcc;
		this.balance = balance;
		this.limits = limits;
		this.clients = clients;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumAcc() {
		return numAcc;
	}

	public void setNumAcc(String numAcc) {
		this.numAcc = numAcc;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getLimits() {
		return limits;
	}



	public void setLimits(Double limits) {
		this.limits = limits;
	}



	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checking other = (Checking) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
