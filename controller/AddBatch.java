package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class AddBatch {
	public static void main(String[] args) {
		
		StudentDao studentDao=new StudentDao();
		ArrayList<Student> al=new ArrayList<>();
		
		Student s1=new Student();
		s1.setId(7);
		s1.setName("Shubham Yadav");
		s1.setEmail("syadav@gmail.com");
		
		Student s2=new Student();
		s2.setId(8);
		s2.setName("Hamid Shaik");
		s2.setEmail("hamidss@gmail.com");
		
		Student s3=new Student();
		s3.setId(9);
		s3.setName("Nilesh Patil");
		s3.setEmail("nileshp@email.com");
		
		
		al.add(s3);
		al.add(s2);
		al.add(s1);
		
		studentDao.addMultipleStudents(al);
	}

}
