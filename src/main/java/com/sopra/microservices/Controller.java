package com.sopra.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class Controller {
	
	@Autowired
	private ServicesImplementation ser;
	
	@PostMapping("/add")
	public ResponseEntity<Void> add(@RequestBody BankingCustomer bc){
		ser.add(bc);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<BankingCustomer>> getAll(){
		List<BankingCustomer> ls=ser.getAll();
		return new ResponseEntity<>(ls,HttpStatus.OK);
	}
	
	@GetMapping("/get/{custId}")
	public ResponseEntity<BankingCustomer> getbyId(@PathVariable("cust_Id") int id){
		BankingCustomer bc=ser.getbyId(id);
		return new ResponseEntity<>(bc, HttpStatus.OK);
		
	}
	
	@PutMapping("/deposit")
	public ResponseEntity<String> deposit(@RequestBody double amount, int custId){
		BankingCustomer bc = ser.getbyId(custId);
		bc.setAccBalance(bc.getAccBalance() + amount);
		ser.update(bc);
		return new ResponseEntity<String>("deposited",HttpStatus.OK);
		
		
	}
	
	@PutMapping("/withdraw")
	public ResponseEntity<String> withdraw(@RequestBody double amount, int custId){
		BankingCustomer bc = ser.getbyId(custId);
		bc.setAccBalance(bc.getAccBalance() - amount);
		ser.update(bc);
		return new ResponseEntity<String>("withdrawn",HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
