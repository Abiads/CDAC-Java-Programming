package com.cdac;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample
{

	public static void main(String[] args) 
	{
	
//		ArrayList<Integer> al = new ArrayList();
//		
//		al.add(10);
//		al.add(20);
//		al.add(30);
//		al.add(40);
//		al.add(50);
//		
//		
//		for(Integer ele :al)
//		{
//			System.out.println(ele);
//		}
		
		
		ArrayList<Student> al = new ArrayList();
		
		
		Student s1 = new Student(1001,"nsnathan",40);
		Student s2 = new Student(1002,"shan",50);
		Student s3 = new Student(1003,"guru",80);
		
		
		al.add(s1);
		al.add(s2);
		al.add(s3);
		
		
		for(Student s :al)
			{
             s.display();
			}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the details to update");
		
		int sno = sc.nextInt();
		int m = sc.nextInt();
		
		
		
		for(Student s :al)
		{
         
			if(s.sid == sno)
			{
				s.makr = m;
			}
		}
		
		System.out.println("after update");
		
		for(Student s :al)
		{
         s.display();
		}
	
	}
	
	
}
