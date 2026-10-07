package com.cdac;

class Emp
{
	
	int empno;
	String name;
	float sal;
	
	public Emp(int empno, String name, float sal)
	{
		
		this.empno = empno;
		this.name = name;
		this.sal = sal;
	}
	
	void displayEmployee()
	{
		System.out.print(empno+name+sal);
	}
	
	
}

class Developer extends Emp
{
	String projectname;
	
	Developer(int empno, String name, float sal,String projectname)
	{
	super(empno,name,sal);
	this.projectname = projectname;
	
	}
	
	void displayDeveloper()
	{   super.displayEmployee();
		System.out.print(projectname);
	}
	
}


class Tester extends Emp
{
	String tool;
	
	public Tester(int empno, String name, float sal,String tool)
	{
		super(empno, name, sal);
		this.tool = tool;
		
	}

	void displayTester()
	{   super.displayEmployee();
		System.out.println(tool);
	}
	
	
}





public class inheritanceExample2Main 
{

public static void main(String[] args) 
{

	Developer d = new Developer(1001,"nsnathan",40000,"IOT");
    d.displayDeveloper();
    System.out.println();
    System.out.println("tester details");
    Tester t = new Tester(1002,"raj",5000,"selenium");
    t.displayTester();
	
}	
}
