package com.reciepe.chef.controller;

import com.reciepe.chef.model.HttpResponse;
import com.reciepe.chef.model.Customer;
import com.reciepe.chef.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.util.Map.of;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public ResponseEntity<HttpResponse> saveCustomer(@RequestBody Customer customer) {

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .data(of("customerId", customerService.saveCustomer(customer)))
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

}
