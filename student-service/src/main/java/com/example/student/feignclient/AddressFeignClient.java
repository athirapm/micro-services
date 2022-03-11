package com.example.student.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.student.dto.AddressResponse;
// specifying the url and name of the address service
//@FeignClient(url = "${address.service.url}", value = "address-feign-client")
// specifying the name of the service as appeared in the eureka registry
@FeignClient(value = "address-service")
public interface AddressFeignClient {
	@GetMapping("/fetch")
	public AddressResponse fetchAddress(@RequestParam Long id);

}
