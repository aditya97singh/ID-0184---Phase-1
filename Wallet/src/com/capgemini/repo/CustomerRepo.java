package com.capgemini.repo;

import com.capgemini.beans.Customer;

public interface CustomerRepo {
	
	public boolean save(Customer customer);
	public Customer findOne(String mobNo);

}
