package com.cdac;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement
{

	public ArrayList<Employee> createEmpList()
	{
		
		
		Employee e1 = new Employee(1001,"nsnathan",4000);
		Employee e2= new Employee(1002,"nathan",5000);
		Employee e3 = new Employee(1003,"shan",6000);
		
		ArrayList<Employee> al = new ArrayList<>();
		
		//create
		
		al.add(e1);
		al.add(e2);
		al.add(e3);
		
		return al;
		
	}

	public void displayEmpList(ArrayList<Employee> al) 
	{
		for(Employee obj :al)
		{
			obj.displayEmp();
		}
		
	}

	public void SearchEmployee(ArrayList<Employee> al)
	{
		Scanner sc = new Scanner(System.in);
		int eno = sc.nextInt();
		
		for(Employee obj :al)
		{
			if(obj.empno==eno)
			{
				System.out.println("object found");
				obj.displayEmp();
			}
		}
		
	}
	
	
}
