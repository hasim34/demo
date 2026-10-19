package com.project.hasancollab.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.hasancollab.Dto.ApiResponseDto;
import com.project.hasancollab.Dto.CustomerDto;
import com.project.hasancollab.Dto.ApiResponseDto.ApiResponseDtoBuilder;
import com.project.hasancollab.Entity.Customer;
import com.project.hasancollab.Service.CustomerService;

import io.swagger.v3.oas.models.responses.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping ("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        ApiResponseDtoBuilder<Customer> response;
        Customer resp = customerService.getCustomer(id);
        if(resp==null){
            // response = ApiResponseDto.builder().success(false).data(resp).message("user not found").build();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto entity) {
        //TODO: process POST request
        System.out.println("HI");
        Customer customer =  customerService.createCustomer(entity);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }
    
    
}
