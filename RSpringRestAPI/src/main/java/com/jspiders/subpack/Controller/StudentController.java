package com.jspiders.subpack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.subpack.DTOPOJO.StudentDTO;
import com.jspiders.subpack.Responce.StudentResponse;
import com.jspiders.subpack.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StudentResponse> add(@RequestBody StudentDTO student) {
		StudentDTO stud = service.add(student);
		StudentResponse response = new StudentResponse();
		if (stud != null) {
			response.setMsg("OK");
			response.setDiscription("Student Added Successfully..!!");
			response.setStudent(stud);
			return new ResponseEntity<StudentResponse>(response, HttpStatus.ACCEPTED);
		}
		response.setMsg("FAIL");
		response.setDiscription("Student Not Added..!!");
		return new ResponseEntity<StudentResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/search{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StudentResponse> search(@PathVariable int id) {
		StudentDTO stud = service.search(id);
		StudentResponse response = new StudentResponse();
		if (stud != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("ok", "Searched", stud, null),HttpStatus.ACCEPTED);
		}
		response.setMsg("FAIL");
		response.setDiscription("Student Not Found..!!");
		return new ResponseEntity<StudentResponse>(response, HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StudentResponse> update(@RequestBody StudentDTO student) {
		StudentDTO details = service.update(student);
		StudentResponse response = new StudentResponse();
		if (details != null) {
			return new ResponseEntity<StudentResponse>(
					new StudentResponse("OK", "Student Data Found..!!", details, null), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("OK", "Student Not Found..!!", details, null),
				HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(path = "/remove{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StudentResponse> remove(@PathVariable int id) {
		StudentDTO stud = service.remove(id);
		StudentResponse response = new StudentResponse();
		if (stud != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("ok", "Removed Succesfully", stud, null),HttpStatus.ACCEPTED);
		}
		response.setMsg("FAIL");
		response.setDiscription("Student Not Found..!!");
		return new ResponseEntity<StudentResponse>(response, HttpStatus.NOT_FOUND);
	}

}
