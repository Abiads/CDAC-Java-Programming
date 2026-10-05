package com.cdac;

public class Student
{
int sid;
String name;
String  subject;
int mark;
	
public void readStudentData(int id,String na,String s,int m)
{
	//Scanner s = new Scanner(System.in);
	
	sid = id;
	name = na;
	subject = s;
	mark = m;
	
	
}


public void displayStudent()
{
	System.out.print(sid+name+subject+mark);
	
	
}


public void findResult()
{
   if(mark>16)
	   System.out.print("pass");
	   else
		   System.out.print("fail");
	
}

}
