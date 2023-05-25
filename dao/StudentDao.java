package com.jsp.dao;
// com.jsp.dao package is used to handle all the database related task. USE ONLY DATABASE LOGIC only DATABASE OPERATION

import com.jsp.helper.*;
import com.jsp.dto.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao
{
	HelperClass helperClass=new HelperClass();
	Connection connection=null;
//	 to save students as batch
	
	public void addMultipleStudents(List<Student> students) {
		connection=helperClass.getConnection();
		String sql="INSERT INTO student VALUE (?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			for(Student s : students) {
				preparedStatement.setInt(1,s.getId());
				preparedStatement.setString(2,s.getName());
				preparedStatement.setString(3,s.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("Records inserted succesfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
//	 to save a student.
	public Student saveStudent(Student student)
	{
		connection=helperClass.getConnection();
		String sql="INSERT INTO student VALUES(?,?,?)"; //?-delimiters or placeholders
		
		//Create Statement
		
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,student.getId());
			preparedStatement.setString(2,student.getName());
			preparedStatement.setString(3,student.getEmail());
			
//			execute the statement
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	return student;
	}
	
//	 to delete a student
	
	public boolean deleteStudentById(int id) {
		Connection connection= helperClass.getConnection();
		String sql="DELETE from student WHERE ID=?"; //? is delimiter / placeholder
		boolean res= false;
		
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			int res2= preparedStatement.executeUpdate();
			if(res2>0) {
				res= true;
			}
			else {
				res= false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	return res;
	}
	
//	 get all
	public List<Student> getAllStudents(){
		connection=helperClass.getConnection();
		String sql="SELECT * FROM Student";
		PreparedStatement preparedStatement;
		ArrayList<Student> al=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			// execute query
			ResultSet resultSet=preparedStatement.executeQuery();
			 al=new ArrayList();
			while(resultSet.next()) {
				int id= resultSet.getInt(1);
				String name=resultSet.getString(2);
				String email=resultSet.getString(3);
				Student s=new Student();
				s.setId(id);
				s.setName(name);
				s.setEmail(email);
				al.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	return al;	
	}
	
//	update student by ID
	
	public boolean updateStudentById(int id, String name) {
		connection=helperClass.getConnection();
		
//		create statement
		String sql="UPDATE student set name=? WHERE id=?";
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
//	get by id
	public Student getStudentsbyId(int id){
		connection=helperClass.getConnection();
		
		String sql="SELECT * FROM Student WHERE Id=?";
		
		PreparedStatement preparedStatement;
		
		Student student2=new Student();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			// execute query
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id1= resultSet.getInt(1);
				String name1= resultSet.getString(2);
				String email1= resultSet.getString(3);
				
				student2.setId(id1);
				student2.setName(name1);
				student2.setEmail(email1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student2;
	}
	
}