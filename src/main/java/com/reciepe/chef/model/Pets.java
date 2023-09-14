package com.reciepe.chef.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private String type;
    private boolean goodWithChildren;
    private String age;
    private String gender;
    private String size;
}
