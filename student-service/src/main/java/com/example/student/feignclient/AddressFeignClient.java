package com.example.student.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.student.dto.AddressResponse;

@FeignClient(url = "${address.service.url}", value = "address-feign-client")
public interface AddressFeignClient {
	@GetMapping("/fetch")
	public AddressResponse fetchAddress(@RequestParam Long id);

}
