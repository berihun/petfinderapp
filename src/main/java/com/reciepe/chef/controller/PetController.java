package com.reciepe.chef.controller;

import com.reciepe.chef.model.HttpResponse;
import com.reciepe.chef.model.Pets;
import com.reciepe.chef.service.PetsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.util.Map.of;

@RestController
@RequestMapping("/pets")
public class PetController {
    private PetsService petsService;

    public PetController(PetsService petsService) {
        this.petsService = petsService;
    }

    @PostMapping()
    public ResponseEntity<HttpResponse> createPet(@RequestBody Pets pets) {

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .data(of("petId", petsService.savePet(pets)))
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping()
    public ResponseEntity<HttpResponse> searchPets(@RequestParam String type,
                                                   @RequestParam String gender,
                                                   @RequestParam String size,
                                                   @RequestParam String age,
                                                   @RequestParam boolean goodWithChildren,
                                                   @RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<Integer> pageSize) {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .data(of("Pets:", petsService.searchPets(type, gender,size,age,goodWithChildren,page.orElse(0),pageSize.orElse(10))))
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }
}
