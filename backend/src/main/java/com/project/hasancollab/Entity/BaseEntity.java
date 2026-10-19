package com.project.hasancollab.Entity;


import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter 
@Setter 
@NoArgsConstructor    
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;  
 
    private LocalDateTime updatedAt;  
  
    @PrePersist  
    protected void onCreate() {  
        createdAt = LocalDateTime.now(); 
        updatedAt = LocalDateTime.now(); 
    }  
 
    @PreUpdate  
    protected void onUpdate() {  
        updatedAt = LocalDateTime.now(); 
    }  
}