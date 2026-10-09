package com.cdac;

class C
{
	int i=10;
	
	C()
	{
		System.out.println("no argument of C");
	}
	
//	C(int i)
//	{  this();
//		this.i = 10;
//		System.out.println("parameterised constructor of class C");
//	}
	
	
	void displayC()
	{
		System.out.println(i);
	}
	
		
}


class D extends C
{
	int j;
	
	D()
	{
		System.out.println("no argument of D");
	}
	
	
	D(int i)
	{   super();
		this.j = 20;
		System.out.println("parameterised constructor of class D");
	}
	void displayD()
	{
		System.out.println(j);
	}
	
	
	
	
}


public class TestConstrutorBehaviour
{

	public static void main(String[] args) {
		D d = new D(10);
		d.displayD();
		d.displayC();
	}
	
	
}
