package com.sopra.microservices;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface Services {
	
	public BankingCustomer add(BankingCustomer bc);
	
	public List<BankingCustomer> getAll();
	
	public BankingCustomer getbyId(int custId);

	void update(BankingCustomer bc);
	
	
	
	

}
