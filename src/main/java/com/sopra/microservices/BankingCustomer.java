package com.sopra.microservices;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankingCustomer {
	
	@Id
	int custId;
	@Nonnull
	long accNo;
	@Nonnull
	String ifsc;
	@Nonnull
	String custName;
	@Nonnull
	String address;
	@Nonnull
	String phoneNo;
	@Nonnull
	String accType;
	@Nonnull
	double accBalance;

}
