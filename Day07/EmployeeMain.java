package com.cdac;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeMain
{

	public static void main(String[] args) 
	{
	
		EmployeeManagement em = new EmployeeManagement();
        //create
		
		ArrayList<Employee> al=em.createEmpList();
		
		
		//iterate
		
        em.displayEmpList( al);
		
		//serarch
        
        
        em.SearchEmployee(al);
        
        
		

//		//update
//		System.out.println("enter details");
//		eno = sc.nextInt();
//		int sa = sc.nextInt();
//		for(Employee obj :al)
//		{
//			if(obj.empno==eno)
//			{
//				obj.sal = sa;
//			}
//		}
//		
//		System.out.println("after update");
//		for(Employee obj :al)
//		{
//			obj.displayEmp();
//		}
//		
//		
//		//delete
//		
//		System.out.println("enter empno to delete");
//		eno = sc.nextInt();
//		int pos =0;
//		for(Employee obj :al)
//		{
//			if(obj.empno==eno)
//			{
//				pos = al.indexOf(obj);
//			}
//		}
//		al.remove(pos);
//		
//		System.out.println("after delete");
//		
//		for(Employee obj :al)
//		{
//			obj.displayEmp();
//		}
		
		
		
		
		
	}
	
}
