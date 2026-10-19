package com.project.hasancollab.Dto;

import com.project.hasancollab.Entity.Customer;

import lombok.Builder;
import lombok.Data;

/**
 * 
 */
@Data 
@Builder 
public class ApiResponseDto<T> {
    
    private boolean success;

    private String message;

    private T data;
}
