package com.jspiders.subpack.Responce;

import java.util.List;

import com.jspiders.subpack.DTOPOJO.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

	private String msg;
	
	private String discription;
	
	private StudentDTO student;
	
	private List<StudentDTO> list;
}
