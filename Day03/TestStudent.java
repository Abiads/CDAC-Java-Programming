package com.cdac;

public class TestStudent
{
public static void main(String[] args) {
	
	Student s1 = new Student();
	
	System.out.println("enter first student details");
	s1.readStudentData(1001,"nsnathan","c++",50);
	s1.displayStudent();
	s1.findResult();
	
   Student s2 = new Student();
  System.out.println("second object");
  
  System.out.println("enter first student details");
   s2.readStudentData(1002,"raja","java",60);
   
	s2.displayStudent();
	s2.findResult();
  
	
}
}
