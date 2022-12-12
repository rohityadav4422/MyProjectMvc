package com.qspider.springmvc.DAO;

import java.util.List;

import com.qspider.springmvc.DTO.StudentDTO;

public interface StudentDAOInterface {

	
	void addStudent(String name,String email,String userName ,String password);
	
	StudentDTO login(String userName,String password);
	
	List<StudentDTO> viewAllStudent();
	
	StudentDTO removeStudent(int id);

	StudentDTO updateStudent(int id, String name, String email, String userName, String password);
	
	StudentDTO searchStudent(int id);
}
