package com.reciepe.chef.repo;

import com.reciepe.chef.model.Adoption;
import com.reciepe.chef.model.Pets;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    List<Adoption> findByDateAdoptedBetween(LocalDate from, LocalDate to);
}
