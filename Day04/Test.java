package com.cdac;

public class Test
{

	public static void main(String[] args) 
	{
	
		TestEncapsulation t = new TestEncapsulation();
		t.setEmpno(1001);
		t.setName("nsnathan");
		int n = t.getEmpno();
		System.out.println(n);
		System.out.println(t.getName());
		
	}
}
