package com.sopra.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<BankingCustomer, Integer>{

}
