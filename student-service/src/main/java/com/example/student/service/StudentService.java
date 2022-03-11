package com.example.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.student.dto.AddressResponse;
import com.example.student.dto.StudentRequest;
import com.example.student.dto.StudentResponse;
import com.example.student.entity.Student;
import com.example.student.feignclient.AddressFeignClient;
import com.example.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;
	@Autowired
	WebClient webClient;
	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse save(StudentRequest studentRequest) {
		Student student = new Student();
		student.setAddressId(studentRequest.getAddressId());
		student.setEmail(studentRequest.getEmail());
		student.setFirstName(studentRequest.getEmail());
		student.setLastName(studentRequest.getLastName());
		repository.save(student);
		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddress(getStudentAddress(student.getAddressId()));
		// calling address service using open feign client
		studentResponse.setAddress(addressFeignClient.fetchAddress(student.getAddressId()));
		return studentResponse;
	}

	public StudentResponse fetch(Long id) {
		Optional<Student> student = repository.findById(id);
		StudentResponse response = null;
		if (student.isPresent()) {
			response = new StudentResponse(student.get());
			// calling address service using open feign client
			response.setAddress(addressFeignClient.fetchAddress(student.get().getAddressId()));
			return response;
		}
		return null;
	}

	// calling address service using web client
	public AddressResponse getStudentAddress(Long id) {
		return webClient.get().uri("/fetch/?id=" + id).retrieve().bodyToMono(AddressResponse.class).block();
	}

}
