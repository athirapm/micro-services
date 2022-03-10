package com.example.student.dto;

import com.example.student.entity.Student;

public class StudentResponse {
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private AddressResponse address;
	

	public StudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentResponse(Student student) {
		super();
		this.email=student.getEmail();
		this.firstName=student.getFirstName();
		this.lastName=student.getLastName();
		this.id=student.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressResponse getAddress() {
		return address;
	}

	public void setAddress(AddressResponse address) {
		this.address = address;
	}

	
	

}
