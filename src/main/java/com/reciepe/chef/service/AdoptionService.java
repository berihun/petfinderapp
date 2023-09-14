package com.reciepe.chef.service;

import com.reciepe.chef.model.Adoption;
import com.reciepe.chef.model.AdoptionDTO;
import com.reciepe.chef.model.Customer;
import com.reciepe.chef.model.Pets;
import com.reciepe.chef.repo.AdoptionRepository;
import com.reciepe.chef.repo.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionService {
    private AdoptionRepository adoptionRepository;
    private CustomerRepository customerService;
    private PetsService petsService;

    public AdoptionService(AdoptionRepository adoptionRepository, CustomerRepository customerService, PetsService petsService) {
        this.adoptionRepository = adoptionRepository;
        this.customerService = customerService;
        this.petsService = petsService;
    }

    public String saveAdoption(Adoption adoption) {

        if (!customerService.findById(adoption.getCustomerId()).isPresent())
            return "customer does not exist!";
        if (!adoptionRepository.findById(adoption.getPetId()).isPresent())
            return "pet does not exist!";
            adoptionRepository.save(adoption);
        return adoption.getAdoptionId().toString();
    }
    public Page<AdoptionDTO> getAllAdoptions(LocalDate from, LocalDate to, int page, int pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        List<Adoption> searchData=null;
        List<AdoptionDTO> searchData1=new ArrayList<>();

        searchData=adoptionRepository.findByDateAdoptedBetween(from,to);
        searchData1=searchData.stream()
                .map(ll->{
                    Customer cust=customerService.findById(ll.getCustomerId()).get();
                    Pets pet=petsService.findPetByPetId(ll.getPetId());
                    return AdoptionDTO.builder()
                            .petId(pet.getPetId())
                            .type(pet.getType())
                            .age(pet.getAge())
                            .gender(pet.getGender())
                            .goodWithChildren(pet.isGoodWithChildren())
                            .size(pet.getSize())
                            .customerId(cust.getCustomerId())
                            .name(cust.getName())
                            .phone(cust.getPhone())
                            .build();
                })
                .collect(Collectors.toList());
        return new PageImpl<>(searchData1, paging,10);
    }

}
