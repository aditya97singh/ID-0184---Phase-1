package com.capgemini.service;

import java.math.BigDecimal;
import com.capgemini.beans.Customer;
import com.capgemini.beans.WalletC;
import com.capgemini.exceptions.*;
import com.capgemini.repo.CustomerRepo;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerRepo crepo;
    public  CustomerServiceImpl(CustomerRepo crepo){
		this.crepo=crepo;
	}
	
	public Customer createAccount(String name, String mobNo,BigDecimal am) throws DuplicateMobileNoException
	{
	
		BigDecimal ww=am;
		WalletC y=new WalletC(ww);
		Customer x=new Customer(name,mobNo,y);
		if(crepo.findOne(mobNo)==x)
		{
		WalletC w=new WalletC();
        Customer c=new Customer();
		c.setName(name);
		c.setMobNo(mobNo);
		w.setBalance(am);
		c.setWallet(w);
		if(crepo.save(c))
		{ 
			     return c;
		}
	     }throw new DuplicateMobileNoException();
	}
	
	public Customer showAmount(String mobNo) throws MobileNoIsNotFoundException
	{
		if(crepo.findOne(mobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		return crepo.findOne(mobNo);
	}
	
	public Customer depositAmount(String mobNo,BigDecimal am) throws MobileNoIsNotFoundException
	{
		if(crepo.findOne(mobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		Customer c=crepo.findOne(mobNo);
		if(c!=null)
		{	
		 WalletC w=new WalletC();
		 w.setBalance(am.add(c.getWallet().getBalance()));
		 c.setWallet(w);
		 return c;
		}
		return null;
	}
	
	public Customer withdrawAmount(String mobNo,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException
	{
		if(crepo.findOne(mobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		
		Customer c=crepo.findOne(mobNo);
		if(c!=null)
		{	
			BigDecimal a = c.getWallet().getBalance();
			int i = a.compareTo(am);
			if(i == -1) {
				throw new InsufficientAmountException();
			}
		 WalletC w=new WalletC();
		 w.setBalance((c.getWallet().getBalance()).subtract(am));
		 c.setWallet(w);
		 return c;
		}
		return null;
	}
	
	public Customer fundTransfer(String sourceMobNo, String targetMobNo,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException
	{
		Customer a=crepo.findOne(sourceMobNo);
		Customer b=crepo.findOne(targetMobNo);
		
		if(crepo.findOne(targetMobNo)==null)
	    	  throw new MobileNoIsNotFoundException();
		
		if(a!=null && b!=null)
		{
			BigDecimal y = a.getWallet().getBalance();
			int i = y.compareTo(am);
			if(i == -1) {
				throw new InsufficientAmountException();
			}
			
			WalletC w1=new WalletC();
			WalletC w2=new WalletC();
			w1.setBalance(am.add(b.getWallet().getBalance()));
			w2.setBalance((a.getWallet().getBalance()).subtract(am));
			a.setWallet(w2);
			b.setWallet(w1);
			return b;
		}
		return null;
	}

}
