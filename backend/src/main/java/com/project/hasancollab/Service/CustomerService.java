package com.project.hasancollab.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.hasancollab.Dto.CustomerDto;
import com.project.hasancollab.Entity.Customer;
import com.project.hasancollab.Repository.CustomerRepository;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;

@Service 
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public Customer getCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        Customer finalCustomer = customer.orElse(null);
        return finalCustomer;
    }

    public Customer createCustomer(CustomerDto customer){
        System.out.println("HELLo");
        Customer customer2 = new Customer();
        customer2.setEmail(customer.getEmail());
        customer2.setName(customer.getName());
        return customerRepository.save(customer2);
    }
}
