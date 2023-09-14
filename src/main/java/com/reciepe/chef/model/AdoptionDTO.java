package com.reciepe.chef.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AdoptionDTO {
    private Long customerId ;
    private String name ;
    private String phone ;

    private Long petId;
    private String type;
    private boolean goodWithChildren;
    private String age;
    private String gender;
    private String size;
}
