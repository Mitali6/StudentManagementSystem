package com.student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Repository.StudentRepository;
import com.student.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
		public List<Student> getStudentList() {
		return studentRepository.findAll();
	}
	
	public void addNewStudent(Student std) {
		studentRepository.save(std);
	}
	
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
