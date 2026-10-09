package com.cdac;

class Person
{
	int id;
	String name;
	
	public Person(int id, String name) 
	{
		
		this.id = id;
		this.name = name;
	
	}
	void displayPerson()
	{
		System.out.print(id+name);
		
	}
	
	
	
}



class Employee extends Person
{
	
	float sal;
	
	public Employee(int id,String name, float sal) 
	{
		super(id,name);
		
		this.sal = sal;
	}

	void displayEmployee()
	{   super.displayPerson();
		System.out.print(sal);
		
	}
	
	
	
}

class Manager extends Employee
{
	
	String department;
	
	
	public Manager(int id, String name, float sal, String department) 
	{
		super(id, name,  sal);
		this.department = department;
	}


	void dispalyManger()
	{
		super.displayEmployee();
		System.out.println(department);
	}
	
	
	
	
}



public class InheritanceSimpleMain
{

	public static void main(String[] args)
	{
	    
		
		Manager m  = new Manager(1001,"shan",3000,"acts");
		
		System.out.println("manager details");
		m.dispalyManger();
		
		Employee e = new Employee(1001,"raj",4000);
		System.out.println("Employee details");
		e.displayEmployee();
		
	}
	
	
}
