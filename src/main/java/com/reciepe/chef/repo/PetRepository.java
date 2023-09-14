package com.reciepe.chef.repo;

import com.reciepe.chef.model.Pets;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PetRepository extends JpaRepository<Pets, Long> {
    Page<Pets> findPetsByTypeOrGenderOrSizeOrAgeOrGoodWithChildren(String type, String gender, String size, String age, boolean goodWithChildren, Pageable pageable);
}
