package com.jsp.controller;

import com.jsp.dao.*;
public class TestDelete {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();		
		
		if(studentDao.deleteStudentById(2)) {
			System.out.println("record of student with id:2 is deleted.");
		}else {
			System.out.println("could not delete the record.");
		}		
	}
}