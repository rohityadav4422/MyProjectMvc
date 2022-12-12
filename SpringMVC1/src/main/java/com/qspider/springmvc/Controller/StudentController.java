package com.qspider.springmvc.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.qspider.springmvc.DTO.StudentDTO;
import com.qspider.springmvc.Service.StudentService;



@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/addStudent")
	
		private String addStudentPage(ModelMap map,
				@SessionAttribute(name="login",required= false) StudentDTO login) 
		{ if(login != null) 
	       {
			return "AddStudentForm";
	       }
			map.addAttribute("msg", "Invalid username or password");
			return "LoginPage";		
		}
	@PostMapping("/addStudent")
	private String addStudent(@RequestParam String name,@RequestParam String email,
			@RequestParam String userName,@RequestParam String password,ModelMap map,
			@SessionAttribute(name="login",required= false) StudentDTO login) {
		{
			if(login!= null){
	
		service.addStudent(name, email, userName, password);
		return "AddStudentForm";
	    }
	map.addAttribute("msg", "please login first...!");
	return "LoginPage";	
		}
	}
	@PostMapping("/home")
	private String login(HttpSession session,HttpServletRequest request,
			@RequestParam String userName,@RequestParam String password,ModelMap map)
	{
		StudentDTO student =  service.login(userName, password);
		if (student != null) {
			session=request.getSession();
			session.setAttribute("login", student);
			session.setMaxInactiveInterval(300);
			map.addAttribute("student", student);
			return "HomePage";
		}
		map.addAttribute("msg", "Invalid username or Password");
		return "LoginPage";
		
	}
	
	@GetMapping("/logout")
     private String logout(ModelMap map,@SessionAttribute(name="login",required= false) StudentDTO login) {
		{
			if(login!= null) {
		map.addAttribute("msg","Logout Successfully");
		return "LoginPage";
			}
			map.addAttribute("msg", "Please Login First");
			return "LoginPage";
		}
		
	} 
	@GetMapping("/removeStudent")
	private String removeStudent(ModelMap map,
			@SessionAttribute(name="login",required= false) StudentDTO login) {
		{
			if(login!= null)
			{List<StudentDTO> students = service.viewAllStudents();
			map.addAttribute("students", students);
			return "RemovePage";
			}
			map.addAttribute("msg", "please login first...!");
			return "LoginPage";
		}
	}
	@PostMapping("/removeStudent")
	private String removeStudent(@RequestParam int id,ModelMap map,
			@SessionAttribute(name="login",required= false) StudentDTO login)
	{
		StudentDTO student=service.removeStudent(id);
		if(student != null)
		{
			map.addAttribute("msg", "student removed from database");
			List<StudentDTO> students=service.viewAllStudents();
			map.addAttribute("students", students);
		}
		return null;
		
	}
	@GetMapping("/updateStudent")
	private String updateStudent(ModelMap map,@SessionAttribute(name="login",required= false) StudentDTO login) {
		if(login!= null) {
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "UpdateStudent";
		}
		map.addAttribute("msg", "Please login first...!");
		return "LoginPage";	
	}

	@PostMapping("/updateStudent")
	private String updateStudent1(@RequestParam int id, ModelMap map,
			@SessionAttribute(name="login",required= false) StudentDTO login) {
		if(login != null)
		{
			StudentDTO student = service.searchStudent(id);
		if (student != null) {
			map.addAttribute("student", student);
			return "UpdateStudent";
		}
		
		map.addAttribute("msg", "Invalid student id entered");
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "UpdatePage";
		}
		map.addAttribute("msg", "please login first...!");
		return "UpdateStudent";
	}

	@PostMapping("/updateStudentData")
	private String updateStudent2(@RequestParam int id, @RequestParam String name,
            @RequestParam String email,@RequestParam String userName, 
            @RequestParam String password, ModelMap map,@SessionAttribute(name="login",required= false) StudentDTO login) {
		if(login!= null)  {
		StudentDTO student = service.searchStudent(id);
		if (student != null) {
			service.updateStudent(id, name, email, userName, password);
			map.addAttribute("msg", "Student updated successfully");
			List<StudentDTO> students = service.viewAllStudents();
			map.addAttribute("students", students);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "Student not found");
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "UpdateStudent";
	}
		map.addAttribute("msg", "Please login first...!");
		return "LoginPage";	
	}
	
	@GetMapping("/searchStudent")
	private String searchStudent() {
		return "SearchPage";		
	}
	@PostMapping("/searchStudent")
	private String searchStudent1(@RequestParam int id,ModelMap map,
			@SessionAttribute(name="login",required= false) StudentDTO login)  {
		if(login != null) {
			StudentDTO student=service.searchStudent(id);
			map.addAttribute("student",student);
			map.addAttribute("msg", "Search successfully...!!!");
		return "SearchPage";
		}	
		map.addAttribute("msg", "Please login first...!");
		return "LoginPage";	
		
	}
	
}
