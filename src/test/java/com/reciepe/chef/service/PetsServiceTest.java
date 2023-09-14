package com.reciepe.chef.service;

import com.reciepe.chef.model.Pets;
import com.reciepe.chef.repo.PetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetsServiceTest {
    @Mock
    private PetRepository petRepository;
    private PetsService petsService;
//    @Autowired
//    private PetRepository petsRepository;

    @Autowired
    PetsServiceTest(PetsService petsService) {
        this.petsService = petsService;
    }

    @DisplayName("JUnit test for savePets method")
    @Test
    void testSavePet() {
        //given
        Pets pets =
                Pets.builder()
                        .petId(11L)
                        .type("dog")
                        .age("young")
                        .gender("male")
                        .size("medium")
                        .goodWithChildren(true)
                        .build();
        Mockito.when(petRepository.save(pets)).thenReturn(pets);
        //when
        long savedPetsId=petsService.savePet(pets);
        //then
        assertEquals(pets.getPetId(),savedPetsId);
    }

    @Test
    void findPetByPetId() {
        //given
        Long petId=10l;
        Pets pet=Pets.builder()
                .petId(petId)
                .type("DOG")
                .size("large")
                .gender("male")
                .goodWithChildren(true)
                .build();

        //when
        Pets foundPet=petsService.findPetByPetId(petId);
        //then
        assertEquals(pet,foundPet);
    }
        @Test
    void testSearchPets() {
    }
}