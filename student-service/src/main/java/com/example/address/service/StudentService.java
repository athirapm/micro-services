package com.example.address.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address.dto.StudentRequest;
import com.example.address.dto.StudentResponse;
import com.example.address.entity.Student;
import com.example.address.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;

	public StudentResponse save(StudentRequest studentRequest) {
		Student student = new Student();
		student.setAddressId(studentRequest.getAddressId());
		student.setEmail(studentRequest.getEmail());
		student.setFirstName(studentRequest.getEmail());
		student.setLastName(studentRequest.getLastName());
		repository.save(student);
		return new StudentResponse(student);
	}

	public StudentResponse fetch(Long id) {
		Optional<Student> student = repository.findById(id);
		if (student.isPresent())
			return new StudentResponse(student.get());
		return null;
	}

}
