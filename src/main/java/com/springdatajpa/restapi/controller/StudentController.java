package com.springdatajpa.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.entity.Student;
import com.springdatajpa.repository.StudentRepository;

@RestController
public class StudentController {

	//get all the students
	
	@Autowired
	StudentRepository repo;

	//getAllStudents
    @GetMapping("/students")
	public List<Student> getAllStudents(){
	 List<Student> Students =repo.findAll();
		
		return Students;
	}
    
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
    
    	Student student = repo.findById(id).get();
    	
    	  return student;
    }
    
    @PostMapping("/students/add")
    public void createStudent(@RequestBody Student student) {
    	
    	repo.save(student);
    	
    }
    
    @PutMapping("/students/update/{id}")
    public Student updateStudents(@PathVariable int id) {
    Student student = repo.findById(id).get();
     student.setName("sitra");
     student.setPercentage(92);
     repo.save(student);
     return student;
     
    	
    }
    
    @DeleteMapping("/students/delete/{id}")
    public void removeStudent(@PathVariable int id) {
    	Student student = repo.findById(id).get(); // we need to fetch the details of the student which you want to delete
    	repo.delete(student);
    }
}
