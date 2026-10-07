package com.cdac;

import java.util.Scanner;

class A
{
	int i=10;
	
	

	void displayA()
	{
		System.out.println(i);
	}
	
	
}


class B extends A
{
	int j=20;
	
	

	void displayB()
	{
		System.out.println(j);
	}
	
}





public class InheritanceMain 
{
public static void main(String[] args) 
{
	B b = new B();
	b.i = 100;
	b.j=200;
	b.displayA();
	b.displayB();
	
}
	
}
