package com.reciepe.chef.service;

import com.reciepe.chef.model.Customer;
import com.reciepe.chef.repo.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }
    public Long saveCustomer(Customer customer) {

        customerRepo.save(customer);
        return customer.getCustomerId();
    }
}
