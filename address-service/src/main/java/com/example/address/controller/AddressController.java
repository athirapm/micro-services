package com.example.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.address.request.AddressRequest;
import com.example.address.response.AddressResponse;
import com.example.address.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;

	@RequestMapping("/save")
	public AddressResponse createAddress(@RequestBody AddressRequest addressRequest) {

		return addressService.save(addressRequest);

	}

	@RequestMapping("/fetch")
	public AddressResponse fetchAddress(@RequestParam Long id) {

		return addressService.fetch(id);

	}

}
