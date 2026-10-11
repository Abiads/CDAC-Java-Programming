package com.cdac;

interface Payment
{
	
	public void makepayment(int amount);
	
}


class UPI implements Payment
{

	@Override
	public void makepayment(int amount) 
	{
	System.out.println("payment   " + amount + "processed using SBI");	
		
	}
	
	
}
class Netbanking implements Payment
{

	@Override
	public void makepayment(int amount) 
	{
	System.out.println("payment  " + amount +" processedusing netbanking");	
		
	}
	
	
}


class DebitCard implements Payment
{

	@Override
	public void makepayment(int amount) 
	{
	System.out.println("payment   " + amount +" processed using DebitCard");	
		
	}
	
	
}




public class InterfaceExample 
{
public static void main(String[] args)
{
int a;

	Payment p;
	
       p= new UPI();
	   p.makepayment(2000);
	   
	   
	   
			
}

}
