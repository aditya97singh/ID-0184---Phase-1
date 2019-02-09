package com.capgemini.testing;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import com.capgemini.exceptions.*;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.repo.CustomerRepoImpl;
import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;

public class TestC {

	@Before
	public void setUp() throws Exception {
	}


	CustomerRepo crepo = new CustomerRepoImpl();
	CustomerService cs = new CustomerServiceImpl(crepo);
	
	
	@Test //(expected = com.capgemini.exceptions.InsufficientAmountException.class)
	public void WhenTheBalanceIsNotEnoughToWithDrawThenThrowAnError() throws InsufficientAmountException, DuplicateMobileNoException, MobileNoIsNotFoundException {
		
		cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.withdrawAmount("81263162788",BigDecimal.valueOf(2000));
	}
	
	@Test(expected = com.capgemini.exceptions.InsufficientAmountException.class)
	public void WhenTheBalanceIsNotEnoughToTransferThenThrowAnError() throws InsufficientAmountException, DuplicateMobileNoException, MobileNoIsNotFoundException {
		
		
		cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.createAccount("Shobhit", "8128381111", BigDecimal.valueOf(1000));
		cs.fundTransfer("81263162788", "8128381111", BigDecimal.valueOf(2000));
		
	}
	
	@Test(expected = com.capgemini.exceptions.DuplicateMobileNoException.class)
	public void WhenTheMobileNumberIsDuplicateThenThrowAnError() throws InsufficientAmountException, DuplicateMobileNoException, MobileNoIsNotFoundException{
		
        cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.createAccount("Shobhit", "81263162788", BigDecimal.valueOf(500));
		
	}
	
	@Test(expected = com.capgemini.exceptions.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToShowBalanceThenThrowAnError() throws InsufficientAmountException, DuplicateMobileNoException, MobileNoIsNotFoundException {
		
		cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.showAmount("8755560521");
	}
	
	@Test
	public void WhenTheMobileNumberIsValidThenShowBalanceSuccessfully() throws InsufficientAmountException, DuplicateMobileNoException, MobileNoIsNotFoundException {
		
		cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.showAmount("81263162788");
	}
	
	
	@Test(expected = com.capgemini.exceptions.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToFundTransferThenThrowAnError() throws InsufficientAmountException, DuplicateMobileNoException, MobileNoIsNotFoundException {
		
	
		cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.createAccount("Shobhit", "8128381111", BigDecimal.valueOf(500));
		cs.fundTransfer("81263162788", "9761490311", BigDecimal.valueOf(500));
		
	}
	
	
	@Test(expected = com.capgemini.exceptions.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToDepositAmountThenThrowAnError() throws InsufficientAmountException, DuplicateMobileNoException, MobileNoIsNotFoundException {
		
		cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.depositAmount("8755560521", BigDecimal.valueOf(1000));
	}
	
	
	@Test(expected = com.capgemini.exceptions.MobileNoIsNotFoundException.class)
	public void WhenTheMobileNumberIsNotFoundToWithDrawAmountThenThrowAnError() throws MobileNoIsNotFoundException, DuplicateMobileNoException {
		
		cs.createAccount("Aditya", "81263162788", BigDecimal.valueOf(1000));
		cs.depositAmount("8755560521",  BigDecimal.valueOf(1000));
	}
	

}
	
	


