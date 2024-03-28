package com.sopra.microservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesImplementation implements Services {
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public BankingCustomer add(BankingCustomer bc) {
		
		return repo.save(bc);
	}

	@Override
	public List<BankingCustomer> getAll() {
		
		return repo.findAll();
	}

	@Override
	public BankingCustomer getbyId(int custId) {
		Optional<BankingCustomer> cus=repo.findById(custId);
		return cus.get();
	}

	@Override
	public void update(BankingCustomer bc) {
		repo.save(bc);
		
	}
	
	


	
	

}
