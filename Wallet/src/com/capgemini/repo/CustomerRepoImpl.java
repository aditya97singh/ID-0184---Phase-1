package com.capgemini.repo;

import java.util.HashMap;
import java.util.Map;
import com.capgemini.beans.Customer;

public class CustomerRepoImpl implements CustomerRepo{
	
	static Map<String,Customer> m=new HashMap<>();
	public boolean save(Customer customer)
	{
		String n=customer.getMobNo();
		if(findOne(n)!=null)
			return false;
		m.put(n,customer);
		return true;
	}
	public Customer findOne(String mobNo)
	{
        if(m.containsKey(mobNo))
        {
        	Customer c=m.get(mobNo);
        	return c;
        }
        return null;
	}

}
