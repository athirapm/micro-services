package com.example.address.dto;

import com.example.address.entity.Student;

public class StudentResponse {
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private Long addressId;
	

	public StudentResponse(Student student) {
		super();
		this.addressId=student.getAddressId();
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

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	

}
