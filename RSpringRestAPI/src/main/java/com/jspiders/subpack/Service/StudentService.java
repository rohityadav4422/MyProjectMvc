package com.jspiders.subpack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.subpack.DTOPOJO.StudentDTO;
import com.jspiders.subpack.Repository.StudentRepository;
@Service
public class StudentService {
   @Autowired  
	private StudentRepository repository;
	
	public StudentDTO add(StudentDTO student) {
	StudentDTO	stud=repository.add(student);
		return stud;
	}

	public StudentDTO search(int id) {
	StudentDTO	find=repository.search(id);
		return find;
	}

	public StudentDTO update(StudentDTO student) {
		StudentDTO update=repository.update(student);
		return update;
	}

	public StudentDTO remove(int id) {
		StudentDTO	deleted=repository.remove(id);
		return deleted;
	}

}
