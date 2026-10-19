package com.project.hasancollab.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
/** (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
public class CustomerDto {
    private String email;
    private String name;
}
