package com.cdac;

public class Student 
{
   int sid;
   String name;
   int makr;
public Student(int sid, String name, int makr) {
	
	this.sid = sid;
	this.name = name;
	this.makr = makr;
}
   void display()
   {
	   System.out.println(sid+name+makr);
   }
}
