package com.qspider.springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.qspider.springmvc.DAO.StudentDAO;
import com.qspider.springmvc.DTO.StudentDTO;

@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	private StudentDAO dao;
	
	@Override
	public void addStudent(String name, String email, String userName, String password) {
		// TODO Auto-generated method stub
		
		if(name != null && email != null && userName != null && password !=null)
		{
			dao.addStudent(name, email, userName, password);
		}
	}
	@Override
	public StudentDTO login(String userName, String password) {
		if (userName != null && password != null) {
			StudentDTO student = dao.login(userName, password);
			if (student != null) {
				return student;
			}
		}
		return null;
	}
	@Override
	public List<StudentDTO> viewAllStudents() {
		// TODO Auto-generated method stub
		List<StudentDTO> student=dao.viewAllStudent();
		return student;
	}
	@Override
	public StudentDTO removeStudent(int id) {
		if(id>=0) {
			StudentDTO student =dao.removeStudent(id);
			return student;
		}
		return null;
	}
	
	public StudentDTO updateStudent( int id,  String name,
			 String email,  String userName,  String password)
	{
		if(id>0) {
		StudentDTO	student=dao.updateStudent(id,name,email,userName,password);
		return student;
		}
		return null;
		
	}
	@Override
	public StudentDTO searchStudent(int id) {
		if (id > 0) {
			StudentDTO student = dao.searchStudent(id);
			return student;
		}
		return null;
	}
 
 
}
