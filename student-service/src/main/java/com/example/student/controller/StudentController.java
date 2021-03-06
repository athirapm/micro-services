package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.StudentRequest;
import com.example.student.dto.StudentResponse;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/save")
	public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest) {
		return studentService.save(studentRequest);
	}
	@RequestMapping("/fetch")
	public StudentResponse fetchStudent(@RequestParam Long id) {
		return studentService.fetch(id);
	}

}
