package com.capgemini.beans;

import java.math.BigDecimal;

public class WalletC {
	
	private BigDecimal balance;

	public WalletC(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public WalletC() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "WalletC [balance=" + balance + "]";
	}
	
	

}
