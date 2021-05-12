package com.student.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.Service.StudentService;
import com.student.entity.Student;
import com.student.entity.UniqueCourses;

@Controller
public class WebController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/")
	   public String index(Model model) {
		model.addAttribute("uniqueCoursesCount", studentService.getUniqueCoursesInfo());
		model.addAttribute("totalStudents", studentService.getTotalStudents());
		model.addAttribute("liststudent", studentService.getStudentList());
	    return "index";
	   }
	
	@GetMapping(value = "/newUser")
	   public String newStudent(Model model) {
		model.addAttribute("student", new Student());
		return "new";
	}
	
	@PostMapping(value="/save")
	public String addNewStudent(@ModelAttribute("student") Student std){
		studentService.addNewStudent(std);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}")
	public ModelAndView showEditPage(@PathVariable(name="id") Long id) {
		ModelAndView mav = new ModelAndView("new");
		Student std = studentService.getStudentById(id).get();
		mav.addObject("student", std);
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteStudent(@PathVariable(name="id") Long id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}
}
