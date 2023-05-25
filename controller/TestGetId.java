package com.jsp.controller;  

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;


public class TestGetId {
	public static void main(String[] args) {
		StudentDao studentDao=new StudentDao();
		Student student2=studentDao.getStudentsbyId(4);

			System.out.println(student2.getId());
			System.out.println(student2.getName());
			System.out.println(student2.getEmail());
			System.out.println("______________________________");
		}
	}
