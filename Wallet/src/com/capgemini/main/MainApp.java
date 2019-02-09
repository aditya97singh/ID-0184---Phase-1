package com.capgemini.main;

import java.math.BigDecimal;
import java.util.Scanner;
import com.capgemini.exceptions.DuplicateMobileNoException;
import com.capgemini.exceptions.InsufficientAmountException;
import com.capgemini.exceptions.MobileNoIsNotFoundException;
import com.capgemini.repo.CustomerRepo;
import com.capgemini.repo.CustomerRepoImpl;
import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		CustomerRepo crepo=new CustomerRepoImpl();
		CustomerService cs=new CustomerServiceImpl(crepo);
         Scanner sc=new Scanner(System.in);
         int ch;
		do{
			System.out.println("*******Payment Wallet*******\n");
			System.out.println(" 1.Create Account");
			System.out.println(" 2.Show Balance");
			System.out.println(" 3.Deposit Amount");
			System.out.println(" 4.Withdraw Amount");
			System.out.println(" 5.Fund Transfer");
			System.out.println(" 6.Print Transcations");
			
			System.out.println("\nEnter Your Choice :\n");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Please Enter Your Mobile Number");
				String MobNo=sc.next();
				System.out.println("Please Enter Your Name");
				String Name=sc.next();
				System.out.println("Please Enter Money you wanted to add");
				BigDecimal m=sc.nextBigDecimal();
	        try {
			 System.out.println("Account Created : "+cs.createAccount(Name, MobNo,m));
		    } catch (DuplicateMobileNoException e) {
		    	// TODO Auto-generated catch block
			 e.printStackTrace();
		    }
	        break;

 
			case 2:
				try{
				System.out.println("Please Enter Your Mobile Number");
				String MobNo1=sc.next();
				System.out.println("Your amount : "+cs.showAmount(MobNo1));
				}catch(MobileNoIsNotFoundException e) {
			    	// TODO Auto-generated catch block
					 e.printStackTrace();
				    }
	         break;
	         
			case 3:
				System.out.println("Enter mobile number");
	            try {
        	    String MobNo1=sc.next();
        	    System.out.println("Enter amount");
        	    BigDecimal m1=sc.nextBigDecimal();
			    System.out.println("Amount deposited : "+cs.depositAmount(MobNo1,m1));
                } catch (MobileNoIsNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
                }
			   break;
			
			case 4:
				System.out.println("Enter mobile number");
	            try {
        	    String MobNo1=sc.next();
        	    System.out.println("Enter amount");
        	    BigDecimal m1=sc.nextBigDecimal();
			    System.out.println("Amount deposited : "+cs.withdrawAmount(MobNo1,m1));
                } catch (MobileNoIsNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
                }
	            catch (InsufficientAmountException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
			   break;
				
			case 5:
				System.out.println("Enter source mobile number");
	            try {
        	    String MobNo1=sc.next();
        	    System.out.println("Enter target mobile number");
        	    String MobNo2=sc.next();
        	    System.out.println("Enter amount");
        	    BigDecimal m1=sc.nextBigDecimal();
			    System.out.println("Amount deposited : "+cs.fundTransfer(MobNo1,MobNo2,m1));
                } catch (MobileNoIsNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
                }
	            catch (InsufficientAmountException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
			   break;
			   
			case 6 :
				System.out.println("Out of Ink, Please refill");
				break;
				
			}
			}while(ch!=7);
		}
	}


