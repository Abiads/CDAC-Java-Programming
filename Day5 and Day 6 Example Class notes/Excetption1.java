package com.cdac;

import java.util.Scanner;

public class Excetption1 
{

	static void calculate(int a,int b)
	{
		try
		{
		int res = a/b;
		System.out.println(res);
		}catch(ArithmeticException e)
		{
			System.out.println("b value should be grater than zero");
		}
	}
	
	
	public static void main(String[] args) 
	{
	
		Scanner s = new Scanner(System.in);
		
		int a=s.nextInt();
		int b=s.nextInt();
		
		calculate(a,b);
		System.out.println("last line in main");
		
	}
	
}
