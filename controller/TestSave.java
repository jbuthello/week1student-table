package com.jsp.controller;
import com.jsp.dao.*;
import com.jsp.dto.*;

public class TestSave {
	public static void main(String[] args) {
		Student student=new Student();		 
		student.setId(6);
		student.setName("Shardul Warishe");
		student.setEmail("shardul.w@email.com");
		
		StudentDao studentDao=new StudentDao();
		Student s=studentDao.saveStudent(student);
		System.out.println(student.getName()+" sucessfully added");	
	}
}