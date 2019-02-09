package com.capgemini.beans;

public class Customer {

	private String name;
	private String mobNo;
	private WalletC wallet; 
	
	public Customer(String name, String mobNo,WalletC wallet) {
		super();
		this.name = name;
		this.mobNo = mobNo;
		this.wallet=wallet;
	} 
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public WalletC getWallet() {
		return wallet;
	}
	public void setWallet(WalletC wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobNo=" + mobNo + ", wallet=" + wallet + "]";
	}
	
	
	
}
