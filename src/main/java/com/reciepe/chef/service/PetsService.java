package com.reciepe.chef.service;

import com.reciepe.chef.enumeration.PetsType;
import com.reciepe.chef.model.Pets;
import com.reciepe.chef.repo.PetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.PageRequest.of;

import java.util.List;

@Service
public class PetsService {
    private PetRepository petRepository;

    public PetsService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
public Pets findPetByPetId(long id){
        return petRepository.findById(id).get();
}
    public Long savePet(Pets pets) {
        if (pets.getType().equalsIgnoreCase("cat"))
            pets.setType(String.valueOf(PetsType.CAT));

        if (pets.getType().equalsIgnoreCase("dog"))
            pets.setType(String.valueOf(PetsType.DOG));
        petRepository.save(pets);
        return pets.getPetId();
    }

    public Page<Pets> searchPets(String type, String gender, String size, String age, boolean goodWithChildren, int page, int pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        return petRepository.findPetsByTypeOrGenderOrSizeOrAgeOrGoodWithChildren(type, gender, size, age, goodWithChildren, paging);
    }
}
