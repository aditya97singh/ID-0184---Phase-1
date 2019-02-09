package com.capgemini.service;

import java.math.BigDecimal;
import com.capgemini.beans.Customer;
import com.capgemini.exceptions.*;

public interface CustomerService {

	public Customer createAccount(String name, String mobNo, BigDecimal am) throws DuplicateMobileNoException;
	public Customer showAmount(String mobNo) throws MobileNoIsNotFoundException;
	public Customer depositAmount(String mobNo, BigDecimal am) throws MobileNoIsNotFoundException;
	public Customer withdrawAmount(String mobno,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException;
	public Customer fundTransfer(String sourceMobNo, String targetMobNo,BigDecimal am) throws MobileNoIsNotFoundException, InsufficientAmountException;
}
