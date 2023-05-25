package com.jsp.controller;
import com.jsp.dao.*;
public class TestUpdate {
	public static void main(String[] args) {
		
		StudentDao studentDao=new StudentDao();
		
		if(studentDao.updateStudentById(1,"anemail@ymail.com")) {
			System.out.println("Record Updated Sucessfully");
		}
		else {
			System.out.println("Record Not Updated!!");
		}
	}
}