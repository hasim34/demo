package com.project.hasancollab.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Customer
 */
@Entity 
@NoArgsConstructor 
@Getter 
@Setter 
public class Customer extends BaseEntity{

    @Column (nullable = false,unique = true)
    private String name;

    @Column (nullable = false,unique = true)
    private String email;
    
}