package com.project.hasancollab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hasancollab.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
    
}
