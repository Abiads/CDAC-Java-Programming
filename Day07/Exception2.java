package com.cdac;

public class Exception2
{

	public static void main(String[] args) 
	{
	
		//ArrayIndexOutOfBoundsException
		int[] num = {10,30,30,40,50};
		
		try
		{
		System.out.println(num[5]);
		}catch( ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array out of bounds");
		}finally
		{
			System.out.println("inside finally");
		}
		
		
		System.out.println("main ended");
	}
}
