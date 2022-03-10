package com.example.address.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address.entity.Address;
import com.example.address.repository.AddressRepository;
import com.example.address.request.AddressRequest;
import com.example.address.response.AddressResponse;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	public AddressResponse save(AddressRequest addressRequest) {
		Address address = new Address();
		address.setCity(addressRequest.getCity());
		address.setStreet(addressRequest.getStreet());
		addressRepository.save(address);
		return new AddressResponse(address);
	}

	public AddressResponse fetch(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		if (address.isPresent())
			return new AddressResponse(address.get());
		return null;
	}

}
