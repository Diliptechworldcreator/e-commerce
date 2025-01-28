package com.jsp.ecommerce_jee_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private byte[] image;
	
	
	public Customer(String customerName, String customerEmail, String customerPassword, byte[] image) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.image = image;
	}
	
	

}
