package com.reciepe.chef.controller;

import com.reciepe.chef.model.Adoption;
import com.reciepe.chef.model.HttpResponse;
import com.reciepe.chef.service.AdoptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Map.of;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {
    private AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @PostMapping()
    public ResponseEntity<HttpResponse> saveAdoption(@RequestBody Adoption adoption) {

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .data(of("adoptionId", adoptionService.saveAdoption(adoption)))
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping()
    public ResponseEntity<HttpResponse> getAllAdoptions(@RequestParam LocalDate from,
                                                   @RequestParam LocalDate to) {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .data(of("AdoptionDTO:", adoptionService.getAllAdoptions(from,to,0,10)))
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

}
